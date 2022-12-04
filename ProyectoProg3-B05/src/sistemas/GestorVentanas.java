package sistemas;

import javax.swing.JFrame;

import ventanas.VentanaBase;
import ventanas.VentanaCrearCuenta;
import ventanas.VentanaLogin;

public class GestorVentanas {
	
	GestorBBDD GBBDD;
	int actual;
	
	VentanaBase[] ventanas;
	public GestorVentanas(GestorBBDD inGBBDD){
		actual = 0;
		GBBDD = inGBBDD;
		ventanas = new VentanaBase[5];
		ventanas[0] = new VentanaLogin(GBBDD,this);
		ventanas[1] = new VentanaCrearCuenta(GBBDD,this);
		
		ventanas[0].setVisible(true);
	}
	
	public void cambiarVentana(int idVentana) {
		ventanas[actual].setVisible(false);
		ventanas[idVentana].prepararInit();
		ventanas[idVentana].setVisible(true);
	}
}
