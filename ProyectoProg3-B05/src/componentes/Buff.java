package componentes;

import java.util.logging.Logger;

public class Buff {
	private double buffProgreso;
	private double nerfProgreso;
	private double buffDinero;
	private double nerfDinero;
	private double buffFelicidad;
	private double nerfFelicidad;
	private double buffEstudio;
	private double nerfEstudio;
	private int modDias;

	//Logger
	private static Logger loggerBuff = Logger.getLogger(Carta.class.getName());
	
	// Contructor sin parametros. Por defecto en un día todos los buffos estan a 0
	public Buff() {
		buffProgreso = 0.0;
		nerfProgreso = 0.0;
		buffDinero = 0.0;
		nerfDinero = 0.0;
		buffFelicidad = 0.0;
		nerfFelicidad = 0.0;
		buffEstudio = 0.0;
		nerfEstudio = 0.0;
		modDias = 0;
		loggerBuff.info("Creado Buff sin parametros");
	}
	//Constructor con parametros
	public Buff(double buffProgreso, double nerfProgreso, double buffDinero, double nerfDinero, double buffFelicidad, double nerfFelicidad, double buffEstudio, double nerfEstudio, int modDias) {
		if (buffProgreso < -1) {
			this.buffProgreso = -1;
		}else {
			this.buffProgreso = buffProgreso;
		}
		
		if (nerfProgreso < -1) {
			this.nerfProgreso = -1;
		}else {
			this.nerfProgreso = nerfProgreso;
		}
		
		if (buffDinero < -1) {
			this.buffDinero = -1;
		}else {
			this.buffDinero = buffDinero;
		}
		
		if (nerfDinero < -1) {
			this.nerfDinero = -1;
		}else {
			this.nerfDinero = nerfDinero;
		}
		
		if (buffFelicidad < -1) {
			this.buffFelicidad = -1;
		}else {
			this.buffFelicidad = buffFelicidad;
		}
		
		if (nerfFelicidad < -1) {
			this.nerfFelicidad = -1;
		}else {
			this.nerfFelicidad = nerfFelicidad;
		}
		
		if (buffEstudio < -1) {
			this.buffEstudio = -1;
		}else {
			this.buffEstudio = buffEstudio;
		}
		
		if (nerfEstudio < -1) {
			this.nerfEstudio = -1;
		}else {
			this.nerfEstudio = nerfEstudio;
		}

		this.modDias = modDias;
		loggerBuff.info("Creado Buff con parametros");
	}

