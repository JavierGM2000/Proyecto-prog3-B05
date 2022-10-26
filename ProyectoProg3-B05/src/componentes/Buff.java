package componentes;

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
	}

	/*
	 * Función para cambiar el valor del buff si queremos penalizar lo que gana el
	 * valor puede ser negativo
	 */
	public void addBuffProgreso(double cambio) {
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
	public void addbuffDinero(double cambio) {
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
		modDias += cambio;
	}

	// Las funciones de añadir simétricos sirven bara queremos que un un buffo del
	// 20%, reduzca los nerfs en 20% también el nerf
	public void addBuffProgresoSimetrico(double cambio) {
		addBuffProgreso(cambio);
		addNerfProgreso(cambio * -1);
	}
	public void addBuffDineroimetrico(double cambio) {
		addbuffDinero(cambio);
		addNerfDinero(cambio * -1);
	}
	public void addBuffFelicidadimetrico(double cambio) {
		addBuffFelicidad(cambio);
		addNerfFelicidad(cambio * -1);
	}
	public void addBuffEstudioSimetrico(double cambio) {
		addBuffEstudio(cambio);
		addNerfEstudio(cambio * -1);
	}

	// getters
	public double getBuffProgreso() {
		return buffProgreso;
	}

	public double getNerfProgreso() {
		return nerfProgreso;
	}

	public double getBuffDinero() {
		return buffDinero;
	}

	public double getNerfDinero() {
		return nerfDinero;
	}

	public double getBuffFelicidad() {
		return buffFelicidad;
	}

	public double getNerfFelicidad() {
		return nerfFelicidad;
	}

	public double getBuffEstudio() {
		return buffEstudio;
	}

	public double getNerfEstudio() {
		return nerfEstudio;
	}

	public int getModDias() {
		return modDias;
	}
}
