package ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sistemas.GestorBBDD;
import sistemas.GestorVentanas;

public class VentanaCrearCuenta extends VentanaBase {
	GestorBBDD GBBDD;
	GestorVentanas Padre;
	JTextField tfUsuario;
	JTextField tfMail;
	JPasswordField pfContrasenya;

	public VentanaCrearCuenta(GestorBBDD inGBBDD, GestorVentanas inPadre) {
		GBBDD = inGBBDD;
		Padre = inPadre;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 240);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Crear cuenta");
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
		tfUsuario = new JTextField(20);
		pCentroF1.add(tfUsuario);

		JPanel pCentroF3 = new JPanel();
		pCentroF3.setLayout(new FlowLayout());
		pCentro.add(pCentroF3);
		JLabel lMail = new JLabel("Mail: ", SwingConstants.CENTER);
		pCentroF3.add(lMail);
		tfMail = new JTextField(20);
		pCentroF3.add(tfMail);

		JPanel pCentroF2 = new JPanel();
		pCentroF2.setLayout(new FlowLayout());
		pCentro.add(pCentroF2);
		JLabel lContrasenya = new JLabel("Contraseña: ");
		pCentroF2.add(lContrasenya);
		pfContrasenya = new JPasswordField(20);
		pCentroF2.add(pfContrasenya);

		JButton bCrearCuenta = new JButton("CrearCuenta");
		bCrearCuenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int usu = GBBDD.crearUsuario(tfUsuario.getText(), tfMail.getText(), pfContrasenya.getPassword());
				if (usu > 0) {
					JOptionPane.showMessageDialog(rootPane, "Se ha creado el usuario",
							"Usuario creado correctamente", JOptionPane.INFORMATION_MESSAGE,
							null);
						Padre.cambiarVentana(0);
				} else if (usu == 0) {
					JOptionPane.showMessageDialog(rootPane, "El correo ya esta registrado","Ha sucedido un error",JOptionPane.ERROR_MESSAGE);
					
					
				} else {
					JOptionPane.showMessageDialog(rootPane, "No se ha creado el usuario", "Ha sucedido un error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		pSur.add(bCrearCuenta);

		JButton bCancelar = new JButton("Cancelar");
		bCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Padre.cambiarVentana(0);
			}
		});
		pSur.add(bCancelar);

		setVisible(false);
	}

	@Override
	public void prepararInit() {
		tfUsuario.setText(null);
		pfContrasenya.setText(null);
	}
}
