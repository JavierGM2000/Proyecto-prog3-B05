package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaLogin extends JFrame{
	
	public static void main(String[] args) {
		VentanaLogin vl = new VentanaLogin();
	}
	
	public VentanaLogin() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 240);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Login");
		setLayout(new BorderLayout());
		
		JPanel pCentro = new JPanel();
		JPanel pNorte = new JPanel();
		JPanel pSur = new JPanel();
		JPanel pEste = new JPanel();
		JPanel pOeste = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro, BoxLayout.Y_AXIS));
		add(pCentro, BorderLayout.CENTER);
		add(pNorte, BorderLayout.NORTH);
		add(pSur, BorderLayout.SOUTH);
		add(pEste, BorderLayout.EAST);
		add(pOeste, BorderLayout.WEST);
		
		JPanel pCentroF1 = new JPanel();
		pCentroF1.setLayout(new FlowLayout());
		pCentro.add(pCentroF1);
		
		JLabel lUsuario = new JLabel("Usuario: ", SwingConstants.CENTER);
		pCentroF1.add(lUsuario);
		JTextField tfUsuario = new JTextField(20);
		pCentroF1.add(tfUsuario);
		
		JPanel pCentroF2 = new JPanel();
		pCentroF2.setLayout(new FlowLayout());
		pCentro.add(pCentroF2);
		JLabel lContrasenya = new JLabel("Contraseña: ");
		pCentroF2.add(lContrasenya);
		JTextField tfContrasenya = new JTextField(20);
		pCentroF2.add(tfContrasenya);
		
		JButton bIniciarSesion = new JButton("Iniciar Sesion");
		pSur.add(bIniciarSesion);
		JButton bCancelar = new JButton("Cancelar");
		pSur.add(bCancelar);
		
		setVisible(true);
	}
}
