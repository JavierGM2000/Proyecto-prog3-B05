package sistemas;

public class ControladorEstado {
	//Atributos basicos
	private double progreso;
	private double dinero;
	private double felicidad;
	private double estudios;
	//Modificadores a la hora de asignar el valor
	private int modProgre;
	private int modDinero;
	private int modFelici;
	private int modEstudi;
	//Variables que controlan el día y las horas
	private int dia;
	private int horasInicial;
	private int horasActuales;
	//El string de buffos, cada posición representa un día y si tiene valor dentro los buffos
	private String[] buffos;
	
	//Constructor vacio para cuando creamos una nueva partida
	public ControladorEstado() {
		progreso=0.0;
		dinero=100.0;
		felicidad=50.0;
		estudios=0.0;
		dia=0;//El contador de dias empezará en 0 para ir a la par con el array de buffos
		horasInicial=12;//Valor base de horas que hay en un día sin buffos
		buffos = new String[30];
	}
}
