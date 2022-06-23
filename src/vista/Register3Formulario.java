package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.Locaciones;
import enums.Remuneraciones;
import enums.CargasHorarias;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Experiencias;
import enums.EstudiosPrevios;
import enums.Rubros;

public class Register3Formulario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register3Formulario frame = new Register3Formulario();
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
	public Register3Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 3, 0, 0));
		
		JPanel locacion = new JPanel();
		contentPane.add(locacion);
		locacion.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel locacionLabelPan = new JPanel();
		locacion.add(locacionLabelPan);
		
		JLabel locacionLabel = new JLabel("Locacion:");
		locacionLabelPan.add(locacionLabel);
		
		JPanel locacionDesplegable = new JPanel();
		locacion.add(locacionDesplegable);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Locaciones.values()));
		locacionDesplegable.add(comboBox);
		
		JPanel remuneracion = new JPanel();
		contentPane.add(remuneracion);
		remuneracion.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel remuneracionLabelPan = new JPanel();
		remuneracion.add(remuneracionLabelPan);
		
		JLabel remuneracionLabel = new JLabel("Remuneracion:");
		remuneracionLabelPan.add(remuneracionLabel);
		
		JPanel remuneracionDesplegable = new JPanel();
		remuneracion.add(remuneracionDesplegable);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Remuneraciones.values()));
		remuneracionDesplegable.add(comboBox_1);
		
		JPanel cargaHoraria = new JPanel();
		contentPane.add(cargaHoraria);
		cargaHoraria.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel cargaHorariaLabelPan = new JPanel();
		cargaHoraria.add(cargaHorariaLabelPan);
		
		JLabel cargaHorariaLabel = new JLabel("Carga Horaria:");
		cargaHorariaLabelPan.add(cargaHorariaLabel);
		
		JPanel cargaHorariaDesplegable = new JPanel();
		cargaHoraria.add(cargaHorariaDesplegable);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(CargasHorarias.values()));
		cargaHorariaDesplegable.add(comboBox_2);
		
		JPanel puestoLaboral = new JPanel();
		contentPane.add(puestoLaboral);
		puestoLaboral.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel puestoLaboralLabelPan = new JPanel();
		puestoLaboral.add(puestoLaboralLabelPan);
		
		JLabel puestoLaboralLabel = new JLabel("Puesto Laboral:");
		puestoLaboralLabelPan.add(puestoLaboralLabel);
		
		JPanel puestoLaboralDesplegable = new JPanel();
		puestoLaboral.add(puestoLaboralDesplegable);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(PuestosLaborales.values()));
		puestoLaboralDesplegable.add(comboBox_3);
		
		JPanel rangoEtario = new JPanel();
		contentPane.add(rangoEtario);
		rangoEtario.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel rangoEtarioLabelPan = new JPanel();
		rangoEtario.add(rangoEtarioLabelPan);
		
		JLabel rangoEtarioLabel = new JLabel("Rango Etario:");
		rangoEtarioLabelPan.add(rangoEtarioLabel);
		
		JPanel rangoEtarioDesplegable = new JPanel();
		rangoEtario.add(rangoEtarioDesplegable);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(RangosEtarios.values()));
		rangoEtarioDesplegable.add(comboBox_4);
		
		JPanel experiencia = new JPanel();
		contentPane.add(experiencia);
		experiencia.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel experienciaLabelPan = new JPanel();
		experiencia.add(experienciaLabelPan);
		
		JLabel experienciaLabel = new JLabel("Experiencia:");
		experienciaLabelPan.add(experienciaLabel);
		
		JPanel experienciaDesplegable = new JPanel();
		experiencia.add(experienciaDesplegable);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(Experiencias.values()));
		experienciaDesplegable.add(comboBox_5);
		
		JPanel estudio = new JPanel();
		contentPane.add(estudio);
		estudio.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel estudioLabelPan = new JPanel();
		estudio.add(estudioLabelPan);
		
		JLabel estudioLabel = new JLabel("Estudios:");
		estudioLabelPan.add(estudioLabel);
		
		JPanel estudioDesplegable = new JPanel();
		estudio.add(estudioDesplegable);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(EstudiosPrevios.values()));
		estudioDesplegable.add(comboBox_6);
		
		JPanel rubro = new JPanel();
		contentPane.add(rubro);
		rubro.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel rubroLabelPan = new JPanel();
		rubro.add(rubroLabelPan);
		
		JLabel rubroLabel = new JLabel("Rubro:");
		rubroLabelPan.add(rubroLabel);
		
		JPanel rubroDesplegable = new JPanel();
		rubro.add(rubroDesplegable);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(Rubros.values()));
		rubroDesplegable.add(comboBox_7);
		
		JPanel volver = new JPanel();
		contentPane.add(volver);
		
		JButton volverBoton = new JButton("Volver");
		volver.add(volverBoton);
		
		JPanel finalizar = new JPanel();
		contentPane.add(finalizar);
		
		JButton finalizarBoton = new JButton("Finalizar");
		finalizar.add(finalizarBoton);
	}

}
