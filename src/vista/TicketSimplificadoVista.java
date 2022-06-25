package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TicketSimplificadoVista extends JFrame {

	private JPanel contentPane;



	/**
	 * Create the frame.
	 */
	public TicketSimplificadoVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel locacion = new JPanel();
		contentPane.add(locacion);
		locacion.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel locacionLabelPan = new JPanel();
		locacion.add(locacionLabelPan);
		
		JLabel locacionLabel = new JLabel("Locacion:");
		locacionLabelPan.add(locacionLabel);
		
		JPanel locacionDesplegablePan = new JPanel();
		locacion.add(locacionDesplegablePan);
		
		JComboBox locacionDesplegable = new JComboBox();
		locacionDesplegablePan.add(locacionDesplegable);
		
		JPanel rubro = new JPanel();
		contentPane.add(rubro);
		rubro.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel rubroLabelPan = new JPanel();
		rubro.add(rubroLabelPan);
		
		JLabel rubroLabel = new JLabel("Rubro:");
		rubroLabelPan.add(rubroLabel);
		
		JPanel rubroDesplegablePan = new JPanel();
		rubro.add(rubroDesplegablePan);
		
		JComboBox rubroDesplegable = new JComboBox();
		rubroDesplegablePan.add(rubroDesplegable);
		
		JPanel crear = new JPanel();
		contentPane.add(crear);
		
		JButton crearBoton = new JButton("Crear Ticket");
		crear.add(crearBoton);
	}

}
