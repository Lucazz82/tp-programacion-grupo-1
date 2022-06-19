package controladores;

import java.io.IOException;

import persistencia.AgenciaDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.UtilDTO;

public class Sistema {
	private static Sistema _instancia = null;

	private IController controladorActual;

	private Sistema() {

	}

	public static Sistema getInstancia() {
		if (_instancia == null)
			_instancia = new Sistema();
		return _instancia;
	}

	public void iniciarSistema() {
		IPersistencia<AgenciaDTO> persistencia = new PersistenciaBIN<AgenciaDTO>();
		try {
			AgenciaDTO agenciaDTO = persistencia.recuperar("datos.bin");
			UtilDTO.agenciaFromAgenciaDTO(agenciaDTO);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		controladorActual = new LoginController();
	}

	public void cambiarController(IController controller) {
		controladorActual = controller;
	}
}
