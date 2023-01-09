package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToolBar.Separator;

import componentes.Baraja;
import componentes.Buff;
import componentes.Carta;
import componentes.TipoCarta;
import sistemas.ControladorEstado;
import sistemas.GestorBBDD;
import sistemas.GestorVentanas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VentanaJuegoPrincipal extends VentanaBase{
	
	GestorBBDD GBBDD;
	GestorVentanas Padre;
	//Datos de prueba
	//v
	List<Carta> lista = new ArrayList<Carta>();
	Buff b1 = new Buff(0.5, 0.8, 0.7, 0.7, 0.3, 0.8, 0.2, 0.4, 3);
	Carta carta1 = new Carta(00,TipoCarta.OCIO, b1,"Ya es hora de desconectar un poco\nNO?");
	Carta carta2 = new Carta(00,TipoCarta.ESTUDIO, new Buff(),"Has decidido ponerte a \nestudiar");
	Carta carta3 = new Carta(00,TipoCarta.TRABAJO, new Buff(),"Te toca ir a trabajar");
	//^
	
	public VentanaJuegoPrincipal(ControladorEstado estadoJuego) {
		//Datos de prueba
		//v
		lista.add(carta1);
		lista.add(carta2);
		lista.add(carta3);
		//^
		
		//Crear la baraja de cartas
		//TODO
		Baraja barajaCartas = new Baraja(lista);
		
		cargarCartas(barajaCartas);
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
		
		// --- Parte de la derecha de la Ventana (Descripcion de las cartas)
		
		PanelDatosCarta panelDescripcion = new PanelDatosCarta(carta1);
		this.add(panelDescripcion, BorderLayout.CENTER);
		
		// -- Parte del medio de la Ventana (La exposicion de las cartas que pueden tocar + rerroll + siguiente dia)
		
		JPanel pPantallaBaraja = new JPanel(new BorderLayout());
		add(pPantallaBaraja, BorderLayout.WEST);
		
		JPanel pBaraja = new JPanel(new GridLayout(1,3));
		pPantallaBaraja.add(pBaraja, BorderLayout.CENTER);
		
		PanelCarta pnCarta1 = new PanelCarta(carta1);
		//Pasamos al panel de la derecha la carta 1 para que se muestre
		pnCarta1.boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelDescripcion.actualizarCarta(carta1);
			}
		});
		PanelCarta pnCarta2 = new PanelCarta(carta2);
		//Pasamos al panel de la derecha la carta 2 para que se muestre
		pnCarta2.boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelDescripcion.actualizarCarta(carta2);
			}
		});
		PanelCarta pnCarta3 = new PanelCarta(carta3);
		//Pasamos al panel de la derecha la carta 3 para que se muestre
		pnCarta3.boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelDescripcion.actualizarCarta(carta3);
			}
		});
		
		pBaraja.add(pnCarta1);
		pBaraja.add(pnCarta2);
		pBaraja.add(pnCarta3);
		
		JPanel pBarraBotones = new JPanel(new FlowLayout());
		pPantallaBaraja.add(pBarraBotones, BorderLayout.SOUTH);
		
		JButton bSiguienteDia = new JButton("Siguiente dia");
		pBarraBotones.add(bSiguienteDia);
		
		JButton bSeleccionar = new JButton("SELECCIONAR");
		pBarraBotones.add(bSeleccionar);
		
		JButton bRellroll = new JButton("Re-Roll");
		pBarraBotones.add(bRellroll);
		
	bRellroll.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//Obtener 3 cartas aleatorias de la base de datos
			cargarCartas(barajaCartas);
			//Actualizamos los paneles que muestran las cartas
			pnCarta1.actualizarCarta(carta1);
			pnCarta2.actualizarCarta(carta2);
			pnCarta3.actualizarCarta(carta3);
		}
	});
		
		// --- Parte de abajo de la Ventana (Conteo de los dias)
		
		JPanel pBottom = new JPanel(new FlowLayout());
		add(pBottom, BorderLayout.SOUTH);
		
		JLabel lDiasPasados = new JLabel("Día: " + estadoJuego.getDia() + "/30");
		pBottom.add(lDiasPasados);
		
		setVisible(true);
	}
	
	public void cargarCartas(Baraja barjaCar) {
		carta1 = barjaCar.extraerCarta();
		carta2 = barjaCar.extraerCarta();
		carta3 = barjaCar.extraerCarta();
	}
	public static void main(String[] args) {
		ControladorEstado estado = new ControladorEstado();
		new VentanaJuegoPrincipal(estado);
	}
}
