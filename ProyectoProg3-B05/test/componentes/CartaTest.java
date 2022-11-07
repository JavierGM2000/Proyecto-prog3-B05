package componentes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartaTest {

	Carta carta;
	Carta carta2;
	Carta carta3;
	Carta carta4;
	Buff b;
	Buff b1;
	
	@Before
	public void setUp() {
		b1 = new Buff(0.5, 0.8, 0.7, 0.7, 0.3, 0.8, 0.2, 0.4, 3);
		carta = new Carta(TipoCarta.ESTUDIO, b, "descripcion");
		carta2 = new Carta(TipoCarta.ESTUDIO, b, "descripcion");
		carta3 = new Carta(TipoCarta.OCIO, b, "descripcion");
		carta4 = new Carta(TipoCarta.ESTUDIO, b1, "descripcion");
	}
	
	@Test
	public void testgetTipo() {
		assertEquals(carta.getTipo(), TipoCarta.ESTUDIO);
	}
	@Test
	public void testgetBufo() {
		assertEquals(carta.getBufo(), b);
	}
	@Test
	public void testgetDescripcion() {
		assertEquals(carta.getDescripcion(), "descripcion");
	}
	@Test
	public void testEqualsIguales() {
		assertTrue(carta.equals(carta2));
	}
	@Test
	public void testEqualsDiferentesC1() {
		assertFalse(carta.equals(carta3));
	}
	@Test
	public void testEqualsDIferenteC2() {
		assertFalse(carta.equals(carta4));
	}
}
