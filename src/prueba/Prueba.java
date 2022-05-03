package prueba;

import java.util.Iterator;

import enums.CargasHorarias;
import enums.EstudiosPrevios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;
import excepciones.TicketInexistenteException;
import modelos.Agencia;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.Formulario;
import modelos.FormularioFactory;
import modelos.Ticket;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;
import modelos.TicketOrdenable;
import modelos.aspectos.factories.RubroFactory;
import modelos.comisiones.PersonaFisica;
import modelos.comisiones.PersonaJuridica;

public class Prueba {

	public static void main(String[] args) throws TicketInexistenteException {
//		Agencia agencia = Agencia.getInstancia();
//		FormularioFactory fabrica = new FormularioFactory();
//
//		double pesos1[] = { 1, 2, 4, 5, 6, 7, -5 };
//		double pesos2[] = { 1, 8, 4, 5, 6, -1, 5 };
//
//		EmpleadoPretenso empleado1 = new EmpleadoPretenso("Teo", "Puto");
////		Usuario u2 = new Empleador("Lucas", "Peron");
//		Logueable empleado2 = new EmpleadoPretenso("Cami", "nazi");
//		Logueable empleado3 = new EmpleadoPretenso("Raul", "Dametteis");
//		Empleador empleador1 = new Empleador("Franco", "Demaio", "Matias", "Fisica", Rubros.COMERCIO_INTERNACIONAL);
//		Empleador empleador2 = new Empleador("Lucas", "DeLellis", "Lucas", "Juridica", Rubros.SALUD);
//
//		Formulario f1 = fabrica.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.ENTRE_V1_V2, 500, 600,
//				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.ENTRE_40_50, Experiencias.MUCHA,
//				EstudiosPrevios.PRIMARIO, Rubros.SALUD);
//		Formulario f2 = fabrica.getFormulario(Locaciones.HOME_OFFICE, Remuneraciones.MAS_DE_V2, 50, 1000,
//				CargasHorarias.MEDIA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
//				EstudiosPrevios.PRIMARIO, Rubros.SALUD);
//		Formulario f3 = fabrica.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.HASTA_V1, 500, 600,
//				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
//				EstudiosPrevios.PRIMARIO, Rubros.SALUD);
//
//		Ticket t1 = new TicketBusquedaEmpleo(empleado1, f1);
//		Ticket t2 = new TicketBusquedaEmpleado(empleador2, f2, pesos1);
//		Ticket t3 = new TicketBusquedaEmpleado(empleador1, f3, pesos2);
//
//		empleado1.setTicket((TicketBusquedaEmpleo) t1);
//		empleador1.agregarTicket((TicketBusquedaEmpleado) t3);
//		empleador2.agregarTicket((TicketBusquedaEmpleado) t2);
//
//		agencia.agregarEmpleado(empleado1);
////		agencia.agregarEmpleado((EmpleadoPretenso) u2);
////		agencia.agregarEmpleado((EmpleadoPretenso) u3);
//		agencia.agregarEmpleador(empleador1);
//		agencia.agregarEmpleador(empleador2);
//
//		agencia.generarListaAsignacion();
//		Iterator<TicketOrdenable> iterador = agencia.getListaAsignacion((TicketBusquedaEmpleo) t1);
//
//		while (iterador.hasNext()) {
//			System.out.println(iterador.next());
//		}

		Agencia agencia = Agencia.getInstancia();

		// Registrar usuarios
		
		EmpleadoPretenso ep1 = new EmpleadoPretenso("Renzo", "GenioInformatico");
		EmpleadoPretenso ep2 = new EmpleadoPretenso("Teo", "Puto");
		EmpleadoPretenso ep3 = new EmpleadoPretenso("Cami", "nazi");
		EmpleadoPretenso ep4 = new EmpleadoPretenso("Raul", "Dametteis");

		Empleador e1 = new Empleador("Lucas", "Peron", new PersonaFisica(),
				RubroFactory.getRubro(Rubros.COMECIO_LOCAL));
		Empleador e2 = new Empleador("Franco", "Demaio", "Matias", new PersonaJuridica(),
				RubroFactory.getRubro(Rubros.COMERCIO_INTERNACIONAL));
		Empleador e3 = new Empleador("Lucas", "DeLellis", "Lucas", new PersonaJuridica(),
				RubroFactory.getRubro(Rubros.SALUD));
		
		agencia.registrarUsuario(ep1);
		agencia.registrarUsuario(ep2);
		agencia.registrarUsuario(ep3);
		agencia.registrarUsuario(ep4);
		
		agencia.registrarUsuario(e1);
		agencia.registrarUsuario(e2);
		agencia.registrarUsuario(e3);

		// Cargar los tickets con sus formularios
		Formulario f1 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.ENTRE_V1_V2, 500, 600,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.ENTRE_40_50, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.SALUD, ep1);
		Formulario f2 = FormularioFactory.getFormulario(Locaciones.HOME_OFFICE, Remuneraciones.MAS_DE_V2, 50, 1000,
				CargasHorarias.MEDIA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.SALUD, ep2);
		Formulario f3 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.HASTA_V1, 500, 600,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.SALUD, ep3);
		
		double pesos1[] = { 1, 2, 4, 5, 6, 7, -5 };
		double pesos2[] = { 1, 8, 4, 5, 6, -1, 5 };
		
		TicketBusquedaEmpleo t1 = new TicketBusquedaEmpleo(ep1, f1);
		ep1.setTicket(t1);
		TicketBusquedaEmpleado t2 = new TicketBusquedaEmpleado(e1, f2, pesos1);
		e1.agregarTicket(t2);
		TicketBusquedaEmpleado t3 = new TicketBusquedaEmpleado(e2, f3, pesos2);
		e2.agregarTicket(t3);
		
		// Ronda de encuentros laborales
		agencia.generarListasAsignacion();
		
		Iterator<Empleador> iteradorEmpleadores = agencia.getEmpleadores();
		
		while(iteradorEmpleadores.hasNext()) {
			Empleador empleador = iteradorEmpleadores.next();
			Iterator<TicketBusquedaEmpleado> iteradorTickets = empleador.getTickets();
			
			while(iteradorTickets.hasNext()) {
				TicketBusquedaEmpleado ticket = iteradorTickets.next();
				Iterator<TicketOrdenable> listaAsignacion = agencia.getListaAsignacion(ticket);
				System.out.println(listaAsignacion);
			}
			
		}
	}

}
