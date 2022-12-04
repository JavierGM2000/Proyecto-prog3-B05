package componentes;

import java.util.logging.Logger;

public class Carta {

	private int id;
	private TipoCarta tipo;
	private Buff bufo;
	private String descripcion;
	
	//Logger
		private static Logger loggerCarta = Logger.getLogger(Carta.class.getName());
		
	//Constructor con todos los parametros
	public Carta(int id, TipoCarta tipo, Buff bufo, String descripcion) {
		this.id = id;
		this.tipo = tipo;
		this.bufo = bufo;
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
	
	//Equals que compara dos cartas
	//Compara el tipo de carta y los buffos 
	public boolean equals(Carta otraCarta) {
		loggerCarta.info("Comparamos las cartas: " + otraCarta.getId() + " - " + this.id);
		if (otraCarta.getBufo()==bufo && otraCarta.getTipo()==tipo) {
			return true;
		}else {
			return false;
		}
	}
}
