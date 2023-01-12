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
		b1 = new Buff(0.5, 0.8, 0.7, 0.7, 0.3, 0.8, 3);
		carta = new Carta(1, TipoCarta.ESTUDIO, b, -15, 0, 30, "descripcion");
		carta2 = new Carta(1, TipoCarta.ESTUDIO, b, -15,0,30,"descripcion");
		carta3 = new Carta(1, TipoCarta.OCIO, b, 35,-20,0,"descripcion");
		carta4 = new Carta(1, TipoCarta.ESTUDIO, b1, -10,0,20,"descripcion");
	}
	
	@Test
	public void testgetId() {
		assertEquals(carta.getId(), 1);
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
	public void testgetSalud() {
		assertEquals(carta.getSalud(), -15);
	}
	@Test
	public void testgetSalud2() {
		assertEquals(carta3.getSalud(), 35);
	}
	@Test
	public void testgetDinero() {
		assertEquals(carta.getDinero(), 0);
	}
	@Test
	public void testgetDinero2() {
		assertEquals(carta3.getDinero(), -20);
	}
	@Test
	public void testgetProgreso() {
		assertEquals(carta.getProgreso(), 30);
	}
	@Test
	public void testgetProgreso2() {
		assertEquals(carta3.getProgreso(), 0);
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
