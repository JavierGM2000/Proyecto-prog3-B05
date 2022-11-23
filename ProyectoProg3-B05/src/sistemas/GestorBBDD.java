package sistemas;

import java.sql.*;

import at.favre.lib.crypto.bcrypt.*;

public class GestorBBDD {
	private Connection Conn;

	public GestorBBDD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar");
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
			Conn = DriverManager.getConnection("jdbc:mysql://qahf589.emaginarte.info/qahf589?useSSL=false", "qahf589",
					"DeustoSim22");// Contraseña entre las comillas
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/*
	 * Si el el usuario y contraseña es correcta, devuelve la ID del usuario
	 * logeado, si la contraseña no es correcta o el usuario no existe, devuelve 0
	 */
	public int esUsuarioCorrecto(String Usuario, String Contrasena) {
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
				BCrypt.Result result = BCrypt.verifyer().verify(Contrasena.toCharArray(), PassHash);
				if (result.verified == true) {
					// si coinciden el usuario se ha logeado y devolvemos el id
					return id;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	//Función que comprueba si un correo existe
	// Devuelve:
	// true: Cuando el correo ya está en la base de datos o no se ha podido preparar el prepared statement
	//		 La razon por la que devolvemos true ne caso de error es asegurarnos que al crear un usuario
	//		 No pueda suceder que creamos un usuario con el mismo correo dos veces
	// false: Cuando el correo no existe en la base de datos 
	public boolean existeCorreo(String mail) {
		try (PreparedStatement pstmt = Conn.prepareStatement("SELECT COUNT(*) FROM `usuarios` WHERE `mail`=?")) {
			pstmt.setString(1, mail);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1)>0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	//Función para crear un usuario
	//Devuelve 1 si el usuario se ha creado correctamente
	//Devuelve 0 si el correo electronico está en uso
	//Devuelve -1 para cualquier otro error al insertar
	public int crearUsuario() {
		return -1;
	}

	public void CerrarCon() {
		try {
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
