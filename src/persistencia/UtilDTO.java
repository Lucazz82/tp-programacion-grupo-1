package persistencia;

import excepciones.AgenciaInexistenteException;
import excepciones.AgenciaYaExistenteException;
import modelos.Agencia;

public class UtilDTO {
	public static AgenciaDTO agenciaDTOFromAgencia() throws AgenciaInexistenteException {
		AgenciaDTO respuesta = new AgenciaDTO();
		respuesta.setCoincidencias(Agencia.getInstancia().getCoincidencias());
		respuesta.setEmpleadores(Agencia.getInstancia().getEmpleadores());
		respuesta.setEmpleados(Agencia.getInstancia().getEmpleados());
		respuesta.setListasAsignaciones(Agencia.getInstancia().getListasAsignaciones());
		respuesta.setUsuario(Agencia.getInstancia().getUsuario());
		respuesta.setContrasenia(Agencia.getInstancia().getContrasenia());
		return respuesta;
	}

	public static void agenciaFromAgenciaDTO(AgenciaDTO agenciaDTO) throws AgenciaInexistenteException, AgenciaYaExistenteException {
		Agencia.registrarAgencia(agenciaDTO.getUsuario(), agenciaDTO.getContrasenia());
		Agencia agencia = Agencia.getInstancia();

		agencia.setCoincidencias(agenciaDTO.getCoincidencias());
		agencia.setEmpleadores(agenciaDTO.getEmpleadores());
		agencia.setEmpleados(agenciaDTO.getEmpleados());
		agencia.setListasAsignaciones(agenciaDTO.getListasAsignaciones());
		agencia.setUsuario(agenciaDTO.getUsuario());
		agencia.setContrasenia(agenciaDTO.getContrasenia());
	}
}
