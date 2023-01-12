package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import componentes.Carta;

public class PanelDatosCarta extends PanelCarta{
	
	public PanelDatosCarta(Carta carta) {
		super(carta);
		this.setSize(800, getHeight());
		descripcion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		descripcion.setText(carta.getDescripcion());
		descripcion.setSize(getMaximumSize());
		pCentro.add(descripcion, BorderLayout.CENTER);
		boton.setVisible(false);
	}
	@Override
	public void actualizarCarta(Carta cartaActualizada) {
		this.carta = cartaActualizada;
		this.bufos.setText(	"Salud: " + carta.getSalud()+"\n"+
							"Dinero: " + carta.getDinero()+"\n"+
							"Progreso: " + carta.getProgreso()+"\n"+
							"Horas: " + carta.getHoras()+"\n"+
							carta.getBufo().toString());
		this.descripcion.setText(carta.getDescripcion());
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
