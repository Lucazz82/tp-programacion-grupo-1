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
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import enums.CargasHorarias;
import enums.EstudiosPrevios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;

public class FormularioVista extends JFrame implements IVista {

	private JPanel contentPane;
	private JPanel principal;
	private JPanel sur;
	private JPanel locacion;
	private JPanel locacionLabelPan;
	private JLabel locacionLabel;
	private JPanel locacionDesplegablePan;
	private JComboBox locacionDesplegable;
	private JPanel remuneracion;
	private JPanel remuneracionLabelPan;
	private JLabel remuneracionLabel;
	private JPanel remuneracionDesplegablePan;
	private JComboBox remuneracionDesplegable;
	private JPanel cargaHoraria;
	private JPanel cargaHorariaLabelPan;
	private JLabel cargaHorariaLabel;
	private JPanel cargaHorariaDesplegablePan;
	private JComboBox cargaHorariaDesplegable;
	private JPanel puestoLaboral;
	private JPanel puestoLaboralLabelPan;
	private JLabel puestoLaboralLabel;
	private JPanel puestoLaboralDesplegablePan;
	private JComboBox puestoLaboralDesplegable;
	private JPanel rangoEtario;
	private JPanel rangoEtarioLabelPan;
	private JLabel rangoEtarioLabel;
	private JPanel rangoEtarioDesplegablePan;
	private JComboBox rangoEtarioDesplegable;
	private JPanel experiencia;
	private JPanel experienciaLabelPan;
	private JLabel experienciaLabel;
	private JPanel experienciaDesplegablePan;
	private JComboBox experienciaDesplegable;
	private JPanel estudio;
	private JPanel estudioLabelPan;
	private JLabel estudioLabel;
	private JPanel estudioDesplegablePan;
	private JComboBox estudioDesplegable;
	private JPanel rubro;
	private JPanel rubroLabelPan;
	private JLabel rubroLabel;
	private JPanel rubroDesplegablePan;
	private JComboBox rubroDesplegable;
	private JPanel volver;
	private JPanel volverBotonPan;
	private JButton volverBoton;
	private JPanel crear;
	private JButton crearBoton;
	private JPanel limites;
	private JLabel V1Label;
	private JLabel V2Label;
	private JSpinner V1Spinner;
	private JSpinner V2Spinner;

