package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Register2Agencia extends JFrame implements IVista {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Register2Agencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {

	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		// TODO Auto-generated method stub
		
	}

}
