package controladores;

import java.awt.event.ActionEvent;

import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
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
		} catch (AgenciaInexistenteException e) {}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
