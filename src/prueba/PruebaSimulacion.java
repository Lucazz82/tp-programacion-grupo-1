package prueba;

import controladores.UsuarioController;
import enums.CargasHorarias;
import enums.EstudiosPrevios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.Formulario;
import modelos.FormularioFactory;
import modelos.aspectos.factories.RubroFactory;
import modelos.comisiones.PersonaFisica;

public class PruebaSimulacion {
	public static void main(String args[]) {
		Empleador e1 = new Empleador("Raul", "Rodriguez", new PersonaFisica(),
				RubroFactory.getRubro(Rubros.COMERCIO_LOCAL));
		Thread empleadorThread1 = new Thread(e1, "Raul");
		Empleador e2 = new Empleador("Sergio", "Chupapija", new PersonaFisica(),
				RubroFactory.getRubro(Rubros.COMERCIO_LOCAL));
		Thread empleadorThread2 = new Thread(e1, "Sergio");
		
		EmpleadoPretenso ep1 = new EmpleadoPretenso("Renzo", "GenioInformatico");
		EmpleadoPretenso ep2 = new EmpleadoPretenso("Teo", "Ramos");
		EmpleadoPretenso ep3 = new EmpleadoPretenso("lucas", "d leis");
		
		// No coincide nada
		Formulario f1 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.ENTRE_V1_V2, 500, 600,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.ENTRE_40_50, Experiencias.MUCHA,
				EstudiosPrevios.SECUNDARIO, Rubros.SALUD);
		
		// Coincide todo
		Formulario f2 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.MAS_DE_V2, 50, 1000,
				CargasHorarias.MEDIA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.COMERCIO_INTERNACIONAL);
		
		// Coincide rubro
		Formulario f3 = FormularioFactory.getFormulario(Locaciones.PRESENCIAL, Remuneraciones.MAS_DE_V2, 50, 1000,
				CargasHorarias.MEDIA, PuestosLaborales.JUNIOR, RangosEtarios.MENOS_DE_40, Experiencias.MUCHA,
				EstudiosPrevios.PRIMARIO, Rubros.COMERCIO_INTERNACIONAL);
		
		UsuarioController uc = new UsuarioController();
		uc.agregarTicket(ep1, f1, PuestosLaborales.GERENCIAL);
		uc.agregarTicket(ep2, f2, PuestosLaborales.JUNIOR);
		uc.agregarTicket(ep3, f3, PuestosLaborales.SENIOR);
		
//		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.CUALQUIERA, Rubros.COMERCIO_INTERNACIONAL));
//		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.HOME_OFFICE, Rubros.COMERCIO_LOCAL));
//		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.PRESENCIAL, Rubros.COMERCIO_INTERNACIONAL));
		
		Thread ep1Thread = new Thread(ep1, "Renzo");
		Thread ep2Thread = new Thread(ep2, "Teo");
		Thread ep3Thread = new Thread(ep3, "Lucas");
		
		empleadorThread1.start();
		empleadorThread2.start();
		ep1Thread.start();
		ep2Thread.start();
		ep3Thread.start();
	}
}
