package componentes;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Carta {

	private int id;
	private TipoCarta tipo;
	private Buff bufo;
	private int salud;
	private int dinero;
	private int progreso;
	private int horas;
	private String descripcion;
	
	//Logger
		private static Logger loggerCarta = Logger.getLogger(Carta.class.getName());
		
	//Constructor con todos los parametros
	public Carta(int id, TipoCarta tipo, Buff bufo, int salud, int dinero, int progreso, int horas, String descripcion) {
		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (Exception ex) {
			loggerCarta.warning(String.format("%s - Error leyendo configuración del Logger: %s", 
										this.getClass(), ex.getMessage()));
		}
		this.id = id;
		this.tipo = tipo;
		this.bufo = bufo;
		this.salud = salud;
		this.dinero = dinero;
		this.progreso = progreso;
		this.horas = horas;
		this.descripcion = descripcion;
		loggerCarta.info(String.format("Carta creada con: Id -> %d - Tipo -> %s- Salud -> %d - Dinero -> %d - Progreso -> %d - Horas -> %d", id,tipo.toString(),salud,dinero,progreso,horas));
	}

	//Getters
	public TipoCarta getTipo() {
		loggerCarta.fine("Devuelto tipo: " + tipo.toString());
		return tipo;
	}

	public Buff getBufo() {
		loggerCarta.fine("Devuelto bufo");
		return bufo;
	}

	public String getDescripcion() {
		loggerCarta.fine("Devuelta descripcion");
		return descripcion;
	}
	
	public int getId() {
		loggerCarta.fine("Devuelta Id: " + id);
		return id;
	}
	
	public int getSalud() {
		loggerCarta.fine("Devuelta salud: " + salud);
		return this.salud;
	}
	
	public int getDinero() {
		loggerCarta.fine("Devuelto dinero: " + dinero);
		return this.dinero;
	}
	
	public int getProgreso() {
		loggerCarta.fine("Devuelto progreso: " + progreso);
		return this.progreso;
	}
	
	public int getHoras() {
		loggerCarta.fine("Devueltas horas: " + horas);
		return this.horas;
	}
	//Equals que compara dos cartas
	//Compara el tipo de carta y los buffos 
	public boolean equals(Carta otraCarta) {
		loggerCarta.fine("Comparamos las cartas: " + otraCarta.getId() + " - " + this.id);
		if (otraCarta.getBufo()==bufo && otraCarta.getTipo()==tipo && otraCarta.getSalud()==salud &&
			otraCarta.getDinero()==dinero && otraCarta.getProgreso()==progreso && otraCarta.getHoras()==horas) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return id+"#"+tipo+"#"+bufo.toStringGuardado()+"#"+salud+"#"+dinero+"#"+progreso+"#"+horas+"#"+descripcion;
	}
}
