package componentes;

public class Carta {

	private TipoCarta tipo;
	private Buff bufo;
	private String descripcion;
	
	//Constructor con todos los parametros
	public Carta(TipoCarta tipo, Buff bufo, String descripcion) {
		this.tipo = tipo;
		this.bufo = bufo;
		this.descripcion = descripcion;
	}

	//Getters
	public TipoCarta getTipo() {
		return tipo;
	}

	public Buff getBufo() {
		return bufo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	//Equals que compara dos cartas
	//Compara el tipo de carta y los buffos 
	public boolean equals(Carta otraCarta) {
		if (otraCarta.getBufo()==bufo && otraCarta.getTipo()==tipo) {
			return true;
		}else {
			return false;
		}
	}

}
