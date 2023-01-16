package sistemas;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.swing.JFrame;

import componentes.Carta;
import componentes.Usuario;
import ventanas.VentanaBase;
import ventanas.VentanaCrearCuenta;
import ventanas.VentanaLogin;
import ventanas.VentanaPartidaSelec;
import ventanas.VentanaJuegoPrincipal;

public class GestorVentanas implements Serializable{

	private static final long serialVersionUID = 1L;
	GestorBBDD GBBDD;
	Usuario Usu;
	int actual;

	// Logger
	private static Logger loggeGV = Logger.getLogger(Carta.class.getName());

	VentanaBase[] ventanas;

	public GestorVentanas(GestorBBDD inGBBDD) {
		actual = 0;
		GBBDD = inGBBDD;
		ventanas = new VentanaBase[5];
		ventanas[0] = new VentanaLogin(GBBDD, this);
		ventanas[1] = new VentanaCrearCuenta(GBBDD, this);
		ventanas[2] = new VentanaPartidaSelec(GBBDD, this);
		ventanas[3] = null;
		ventanas[0].setVisible(true);
	}

	public void cambiarVentana(int idVentana) {
		loggeGV.info(String.format("Cambiando ventana a la número %d", idVentana));
		ventanas[actual].setVisible(false);
		actual = idVentana;
		ventanas[idVentana].prepararInit();
		ventanas[idVentana].setVisible(true);
	}
	
	public void empezarNuevaPartida(GestorVentanas gestorV) {
		loggeGV.info(String.format("Empezando nueva partida para el usuario %d", Usu.getId()));
		ventanas[actual].setVisible(false);
		int idPartida = GBBDD.CrearPartidaParaUsuario(Usu.getId());
		ControladorEstado CE = new ControladorEstado(idPartida, gestorV);
		ventanas[3] = new VentanaJuegoPrincipal(CE);
		CE.GuardarPartida();
	}
	
	public void subirPartida(String info,int partId) {
		GBBDD.ActualizarPartidaUsuario(info, partId);
	}
	
	
	public void cargarPartida(GestorVentanas gestorV,int partId) {
		loggeGV.info(String.format("Cargando partida para el usuario %d", Usu.getId()));
		ventanas[actual].setVisible(false);
		ControladorEstado CE = GBBDD.ConseguirPartidaParaUsuario(partId);
		CE.setGestorVentana(this);
		ventanas[3] = new VentanaJuegoPrincipal(CE);
	}
	
	
	public void salirDePartida() {
		ventanas[2].setVisible(true);
		ventanas[3].dispose();
		ventanas[3] = null;
	}

	public void setUsu(int usId, String usNom) {
		loggeGV.info(String.format("Usuario actual puesto a %d", usId));
		Usu = new Usuario(usNom, usId);
	}
	
	public void closeUsu() {
		loggeGV.info("Quitado usuario actual");
		Usu = null;
	}

	public String getUsuName() {
		return Usu.getNombre();
	}
	
	public int getUsuID() {
		return Usu.getId();
	}
	
	public JFrame getVentana(int index) {
		return ventanas[index];
	}
}
