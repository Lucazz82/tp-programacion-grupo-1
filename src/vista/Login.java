package vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import enums.TiposUsuario;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame implements IVista, ILogin {

	private JPanel contentPane;
	private JLabel usuarioLabel;
	private JPanel usuarioLabelPan;
	private JTextField usuarioText;
	private JPanel usuarioTextPan;
	private JPanel usuario;
	private JLabel contraseniaLabel;
	private JPanel contraseniaLabelPan;
	private JPanel contraseniaTextPan;
	private JPasswordField contraseniaText;
	private JPanel contrasenia;
	private JButton loginBoton;
	private JPanel loginBotonPan;
	private JButton registerBoton;
	private JPanel registerBotonPan;
	private JPanel botones;
	private JPanel principal;
	private JComboBox tipoUsuarioDesplegable;
	private JPanel tipoUsuarioPanel;

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		principal = new JPanel();
		contentPane.add(principal, BorderLayout.CENTER);
		principal.setLayout(new GridLayout(3, 1, 0, 0));

		usuario = new JPanel();
		principal.add(usuario);
		usuario.setLayout(new GridLayout(2, 1, 0, 0));

		usuarioLabelPan = new JPanel();
		usuario.add(usuarioLabelPan);

		usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		usuarioLabelPan.add(usuarioLabel);

		usuarioTextPan = new JPanel();
		usuario.add(usuarioTextPan);

		usuarioText = new JTextField();
		usuarioTextPan.add(usuarioText);
		usuarioText.setColumns(10);

		contrasenia = new JPanel();
		principal.add(contrasenia);
		contrasenia.setLayout(new GridLayout(2, 1, 0, 0));

		contraseniaLabelPan = new JPanel();
		contrasenia.add(contraseniaLabelPan);

		contraseniaLabel = new JLabel("Contraseña:");
		contraseniaLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		contraseniaLabelPan.add(contraseniaLabel);

		contraseniaTextPan = new JPanel();
		contrasenia.add(contraseniaTextPan);

		contraseniaText = new JPasswordField();
		contraseniaText.setColumns(10);
		contraseniaTextPan.add(contraseniaText);

		tipoUsuarioPanel = new JPanel();
		principal.add(tipoUsuarioPanel);

		tipoUsuarioDesplegable = new JComboBox();
		tipoUsuarioDesplegable.setModel(new DefaultComboBoxModel(TiposUsuario.values()));
		tipoUsuarioPanel.add(tipoUsuarioDesplegable);

		botones = new JPanel();
		contentPane.add(botones, BorderLayout.SOUTH);
		botones.setLayout(new GridLayout(0, 2, 0, 0));

		loginBotonPan = new JPanel();
		botones.add(loginBotonPan);

		loginBoton = new JButton("Login");
		loginBotonPan.add(loginBoton);

		registerBotonPan = new JPanel();
		botones.add(registerBotonPan);

		registerBoton = new JButton("Register");
		registerBotonPan.add(registerBoton);

		setVisible(true);
	}

	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		loginBoton.addActionListener(actionListener);
		registerBoton.addActionListener(actionListener);
	}

	@Override
	public String getUsuario() {
		return usuarioText.getText();
	}

	@Override
	public String getContrasenia() {
		return String.valueOf(contraseniaText.getPassword());
	}

	public TiposUsuario getTipoUsuario() {
		return (TiposUsuario) this.tipoUsuarioDesplegable.getSelectedItem();
	}
}
