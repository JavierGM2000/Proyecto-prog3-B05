package sistemas;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;

import componentes.Buff;
import componentes.Carta;
import ventanas.VentanaJuegoPrincipal;

public class ControladorEstado {
	
	// Gestor Ventana
	private GestorVentanas gestorV;
	//Atributos basicos
	private int partidaid;
	private int progreso;
	private int dinero;
	private int salud;

	//Variables que controlan el día y las horas
	private int dia;
	private int horasInicial;
	private int horasActuales;
	//El string de buffos, cada posición representa un día y si tiene valor dentro los buffos
	private Buff[] buffos;
	
	//Constructor vacio para cuando creamos una nueva partida
	public ControladorEstado(GestorVentanas gestorV) {
		this.gestorV = gestorV;
		partidaid=0;
		progreso=0;
		dinero=100;
		salud=50;
		dia=0;//El contador de dias empezará en 0 para ir a la par con el array de buffos
		horasInicial=12;//Valor base de horas que hay en un día sin buffos
		horasActuales=12;
		buffos = new Buff[30];
	}
	
	//Constructor para cuando creamos una partida nueva con una id
		public ControladorEstado(int partId, GestorVentanas gestorV) {
			this.gestorV = gestorV;
			partidaid = partId;
			progreso=0;
			dinero=100;
			salud=50;
			dia=0;//El contador de dias empezará en 0 para ir a la par con el array de buffos
			horasInicial=12;//Valor base de horas que hay en un día sin buffos
			horasActuales=12;
			buffos = new Buff[30];
		}

	public void verificarDia() {
		if(dia >= 30) {
			if(getProgreso() >= 50) {
				finDelJuegoBueno();				
			}
			if(getProgreso() < 50) {
				finDelJuegoMalo();
			}
		}if (dia < 30) {
			if(getSalud() > 0) {
				setDia(getDia() + 1);
			} if(getSalud() <= 0) {
				finDelJuegoMitad();
			}
		}
		
	}
	
	public void verificarSalud() {
		if (salud <= 0){
			finDelJuegoMalo();
		}
	}
	
	public Boolean verificarDinero(Carta carta) {
		if (this.dinero+carta.getDinero()>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void verificarProgreso() {
		if (progreso >= 100) {
			finDelJuegoBueno();
		}
	}

	public void aplicarCarta(Carta cartaA) {
		if (verificarDinero(cartaA)) {
			this.buffos[cartaA.getBufo().getModDias()] = cartaA.getBufo();
			if (this.buffos[dia]!= null){
				if (this.salud<=100 && this.salud>=0) {
					this.salud = (int) (this.salud+cartaA.getSalud()*this.buffos[dia].getBuffFelicidad());
					if (this.salud<0){this.salud=0;}
					if (this.salud>100){this.salud=100;}
				}
				if (this.dinero<=500 && this.dinero>=0) {
					this.dinero = (int) (this.dinero+cartaA.getDinero()*this.buffos[dia].getBuffDinero());
					if (this.dinero<0){this.dinero=0;}
					if (this.dinero>500){this.dinero=500;}
				}
				if (this.progreso<=100 && this.progreso>=0) {
					this.progreso = (int) (this.progreso+cartaA.getProgreso()*this.buffos[dia].getBuffProgreso());
					if (this.progreso>100){this.progreso=100;}
				}
			}else {
				if (this.salud<=100 && this.salud>=0) {
					this.salud = this.salud+cartaA.getSalud();
					if (this.salud<0){this.salud=0;}
					if (this.salud>100){this.salud=100;}
				}
				if (this.dinero<=500 && this.dinero>=0) {
					this.dinero = this.dinero+cartaA.getDinero();
					if (this.dinero<0){this.dinero=0;}
					if (this.dinero>500){this.dinero=500;}
				}
				if (this.progreso<=100 && this.progreso>=0) {
					this.progreso = this.progreso+cartaA.getProgreso();
					if (this.progreso>100){this.progreso=100;}
				}
				
			}
			this.horasActuales = this.horasActuales-cartaA.getHoras();
		}	
	}
	
	public void finDelJuegoBueno() {
		
		// TODO Auto-generated method stub
		
		// JOptionPane ("Enhorabuena has aprobado con (Cantidad de porcentaje)
		// y ademas eres la hostia (si el animo )") 
		// con la siguientes opciones :
		// Opcion 1: Ir al menu del juego (pantalla de partidas)
		// Opcion 2: Crear nueva partida
		
		String[] opciones = {"Ir al Menu"};
		
		String frase = String.format("Enhorabuena has finalizado el proyecto con un %d%%.", getProgreso());
		
		if(getSalud()>= 80){
			frase += " Ademas tienes la moral POR LAS NUBES!!";
		} else if(getSalud() >= 40) {
			frase += " Estas sastisfecho pero, destrozado";
		} else {
			frase += " Tu salud está en PELIGRO!";
		}
		
		int opcion = JOptionPane.showOptionDialog(null, frase, "Final del juego", 0, JOptionPane.PLAIN_MESSAGE, null, opciones, "Ir al Menu");
		
		if(opcion == 0) { // Ir al menu
			gestorV.cambiarVentana(2);
		}
	}
	
	public void finDelJuegoMalo() {
		
		String[] opciones = {"Ir al Menu"};
		
		String frase = String.format("No llegaste a aprobar el proyecto, solo conseguiste un %d%%.", getProgreso());
		
		if(getSalud()>= 80){
			frase += " PODRÍAS HABER HECHO MÁS!!";
		} else if(getSalud() >= 40) {
			frase += " Y te has esforzado";
		} else {
			frase += " Y Desgraciadamente, ni te has acercado";
		}
		
		int opcion = JOptionPane.showOptionDialog(null, frase, "Final del juego", 0, JOptionPane.PLAIN_MESSAGE, null, opciones, "Ir al Menu");
		
		if(opcion == 0) { // Ir al menu
			gestorV.cambiarVentana(2);
		}
	}
	
	public void finDelJuegoMitad() {
		
		String[] opciones = {"Ir al Menu"};
		
		String frase = String.format("Has colapsado de tanto trabajar cuando el proyecto iba un %d%%.", getProgreso());
		
		int opcion = JOptionPane.showOptionDialog(null, frase, "Final del juego", 0, JOptionPane.PLAIN_MESSAGE, null, opciones, "Ir al Menu");
		
		if(opcion == 0) { // Ir al menu
			gestorV.cambiarVentana(2);
		}
	}

	public boolean GuardarPartida() {
		JSONObject obj = new JSONObject();
		obj.put("progreso", this.progreso);
		obj.put("salud", this.salud);
		obj.put("dia", this.dia);
		obj.put("horasInicial", this.horasInicial);
		obj.put("horasActuales", this.horasActuales);
		obj.put("buffos", this.buffos);
		return false;
	}
	
	// Geters de la clase
	public int getProgreso() {
		return progreso;
	}
	public int getDinero() {
		return dinero;
	}
	public int getSalud() {
		return salud;
	}
	public int getDia() {
		return dia;
	}
	public int getHorasActuales() {
		return horasActuales;
	}
	
	public int getHorasIniciales() {
		return horasInicial;
	}
	
	public void setHorasActuales(int horasActuales) {
		this.horasActuales = horasActuales;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	
	public GestorVentanas getGestorV() {
			return gestorV;
		}

//	public static void main(String[] args) {
//		ControladorEstado ce = new ControladorEstado();
//		ce.finDelJuegoMalo();
//	}
}
