package prueba;

import java.util.Iterator;

import enums.CargasHorarias;
import enums.Estudios;
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
import modelos.Usuario;
import modelos.UsuarioOrdenable;

public class Prueba {

	public static void main(String[] args) throws TicketInexistenteException {
		Agencia agencia = Agencia.getInstancia();
		FormularioFactory fabrica = new FormularioFactory();
		
		double pesos1[]= {1,2,4,5,6,7,-5};
		double pesos2[]= {1,8,4,5,6,-1,5};
		

		EmpleadoPretenso u1 = new EmpleadoPretenso("Teo", "Puto");
//		Usuario u2 = new Empleador("Lucas", "Peron");
		Usuario u2 = new EmpleadoPretenso("Cami", "nazi");
		Usuario u3 = new EmpleadoPretenso("Raul", "Dametteis");
		Empleador u4 = new Empleador("Franco", "Demaio", "Matias", "Fisica", Rubros.COMERCIO_INTERNACIONAL);
		Empleador u5 = new Empleador("Lucas", "DeLellis", "Lucas", "Juridica", Rubros.SALUD);
		
		Formulario f1 = fabrica.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.ENTRE_V1_V2, 500, 600, CargasHorarias.COMPLETA,
				PuestosLaborales.SEMI_SENIOR, RangosEtarios.ENTRE_40_50, Experiencias.MUCHA, Estudios.PRIMARIO,
				Rubros.SALUD);
		Formulario f2= fabrica.getFormulario(Locaciones.HOME_OFFICE, Remuneraciones.MAS_DE_V2, 50, 1000, CargasHorarias.MEDIA,
				PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA, Estudios.PRIMARIO,
				Rubros.SALUD);
		Formulario f3 = fabrica.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.HASTA_V1, 500, 600, CargasHorarias.COMPLETA,
				PuestosLaborales.SEMI_SENIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA, Estudios.PRIMARIO,
				Rubros.SALUD);
		
		Ticket t1 = new TicketBusquedaEmpleo(u1, f1);
		Ticket t2 = new TicketBusquedaEmpleado(u5,f2,pesos1);
		Ticket t3 = new TicketBusquedaEmpleado(u4,f3,pesos2);
		
		u1.setTicket((TicketBusquedaEmpleo)t1);
		u4.agregarTicket((TicketBusquedaEmpleado) t3);
		u5.agregarTicket((TicketBusquedaEmpleado) t2);
		

		agencia.generarListaAsignacion();
		Iterator<UsuarioOrdenable> iterador=agencia.getListaAsignacion((TicketBusquedaEmpleo)t1);
		
		while (iterador.hasNext()) {
			System.out.println(iterador.next());
		}
	}

}
