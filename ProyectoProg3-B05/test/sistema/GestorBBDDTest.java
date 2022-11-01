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
		assertEquals(1, G.esUsuarioCorrecto("UserPrueba", "prueba"));
	}

	// ahora simulamos que el usuario ha metido la contraseña mal
	@Test
	public void testesUsuarioCorrectoMalPass() {
		assertEquals(0, G.esUsuarioCorrecto("UserPrueba", "OhNoSeMeHaOlvidado"));
	}

	// ahora simulamos que el usuario ha metido el usuario mal
	@Test
	public void testesUsuarioCorrectoMalUser() {
		assertEquals(0, G.esUsuarioCorrecto("YEstoTambien", "OhNoSeMeHaOlvidado"));
	}

	@After
	public void cerrar() {
		G.CerrarCon();
	}
}
