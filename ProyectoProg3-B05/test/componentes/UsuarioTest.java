package componentes;

import static org.junit.Assert.*;
import org.junit.Before;

import componentes.Usuario;
import sistemas.GestorBBDD;

import org.junit.Test;

public class UsuarioTest {

	Usuario u;
	
	@Before
	public void setUp() {
		u = new Usuario("Alfonso", 0);
	}
	
	@Test
	public void getIdTest() {
		assertEquals(u.getId(), 0);
	}
	
	@Test
	public void getNombreTest() {
		assertEquals(u.getNombre(), "Alfonso");
	}
	
	@Test
	public void getTipoTest() {
		assertEquals(u.getTipo(), TipoUsuario.JUGADOR);
	}

}
