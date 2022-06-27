package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import modelos.BolsaDeTrabajo;
import modelos.Coincidencia;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;

public class AgenciaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<EmpleadoPretenso> empleados = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones = new HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>>();
	private ArrayList<Coincidencia> coincidencias = new ArrayList<Coincidencia>();
	
	private String usuario;
	private String contrasenia;
	
	private BolsaDeTrabajo bolsaDeTrabajo;

	public AgenciaDTO() {
	}

	public AgenciaDTO(ArrayList<EmpleadoPretenso> empleados, ArrayList<Empleador> empleadores,
			HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones,
			ArrayList<Coincidencia> coincidencias, String usuario, String contrasenia, BolsaDeTrabajo bolsaDeTrabajo) {
		super();
		this.empleados = empleados;
		this.empleadores = empleadores;
		this.listasAsignaciones = listasAsignaciones;
		this.coincidencias = coincidencias;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.bolsaDeTrabajo = bolsaDeTrabajo;
	}

	public BolsaDeTrabajo getBolsaDeTrabajo() {
		return bolsaDeTrabajo;
	}
	
	
	public void setBolsaDeTrabajo(BolsaDeTrabajo bolsaDeTrabajo) {
		this.bolsaDeTrabajo = bolsaDeTrabajo;
	}


	public ArrayList<EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<EmpleadoPretenso> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(ArrayList<Empleador> empleadores) {
		this.empleadores = empleadores;
	}

	public HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> getListasAsignaciones() {
		return listasAsignaciones;
	}

	public void setListasAsignaciones(
			HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones) {
		this.listasAsignaciones = listasAsignaciones;
	}

	public ArrayList<Coincidencia> getCoincidencias() {
		return coincidencias;
	}

	public void setCoincidencias(ArrayList<Coincidencia> coincidencias) {
		this.coincidencias = coincidencias;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
}
