package persistencia;

import modelos.Agencia;

public class UtilDTO {
	public static AgenciaDTO agenciaDTOFromAgencia() {
		AgenciaDTO respuesta = new AgenciaDTO();
		respuesta.setCoincidencias(Agencia.getInstancia().getCoincidencias());
		respuesta.setEmpleadores(Agencia.getInstancia().getEmpleadores());
		respuesta.setEmpleados(Agencia.getInstancia().getEmpleados());
		respuesta.setListasAsignaciones(Agencia.getInstancia().getListasAsignaciones());

		return respuesta;
	}

	public static void agenciaFromAgenciaDTO(AgenciaDTO agenciaDTO) {
		Agencia agencia = Agencia.getInstancia();

		agencia.setCoincidencias(agenciaDTO.getCoincidencias());
		agencia.setEmpleadores(agenciaDTO.getEmpleadores());
		agencia.setEmpleados(agenciaDTO.getEmpleados());
		agencia.setListasAsignaciones(agenciaDTO.getListasAsignaciones());
	}
}
