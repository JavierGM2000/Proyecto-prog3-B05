package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import componentes.Carta;

public class PanelCarta extends JPanel{
	Carta carta;
	JButton boton = new JButton("Informacion");
	JLabel imagen = new JLabel();
	JTextArea bufos = new JTextArea();
	JLabel titulo = new JLabel();
	JLabel descripcion = new JLabel();
	JPanel pTitulo = new JPanel();
	JPanel pCentro = new JPanel();
	JPanel pCentroIz = new JPanel();
	
	public PanelCarta(Carta carta) {
		super();
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		pCentro.setLayout(new BorderLayout());
		pCentroIz.setLayout(new GridLayout(2, 1));
		this.actualizarCarta(carta);
		
		pTitulo.add(titulo);
		pCentroIz.add(imagen);
		pCentroIz.add(bufos);
		pCentro.add(pCentroIz, BorderLayout.WEST);
		this.add(pTitulo,BorderLayout.NORTH);
		this.add(pCentro,BorderLayout.CENTER);
		this.add(boton,BorderLayout.SOUTH);
	}
	
	public void actualizarCarta(Carta cartaActualizada) {
		this.carta = cartaActualizada;
		this.bufos.setText(carta.getBufo().toString());
		System.out.println(carta.getBufo().toString());
		switch (carta.getTipo()) {
		case OCIO: {
			Image img = new ImageIcon( getClass().getResource("/Ocio.png")).getImage();
			imagen.setIcon(new ImageIcon(img.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
			titulo.setText("Ocio");
			break;
		}
		case TRABAJO: {
			Image img = new ImageIcon( getClass().getResource("/Trabajo.png")).getImage();
			imagen.setIcon(new ImageIcon(img.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
			titulo.setText("Trabajo");
			break;
		}
		case ESTUDIO: {
			Image img = new ImageIcon( getClass().getResource("/Estudio.png")).getImage();
			imagen.setIcon(new ImageIcon(img.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
			titulo.setText("Estudio");
			break;
		}
		default:
			imagen.setIcon(null);
			break;
		}
		this.repaint();
	}
}