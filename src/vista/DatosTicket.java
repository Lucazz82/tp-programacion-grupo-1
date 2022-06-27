package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class DatosTicket extends JFrame implements IVista {

	private JPanel contentPane;
	private JPanel left;
	private JPanel locacion;
	private JLabel locacionLabel;
	private JLabel locacionText;
	private JPanel remuneracion;
	private JLabel remuneracionLabel;
	private JLabel remuneracionText;
	private JPanel cargaHoraria;
	private JLabel cargaHorariaLabel;
	private JLabel cargaHorariaText;
	private JPanel puestoLaboral;
	private JLabel puestoLaboralLabel;
	private JLabel puestoLaboralText;
	private JPanel rangoEtario;
	private JLabel rangoEtarioLabel;
	private JLabel rangoEtarioText;
	private JPanel experiencia;
	private JLabel experienciaLabel;
	private JLabel experienciaText;
	private JPanel estudio;
	private JLabel estudioLabel;
	private JLabel estudioText;
	private JPanel rubro;
	private JLabel rubroLabel;
	private JLabel rubroText;
	private JPanel right;
	private JPanel fecha;
	private JLabel fechaLabel;
	private JLabel fechaText;
	private JPanel estado;
	private JLabel estadoLabel;
	private JLabel estadoText;
	private JPanel elegido;
	private JLabel elegidoLabel;
	private JLabel elegidoText;
	private JButton volverBoton;
	private JPanel volverBotonPan;

	public DatosTicket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		left = new JPanel();
		contentPane.add(left);
		left.setLayout(new GridLayout(0, 1, 0, 0));

		locacion = new JPanel();
		left.add(locacion);

		locacionLabel = new JLabel("Locacion:");
		locacion.add(locacionLabel);

		locacionText = new JLabel("New label");
		locacion.add(locacionText);

		remuneracion = new JPanel();
		left.add(remuneracion);

		remuneracionLabel = new JLabel("Remuneracion:");
		remuneracion.add(remuneracionLabel);

		remuneracionText = new JLabel("New label");
		remuneracion.add(remuneracionText);

		cargaHoraria = new JPanel();
		left.add(cargaHoraria);

		cargaHorariaLabel = new JLabel("Carga Horaria:");
		cargaHoraria.add(cargaHorariaLabel);

		cargaHorariaText = new JLabel("New label");
		cargaHoraria.add(cargaHorariaText);

		puestoLaboral = new JPanel();
		left.add(puestoLaboral);

		puestoLaboralLabel = new JLabel("Puesto Laboral:");
		puestoLaboral.add(puestoLaboralLabel);

		puestoLaboralText = new JLabel("New label");
		puestoLaboral.add(puestoLaboralText);

		rangoEtario = new JPanel();
		left.add(rangoEtario);

		rangoEtarioLabel = new JLabel("Rango Etario:");
		rangoEtario.add(rangoEtarioLabel);

		rangoEtarioText = new JLabel("New label");
		rangoEtario.add(rangoEtarioText);

		experiencia = new JPanel();
		left.add(experiencia);

		experienciaLabel = new JLabel("Experiencia:");
		experiencia.add(experienciaLabel);

		experienciaText = new JLabel("New label");
		experiencia.add(experienciaText);

		estudio = new JPanel();
		left.add(estudio);

		estudioLabel = new JLabel("Estudios Previos:");
		estudio.add(estudioLabel);

		estudioText = new JLabel("New label");
		estudio.add(estudioText);

		rubro = new JPanel();
		left.add(rubro);

		rubroLabel = new JLabel("Rubro:");
		rubro.add(rubroLabel);

		rubroText = new JLabel("New label");
		rubro.add(rubroText);

		right = new JPanel();
		contentPane.add(right);
		right.setLayout(new GridLayout(0, 1, 0, 0));

		fecha = new JPanel();
		right.add(fecha);

		fechaLabel = new JLabel("Fecha de Creación:");
		fecha.add(fechaLabel);

		fechaText = new JLabel("New label");
		fecha.add(fechaText);

		estado = new JPanel();
		right.add(estado);

		estadoLabel = new JLabel("Estado:");
		estado.add(estadoLabel);

		estadoText = new JLabel("New label");
		estado.add(estadoText);

		elegido = new JPanel();
		right.add(elegido);

		elegidoLabel = new JLabel("Elegido:");
		elegido.add(elegidoLabel);

		elegidoText = new JLabel("New label");
		elegido.add(elegidoText);

		volverBotonPan = new JPanel();
		right.add(volverBotonPan);

		volverBoton = new JButton("Volver");
		volverBotonPan.add(volverBoton);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.volverBoton.addActionListener(actionListener);
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
	}

	public void setLocacion(String locacion) {
		this.locacionText.setText(locacion);
	}

	public void setRemuneracion(String remuneracion) {
		this.remuneracionText.setText(remuneracion);
	}

	public void setPuestoLaboral(String puesto) {
		this.puestoLaboralText.setText(puesto);
	}

	public void setRangoEtario(String rango) {
		this.rangoEtarioText.setText(rango);
	}

	public void setExperiencia(String experiencia) {
		this.experienciaText.setText(experiencia);
	}

	public void setEstudio(String estudio) {
		this.estudioText.setText(estudio);
	}

	public void setRubro(String rubro) {
		this.rubroText.setText(rubro);
	}

	public void setCargaHoraria(String carga) {
		this.cargaHorariaText.setText(carga);
	}

	public void setFecha(String fecha) {
		this.fechaText.setText(fecha);
	}

	public void setElegido(String elegido) {
		this.elegidoText.setText(elegido);
	}

	public void setEstado(String estado) {
		this.estadoText.setText(estado);
	}
}
