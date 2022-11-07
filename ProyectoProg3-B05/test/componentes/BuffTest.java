package componentes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuffTest {

	Buff b;
	Buff b1;
	Buff b2;
	@Before
	public void setUp() throws Exception {
		b = new Buff();
		b1 = new Buff(0.5, 0.8, 0.7, 0.7, 0.3, 0.8, 0.2, 0.4, 3);
		b2 = new Buff(-1.3, -1.8, -1.7, -2.7, -1.3, -1.8, -1.2, -1.4, 3);
	}
	//Teses del constructor con parametros
	@Test
	public void testConstructorBuffProgreso() {
		assertEquals(0.5, b1.getBuffProgreso(), 0);
	}
	@Test
	public void testConstructorBuffProgresoNegativo() {
		assertEquals(-1.0, b2.getBuffProgreso(), 0);
	}
	@Test
	public void testConstructorNerfProgreso() {
		assertEquals(0.8, b1.getNerfProgreso(), 0);
	}
	@Test
	public void testConstructorNerfProgresoNegativo() {
		assertEquals(-1, b2.getNerfProgreso(), 0);
	}
	@Test
	public void testConstructorBuffDinero() {
		assertEquals(0.7, b1.getBuffDinero(), 0);
	}
	@Test
	public void testConstructorBuffDineroNegativo() {
		assertEquals(-1.0, b2.getBuffDinero(), 0);
	}
	@Test
	public void testConstructorNerfDinero() {
		assertEquals(0.7, b1.getBuffDinero(), 0);
	}
	@Test
	public void testConstructorNerfDineroNegativo() {
		assertEquals(-1.0, b2.getBuffDinero(), 0);
	}
	@Test
	public void testConstructorBuffFelicidad() {
		assertEquals(0.3, b1.getBuffFelicidad(), 0);
	}
	@Test
	public void testConstructorBuffFelicidadNegativo() {
		assertEquals(-1.0, b2.getBuffFelicidad(), 0);
	}
	@Test
	public void testConstructorNerfFelicidad() {
		assertEquals(0.8, b1.getNerfFelicidad(), 0);
	}
	@Test
	public void testConstructorNerfFelicidadNegativo() {
		assertEquals(-1.0, b2.getNerfFelicidad(), 0);
	}
	@Test
	public void testConstructorBuffEstudio() {
		assertEquals(0.2, b1.getBuffEstudio(), 0);
	}
	@Test
	public void testConstructorBuffEstudioNegativo() {
		assertEquals(-1.0, b2.getNerfEstudio(), 0);
	}
	@Test
	public void testConstructorNerfEstudio() {
		assertEquals(0.4, b1.getNerfEstudio(), 0);
	}
	@Test
	public void testConstructorNerfEstudioNegativo() {
		assertEquals(-1.0, b2.getNerfEstudio(), 0);
	}
	@Test
	public void testConstructorModDias() {
		assertEquals(3, b1.getModDias(), 0);
	}
	
	//Teses de funciones
	@Test
	public void testAddBuffProgreso() {
		b.addBuffProgreso(0.2);
		assertEquals(0.2,b.getBuffProgreso(), 0);
	}
	@Test
	public void testAddBuffProgresoNegativo() {
		b.addBuffProgreso(-0.2);
		assertEquals(-0.2,b.getBuffProgreso(),0);
	}
	@Test
	public void testAddBuffProgresoNegativoMax() {
		b.addBuffProgreso(-2);
		assertEquals(-1,b.getBuffProgreso(),0);
	}
	@Test
	public void testAddNerfProgreso() {
		b.addNerfProgreso(0.2);
		assertEquals(0.2,b.getNerfProgreso(), 0);
	}
	@Test
	public void testAddNerfProgresoNegativo() {
		b.addNerfProgreso(-0.2);
		assertEquals(-0.2,b.getNerfProgreso(),0);
	}
	@Test
	public void testAddNerfProgresoNegativoMax() {
		b.addNerfProgreso(-2);
		assertEquals(-1,b.getNerfProgreso(),0);
	}
	@Test
	public void testAddbuffDinero() {
		b.addbuffDinero(0.2);
		assertEquals(0.2,b.getBuffDinero(), 0);
	}
	@Test
	public void testAddbuffDineroNegativo() {
		b.addbuffDinero(-0.2);
		assertEquals(-0.2,b.getBuffDinero(),0);
	}
	@Test
	public void testAddbuffDineroNegativoMax() {
		b.addbuffDinero(-2);
		assertEquals(-1,b.getBuffDinero(),0);
	}
	@Test
	public void testAddNerfDinero() {
		b.addNerfDinero(0.2);
		assertEquals(0.2,b.getNerfDinero(), 0);
	}
	@Test
	public void testAddNerfDineroNegativo() {
		b.addNerfDinero(-0.2);
		assertEquals(-0.2,b.getNerfDinero(),0);
	}
	@Test
	public void testAddNerfDineroNegativoMax() {
		b.addNerfDinero(-2);
		assertEquals(-1,b.getNerfDinero(),0);
	}
	@Test
	public void testAddbuffFelicidad() {
		b.addBuffFelicidad(0.2);
		assertEquals(0.2,b.getBuffFelicidad(), 0);
	}
	@Test
	public void testAddbuffFelicidadNegativo() {
		b.addBuffFelicidad(-0.2);
		assertEquals(-0.2,b.getBuffFelicidad(),0);
	}
	@Test
	public void testAddbuffFelicidadNegativoMax() {
		b.addBuffFelicidad(-2);
		assertEquals(-1,b.getBuffFelicidad(),0);
	}
	@Test
	public void testAddNerfFelicidad() {
		b.addNerfFelicidad(0.2);
		assertEquals(0.2,b.getNerfFelicidad(), 0);
	}
	@Test
	public void testAddNerfFelicidadNegativo() {
		b.addNerfFelicidad(-0.2);
		assertEquals(-0.2,b.getNerfFelicidad(),0);
	}
	@Test
	public void testAddNerfFelicidadNegativoMax() {
		b.addNerfFelicidad(-2);
		assertEquals(-1,b.getNerfFelicidad(),0);
	}
	@Test
	public void testAddbuffEstudio() {
		b.addBuffEstudio(0.2);
		assertEquals(0.2,b.getBuffEstudio(), 0);
	}
	@Test
	public void testAddbuffEstudioNegativo() {
		b.addBuffEstudio(-0.2);
		assertEquals(-0.2,b.getBuffEstudio(),0);
	}
	@Test
	public void testAddbuffEstudioNegativoMax() {
		b.addBuffEstudio(-2);
		assertEquals(-1,b.getBuffEstudio(),0);
	}
	@Test
	public void testAddNerfEstudio() {
		b.addNerfEstudio(0.2);
		assertEquals(0.2,b.getNerfEstudio(), 0);
	}
	@Test
	public void testAddNerfEstudioNegativo() {
		b.addNerfEstudio(-0.2);
		assertEquals(-0.2,b.getNerfEstudio(),0);
	}
	@Test
	public void testAddNerfEstudioNegativoMax() {
		b.addNerfEstudio(-2);
		assertEquals(-1,b.getNerfEstudio(),0);
	}
	@Test
	public void testAddBuffProgresoSim() {
		b.addBuffProgresoSimetrico(0.2);
		assertEquals(0.2,b.getBuffProgreso(),0);
		assertEquals(-0.2,b.getNerfProgreso(),0);
	}
	@Test
	public void testAddBuffProgresoSimMinNer() {
		b.addBuffProgresoSimetrico(2);
		assertEquals(2,b.getBuffProgreso(),0);
		assertEquals(-1,b.getNerfProgreso(),0);
	}
	@Test
	public void testAddBuffProgresoSimMinBuf() {
		b.addBuffProgresoSimetrico(-2);
		assertEquals(-1,b.getBuffProgreso(),0);
		assertEquals(2,b.getNerfProgreso(),0);
	}
	@Test
	public void testAddBuffDineroSim() {
		b.addBuffDineroimetrico(0.2);
		assertEquals(0.2,b.getBuffDinero(),0);
		assertEquals(-0.2,b.getNerfDinero(),0);
	}
	@Test
	public void testAddBuffDineroSimMinNer() {
		b.addBuffDineroimetrico(2);
		assertEquals(2,b.getBuffDinero(),0);
		assertEquals(-1,b.getNerfDinero(),0);
	}
	@Test
	public void testAddBuffDineroSimMinBuf() {
		b.addBuffDineroimetrico(-2);
		assertEquals(-1,b.getBuffDinero(),0);
		assertEquals(2,b.getNerfDinero(),0);
	}
	@Test
	public void testAddBuffFelicidadSim() {
		b.addBuffFelicidadimetrico(0.2);
		assertEquals(0.2,b.getBuffFelicidad(),0);
		assertEquals(-0.2,b.getNerfFelicidad(),0);
	}
	@Test
	public void testAddBuffFelicidadSimMinNer() {
		b.addBuffFelicidadimetrico(2);
		assertEquals(2,b.getBuffFelicidad(),0);
		assertEquals(-1,b.getNerfFelicidad(),0);
	}
	@Test
	public void testAddBuffFelicidadSimMinBuf() {
		b.addBuffFelicidadimetrico(-2);
		assertEquals(-1,b.getBuffFelicidad(),0);
		assertEquals(2,b.getNerfFelicidad(),0);
	}
	@Test
	public void testAddBuffEstudioSim() {
		b.addBuffEstudioSimetrico(0.2);
		assertEquals(0.2,b.getBuffEstudio(),0);
		assertEquals(-0.2,b.getNerfEstudio(),0);
	}
	@Test
	public void testAddBuffEstudioSimMinNer() {
		b.addBuffEstudioSimetrico(2);
		assertEquals(2,b.getBuffEstudio(),0);
		assertEquals(-1,b.getNerfEstudio(),0);
	}
	@Test
	public void testAddBuffEstudioSimMinBuf() {
		b.addBuffEstudioSimetrico(-2);
		assertEquals(-1,b.getBuffEstudio(),0);
		assertEquals(2,b.getNerfEstudio(),0);
	}
	@Test
	public void testModDias() {
		b.modifDias(2);
		assertEquals(2,b.getModDias());
	}
	@Test
	public void testModDiasNeg() {
		b.modifDias(-2);
		assertEquals(-2,b.getModDias());
	}
	@Test
	public void testModDiasZero() {
		b.modifDias(0);
		assertEquals(0,b.getModDias());
	}
	
}
