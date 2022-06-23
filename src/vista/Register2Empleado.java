package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Register2Empleado extends JFrame implements IVista {

	private JPanel contentPane;
	private JTextField nombreText;
	private JTextField apellidoText;
	private JTextField telefonoText;

	/**
	 * Create the frame.
	 */
	public Register2Empleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 0, 0, 0));
		
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
		
		JPanel apellido = new JPanel();
		contentPane.add(apellido);
		apellido.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel apellidoLabelPan = new JPanel();
		apellido.add(apellidoLabelPan);
		
		JLabel apellidoLabel = new JLabel("Apellido:");
		apellidoLabelPan.add(apellidoLabel);
		
		JPanel apellidoTextPan = new JPanel();
		apellido.add(apellidoTextPan);
		
		apellidoText = new JTextField();
		apellidoTextPan.add(apellidoText);
		apellidoText.setColumns(10);
		
		JPanel telefono = new JPanel();
		contentPane.add(telefono);
		telefono.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel telefonoLabelPan = new JPanel();
		telefono.add(telefonoLabelPan);
		
		JLabel telefonoLabel = new JLabel("Telefono:");
		telefonoLabelPan.add(telefonoLabel);
		
		JPanel telefonoTextPan = new JPanel();
		telefono.add(telefonoTextPan);
		
		telefonoText = new JTextField();
		telefonoTextPan.add(telefonoText);
		telefonoText.setColumns(10);
		
		JPanel fecha = new JPanel();
		contentPane.add(fecha);
		fecha.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel fechaLabelPan = new JPanel();
		fecha.add(fechaLabelPan);
		
		JLabel fechaLabel = new JLabel("Fecha:");
		fechaLabelPan.add(fechaLabel);
		
		JPanel fechaText = new JPanel();
		fecha.add(fechaText);
		
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
