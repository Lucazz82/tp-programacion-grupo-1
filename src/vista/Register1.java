package vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import enums.TiposUsuario;

public class Register1 extends JFrame implements IVista, IRegister {

	private JPanel contentPane;
	private JLabel usuarioLabel;
	private JLabel contraseniaLabel;
	private JPasswordField contraseniaText;
	private JTextField usuarioText;
	private JButton siguienteBoton;
	private JComboBox comboBox;
	private JPanel botones;
	private JPanel desplegable;
	private JPanel contraseniaTextPan;
	private JPanel contraseniaLabelPan;
	private JPanel contrasenia;
	private JPanel usuarioTextPan;
	private JPanel usuarioLabelPan;
	private JPanel usuario;

	/**
	 * Create the frame.
	 */
	public Register1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));

		usuario = new JPanel();
		contentPane.add(usuario);
		usuario.setLayout(new GridLayout(2, 1, 0, 0));

		usuarioLabelPan = new JPanel();
		usuario.add(usuarioLabelPan);

		usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
		usuarioLabelPan.add(usuarioLabel);

		usuarioTextPan = new JPanel();
		usuario.add(usuarioTextPan);

		usuarioText = new JTextField();
		usuarioTextPan.add(usuarioText);
		usuarioText.setColumns(10);

		contrasenia = new JPanel();
		contentPane.add(contrasenia);
		contrasenia.setLayout(new GridLayout(2, 1, 0, 0));

		contraseniaLabelPan = new JPanel();
		contrasenia.add(contraseniaLabelPan);

		contraseniaLabel = new JLabel("Contraseña");
		contraseniaLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
		contraseniaLabelPan.add(contraseniaLabel);

		contraseniaTextPan = new JPanel();
		contrasenia.add(contraseniaTextPan);

		contraseniaText = new JPasswordField();
		contraseniaText.setColumns(10);
		contraseniaTextPan.add(contraseniaText);

		desplegable = new JPanel();
		contentPane.add(desplegable);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Cantarell", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(TiposUsuario.values()));
		comboBox.setMaximumRowCount(3);
		desplegable.add(comboBox);

		botones = new JPanel();
		contentPane.add(botones);

		siguienteBoton = new JButton("Siguente");
		botones.add(siguienteBoton);
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		siguienteBoton.addActionListener(actionListener);
	}

	@Override
	public String getUsuario() {
		return usuarioText.getText();
	}

	@Override
	public String getContrasenia() {
		return String.valueOf(contraseniaText.getPassword());
	}

	@Override
	public TiposUsuario getTipoUsuario() {
		return (TiposUsuario) comboBox.getSelectedItem();
	}

}
