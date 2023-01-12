package componentes;

import java.util.logging.Logger;

public class Carta {

	private int id;
	private TipoCarta tipo;
	private Buff bufo;
	private int salud;
	private int dinero;
	private int progreso;
	private String descripcion;
	
	//Logger
		private static Logger loggerCarta = Logger.getLogger(Carta.class.getName());
		
	//Constructor con todos los parametros
	public Carta(int id, TipoCarta tipo, Buff bufo, int salud, int dinero, int progreso, String descripcion) {
		this.id = id;
		this.tipo = tipo;
		this.bufo = bufo;
		this.salud = salud;
		this.dinero = dinero;
		this.progreso = progreso;
		this.descripcion = descripcion;
		loggerCarta.info("Carta creada con: " + id + " - " + tipo + " - " + descripcion);
	}

	//Getters
	public TipoCarta getTipo() {
		loggerCarta.info("Devuelto el valor de Tipo de carta");
		return tipo;
	}

	public Buff getBufo() {
		loggerCarta.info("Devuelto el valor de Bufo");
		return bufo;
	}

	public String getDescripcion() {
		loggerCarta.info("Devuelto el valor de la Descripcion ");
		return descripcion;
	}
	
	public int getId() {
		loggerCarta.info("Devuelto el valor del id");
		return id;
	}
	
	public int getSalud() {
		return this.salud;
	}
	
	public int getDinero() {
		return this.dinero;
	}
	
	public int getProgreso() {
		return this.progreso;
	}
	//Equals que compara dos cartas
	//Compara el tipo de carta y los buffos 
	public boolean equals(Carta otraCarta) {
		loggerCarta.info("Comparamos las cartas: " + otraCarta.getId() + " - " + this.id);
		if (otraCarta.getBufo()==bufo && otraCarta.getTipo()==tipo && otraCarta.getSalud()==salud &&
			otraCarta.getDinero()==dinero && otraCarta.getProgreso()==progreso) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return id+"#"+tipo+"#"+bufo.toString()+"#"+salud+"#"+dinero+"#"+progreso+"#"+descripcion;
	}
}
