package componentes;

public class Buff {
	private double buffProgeso;
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
		buffProgeso = 0.0;
		nerfProgreso = 0.0;
		buffDinero = 0.0;
		nerfDinero = 0.0;
		buffFelicidad = 0.0;
		nerfFelicidad = 0.0;
		buffEstudio = 0.0;
		nerfEstudio = 0.0;
		modDias = 0;
	}
}
