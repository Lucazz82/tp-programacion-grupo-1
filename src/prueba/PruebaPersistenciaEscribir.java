package prueba;

import java.io.IOException;
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
import persistencia.AgenciaDTO;
import persistencia.PersistenciaBIN;
import persistencia.UtilDTO;

public class PruebaPersistenciaEscribir {
	public static void main(String[] args) throws TicketInexistenteException, IOException {
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
//		agencia.registrarUsuario(ep2);
//		agencia.registrarUsuario(ep3);
//		agencia.registrarUsuario(ep4);

		agencia.registrarUsuario(e1);
		agencia.registrarUsuario(e2);
		agencia.registrarUsuario(e3);

		// Cargar los tickets con sus formularios
		Formulario f1 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.ENTRE_V1_V2, 500, 600,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.ENTRE_40_50, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.SALUD);
		Formulario f2 = FormularioFactory.getFormulario(Locaciones.HOME_OFFICE, Remuneraciones.MAS_DE_V2, 50, 1000,
				CargasHorarias.MEDIA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.SALUD);
		Formulario f3 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.HASTA_V1, 500, 600,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.SALUD);

		double pesos1[] = { 1, 2, 4, 5, 6, 7, -5 };
		double pesos2[] = { 1, 8, 4, 5, 6, -1, 5 };

		UsuarioController usuarioControler = new UsuarioController();

		TicketBusquedaEmpleo t1 = usuarioControler.agregarTicket(ep1, f1, PuestosLaborales.GERENCIAL);

		TicketBusquedaEmpleado t2 = usuarioControler.agregarTicket(e1, f2, pesos1);
		TicketBusquedaEmpleado t3 = usuarioControler.agregarTicket(e2, f3, pesos2);

		agencia.generarListasAsignacion();

		ArrayList<Empleador> empleadores = agencia.getEmpleadores();

		for (int j = 0; j < empleadores.size(); j++) {
			Empleador empleador = empleadores.get(j);
			Iterator<TicketBusquedaEmpleado> iteradorTickets = empleador.getTickets();

			while (iteradorTickets.hasNext()) {
				TicketBusquedaEmpleado ticket = iteradorTickets.next();
				Iterator<TicketOrdenable> listaAsignacion = agencia.getListaAsignacion(ticket);
				while (listaAsignacion.hasNext()) {
					TicketOrdenable to = listaAsignacion.next();
					System.out.println(to);
					System.out.println("\n");
				}
			}

		}

		ep1.getTicket().setElegido(t2);
		t2.setElegido(t1);
		t3.setElegido(t1);

		agencia.rondaContratacion();

		AgenciaDTO agenciaDTO = UtilDTO.agenciaDTOFromAgencia();
		PersistenciaBIN<AgenciaDTO> persistencia = new PersistenciaBIN<>();
		persistencia.persistir("agencia.bin", agenciaDTO);
		System.out.println("Agencia guardada exitosamente.");
	}
}
