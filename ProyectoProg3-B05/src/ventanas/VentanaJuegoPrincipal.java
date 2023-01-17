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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	int numCarta = 0;
	//Datos de prueba
	//v
	List<Carta> lista = new ArrayList<Carta>();
	Buff b1 = new Buff(1.5, 1.8, 1.0, 0.7, 1.0, 1.0, 0);
	Carta carta1 = new Carta(00,TipoCarta.OCIO, b1,10,-15,0,2,"Ya es hora de desconectar un poco\nNO?");
	Carta carta2 = new Carta(00,TipoCarta.ESTUDIO, new Buff(),-20,5,25,2,"Has decidido ponerte a \nestudiar");
	Carta carta3 = new Carta(00,TipoCarta.TRABAJO, new Buff(),-15,50,5,4,"Te toca ir a trabajar");
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
		Baraja barajaCartas = new Baraja();
		
		cargarCartas(barajaCartas, 0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1080, 540);
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
		
		JButton bGuardar = new JButton("Guardar y salir"); // Icono de menu mucho mas adecuado
		pTopDerecha.add(bGuardar);
		
		bGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"Guardar y salir"};
				int opcion = JOptionPane.showOptionDialog(null, "Seguro que quieres guardar y salir?", "Guardar y Salir", 0, JOptionPane.PLAIN_MESSAGE, null, opciones, "Guardar y salir");
				if(opcion == 0) {
					estadoJuego.GuardarPartida();
					estadoJuego.getGestorV().cambiarVentana(2);
					setVisible(false);
				}
			}
		});
		
		// Zona de los Progress Bars 
		
		JPanel pBarras = new JPanel(new FlowLayout());
		pTop.add(pBarras, BorderLayout.CENTER);
		
		JLabel lSalud = new JLabel("Salud: ");
		JProgressBar pbSalud = new JProgressBar(0, 100);
		pbSalud.setValue(estadoJuego.getSalud());
		pbSalud.setBackground(Color.GRAY);
		pbSalud.setForeground(Color.RED);
		pbSalud.setString(estadoJuego.getSalud() + "/" + pbSalud.getMaximum() + "(PS)");
		pbSalud.setStringPainted(true);
		pbSalud.getString();
		pbSalud.repaint();
		pBarras.add(lSalud);
		pBarras.add(pbSalud);
		
		JLabel lDinero = new JLabel("Dinero: ");
		JProgressBar pbDinero = new JProgressBar(0, 500);
		pbDinero.setValue(estadoJuego.getDinero());
		pbDinero.setBackground(Color.GRAY);
		pbDinero.setForeground(Color.GREEN);
		pbDinero.setString(estadoJuego.getDinero() + "/" + pbDinero.getMaximum() + "(€)");
		pbDinero.setStringPainted(true);
		pbDinero.getString();
		pbDinero.repaint();
		pBarras.add(lDinero);
		pBarras.add(pbDinero);
		
		JLabel lProyecto = new JLabel("Proyecto: ");
		JProgressBar pbProyecto = new JProgressBar(0, 100);
		pbProyecto.setValue(estadoJuego.getProgreso());
		pbProyecto.setBackground(Color.GRAY);
		pbProyecto.setForeground(Color.BLUE);
		pbProyecto.setString(estadoJuego.getProgreso() + " % ");
		pbProyecto.setStringPainted(true);
		pbProyecto.getString();
		pbProyecto.repaint();
		pBarras.add(lProyecto);
		pBarras.add(pbProyecto);
		
		JLabel lHoras = new JLabel("Horas: ");
		JProgressBar pbHoras = new JProgressBar(0, 12);
		pbHoras.setValue(estadoJuego.getHorasActuales());
		pbHoras.setBackground(Color.GRAY);
		pbHoras.setForeground(Color.MAGENTA);
		pbHoras.setString(estadoJuego.getHorasActuales() + " /" + estadoJuego.getHorasIniciales() + "h");
		pbHoras.setStringPainted(true);
		pbHoras.getString();
		pbHoras.repaint();
		pBarras.add(lHoras);
		pBarras.add(pbHoras);
		
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
		bSeleccionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(estadoJuego.getHorasActuales()>=panelDescripcion.getCarta().getHoras()) {
				estadoJuego.aplicarCarta(panelDescripcion.getCarta());
				pbSalud.setValue(estadoJuego.getSalud());
				pbSalud.setString(estadoJuego.getSalud() + "/" + pbSalud.getMaximum() + "(PS)");
				pbSalud.repaint();
				
				pbDinero.setValue(estadoJuego.getDinero());
				pbDinero.setString(estadoJuego.getDinero() + "/" + pbDinero.getMaximum() + "(€)");
				pbDinero.repaint();
				
				pbProyecto.setValue(estadoJuego.getProgreso());
				pbProyecto.setString(estadoJuego.getProgreso() + " % ");
				pbProyecto.repaint();
				
				pbHoras.setValue(estadoJuego.getHorasActuales());
				pbHoras.setString(estadoJuego.getHorasActuales() + " /" + estadoJuego.getHorasIniciales() + "h");
				pbHoras.repaint();
				} else {
					JOptionPane.showInternalMessageDialog(null, "No tienes suficientes horas \nPasa al siguiente dia");
				}
				estadoJuego.verificarSalud();
				estadoJuego.verificarProgreso();
				if(panelDescripcion.getCarta().equals(carta1)) {
					if(estadoJuego.getHorasActuales()>= carta1.getHoras()) {
					cargarCartas(barajaCartas, 1);
					pnCarta1.actualizarCarta(carta1);
					}
					
				}else if(panelDescripcion.getCarta().equals(carta2)) {
					if(estadoJuego.getHorasActuales()>= carta2.getHoras()) {
					cargarCartas(barajaCartas, 2);
					pnCarta2.actualizarCarta(carta2);
					}
					
				}else if (panelDescripcion.getCarta().equals(carta3)) {
					if(estadoJuego.getHorasActuales()>= carta3.getHoras()) {
					cargarCartas(barajaCartas, 3);
					pnCarta3.actualizarCarta(carta3);
					}
					
				}
				estadoJuego.GuardarPartida();
			}
		});
		pBarraBotones.add(bSeleccionar);
		
		JButton bRellroll = new JButton("Re-Roll");
		pBarraBotones.add(bRellroll);
		
		JPanel pBottom = new JPanel(new FlowLayout());
		add(pBottom, BorderLayout.SOUTH);
		
		JLabel lDiasPasados = new JLabel("Día: " + estadoJuego.getDia() + "/30");
		pBottom.add(lDiasPasados);
		
		bSiguienteDia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				estadoJuego.verificarDia();
				estadoJuego.verificarSalud();
				estadoJuego.verificarProgreso();
					//Obtener 3 cartas aleatorias de la base de datos
					cargarCartas(barajaCartas, 0);
					//Actualizamos los paneles que muestran las cartas
					pnCarta1.actualizarCarta(carta1);
					pnCarta2.actualizarCarta(carta2);
					pnCarta3.actualizarCarta(carta3);
					panelDescripcion.actualizarCarta(carta1);
					pBottom.removeAll();
					JLabel lDiasPasadosActualizado = new JLabel("Día: " + estadoJuego.getDia() + "/30");
					pBottom.add(lDiasPasadosActualizado);
					estadoJuego.setHorasActuales(12); // TODO aqui vamos a tener que poner cuantas horas se van a necesitar si se le aplica algun buffo/nerffeo
					pbHoras.setValue(estadoJuego.getHorasActuales());
					pbHoras.setString(estadoJuego.getHorasActuales() + " /" + estadoJuego.getHorasIniciales() + "h");
					pbHoras.repaint();
			}
		});
		
		bRellroll.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//Restamos 3 horas a las horas posibles del dia
			if(estadoJuego.getHorasActuales()>=3) {
			estadoJuego.setHorasActuales(estadoJuego.getHorasActuales() - 3);
			pbHoras.setValue(estadoJuego.getHorasActuales());
			pbHoras.setString(estadoJuego.getHorasActuales() + " /" + estadoJuego.getHorasIniciales() + "h");
			pbHoras.repaint();
			//Obtener 3 cartas aleatorias de la base de datos
			cargarCartas(barajaCartas, 0);
			//Actualizamos los paneles que muestran las cartas
			pnCarta1.actualizarCarta(carta1);
			pnCarta2.actualizarCarta(carta2);
			pnCarta3.actualizarCarta(carta3);
			} else {
				JOptionPane.showInternalMessageDialog(null, "No puedes cambiar cartas \nno se dispone de suficientes horas");
			}
		}
	});

		setVisible(true);
	}
	
	public void cargarCartas(Baraja barjaCar, int i) {
		switch (i) {
		case 0: {
			carta1 = barjaCar.extraerCarta();
			carta2 = barjaCar.extraerCarta();
			carta3 = barjaCar.extraerCarta();
			break;
		}
		case 1: {
			carta1 = barjaCar.extraerCarta();
			break;
		}
		case 2: {
			carta2 = barjaCar.extraerCarta();
			break;
		}
		case 3: {
			carta3 = barjaCar.extraerCarta();
			break;
		}
		default:
			carta1 = barjaCar.extraerCarta();
			carta2 = barjaCar.extraerCarta();
			carta3 = barjaCar.extraerCarta();
			break;
		}
	}
}
