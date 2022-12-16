package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sistemas.GestorBBDD;
import sistemas.GestorVentanas;

public class VentanaPartidaSelec extends VentanaBase {
	GestorBBDD GBBDD;
	GestorVentanas Padre;
	JLabel lUsuario;
	
	public VentanaPartidaSelec(GestorBBDD inGBBDD,GestorVentanas inPadre) {
		GBBDD = inGBBDD;
		Padre = inPadre;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 240);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Elegir Partida");
		setLayout(new BorderLayout());
		
		JPanel pCentro = new JPanel();
		JPanel pNorte = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro, BoxLayout.Y_AXIS));
		add(pCentro, BorderLayout.CENTER);
		add(pNorte, BorderLayout.NORTH);
		
		
		lUsuario = new JLabel("Hola,  ", SwingConstants.CENTER);
		pNorte.add(lUsuario);
		
		
		
		setVisible(false);
	}
	
	@Override
	public void prepararInit() {
		lUsuario.setText("Hola, "+Padre.getUsuName());
	}
}
