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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("Username");
		usuarioTextPan.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel contraseniaPanel = new JPanel();
		principal.add(contraseniaPanel);
		contraseniaPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel labelcontrasenia = new JPanel();
		contraseniaPanel.add(labelcontrasenia);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelcontrasenia.add(lblNewLabel);
		
		JPanel textPanContrasenia = new JPanel();
		contraseniaPanel.add(textPanContrasenia);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		textPanContrasenia.add(txtPassword);
		
		JPanel buttonPanel = new JPanel();
		principal.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		buttonPanel.add(panel_1);
		
		JButton btnNewButton = new JButton("Login");
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		buttonPanel.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("Register");
		panel_2.add(btnNewButton_1);
	}

}
