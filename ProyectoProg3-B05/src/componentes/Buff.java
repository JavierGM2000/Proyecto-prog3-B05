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
}
