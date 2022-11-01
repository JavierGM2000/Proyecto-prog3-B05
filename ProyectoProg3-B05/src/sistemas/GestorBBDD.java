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
					"");// Contraseña entre las comillas
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

	public void CerrarCon() {
		try {
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
