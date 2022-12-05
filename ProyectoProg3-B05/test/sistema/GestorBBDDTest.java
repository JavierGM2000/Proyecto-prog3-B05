package sistema;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sistemas.GestorBBDD;

public class GestorBBDDTest {

	GestorBBDD G;

	@Before
	public void setUp() {
		G = new GestorBBDD();
	}

	// Para las pruebas hay un usuario de prueba creado en la base de datos con
	// usuario : UserPrueba y clave: prueba
	@Test
	public void testesUsuarioCorrecto() {
		assertEquals(1, G.esUsuarioCorrecto("UserPrueba", "prueba".toCharArray()));
	}

	// ahora simulamos que el usuario ha metido la contraseña mal
	@Test
	public void testesUsuarioCorrectoMalPass() {
		assertEquals(0, G.esUsuarioCorrecto("UserPrueba", "OhNoSeMeHaOlvidado".toCharArray()));
	}

	// ahora simulamos que el usuario ha metido el usuario mal
	@Test
	public void testesUsuarioCorrectoMalUser() {
		assertEquals(0, G.esUsuarioCorrecto("YEstoTambien", "OhNoSeMeHaOlvidado".toCharArray()));
	}
	
	//La funcion que comprueba si un correo existe se encuentra un correo que existe
	@Test
	public void testexisteCorreoSi() {
		assertEquals(true, G.existeCorreo("prueba@prueba.com"));
	}
	
	@Test
	public void crearBorrarusuario() {
		int userid = G.crearUsuario("prueba2", "superprueba@pruebisima.com", "Las contraseñas seguras son las comicamente largas".toCharArray());
		assertEquals(true,G.existeCorreo("superprueba@pruebisima.com"));
		assertEquals(userid,G.esUsuarioCorrecto("prueba2", "Las contraseñas seguras son las comicamente largas".toCharArray()));
		assertEquals(true,G.borrarUsuario(userid));
	}

	@After
	public void cerrar() {
		G.CerrarCon();
	}
}
