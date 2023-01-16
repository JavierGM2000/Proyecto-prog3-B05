package sistemas;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import at.favre.lib.crypto.bcrypt.*;
import componentes.Carta;
import componentes.Partida;

public class GestorBBDD {
	private Connection Conn;

	// Logger
	private static Logger loggerBBDD = Logger.getLogger(Carta.class.getName());

	public GestorBBDD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			loggerBBDD.fine("Driver de mysql cargado correctamente");
		} catch (ClassNotFoundException e) {
			loggerBBDD.severe("No se a podido cargar el driver de mysql");
		}
		try {
			////////////////////////////////////////////
			// IMPORTANTE
			////////////////////////////////////////////
			// Al hacer commit de cambios en este
			// archivo asegurarse que la contraseña
			// no esta metida. Subir la clave al un
			// git PUBLICO seria un
			// GRAN RIESGO DE SEGURIDAD DE LA BBDD
			////////////////////////////////////////////
			// En caso de necistar la contraseña o una
			// copia de la estructura de la BBDD,
			// contacte con los usuarios autorizados
			// del repositorio
			////////////////////////////////////////////
			Properties properties = new Properties();
			try {
				properties.load(new FileInputStream("proyecto.properties"));

				Conn = DriverManager.getConnection(properties.getProperty("enlace_base_de_datos"),
						properties.getProperty("nombre_de_la_base_de_datos"),
						properties.getProperty("contrasenya_base_de_datos"));// Contraseña entre las comillas
				loggerBBDD.fine("Conexion con la Base de Datos exitosa");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			loggerBBDD.info("Conexion online fallida, intentando conexion local");
			this.Conn = GetConFromPath("data/bbdd/Basedatos");
			// e.printStackTrace();
		}
	}

	public Connection GetConFromPath(String path) {
		Connection Conec;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			loggerBBDD.severe("No se a podido cargar sqlite");
		}
		try {
			Conec = DriverManager.getConnection("JDBC:sqlite:" + path);
			return Conec;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			loggerBBDD.severe("No se a podido conectar a sqlite");
		}
		return null;
	}

	/*
	 * Si el el usuario y contraseña es correcta, devuelve la ID del usuario
	 * logeado, si la contraseña no es correcta o el usuario no existe, devuelve 0
	 */
	public int esUsuarioCorrecto(String Usuario, char[] Contrasena) {
		// PreparedStatement pstmt;
		try (PreparedStatement pstmt = Conn.prepareStatement("SELECT id,`contra` FROM `usuarios` WHERE `nombre`=?")) {
			pstmt.setString(1, Usuario);
			ResultSet rs = pstmt.executeQuery();
			// Queremos saber si hay filas, si no hay filas el usuario no existe
			if (rs.isBeforeFirst()) {
				// como los usuarios son unicos, solo necesitamos un next
				rs.next();
				int id = rs.getInt(1);
				String PassHash = rs.getString(2);
				// Comparamos la contraseña
				// Codigo de ejemplo de la documentacion de la libreria BCRYPT:
				// https://github.com/patrickfav/bcrypt
				BCrypt.Result result = BCrypt.verifyer().verify(Contrasena, PassHash);
				if (result.verified == true) {
					// si coinciden el usuario se ha logeado y devolvemos el id
					loggerBBDD.fine("Usuario y  contraseñas correctos");
					return id;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} catch (SQLException e) {
			loggerBBDD.severe("Error al obtener las ids de los usuarios de la Base de Datos");
			e.printStackTrace();
		}

		return 0;
	}

	// Función para crear un usuario
	// Devuelve 1 si el usuario se ha creado correctamente
	// Devuelve 0 si el correo electronico está en uso
	// Devuelve -1 para cualquier otro error al insertar
	public int crearUsuario(String Usuario, String Mail, char[] Contrasena) {

		if (existeCorreo(Mail)) {
			return 0;
		}

		try (PreparedStatement pstmt = Conn.prepareStatement(
				"INSERT INTO `usuarios`(`nombre`, `mail`, `contra`) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, Usuario);
			pstmt.setString(2, Mail);
			String HashContra = BCrypt.withDefaults().hashToString(12, Contrasena);
			pstmt.setString(3, HashContra);
			pstmt.executeUpdate();
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					loggerBBDD.fine("Usuario -" + generatedKeys.getLong(1) + "- creado en la Base de Datos");
					return (int) generatedKeys.getLong(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			loggerBBDD.severe("Error al insertar un nuevo usuario en la Base de Datos");
		}

		return 0;
	}

	// Devuelve true si el usuario se ha borrado correctamente
	public boolean borrarUsuario(int id) {

		try (PreparedStatement pstmt = Conn.prepareStatement("DELETE FROM `usuarios` WHERE `id`=?")) {
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() > 0) {
				loggerBBDD.fine("Usuario -" + id + "- borrado de la Base de Datos");
				return true;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			loggerBBDD.severe("Error al borrar un usuario en la Base de Datos");
		}

		return false;
	}

	// Devuelve el número de partidas que tiene un usuario, si hay un error devuelve
	// -1
	public int EncontrarPartidasUsuario(int UsId) {
		try (PreparedStatement pstmt = Conn.prepareStatement("SELECT COUNT(*) FROM `partida` WHERE `user_id`=?")) {
			pstmt.setInt(1, UsId);

			ResultSet rs = pstmt.executeQuery();

			rs.next();
			int cuentas = rs.getInt(1);
			loggerBBDD.fine("Usuario -" + UsId + "- tiene el siguiente numero de cuentas: " + cuentas);
			return cuentas;

		} catch (SQLException e1) {
			e1.printStackTrace();
			loggerBBDD.severe("Error al borrar un usuario en la Base de Datos");
		}
		return -1;
	}
	
	public List<Partida> ConseguirPartidasUsuarios(int usId){
		List<Partida> lPartids = new ArrayList<>();
		try (PreparedStatement pstmt = Conn.prepareStatement("SELECT `id`,`last_used`,`info` FROM `partida` WHERE `user_id`=? ORDER BY `last_used` DESC")) {
			pstmt.setInt(1, usId);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				lPartids.add(new Partida(rs.getInt(1), rs.getString(2) ,rs.getString(3)));
			}
			

		} catch (SQLException e1) {
			e1.printStackTrace();
			loggerBBDD.severe("Error al borrar un usuario en la Base de Datos");
		}
		return lPartids;
	}

	// Devuelve el id de la partida que se ha creado
	public int CrearPartidaParaUsuario(int UsId) {
		try (PreparedStatement pstmt = Conn.prepareStatement(
				"INSERT INTO `partida`(`user_id`, `last_used`, `info`) VALUES (?,NOW(),'')",
				Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setInt(1, UsId);
			pstmt.executeUpdate();
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					loggerBBDD.fine("Partida creada -" + generatedKeys.getLong(1) + "-");
					return (int) generatedKeys.getLong(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			loggerBBDD.severe("Error al insertar un nuevo usuario en la Base de Datos");
		}
		return -1;
	}

	public ControladorEstado ConseguirPartidaParaUsuario(int partidaId) {
		String info = "";
		try (PreparedStatement pstmt = Conn.prepareStatement("SELECT `info` FROM `partida` WHERE `id`=?")) {
			pstmt.setInt(1, partidaId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.isBeforeFirst()) {
				rs.next();
				info = rs.getString(1);
			} else {
				return null;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			loggerBBDD.severe("Error al insertar un nuevo usuario en la Base de Datos");
		}
		byte[] data = Base64.getDecoder().decode(info);
		
		Object o = null;
		try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
			o = ois.readObject();
			ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (ControladorEstado) o;
	}

	public boolean ActualizarPartidaUsuario(String info, int partidaId) {
		try (PreparedStatement pstmt = Conn
				.prepareStatement("UPDATE `partida` SET `last_used`=NOW(),`info`=? WHERE `id`=?")) {
			pstmt.setString(1, info);
			pstmt.setInt(2, partidaId);

			if (pstmt.executeUpdate() > 0) {
				loggerBBDD.fine("Partida " + partidaId + " actualizada");
				return true;
			}
			return false;

		} catch (SQLException e1) {
			e1.printStackTrace();
			loggerBBDD.severe("Error al borrar un usuario en la Base de Datos");
		}
		return false;
	}

	// Función que comprueba si un correo existe
	// Devuelve:
	// true: Cuando el correo ya está en la base de datos o no se ha podido preparar
	// el prepared statement
	// La razon por la que devolvemos true ne caso de error es asegurarnos que al
	// crear un usuario
	// No pueda suceder que creamos un usuario con el mismo correo dos veces
	// false: Cuando el correo no existe en la base de datos
	public boolean existeCorreo(String mail) {
		try (PreparedStatement pstmt = Conn.prepareStatement("SELECT COUNT(*) FROM `usuarios` WHERE `mail`=?")) {
			pstmt.setString(1, mail);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {
				loggerBBDD.fine("Existe el correo");
				return true;
			} else {
				loggerBBDD.fine("No existe el correo");
				return false;
			}
		} catch (SQLException e) {
			loggerBBDD.severe("Error al obtener el numero de mails de la Base de Datos");
			e.printStackTrace();
		}
		return true;
	}

	public void CerrarCon() {
		try {
			Conn.close();
			loggerBBDD.fine("Base de Datos cerrada");
		} catch (SQLException e) {
			loggerBBDD.severe("Error al cerrar la base de datos");
			e.printStackTrace();
		}
	}
}
