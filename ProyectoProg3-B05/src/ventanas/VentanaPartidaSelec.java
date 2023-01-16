package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import componentes.Partida;
import sistemas.GestorBBDD;
import sistemas.GestorVentanas;
import sistemas.PartidaRenderer;
import sistemas.PartidaTableModel;

public class VentanaPartidaSelec extends VentanaBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GestorBBDD GBBDD;
	GestorVentanas Padre;
	JLabel lUsuario;
	JPanel pCentro;
	JTable jTablePartidas;
	public VentanaPartidaSelec(GestorBBDD inGBBDD,GestorVentanas inPadre) {
		GBBDD = inGBBDD;
		Padre = inPadre;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Elegir Partida");
		setLayout(new BorderLayout());
		
		pCentro = new JPanel();
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
				Padre.empezarNuevaPartida(inPadre);
			}
		});	
		
		JButton bCargar = new JButton("Cargar");
		bCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowselect = jTablePartidas.getSelectedRow();
				if(rowselect>-1) {
					int partId = (int) jTablePartidas.getValueAt(rowselect, 0);
					Padre.cargarPartida(Padre, partId);
				}
				
			}
		});	
		
		pSur.add(bSalir);
		pSur.add(bNuevaPartida);
		pSur.add(bCargar);
		
		setVisible(false);
	}
	
	@Override
	public void prepararInit() {
		lUsuario.setText("Hola, "+Padre.getUsuName());
		this.remove(pCentro);
		pCentro = new JPanel();
		pCentro.setLayout(new BoxLayout(pCentro, BoxLayout.Y_AXIS));
		add(pCentro, BorderLayout.CENTER);
		if(GBBDD.EncontrarPartidasUsuario(Padre.getUsuID())<=0) {
			JLabel labelNoPartidas = new JLabel("No tienes ninguna partida creada, crea una nueva partida");
			pCentro.add(labelNoPartidas);
		} else {
			List<Partida> lPartids = GBBDD.ConseguirPartidasUsuarios(Padre.getUsuID());
			
			jTablePartidas = new JTable();
			jTablePartidas.setRowHeight(30);
			jTablePartidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
			((DefaultTableCellRenderer) jTablePartidas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
			
			pCentro.add(jTablePartidas.getTableHeader());
			pCentro.add(jTablePartidas);
			
			jTablePartidas.setModel(new PartidaTableModel(lPartids));	
			
			PartidaRenderer defaultRenderer = new PartidaRenderer();
			
			for (int i=0; i<jTablePartidas.getColumnModel().getColumnCount(); i++) {
				jTablePartidas.getColumnModel().getColumn(i).setCellRenderer(defaultRenderer);
			}
		}
		this.add(pCentro);
		this.repaint();
	}
}
