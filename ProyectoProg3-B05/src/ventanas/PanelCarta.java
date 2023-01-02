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

import componentes.Carta;

public class PanelCarta extends JPanel{
	Carta carta;
	JButton boton = new JButton("Informacion");
	JLabel etiqueta = new JLabel();
	JLabel bufos = new JLabel();
	JLabel titulo = new JLabel();
	JPanel pTitulo = new JPanel();
	JPanel pCentro = new JPanel();
	
	
	public PanelCarta(Carta carta) {
		super();
		this.carta = carta;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		pCentro.setLayout(new GridLayout(2, 1));
		this.bufos.setText(carta.getBufo().toString());
		
		switch (carta.getTipo()) {
		case OCIO: {
			Image img = new ImageIcon( getClass().getResource("/Ocio.png")).getImage();
			etiqueta.setIcon(new ImageIcon(img.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
			titulo.setText("Ocio");
			System.out.println("Ocio");
			break;
		}
		case TRABAJO: {
			Image img = new ImageIcon( getClass().getResource("/Trabajo.png")).getImage();
			etiqueta.setIcon(new ImageIcon(img.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
			titulo.setText("Trabajo");
			System.out.println("Trabajo");
			break;
		}
		case ESTUDIO: {
			Image img = new ImageIcon( getClass().getResource("/Estudio.png")).getImage();
			etiqueta.setIcon(new ImageIcon(img.getScaledInstance(175, 175, Image.SCALE_SMOOTH)));
			titulo.setText("Estudio");
			System.out.println("Estudio");
			break;
		}
		default:
			etiqueta.setIcon(null);
			System.out.println("Nada");
			break;
		}
		
		pTitulo.add(titulo);
		pCentro.add(etiqueta);
		pCentro.add(bufos);
		this.add(pTitulo,BorderLayout.NORTH);
		this.add(pCentro,BorderLayout.CENTER);
		this.add(boton,BorderLayout.SOUTH);
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}