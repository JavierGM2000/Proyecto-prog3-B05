package componentes;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Buff implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double buffProgreso;
	private double nerfProgreso;
	private double buffDinero;
	private double nerfDinero;
	private double buffFelicidad;
	private double nerfFelicidad;
	private int modDias;

	//Logger
	private static Logger loggerBuff = Logger.getLogger(Carta.class.getName());
	
	// Contructor sin parametros. Por defecto en un día todos los buffos estan a 0
	public Buff() {
		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (Exception ex) {
			loggerBuff.warning(String.format("%s - Error leyendo configuración del Logger: %s", 
										this.getClass(), ex.getMessage()));
		}
		buffProgreso = 1.0;
		nerfProgreso = 1.0;
		buffDinero = 1.0;
		nerfDinero = 1.0;
		buffFelicidad = 1.0;
		nerfFelicidad = 1.0;
		modDias = 0;
		loggerBuff.info("Creado Buff sin parametros");
	}
	//Constructor con parametros
	public Buff(double buffProgreso, double nerfProgreso, double buffDinero, double nerfDinero, double buffFelicidad, double nerfFelicidad, int modDias) {
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

		this.modDias = modDias;
		loggerBuff.info("Creado Buff con parametros");
	}

	/*
	 * Función para cambiar el valor del buff si queremos penalizar lo que gana el
	 * valor puede ser negativo
	 */
	public void addBuffProgreso(double cambio) {
		loggerBuff.fine("Añadido BuffProgreso: " + cambio);
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
		loggerBuff.fine("Añadido BuffProgreso: " + cambio);
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
		loggerBuff.fine("Añadido BuffDinero: " + cambio);
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
		loggerBuff.fine("Añadido NerfDinero: " + cambio);
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
		loggerBuff.fine("Añadido BuffFelicidad: " + cambio);
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
		loggerBuff.fine("Añadido NerfFelicidad: " + cambio);
		// El valor del nerf nunca puede ser negativo, si la operación daría menor que
		// -1, lo ponemos a -1
		if (nerfFelicidad + cambio < -1) {
			nerfFelicidad = -1;
			return;
		}
		nerfFelicidad += cambio;
	}


	//Funcion para modificar el modificador de días
	public void modifDias(int cambio) {
		loggerBuff.fine("Dias modificados: " + cambio);
		modDias += cambio;
	}

	// Las funciones de añadir simétricos sirven para cuando queremos que un un buffo del
	// 20%, reduzca los nerfs en 20% también el nerf
	public void addBuffProgresoSimetrico(double cambio) {
		loggerBuff.fine("Añadido BuffProgresoSimetrico: " + cambio);
		addBuffProgreso(cambio);
		addNerfProgreso(cambio * -1);
	}
	public void addBuffDineroimetrico(double cambio) {
		loggerBuff.fine("Añadido BuffProgresoSimetrico: " + cambio);
		addBuffDinero(cambio);
		addNerfDinero(cambio * -1);
	}
	public void addBuffFelicidadimetrico(double cambio) {
		loggerBuff.fine("Añadido BuffDineroimetrico: " + cambio);
		addBuffFelicidad(cambio);
		addNerfFelicidad(cambio * -1);
	}

	// getters
	public double getBuffProgreso() {
		loggerBuff.fine("Devuelto BuffProgreso: " + buffProgreso);
		return buffProgreso;
	}

	public double getNerfProgreso() {
		loggerBuff.fine("Devuelto NerfProgreso: " + nerfProgreso);
		return nerfProgreso;
	}

	public double getBuffDinero() {
		loggerBuff.fine("Devuelto BuffDinero: " + buffDinero);
		return buffDinero;
	}

	public double getNerfDinero() {
		loggerBuff.fine("Devuelto NerfDinero: " + nerfDinero);
		return nerfDinero;
	}

	public double getBuffFelicidad() {
		loggerBuff.fine("Devuelto BuffFelicidad: " + nerfFelicidad);
		return buffFelicidad;
	}

	public double getNerfFelicidad() {
		loggerBuff.fine("Devuelto NerfFelicidad: " + nerfFelicidad);
		return nerfFelicidad;
	}

	public int getModDias() {
		loggerBuff.fine("Devuelto ModDias: " + modDias);
		return modDias;
	}
	
	public boolean isNotNull(double bufo) {
		if (bufo==0.0) {
			loggerBuff.fine("El bufo NO es nulo");
			return false;
		}else {
			loggerBuff.fine("El bufo SI es nulo");
			return true;
		}
	}
	
	public String toStringGuardado() {
		String resultado = "";
		if(this.isNotNull(buffDinero)) {
			resultado = resultado + "Bufo dinero-" + getBuffDinero() + "-";
		}
		if(this.isNotNull(nerfDinero)) {
			resultado = resultado + "Nerf dinero-" +getNerfDinero() + "-";
		}
		if(this.isNotNull(buffFelicidad)) {
			resultado = resultado + "Bufo felicidad-" +getBuffFelicidad() + "-";
		}
		if(this.isNotNull(nerfFelicidad)) {
			resultado = resultado + "Nerf felicidad-" +getNerfFelicidad() + "-";
		}
		if(this.isNotNull(buffProgreso)) {
			resultado = resultado + "Bufo progreso-" +getBuffProgreso() + "-";
		}
		if(this.isNotNull(nerfProgreso)) {
			resultado = resultado + "Nerf progreso-" +getNerfProgreso() + "-";
		}
		if(this.isNotNull(modDias)) {
			resultado = resultado + "Modificacion de dias-" +getModDias() + "-";
		}
		return resultado;
	}
	public String toString() {
		String resultado = "";
		if(this.isNotNull(buffDinero)) {
			resultado = resultado + "Bufo dinero: " + getBuffDinero() + "\n";
		}
		if(this.isNotNull(nerfDinero)) {
			resultado = resultado + "Nerf dinero: " +getNerfDinero() + "\n";
		}
		if(this.isNotNull(buffFelicidad)) {
			resultado = resultado + "Bufo felicidad: " +getBuffFelicidad() + "\n";
		}
		if(this.isNotNull(nerfFelicidad)) {
			resultado = resultado + "Nerf felicidad: " +getNerfFelicidad() + "\n";
		}
		if(this.isNotNull(buffProgreso)) {
			resultado = resultado + "Bufo progreso: " +getBuffProgreso() + "\n";
		}
		if(this.isNotNull(nerfProgreso)) {
			resultado = resultado + "Nerf progreso: " +getNerfProgreso() + "\n";
		}
		if(this.isNotNull(modDias)) {
			resultado = resultado + "Modificacion de dias: " +getModDias() + "\n";
		}
		return resultado;
	}
}
