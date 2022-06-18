package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ILogin {

	private JPanel contentPane;
	private JTextField usuarioText;
	private JPasswordField contraseniaText;
	
	private JButton loginButton;
	private JButton registerButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel principal = new JPanel();
		contentPane.add(principal, BorderLayout.CENTER);
		principal.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel usuarioPanel = new JPanel();
		principal.add(usuarioPanel);
		usuarioPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel usuarioLabelPan = new JPanel();
		usuarioPanel.add(usuarioLabelPan);
		
		JLabel usuarioLabel = new JLabel("Usuario:");
		usuarioLabelPan.add(usuarioLabel);
		usuarioLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		
		JPanel usuarioTextPan = new JPanel();
		usuarioPanel.add(usuarioTextPan);
		
		usuarioText = new JTextField();
		usuarioText.setToolTipText("Username");
		usuarioTextPan.add(usuarioText);
		usuarioText.setColumns(10);
		
		JPanel contraseniaPanel = new JPanel();
		principal.add(contraseniaPanel);
		contraseniaPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel contraseniaLabelPan = new JPanel();
		contraseniaPanel.add(contraseniaLabelPan);
		
		JLabel contraseniaLabel = new JLabel("Contrase\u00F1a:");
		contraseniaLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		contraseniaLabelPan.add(contraseniaLabel);
		
		JPanel contraseniaTextPan = new JPanel();
		contraseniaPanel.add(contraseniaTextPan);
		
		contraseniaText = new JPasswordField();
		contraseniaText.setColumns(10);
		contraseniaTextPan.add(contraseniaText);
		
		JPanel botonPanel = new JPanel();
		principal.add(botonPanel);
		botonPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel botonLoginPan = new JPanel();
		botonPanel.add(botonLoginPan);
		
		JButton botonLogin = new JButton("Login");
		botonLoginPan.add(botonLogin);
		loginButton = botonLogin;
		
		JPanel botonRegisterPan = new JPanel();
		botonPanel.add(botonRegisterPan);
		
		JButton botonRegister = new JButton("Register");
		botonRegisterPan.add(botonRegister);
		registerButton = botonRegister;
		
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		loginButton.addActionListener(actionListener);
		registerButton.addActionListener(actionListener);
	}

	@Override
	public String getUsuario() {
		return null;
	}

	@Override
	public String getContrasenia() {
		// TODO Auto-generated method stub
		return null;
	}

}