	/**
	 * Create the frame.
	 */
	public FormularioVista() {
		setTitle("Creacion de Formulario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		principal = new JPanel();
		contentPane.add(principal, BorderLayout.CENTER);
		principal.setLayout(new GridLayout(0, 2, 0, 0));

		locacion = new JPanel();
		principal.add(locacion);
		locacion.setLayout(new GridLayout(2, 0, 0, 0));

		locacionLabelPan = new JPanel();
		locacion.add(locacionLabelPan);

		locacionLabel = new JLabel("Locacion:");
		locacionLabelPan.add(locacionLabel);

		locacionDesplegablePan = new JPanel();
		locacion.add(locacionDesplegablePan);

		locacionDesplegable = new JComboBox();
		locacionDesplegable.setModel(new DefaultComboBoxModel(Locaciones.values()));
		locacionDesplegablePan.add(locacionDesplegable);

		remuneracion = new JPanel();
		principal.add(remuneracion);
		remuneracion.setLayout(new GridLayout(2, 0, 0, 0));

		remuneracionLabelPan = new JPanel();
		remuneracion.add(remuneracionLabelPan);

		remuneracionLabel = new JLabel("Remuneracion:");
		remuneracionLabelPan.add(remuneracionLabel);

		remuneracionDesplegablePan = new JPanel();
		remuneracion.add(remuneracionDesplegablePan);

		remuneracionDesplegable = new JComboBox();
		remuneracionDesplegable.setModel(new DefaultComboBoxModel(Remuneraciones.values()));
		remuneracionDesplegablePan.add(remuneracionDesplegable);

		cargaHoraria = new JPanel();
		principal.add(cargaHoraria);
		cargaHoraria.setLayout(new GridLayout(2, 0, 0, 0));

		cargaHorariaLabelPan = new JPanel();
		cargaHoraria.add(cargaHorariaLabelPan);

		cargaHorariaLabel = new JLabel("Carga Horaria:");
		cargaHorariaLabelPan.add(cargaHorariaLabel);

		cargaHorariaDesplegablePan = new JPanel();
		cargaHoraria.add(cargaHorariaDesplegablePan);

		cargaHorariaDesplegable = new JComboBox();
		cargaHorariaDesplegable.setModel(new DefaultComboBoxModel(CargasHorarias.values()));
		cargaHorariaDesplegablePan.add(cargaHorariaDesplegable);

		limites = new JPanel();
		principal.add(limites);
		limites.setLayout(new GridLayout(2, 2, 0, 0));

		V1Label = new JLabel("V1");
		limites.add(V1Label);

		V2Label = new JLabel("V2");
		limites.add(V2Label);

		V1Spinner = new JSpinner();
		V1Spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		limites.add(V1Spinner);

		V2Spinner = new JSpinner();
		V2Spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		limites.add(V2Spinner);

		puestoLaboral = new JPanel();
		principal.add(puestoLaboral);
		puestoLaboral.setLayout(new GridLayout(2, 0, 0, 0));

		puestoLaboralLabelPan = new JPanel();
		puestoLaboral.add(puestoLaboralLabelPan);

		puestoLaboralLabel = new JLabel("Puesto Laboral:");
		puestoLaboralLabelPan.add(puestoLaboralLabel);

		puestoLaboralDesplegablePan = new JPanel();
		puestoLaboral.add(puestoLaboralDesplegablePan);

		puestoLaboralDesplegable = new JComboBox();
		puestoLaboralDesplegable.setModel(new DefaultComboBoxModel(PuestosLaborales.values()));
		puestoLaboralDesplegablePan.add(puestoLaboralDesplegable);

		rangoEtario = new JPanel();
		principal.add(rangoEtario);
		rangoEtario.setLayout(new GridLayout(2, 0, 0, 0));

		rangoEtarioLabelPan = new JPanel();
		rangoEtario.add(rangoEtarioLabelPan);

		rangoEtarioLabel = new JLabel("Rango Etario:");
		rangoEtarioLabelPan.add(rangoEtarioLabel);

		rangoEtarioDesplegablePan = new JPanel();
		rangoEtario.add(rangoEtarioDesplegablePan);

		rangoEtarioDesplegable = new JComboBox();
		rangoEtarioDesplegable.setModel(new DefaultComboBoxModel(RangosEtarios.values()));
		rangoEtarioDesplegablePan.add(rangoEtarioDesplegable);

		experiencia = new JPanel();
		principal.add(experiencia);
		experiencia.setLayout(new GridLayout(2, 0, 0, 0));

		experienciaLabelPan = new JPanel();
		experiencia.add(experienciaLabelPan);

		experienciaLabel = new JLabel("Experiencia:");
		experienciaLabelPan.add(experienciaLabel);

		experienciaDesplegablePan = new JPanel();
		experiencia.add(experienciaDesplegablePan);

		experienciaDesplegable = new JComboBox();
		experienciaDesplegable.setModel(new DefaultComboBoxModel(Experiencias.values()));
		experienciaDesplegablePan.add(experienciaDesplegable);

		estudio = new JPanel();
		principal.add(estudio);
		estudio.setLayout(new GridLayout(2, 0, 0, 0));

		estudioLabelPan = new JPanel();
		estudio.add(estudioLabelPan);

		estudioLabel = new JLabel("Estudios:");
		estudioLabelPan.add(estudioLabel);

		estudioDesplegablePan = new JPanel();
		estudio.add(estudioDesplegablePan);

		estudioDesplegable = new JComboBox();
		estudioDesplegable.setModel(new DefaultComboBoxModel(EstudiosPrevios.values()));
		estudioDesplegablePan.add(estudioDesplegable);

		rubro = new JPanel();
		principal.add(rubro);
		rubro.setLayout(new GridLayout(2, 0, 0, 0));

		rubroLabelPan = new JPanel();
		rubro.add(rubroLabelPan);

		rubroLabel = new JLabel("Rubro:");
		rubroLabelPan.add(rubroLabel);

		rubroDesplegablePan = new JPanel();
		rubro.add(rubroDesplegablePan);

		rubroDesplegable = new JComboBox();
		rubroDesplegable.setModel(new DefaultComboBoxModel(Rubros.values()));
		rubroDesplegablePan.add(rubroDesplegable);

		sur = new JPanel();
		contentPane.add(sur, BorderLayout.SOUTH);

		volver = new JPanel();
		sur.add(volver);

		volverBotonPan = new JPanel();
		volver.add(volverBotonPan);

		volverBoton = new JButton("Volver");
		volverBotonPan.add(volverBoton);

		crear = new JPanel();
		sur.add(crear);

		crearBoton = new JButton("Crear Ticket");
		crear.add(crearBoton);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public Locaciones getLocacion() {
		return (Locaciones) this.locacionDesplegable.getSelectedItem();
	}

	public Remuneraciones getRemuneracion() {
		return (Remuneraciones) this.remuneracionDesplegable.getSelectedItem();
	}

	public int getV1() {
		return (int) this.V1Spinner.getValue();
	}

	public void desHabilitarV1() {
		this.V1Spinner.setEnabled(false);
	}

	public void desHabilitarV2() {
		this.V2Spinner.setEnabled(false);
	}

	public void habilitarV1() {
		this.V1Spinner.setEnabled(true);
	}

	public void habilitarV2() {
		this.V2Spinner.setEnabled(true);
	}

	public int getV2() {
		return (int) this.V2Spinner.getValue();
	}

	public CargasHorarias getCargaHoraria() {
		return (CargasHorarias) this.cargaHorariaDesplegable.getSelectedItem();
	}

	public PuestosLaborales getPuestoLaboral() {
		return (PuestosLaborales) this.puestoLaboralDesplegable.getSelectedItem();
	}

	public RangosEtarios getRangoEtario() {
		return (RangosEtarios) this.rangoEtarioDesplegable.getSelectedItem();
	}

	public Experiencias getExperiencias() {
		return (Experiencias) this.experienciaDesplegable.getSelectedItem();
	}

	public EstudiosPrevios getEstudios() {
		return (EstudiosPrevios) this.estudioDesplegable.getSelectedItem();
	}

	public Rubros getRubro() {
		return (Rubros) this.rubroDesplegable.getSelectedItem();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.crearBoton.addActionListener(actionListener);
		this.volverBoton.addActionListener(actionListener);
		this.remuneracionDesplegable.addActionListener(actionListener);
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);

	}
}
