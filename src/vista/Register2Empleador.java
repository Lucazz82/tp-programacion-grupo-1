package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.TipoPersona;
import java.awt.GridBagLayout;
import enums.Rubros;
import javax.swing.JButton;

public class Register2Empleador extends JFrame implements IVista {

	private JPanel contentPane;
	private JTextField nombreText;
	private JLabel nombreLabel;
	private JLabel tipoPersonaLabel;
	private JComboBox tipoPersonaComboBox;
	private JLabel rubroLabel;
	private JComboBox rubroComboBox;
	private JButton volverBoton;
	private JButton siguienteBoton;

	/**
	 * Create the frame.
	 */
	public Register2Empleador() {
		setTitle("Datos Personales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel nombre = new JPanel();
		contentPane.add(nombre);
		nombre.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel nombreLabelPan = new JPanel();
		nombre.add(nombreLabelPan);
		
		nombreLabel = new JLabel("Nombre:");
		nombreLabelPan.add(nombreLabel);
		
		JPanel nombreTextPan = new JPanel();
		nombre.add(nombreTextPan);
		
		nombreText = new JTextField();
		nombreTextPan.add(nombreText);
		nombreText.setColumns(10);
		
		JPanel tipoPersona = new JPanel();
		contentPane.add(tipoPersona);
		tipoPersona.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel tipoPersonaLabelPan = new JPanel();
		tipoPersona.add(tipoPersonaLabelPan);
		
		tipoPersonaLabel = new JLabel("Tipo de Persona:");
		tipoPersonaLabelPan.add(tipoPersonaLabel);
		
		JPanel desplegableTipoPan = new JPanel();
		tipoPersona.add(desplegableTipoPan);
		
		tipoPersonaComboBox = new JComboBox();
		tipoPersonaComboBox.setModel(new DefaultComboBoxModel(TipoPersona.values()));
		desplegableTipoPan.add(tipoPersonaComboBox);
		
		JPanel rubro = new JPanel();
		contentPane.add(rubro);
		rubro.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel rubroLabelPan = new JPanel();
		rubro.add(rubroLabelPan);
		
		rubroLabel = new JLabel("Rubro:");
		rubroLabelPan.add(rubroLabel);
		
		JPanel desplegableRubroPan = new JPanel();
		rubro.add(desplegableRubroPan);
		
		rubroComboBox = new JComboBox();
		rubroComboBox.setModel(new DefaultComboBoxModel(Rubros.values()));
		desplegableRubroPan.add(rubroComboBox);
		
		JPanel botones = new JPanel();
		contentPane.add(botones);
		botones.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel volverBotonPan = new JPanel();
		botones.add(volverBotonPan);
		
		volverBoton = new JButton("Volver");
		volverBotonPan.add(volverBoton);
		
		JPanel siguienteBotonPan = new JPanel();
		botones.add(siguienteBotonPan);
		
		siguienteBoton = new JButton("Siguiente");
		siguienteBotonPan.add(siguienteBoton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		siguienteBoton.addActionListener(actionListener);
	}
	
	public TipoPersona getTipoPersona() {
		return (TipoPersona) tipoPersonaComboBox.getSelectedItem();
	}
	
	public Rubros getRubro() {
		return (Rubros) rubroComboBox.getSelectedItem();
	}
	
	public String getNombre() {
		return nombreText.getText();
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		// TODO Auto-generated method stub
		
	}

}
