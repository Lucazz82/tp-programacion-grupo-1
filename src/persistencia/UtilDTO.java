package persistencia;

import modelos.Agencia;

public class UtilDTO {
	public AgenciaDTO agenciaDTOFromAgencia() {
		AgenciaDTO respuesta = new AgenciaDTO();
		respuesta.setCoincidencias(Agencia.getInstancia().getCoincidencias());
		respuesta.setEmpleadores(Agencia.getInstancia().getEmpleadores());
		respuesta.setEmpleados(Agencia.getInstancia().getEmpleados());
		respuesta.setFechaLista(Agencia.getInstancia().getFechaLista()); //ESTE NO SE PUEDE PERSISTIR ES GREGORIAN CALENDAR
		respuesta.setListasAsignaciones(Agencia.getInstancia().getListasAsignaciones());
		
		return respuesta;
	}
	
	public void agenciaFromAgenciaDTO(AgenciaDTO agenciaDTO) {
		Agencia agencia = Agencia.getInstancia();
		
		agencia.setCoincidencias(agenciaDTO.getCoincidencias());
		agencia.setEmpleadores(agenciaDTO.getEmpleadores());
		agencia.setEmpleados(agenciaDTO.getEmpleados());
		agencia.setFechaLista(agenciaDTO.getFechaLista()); //ESTE NO SE PUEDE PERSISTIR ES GREGORIAN CALENDAR
		agencia.setListasAsignaciones(agenciaDTO.getListasAsignaciones());
	}
}
