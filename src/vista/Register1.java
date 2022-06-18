package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Register1 extends JFrame {

	private JPanel contentPane;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel usuario = new JPanel();
		contentPane.add(usuario);
		usuario.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel usuarioLabelPan = new JPanel();
		usuario.add(usuarioLabelPan);
		
		JLabel usuarioLabel = new JLabel("New label");
		usuarioLabelPan.add(usuarioLabel);
		
		JPanel usuarioTextPan = new JPanel();
		usuario.add(usuarioTextPan);
		
		usuarioText = new JTextField();
		usuarioTextPan.add(usuarioText);
		usuarioText.setColumns(10);
	}

}
