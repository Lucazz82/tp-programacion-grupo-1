package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

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

	/**
	 * Create the frame.
	 */
	public Register2Empleador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel nombre = new JPanel();
		contentPane.add(nombre);
		nombre.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel nombreLabelPan = new JPanel();
		nombre.add(nombreLabelPan);
		
		JLabel nombreLabel = new JLabel("Nombre:");
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
		
		JLabel tipoPersonaLabel = new JLabel("Tipo de Persona:");
		tipoPersonaLabelPan.add(tipoPersonaLabel);
		
		JPanel desplegableTipoPan = new JPanel();
		tipoPersona.add(desplegableTipoPan);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipoPersona.values()));
		desplegableTipoPan.add(comboBox);
		
		JPanel rubro = new JPanel();
		contentPane.add(rubro);
		rubro.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel rubroLabelPan = new JPanel();
		rubro.add(rubroLabelPan);
		
		JLabel rubroLabel = new JLabel("Rubro:");
		rubroLabelPan.add(rubroLabel);
		
		JPanel desplegableRubroPan = new JPanel();
		rubro.add(desplegableRubroPan);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Rubros.values()));
		desplegableRubroPan.add(comboBox_1);
		
		JPanel botones = new JPanel();
		contentPane.add(botones);
		botones.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel volverBotonPan = new JPanel();
		botones.add(volverBotonPan);
		
		JButton volverBoton = new JButton("Volver");
		volverBotonPan.add(volverBoton);
		
		JPanel siguienteBotonPan = new JPanel();
		botones.add(siguienteBotonPan);
		
		JButton siguienteBoton = new JButton("Siguiente");
		siguienteBotonPan.add(siguienteBoton);
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {

	}

}
