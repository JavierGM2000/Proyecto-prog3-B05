package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToolBar.Separator;

import componentes.Buff;
import componentes.Carta;
import componentes.Estado;
import componentes.TipoCarta;
import sistemas.GestorBBDD;
import sistemas.GestorVentanas;

import java.util.logging.Logger;

public class VentanaJuegoPrincipal extends VentanaBase{
	
	
	GestorBBDD GBBDD;
	GestorVentanas Padre;
	Estado estadoJuego = new Estado();
	Carta cNula1 = new Carta(00,TipoCarta.OCIO, new Buff(),"carta nula");
	Carta cNula2 = new Carta(00,TipoCarta.ESTUDIO, new Buff(),"carta nula");
	Carta cNula3 = new Carta(00,TipoCarta.TRABAJO, new Buff(),"carta nula");
	
	public VentanaJuegoPrincipal() {

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(960, 540);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Titulo del juego"); // Hay que cambiarlo cuando se sepa el titulo final
		setLayout(new BorderLayout());
		// ---- Parte de arriba de la Ventana (Zona del menu + Progress bars)
		
		
		// Zona del Menu
			
		JPanel pTop = new JPanel(new BorderLayout());
		add(pTop, BorderLayout.NORTH);
		
		JPanel pTopDerecha = new JPanel();
		pTop.add(pTopDerecha, BorderLayout.EAST);
		
		JButton bMenu = new JButton("Menu"); // Icono de menu mucho mas adecuado
		pTopDerecha.add(bMenu);
		
		// Zona de los Progress Bars
		
		JPanel pBarras = new JPanel(new FlowLayout());
		pTop.add(pBarras, BorderLayout.CENTER);
		
		JProgressBar pbSalud = new JProgressBar(0, 100);
		pbSalud.setValue(estadoJuego.getSalud());
		pbSalud.setBackground(Color.GRAY);
		pbSalud.setForeground(Color.RED);
		pbSalud.setString(estadoJuego.getSalud() + "/" + pbSalud.getMaximum() + "(PS)");
		pbSalud.setStringPainted(true);
		pbSalud.getString();
		pbSalud.repaint();
		pBarras.add(pbSalud);
		
		JProgressBar pbDinero = new JProgressBar(0, 500);
		pbDinero.setValue(estadoJuego.getDinero());
		pbDinero.setBackground(Color.GRAY);
		pbDinero.setForeground(Color.GREEN);
		pbDinero.setString(estadoJuego.getDinero() + "/" + pbDinero.getMaximum() + "(€)");
		pbDinero.setStringPainted(true);
		pbDinero.getString();
		pbDinero.repaint();
		pBarras.add(pbDinero);
		
		JProgressBar pbProyecto = new JProgressBar(0, 100);
		pbProyecto.setValue(estadoJuego.getProgreso());
		pbProyecto.setBackground(Color.GRAY);
		pbProyecto.setForeground(Color.BLUE);
		pbProyecto.setString(estadoJuego.getProgreso() + " % ");
		pbProyecto.setStringPainted(true);
		pbProyecto.getString();
		pbProyecto.repaint();
		pBarras.add(pbProyecto);
		
		// -- Parte del medio de la Ventana (La exposicion de las cartas que pueden tocar + rerroll + siguiente dia)
		
		JPanel pPantallaBaraja = new JPanel(new BorderLayout());
		add(pPantallaBaraja, BorderLayout.CENTER);
		
		JPanel pBaraja = new JPanel(new GridLayout(1,3));
		pPantallaBaraja.add(pBaraja, BorderLayout.CENTER);
		
		PanelCarta carta1 = new PanelCarta(cNula1);
		PanelCarta carta2 = new PanelCarta(cNula2);
		PanelCarta carta3 = new PanelCarta(cNula3);
		
		pBaraja.add(carta1);
		pBaraja.add(carta2);
		pBaraja.add(carta3);
		
		JPanel pBarraBotones = new JPanel(new FlowLayout());
		pPantallaBaraja.add(pBarraBotones, BorderLayout.SOUTH);
		
		JButton bSiguienteDia = new JButton("Siguiente dia");
		pBarraBotones.add(bSiguienteDia);
		
		JButton bSeleccionar = new JButton("SELECCIONAR");
		pBarraBotones.add(bSeleccionar);
		
		JButton bRellroll = new JButton("Re-Roll");
		pBarraBotones.add(bRellroll);
		
		// --- Parte de la derecha de la Ventana (Descripcion de las cartas)
		
		JPanel pRight = new JPanel(new BorderLayout());
		add(pRight, BorderLayout.EAST);

		JLabel nomCarta = new JLabel("Nombre de la carta seleccioana");
		pRight.add(nomCarta, BorderLayout.NORTH);
		
		JPanel cuerpoDescCarta = new JPanel();
		cuerpoDescCarta.setLayout(new BoxLayout(cuerpoDescCarta, BoxLayout.Y_AXIS));
		pRight.add(cuerpoDescCarta, BorderLayout.CENTER);
		
		JLabel carta = new JLabel("Insertar imagen de la carta");
		cuerpoDescCarta.add(carta);
		
		JLabel descCarta =  new JLabel(
				"Aqui se le insertará toda la descripcion a la carta para saber lo que altera");
		cuerpoDescCarta.add(descCarta);
		
		// --- Parte de abajo de la Ventana (Conteo de los dias)
		
		JPanel pBottom = new JPanel(new FlowLayout());
		add(pBottom, BorderLayout.SOUTH);
		
		
		JLabel lDiasPasados = new JLabel("Día: " + estadoJuego.getDia() + "/30");
		pBottom.add(lDiasPasados);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaJuegoPrincipal();
	}
}
