package controladores;

import java.io.IOException;

import persistencia.AgenciaDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.UtilDTO;

public class Sistema {
	private static Sistema _instancia = null;

	private IController controladorActual;
	private IPersistencia<AgenciaDTO> persistencia = new PersistenciaBIN<AgenciaDTO>();
	private static String filename = "datos.bin";

	private Sistema() {

	}

	public static Sistema getInstancia() {
		if (_instancia == null)
			_instancia = new Sistema();
		return _instancia;
	}

	public void iniciarSistema() {
		try {
			AgenciaDTO agenciaDTO = persistencia.recuperar(filename);
			UtilDTO.agenciaFromAgenciaDTO(agenciaDTO);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		controladorActual = new LoginController();
	}
	
	public void cerrarSistema() {
		try {
			persistencia.persistir(filename, UtilDTO.agenciaDTOFromAgencia());
		} catch (IOException e1) {
			System.out.println("Error al persistir");
		}
	}

	public void cambiarController(IController controller) {
		controladorActual = controller;
	}
}
