package sistemas;

import java.util.logging.Logger;

import javax.swing.JFrame;

import componentes.Carta;
import componentes.Usuario;
import ventanas.VentanaBase;
import ventanas.VentanaCrearCuenta;
import ventanas.VentanaLogin;
import ventanas.VentanaPartidaSelec;

public class GestorVentanas {

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
		ventanas[0].setVisible(true);
	}

	public void cambiarVentana(int idVentana) {
		loggeGV.info(String.format("Cambiando ventana a la número %x", idVentana));
		ventanas[actual].setVisible(false);
		actual = idVentana;
		ventanas[idVentana].prepararInit();
		ventanas[idVentana].setVisible(true);
	}

	public void setUsu(int usId, String usNom) {
		Usu = new Usuario(usNom, usId);
	}

	public String getUsuName() {
		return Usu.getNombre();
	}
}
