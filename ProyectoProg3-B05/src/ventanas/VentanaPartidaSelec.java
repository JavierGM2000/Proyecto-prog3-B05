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
		JPanel pSur = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro, BoxLayout.Y_AXIS));
		add(pCentro, BorderLayout.CENTER);
		add(pNorte, BorderLayout.NORTH);
		add(pSur, BorderLayout.SOUTH);
		
		lUsuario = new JLabel("Hola,  ", SwingConstants.CENTER);
		pNorte.add(lUsuario);
		
		JButton bSalir = new JButton("Cancelar");
		bSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showOptionDialog(rootPane, "Seguro que quieres cerrar tu sesión?", "Log-out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if (n==0) {
							
						Padre.cambiarVentana(0);
					}
			}
		});
		JButton bNuevaPartida = new JButton("Nueva Partida");
		bNuevaPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		pSur.add(bSalir);
		pSur.add(bNuevaPartida);
		
		setVisible(false);
	}
	
	@Override
	public void prepararInit() {
		lUsuario.setText("Hola, "+Padre.getUsuName());
	}
}
