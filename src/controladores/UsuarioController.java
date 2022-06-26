package controladores;

import enums.PuestosLaborales;
import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.Formulario;
import modelos.IComision;
import modelos.Logueable;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;
import modelos.aspectos.factories.PuestoLaboralFactory;

public class UsuarioController {
//	public void login(String nombreUsuario, String contrasena) {
//		Agencia agencia = Agencia.getInstancia();
//		try {
//			Logueable usuario = agencia.buscarUsuario(nombreUsuario);
//			usuario.login(contrasena);
//		} catch (UsuarioInexistenteException e) {
//
//		} catch (ContrasenaIncorrectaException e) {
//
//		}
//	}
//
//	public void registrarEmpleado(String nombreUsuario, String contrasena) {
//		Agencia.getInstancia().registrarUsuario(new EmpleadoPretenso(nombreUsuario, contrasena));
//	}
//
//	public TicketBusquedaEmpleado agregarTicket(Empleador creador, Formulario formulario, double[] pesos) {
//		TicketBusquedaEmpleado ticket = new TicketBusquedaEmpleado(creador, formulario, pesos);
//		creador.agregarTicket(ticket);
//		return ticket;
//	}
//
//	public TicketBusquedaEmpleo agregarTicket(EmpleadoPretenso creador, Formulario formulario,
//			PuestosLaborales puesto) {
//		IComision comision = PuestoLaboralFactory.getPuestoLaboral(puesto, creador);
//		TicketBusquedaEmpleo ticket = new TicketBusquedaEmpleo(creador, formulario, comision);
//		creador.setTicket(ticket);
//		return ticket;
//	}
}
