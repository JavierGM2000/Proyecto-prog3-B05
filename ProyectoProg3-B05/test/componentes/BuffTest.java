package componentes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuffTest {

	Buff b;
	@Before
	public void setUp() throws Exception {
		b = new Buff();
	}

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
