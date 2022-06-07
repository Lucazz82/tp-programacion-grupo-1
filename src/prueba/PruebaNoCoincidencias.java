package prueba;

import java.util.ArrayList;
import java.util.Iterator;

import controladores.UsuarioController;
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
import modelos.Coincidencia;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.Formulario;
import modelos.FormularioFactory;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;
import modelos.TicketOrdenable;
import modelos.aspectos.factories.RubroFactory;
import modelos.comisiones.PersonaFisica;
import modelos.comisiones.PersonaJuridica;

public class PruebaNoCoincidencias {

	public static void main(String[] args) throws TicketInexistenteException {
		// TODO Auto-generated method stub
		Agencia agencia = Agencia.getInstancia();

		// Registrar usuarios

		EmpleadoPretenso ep1 = new EmpleadoPretenso("Renzo", "GenioInformatico");
		EmpleadoPretenso ep2 = new EmpleadoPretenso("Teo", "Ramos");
		EmpleadoPretenso ep3 = new EmpleadoPretenso("Cami", "Cacace");
		EmpleadoPretenso ep4 = new EmpleadoPretenso("Guille", "Profe!");

		Empleador e1 = new Empleador("Raul", "Rodriguez", new PersonaFisica(),
				RubroFactory.getRubro(Rubros.COMERCIO_LOCAL));
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
				EstudiosPrevios.SECUNDARIO, Rubros.SALUD);
		Formulario f2 = FormularioFactory.getFormulario(Locaciones.HOME_OFFICE, Remuneraciones.MAS_DE_V2, 50, 1000,
				CargasHorarias.MEDIA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.COMERCIO_INTERNACIONAL);
		Formulario f3 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.HASTA_V1, 700, 800,
				CargasHorarias.COMPLETA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.COMERCIO_INTERNACIONAL);
		Formulario f4 = FormularioFactory.getFormulario(Locaciones.PRESENCIAL, Remuneraciones.HASTA_V1, 450, 900,
				CargasHorarias.COMPLETA, PuestosLaborales.SENIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.TERCIARIO, Rubros.COMERCIO_LOCAL);
		Formulario f5 = FormularioFactory.getFormulario(Locaciones.HOME_OFFICE, Remuneraciones.HASTA_V1, 100, 1000,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.SECUNDARIO, Rubros.COMERCIO_INTERNACIONAL);
		Formulario f6 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.ENTRE_V1_V2, 535, 570,
				CargasHorarias.COMPLETA, PuestosLaborales.SENIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.TERCIARIO, Rubros.COMERCIO_LOCAL);
		Formulario f7 = FormularioFactory.getFormulario(Locaciones.PRESENCIAL, Remuneraciones.MAS_DE_V2, 375, 600,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.SALUD);
		Formulario f8 = FormularioFactory.getFormulario(Locaciones.HOME_OFFICE, Remuneraciones.HASTA_V1, 670, 1000,
				CargasHorarias.COMPLETA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.NADA,
				EstudiosPrevios.PRIMARIO, Rubros.COMERCIO_INTERNACIONAL);

		double pesos1[] = { 1, 2, 4, 5, 6, 7, -5 };
		double pesos2[] = { 1, 8, 4, 5, 6, -1, 5 };
		double pesos3[] = { 5, 6, 6, 1000, -50, 3, 1 };
		double pesos4[] = { 75, 16, 6, 50, -50, 3, 11 };

		UsuarioController usuarioControler = new UsuarioController();

		TicketBusquedaEmpleo t1 = usuarioControler.agregarTicket(ep1, f1, PuestosLaborales.GERENCIAL);
		TicketBusquedaEmpleo t2 = usuarioControler.agregarTicket(ep2, f2, PuestosLaborales.JUNIOR);
		TicketBusquedaEmpleo t3 = usuarioControler.agregarTicket(ep3, f3, PuestosLaborales.JUNIOR);
		TicketBusquedaEmpleo t4 = usuarioControler.agregarTicket(ep4, f4, PuestosLaborales.SENIOR);

		TicketBusquedaEmpleado t5 = usuarioControler.agregarTicket(e1, f5, pesos1);
		TicketBusquedaEmpleado tigual = usuarioControler.agregarTicket(e1, f5, pesos1);
		TicketBusquedaEmpleado t6 = usuarioControler.agregarTicket(e2, f6, pesos2);
		TicketBusquedaEmpleado t7 = usuarioControler.agregarTicket(e3, f7, pesos3);
		TicketBusquedaEmpleado t8 = usuarioControler.agregarTicket(e3, f8, pesos4);

		// muestro empleadores con sus respectivas listas de asignacion

		agencia.generarListasAsignacion();

		System.out.println("\n \n \n LISTAS DE ASIGNACION: \n \n");
		ArrayList<Empleador> empleadores = agencia.getEmpleadores();

		for (int j = 0 ; j < empleadores.size() ; j++) {
			Empleador empleador = empleadores.get(j);
			Iterator<TicketBusquedaEmpleado> iteradorTickets = empleador.getTickets();

			while (iteradorTickets.hasNext()) {
				System.out.println("\n");
				System.out.println(empleador);
				TicketBusquedaEmpleado ticket = iteradorTickets.next();
				Iterator<TicketOrdenable> listaAsignacion = agencia.getListaAsignacion(ticket);
				while (listaAsignacion.hasNext()) {
					TicketOrdenable to = listaAsignacion.next();
					System.out.println(to);
				}
			}

		}

		// hora de elegir para cada empleado pretenso su eleccion
		ep1.getTicket().setElegido(t7);
		t7.setElegido(t1);
		ep2.getTicket().setElegido(t6);
		t6.setElegido(t2);
		ep3.getTicket().setElegido(t8);
		t8.setElegido(t3);
		ep4.getTicket().setElegido(t5);
		t5.setElegido(t4);

		System.out.println("\n \n \n RONDA DE CONTRATACIONES: \n \n");

		agencia.rondaContratacion();

		ArrayList<Coincidencia> coincidencias = agencia.getCoincidencias();
		for (int i = 0 ; i < coincidencias.size() ; i++) {
			Coincidencia c = coincidencias.get(i);
//				System.out.println(c.getComisionEmpleado());
//				System.out.println(c.getComisionEmpleador());
//				System.out.println(c.getTicketEmpleado());
//				System.out.println(c.getTicketEmpleador());
			System.out.println("Coincidencia " + (i + 1));
			System.out.println(c.getTicketEmpleado().getCreador());
			System.out.println(c.getTicketEmpleador().getCreador());
			System.out.println("\n");
		}
	}

}
