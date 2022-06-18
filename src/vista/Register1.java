package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.TiposUsuario;
import javax.swing.JButton;

public class Register1 extends JFrame {

	private JPanel contentPane;
	private JLabel usuarioLabel;
	private JLabel contraseniaLabel;
	private JPasswordField contraseniaText;
	private JTextField usuarioText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register1 frame = new Register1();
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
	public Register1() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel usuario = new JPanel();
		contentPane.add(usuario);
		usuario.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel usuarioLabelPan = new JPanel();
		usuario.add(usuarioLabelPan);
		
		usuarioLabel = new JLabel("Usuario:");
		usuarioLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
		usuarioLabelPan.add(usuarioLabel);
		
		JPanel usuarioTextPan = new JPanel();
		usuario.add(usuarioTextPan);
		
		usuarioText = new JTextField();
		usuarioTextPan.add(usuarioText);
		usuarioText.setColumns(10);
		
		JPanel contrasenia = new JPanel();
		contentPane.add(contrasenia);
		contrasenia.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel contraseniaLabelPan = new JPanel();
		contrasenia.add(contraseniaLabelPan);
		
		contraseniaLabel = new JLabel("Contraseña");
		contraseniaLabel.setFont(new Font("Cantarell", Font.PLAIN, 20));
		contraseniaLabelPan.add(contraseniaLabel);
		
		JPanel contraseniaTextPan = new JPanel();
		contrasenia.add(contraseniaTextPan);
		
		contraseniaText = new JPasswordField();
		contraseniaText.setColumns(10);
		contraseniaTextPan.add(contraseniaText);
		
		JPanel desplegable = new JPanel();
		contentPane.add(desplegable);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Cantarell", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(TiposUsuario.values()));
		comboBox.setMaximumRowCount(3);
		desplegable.add(comboBox);
		
		JPanel botones = new JPanel();
		contentPane.add(botones);
		
		JButton siguenteBoton = new JButton("Siguente");
		botones.add(siguenteBoton);
		this.setVisible(true);
	}

}