	/*
	 * Función para cambiar el valor del buff si queremos penalizar lo que gana el
	 * valor puede ser negativo
	 */
	public void addBuffProgreso(double cambio) {
		loggerBuff.info("Añadido BuffProgreso: " + cambio);
		// El valor del buff nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (buffProgreso + cambio < -1) {
			buffProgreso = -1;
			return;
		}
		buffProgreso += cambio;
	}

	/*
	 * Función para cambiar el valor del nerf si queremos reducir lo que pierde el
	 * valor puede ser negativo
	 */
	public void addNerfProgreso(double cambio) {
		loggerBuff.info("Añadido BuffProgreso: " + cambio);
		// El valor del nerf nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (nerfProgreso + cambio < -1) {
			nerfProgreso = -1;
			return;
		}
		nerfProgreso += cambio;
	}

	/*
	 * Función para cambiar el valor del buff si queremos penalizar lo que gana el
	 * valor puede ser negativo
	 */
	public void addBuffDinero(double cambio) {
		loggerBuff.info("Añadido BuffDinero: " + cambio);
		// El valor del buff nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (buffDinero + cambio < -1) {
			buffDinero = -1;
			return;
		}
		buffDinero += cambio;
	}

	/*
	 * Función para cambiar el valor del nerf si queremos reducir lo que pierde el
	 * valor puede ser negativo
	 */
	public void addNerfDinero(double cambio) {
		loggerBuff.info("Añadido NerfDinero: " + cambio);
		// El valor del nerf nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (nerfDinero + cambio < -1) {
			nerfDinero = -1;
			return;
		}
		nerfDinero += cambio;
	}

	/*
	 * Función para cambiar el valor del buff si queremos penalizar lo que gana el
	 * valor puede ser negativo
	 */
	public void addBuffFelicidad(double cambio) {
		loggerBuff.info("Añadido BuffFelicidad: " + cambio);
		// El valor del buff nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (buffFelicidad + cambio < -1) {
			buffFelicidad = -1;
			return;
		}
		buffFelicidad += cambio;
	}

	/*
	 * Función para cambiar el valor del nerf si queremos reducir lo que pierde el
	 * valor puede ser negativo
	 */
	public void addNerfFelicidad(double cambio) {
		loggerBuff.info("Añadido NerfFelicidad: " + cambio);
		// El valor del nerf nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (nerfFelicidad + cambio < -1) {
			nerfFelicidad = -1;
			return;
		}
		nerfFelicidad += cambio;
	}

	/*
	 * Función para cambiar el valor del buff si queremos penalizar lo que gana el
	 * valor puede ser negativo
	 */
	public void addBuffEstudio(double cambio) {
		loggerBuff.info("Añadido BuffEstudio: " + cambio);
		// El valor del buff nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (buffEstudio + cambio < -1) {
			buffEstudio = -1;
			return;
		}
		buffEstudio += cambio;
	}

	/*
	 * Función para cambiar el valor del nerf si queremos reducir lo que pierde el
	 * valor puede ser negativo
	 */
	public void addNerfEstudio(double cambio) {
		loggerBuff.info("Añadido NerfEstudio: " + cambio);
		// El valor del nerf nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (nerfEstudio + cambio < -1) {
			nerfEstudio = -1;
			return;
		}
		nerfEstudio += cambio;
	}
	//Funcion para modificar el modificador de días
	public void modifDias(int cambio) {
		loggerBuff.info("Dias modificados: " + cambio);
		modDias += cambio;
	}

	// Las funciones de añadir simétricos sirven para cuando queremos que un un buffo del
	// 20%, reduzca los nerfs en 20% también el nerf
	public void addBuffProgresoSimetrico(double cambio) {
		loggerBuff.info("Añadido BuffProgresoSimetrico: " + cambio);
		addBuffProgreso(cambio);
		addNerfProgreso(cambio * -1);
	}
	public void addBuffDineroimetrico(double cambio) {
		loggerBuff.info("Añadido BuffProgresoSimetrico: " + cambio);
		addBuffDinero(cambio);
		addNerfDinero(cambio * -1);
	}
	public void addBuffFelicidadimetrico(double cambio) {
		loggerBuff.info("Añadido BuffDineroimetrico: " + cambio);
		addBuffFelicidad(cambio);
		addNerfFelicidad(cambio * -1);
	}
	public void addBuffEstudioSimetrico(double cambio) {
		loggerBuff.info("Añadido BuffEstudioSimetrico: " + cambio);
		addBuffEstudio(cambio);
		addNerfEstudio(cambio * -1);
	}

	// getters
	public double getBuffProgreso() {
		loggerBuff.info("Devuelto BuffProgreso: " + buffProgreso);
		return buffProgreso;
	}

	public double getNerfProgreso() {
		loggerBuff.info("Devuelto NerfProgreso: " + nerfProgreso);
		return nerfProgreso;
	}

	public double getBuffDinero() {
		loggerBuff.info("Devuelto BuffDinero: " + buffDinero);
		return buffDinero;
	}

	public double getNerfDinero() {
		loggerBuff.info("Devuelto NerfDinero: " + nerfDinero);
		return nerfDinero;
	}

	public double getBuffFelicidad() {
		loggerBuff.info("Devuelto BuffFelicidad: " + nerfFelicidad);
		return buffFelicidad;
	}

	public double getNerfFelicidad() {
		loggerBuff.info("Devuelto NerfFelicidad: " + nerfFelicidad);
		return nerfFelicidad;
	}

	public double getBuffEstudio() {
		loggerBuff.info("Devuelto BuffEstudio: " + buffEstudio);
		return buffEstudio;
	}

	public double getNerfEstudio() {
		loggerBuff.info("Devuelto NerfEstudio: " + nerfEstudio);
		return nerfEstudio;
	}

	public int getModDias() {
		loggerBuff.info("Devuelto ModDias: " + modDias);
		return modDias;
	}
}
