package controladores;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
import modelos.Coincidencia;
import vista.CoincidenciasVista;

public class CoincidenciasController extends Controller<CoincidenciasVista> {

	public CoincidenciasController() {
		super(new CoincidenciasVista());
		this.setCoincidencias();
	}

	private void setCoincidencias() {
		try {
			Agencia agencia = Agencia.getInstancia();
			this.vista.setListaCoincidencias(agencia.getCoincidencias());
		} catch (AgenciaInexistenteException e) {
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new AgenciaController());
			this.vista.setVisible(false);
		} else if(e.getActionCommand().equalsIgnoreCase("Ver Comision")) {
			Coincidencia coincidencia = this.vista.getCoincidencia();
			if(coincidencia != null) {
				String msg = "Comision empleador: " + coincidencia.getComisionEmpleador() + "\nComision empleado: " + coincidencia.getComisionEmpleado(); 
				JOptionPane.showMessageDialog(vista, msg);				
			} else {
				JOptionPane.showMessageDialog(vista, "Debe seleccionar una coincidencia");	
			}
		}
	}

}
