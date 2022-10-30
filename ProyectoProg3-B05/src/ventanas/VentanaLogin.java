package ventanas;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class VentanaLogin extends JFrame{
	
	public VentanaLogin() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640, 480);
		setTitle("Mi primera ventana!");
		setLayout(new FlowLayout());
		
		setVisible(true);
	}
}
