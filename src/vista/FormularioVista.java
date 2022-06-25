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

public class FormularioVista extends JFrame {

	private JPanel contentPane;
	private JLabel locacionLabel;
	private JPanel locacionLabelPan;
	private JPanel locacion;
	private JPanel locacionDesplegable;
	private JComboBox comboBox;
	private JPanel remuneracion;
	private JPanel remuneracionLabelPan;
	private JLabel remuneracionLabel;
	private JPanel remuneracionDesplegable;
	private JComboBox comboBox_1;
	private JPanel cargaHoraria;
	private JPanel cargaHorariaLabelPan;
	private JLabel cargaHorariaLabel;
	private JPanel cargaHorariaDesplegable;
	private JComboBox comboBox_2;
	private JPanel puestoLaboral;
	private JPanel puestoLaboralLabelPan;
	private JLabel puestoLaboralLabel;
	private JPanel puestoLaboralDesplegable;
	private JComboBox comboBox_3;
	private JPanel rangoEtario;
	private JPanel rangoEtarioLabelPan;
	private JLabel rangoEtarioLabel;
	private JPanel rangoEtarioDesplegable;
	private JComboBox comboBox_4;
	private JPanel experiencia;
	private JPanel experienciaLabelPan;
	private JLabel experienciaLabel;
	private JPanel experienciaDesplegable;
	private JComboBox comboBox_5;
	private JPanel estudio;
	private JPanel estudioLabelPan;
	private JLabel estudioLabel;
	private JPanel estudioDesplegable;
	private JComboBox comboBox_6;
	private JPanel rubro;
	private JPanel rubroLabelPan;
	private JLabel rubroLabel;
	private JPanel rubroDesplegable;
	private JComboBox comboBox_7;
	private JPanel volver;
	private JButton volverBoton;
	private JPanel finalizar;
	private JButton finalizarBoton;

	/**
	 * Create the frame.
	 */
	public FormularioVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 3, 0, 0));
		
		locacion = new JPanel();
		contentPane.add(locacion);
		locacion.setLayout(new GridLayout(2, 0, 0, 0));
		
		locacionLabelPan = new JPanel();
		locacion.add(locacionLabelPan);
		
		locacionLabel = new JLabel("Locacion:");
		locacionLabelPan.add(locacionLabel);
		
		locacionDesplegable = new JPanel();
		locacion.add(locacionDesplegable);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Locaciones.values()));
		locacionDesplegable.add(comboBox);
		
		remuneracion = new JPanel();
		contentPane.add(remuneracion);
		remuneracion.setLayout(new GridLayout(2, 0, 0, 0));
		
		remuneracionLabelPan = new JPanel();
		remuneracion.add(remuneracionLabelPan);
		
		remuneracionLabel = new JLabel("Remuneracion:");
		remuneracionLabelPan.add(remuneracionLabel);
		
		remuneracionDesplegable = new JPanel();
		remuneracion.add(remuneracionDesplegable);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Remuneraciones.values()));
		remuneracionDesplegable.add(comboBox_1);
		
		cargaHoraria = new JPanel();
		contentPane.add(cargaHoraria);
		cargaHoraria.setLayout(new GridLayout(2, 0, 0, 0));
		
		cargaHorariaLabelPan = new JPanel();
		cargaHoraria.add(cargaHorariaLabelPan);
		
		cargaHorariaLabel = new JLabel("Carga Horaria:");
		cargaHorariaLabelPan.add(cargaHorariaLabel);
		
		cargaHorariaDesplegable = new JPanel();
		cargaHoraria.add(cargaHorariaDesplegable);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(CargasHorarias.values()));
		cargaHorariaDesplegable.add(comboBox_2);
		
		puestoLaboral = new JPanel();
		contentPane.add(puestoLaboral);
		puestoLaboral.setLayout(new GridLayout(2, 0, 0, 0));
		
		puestoLaboralLabelPan = new JPanel();
		puestoLaboral.add(puestoLaboralLabelPan);
		
		puestoLaboralLabel = new JLabel("Puesto Laboral:");
		puestoLaboralLabelPan.add(puestoLaboralLabel);
		
		puestoLaboralDesplegable = new JPanel();
		puestoLaboral.add(puestoLaboralDesplegable);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(PuestosLaborales.values()));
		puestoLaboralDesplegable.add(comboBox_3);
		
		rangoEtario = new JPanel();
		contentPane.add(rangoEtario);
		rangoEtario.setLayout(new GridLayout(2, 0, 0, 0));
		
		rangoEtarioLabelPan = new JPanel();
		rangoEtario.add(rangoEtarioLabelPan);
		
		rangoEtarioLabel = new JLabel("Rango Etario:");
		rangoEtarioLabelPan.add(rangoEtarioLabel);
		
		rangoEtarioDesplegable = new JPanel();
		rangoEtario.add(rangoEtarioDesplegable);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(RangosEtarios.values()));
		rangoEtarioDesplegable.add(comboBox_4);
		
		experiencia = new JPanel();
		contentPane.add(experiencia);
		experiencia.setLayout(new GridLayout(2, 0, 0, 0));
		
		experienciaLabelPan = new JPanel();
		experiencia.add(experienciaLabelPan);
		
		experienciaLabel = new JLabel("Experiencia:");
		experienciaLabelPan.add(experienciaLabel);
		
		experienciaDesplegable = new JPanel();
		experiencia.add(experienciaDesplegable);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(Experiencias.values()));
		experienciaDesplegable.add(comboBox_5);
		
		estudio = new JPanel();
		contentPane.add(estudio);
		estudio.setLayout(new GridLayout(2, 0, 0, 0));
		
		estudioLabelPan = new JPanel();
		estudio.add(estudioLabelPan);
		
		estudioLabel = new JLabel("Estudios:");
		estudioLabelPan.add(estudioLabel);
		
		estudioDesplegable = new JPanel();
		estudio.add(estudioDesplegable);
		
		comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(EstudiosPrevios.values()));
		estudioDesplegable.add(comboBox_6);
		
		rubro = new JPanel();
		contentPane.add(rubro);
		rubro.setLayout(new GridLayout(2, 0, 0, 0));
		
		rubroLabelPan = new JPanel();
		rubro.add(rubroLabelPan);
		
		rubroLabel = new JLabel("Rubro:");
		rubroLabelPan.add(rubroLabel);
		
		rubroDesplegable = new JPanel();
		rubro.add(rubroDesplegable);
		
		comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(Rubros.values()));
		rubroDesplegable.add(comboBox_7);
		
		volver = new JPanel();
		contentPane.add(volver);
		
		volverBoton = new JButton("Volver");
		volver.add(volverBoton);
		
		finalizar = new JPanel();
		contentPane.add(finalizar);
		
		finalizarBoton = new JButton("Finalizar");
		finalizar.add(finalizarBoton);
	}

}
