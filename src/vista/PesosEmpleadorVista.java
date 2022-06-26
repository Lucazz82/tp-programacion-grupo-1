package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class PesosEmpleadorVista extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel pesosLabelPan;
	private JPanel pesos1Pan;
	private JLabel pesosLabel;
	private JLabel locacionLabel;
	private JPanel locacionPan;
	private JPanel locacionPanNum;
	private JSpinner spinnerLocacion;
	private JPanel remuneracionPan;
	private JLabel remuneracionLabel;
	private JPanel remuneracionPanNum;
	private JSpinner spinnerRemuneracion;
	private JPanel pesos2Pan;
	private JPanel cargaHorariaPan;
	private JLabel cargaHorariaLabel;
	private JSpinner spinnerCargaHoraria;
	private JPanel cargaHorariaPanNum;
	private JPanel tipoDePuestoPan;
	private JLabel tipoDePuestoLabel;
	private JPanel tipoDePuestoPanNum;
	private JSpinner spinnerPuesto;
	private JPanel pesos3Pan;
	private JPanel rangoEtarioPan;
	private JLabel rangoEtarioLabel;
	private JPanel rengoEtarioPanNum;
	private JSpinner spinnerRangoEtario;
	private JPanel experienciaPan;
	private JLabel experienciaLabel;
	private JPanel experienciaPanNum;
	private JSpinner spinnerExperiencia;
	private JLabel estudiosLabel;
	private JPanel estudiosPanLabel;
	private JSpinner spinnerEstudios;
	private JPanel enBlanco;
	private JButton siguienteBoton;
	private JPanel estudiosPanNum;
	private JPanel siguienteBotonPan;

	public PesosEmpleadorVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 0, 0));
		
		pesosLabelPan = new JPanel();
		contentPane.add(pesosLabelPan);
		
		pesosLabel = new JLabel("Pesos:");
		pesosLabelPan.add(pesosLabel);
		
		pesos1Pan = new JPanel();
		contentPane.add(pesos1Pan);
		pesos1Pan.setLayout(new GridLayout(0, 4, 0, 0));
		
		locacionPan = new JPanel();
		pesos1Pan.add(locacionPan);
		
		locacionLabel = new JLabel("Locacion:");
		locacionPan.add(locacionLabel);
		
		locacionPanNum = new JPanel();
		pesos1Pan.add(locacionPanNum);
		
		spinnerLocacion = new JSpinner(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		locacionPanNum.add(spinnerLocacion);
		
		remuneracionPan = new JPanel();
		pesos1Pan.add(remuneracionPan);
		
		remuneracionLabel = new JLabel("Remuneracion:");
		remuneracionPan.add(remuneracionLabel);
		
		remuneracionPanNum = new JPanel();
		pesos1Pan.add(remuneracionPanNum);
		
		spinnerRemuneracion = new JSpinner(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		remuneracionPanNum.add(spinnerRemuneracion);
		
		pesos2Pan = new JPanel();
		contentPane.add(pesos2Pan);
		pesos2Pan.setLayout(new GridLayout(0, 4, 0, 0));
		
		cargaHorariaPan = new JPanel();
		pesos2Pan.add(cargaHorariaPan);
		
		cargaHorariaLabel = new JLabel("Carga Horaria:");
		cargaHorariaPan.add(cargaHorariaLabel);
		
		cargaHorariaPanNum = new JPanel();
		pesos2Pan.add(cargaHorariaPanNum);
		
		spinnerCargaHoraria = new JSpinner(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		cargaHorariaPanNum.add(spinnerCargaHoraria);
		
		tipoDePuestoPan = new JPanel();
		pesos2Pan.add(tipoDePuestoPan);
		
		tipoDePuestoLabel = new JLabel("Tipo de Puesto:");
		tipoDePuestoPan.add(tipoDePuestoLabel);
		
		tipoDePuestoPanNum = new JPanel();
		pesos2Pan.add(tipoDePuestoPanNum);
		
		spinnerPuesto = new JSpinner(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		tipoDePuestoPanNum.add(spinnerPuesto);
		
		pesos3Pan = new JPanel();
		contentPane.add(pesos3Pan);
		pesos3Pan.setLayout(new GridLayout(0, 4, 0, 0));
		
		rangoEtarioPan = new JPanel();
		pesos3Pan.add(rangoEtarioPan);
		
		rangoEtarioLabel = new JLabel("Rango Etario:");
		rangoEtarioPan.add(rangoEtarioLabel);
		
		rengoEtarioPanNum = new JPanel();
		pesos3Pan.add(rengoEtarioPanNum);
		
		spinnerRangoEtario = new JSpinner(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		rengoEtarioPanNum.add(spinnerRangoEtario);
		
		experienciaPan = new JPanel();
		pesos3Pan.add(experienciaPan);
		
		experienciaLabel = new JLabel("Experiencia:");
		experienciaPan.add(experienciaLabel);
		
		experienciaPanNum = new JPanel();
		pesos3Pan.add(experienciaPanNum);
		
		spinnerExperiencia = new JSpinner(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		experienciaPanNum.add(spinnerExperiencia);
		
		JPanel pesoYBoton = new JPanel();
		contentPane.add(pesoYBoton);
		pesoYBoton.setLayout(new GridLayout(0, 4, 0, 0));
		
		estudiosPanLabel = new JPanel();
		pesoYBoton.add(estudiosPanLabel);
		
		estudiosLabel = new JLabel("Estudios:");
		estudiosPanLabel.add(estudiosLabel);
		
		estudiosPanNum = new JPanel();
		pesoYBoton.add(estudiosPanNum);
		
		spinnerEstudios = new JSpinner(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		estudiosPanNum.add(spinnerEstudios);
		
		enBlanco = new JPanel();
		pesoYBoton.add(enBlanco);
		
		siguienteBotonPan = new JPanel();
		pesoYBoton.add(siguienteBotonPan);
		
		siguienteBoton = new JButton("Siguiente");
		siguienteBotonPan.add(siguienteBoton);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		siguienteBoton.addActionListener(actionListener);
	}

	@Override
	public void setWindowListener(WindowListener windowListener) {
		this.addWindowListener(windowListener);
	}
	
	public int getLocacion() {
		return (int)this.spinnerLocacion.getValue();
	}
	
	public int getRemuneracion() {
		return (int)this.spinnerRemuneracion.getValue();
	}
	
	public int getRangoEtario() {
		return (int)this.spinnerRangoEtario.getValue();
	}
	
	public int getExperiencia() {
		return (int)this.spinnerExperiencia.getValue();
	}
	
	public int getPuesto() {
		return (int)this.spinnerPuesto.getValue();
	}
	
	public int getCargaHoraria() {
		return (int)this.spinnerCargaHoraria.getValue();
	}
	
	public int getEstudios() {
		return (int)this.spinnerEstudios.getValue();
	}
}
