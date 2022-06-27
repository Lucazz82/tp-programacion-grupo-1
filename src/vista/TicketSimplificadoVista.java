package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Locaciones;
import enums.Rubros;

public class TicketSimplificadoVista extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel centro;
	private JPanel sur;
	private JPanel crearPan;
	private JButton crearBoton;
	private JComboBox locacionDesplegable;
	private JComboBox rubroDesplegable;
	private JButton volverBoton;



	/**
	 * Create the frame.
	 */
	public TicketSimplificadoVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		centro = new JPanel();
		contentPane.add(centro, BorderLayout.CENTER);
		centro.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel locacion = new JPanel();
		centro.add(locacion);
		locacion.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel locacionLabelPan = new JPanel();
		locacion.add(locacionLabelPan);
		
		JLabel locacionLabel = new JLabel("Locacion:");
		locacionLabelPan.add(locacionLabel);
		
		JPanel locacionDesplegablePan = new JPanel();
		locacion.add(locacionDesplegablePan);
		
		locacionDesplegable = new JComboBox();
		locacionDesplegable.setModel(new DefaultComboBoxModel(Locaciones.values()));
		locacionDesplegablePan.add(locacionDesplegable);
		
		JPanel rubro = new JPanel();
		centro.add(rubro);
		rubro.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel rubroLabelPan = new JPanel();
		rubro.add(rubroLabelPan);
		
		JLabel rubroLabel = new JLabel("Rubro:");
		rubroLabelPan.add(rubroLabel);
		
		JPanel rubroDesplegablePan = new JPanel();
		rubro.add(rubroDesplegablePan);
		
		rubroDesplegable = new JComboBox();
		rubroDesplegable.setModel(new DefaultComboBoxModel(Rubros.values()));
		rubroDesplegablePan.add(rubroDesplegable);
		
		sur = new JPanel();
		contentPane.add(sur, BorderLayout.SOUTH);
		
		JPanel volverPan = new JPanel();
		sur.add(volverPan);
		
		volverBoton = new JButton("Volver");
		volverPan.add(volverBoton);
		
		crearPan = new JPanel();
		sur.add(crearPan);
		
		crearBoton = new JButton("Crear Ticket");
		crearPan.add(crearBoton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public Locaciones getLocacion() {
		return (Locaciones) this.locacionDesplegable.getSelectedItem();
	}
	
	public Rubros getRubro() {
		return (Rubros) this.rubroDesplegable.getSelectedItem();
	}
	

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.crearBoton.addActionListener(actionListener);
		this.volverBoton.addActionListener(actionListener);
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
		
	}
	
}
