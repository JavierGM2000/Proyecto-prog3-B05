package sistemas;

import componentes.Buff;

public class ControladorEstado {
	//Atributos basicos
	private double progreso;
	private double dinero;
	private double felicidad;
	private double estudios;
	//Variables que controlan el día y las horas
	private int dia;
	private int horasInicial;
	private int horasActuales;
	//El string de buffos, cada posición representa un día y si tiene valor dentro los buffos
	private Buff[] buffos;
	
	//Constructor vacio para cuando creamos una nueva partida
	public ControladorEstado() {
		progreso=0.0;
		dinero=100.0;
		felicidad=50.0;
		estudios=0.0;
		dia=0;//El contador de dias empezará en 0 para ir a la par con el array de buffos
		horasInicial=12;//Valor base de horas que hay en un día sin buffos
		buffos = new Buff[30];
	}
	
	// Geters de la clase
	public double getProgreso() {
		return progreso;
	}
	public double getDinero() {
		return dinero;
	}
	public double getFelicidad() {
		return felicidad;
	}
	public double getEstudios() {
		return estudios;
	}
	public int getDia() {
		return dia;
	}
	public int getHorasActuales() {
		return horasActuales;
	}
}
