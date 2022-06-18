package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame implements ILogin {

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

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		usuario = new JPanel();
		contentPane.add(usuario);
		usuario.setLayout(new GridLayout(0, 1, 0, 0));
		
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
		contentPane.add(contrasenia);
		contrasenia.setLayout(new GridLayout(0, 1, 0, 0));
		
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
		
		botones = new JPanel();
		contentPane.add(botones);
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

}
