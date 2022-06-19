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

public class PruebaSimulacion2 {

	public static void main(String[] args) {
//		Empleador e1 = new Empleador("Raul", "Rodriguez", new PersonaFisica(),
//				RubroFactory.getRubro(Rubros.COMERCIO_LOCAL));
//		Thread empleadorThread1 = new Thread(e1, "Raul");
//		Empleador e2 = new Empleador("Sergio", "Chupapija", new PersonaFisica(),
//				RubroFactory.getRubro(Rubros.COMERCIO_LOCAL));
//		Thread empleadorThread2 = new Thread(e1, "Sergio");
//		
		EmpleadoPretenso ep1 = new EmpleadoPretenso("Renzo", "GenioInformatico");
		
		// Coincide con 2 Rubros pero con 1 locacion
		Formulario f1 = FormularioFactory.getFormulario(Locaciones.CUALQUIERA, Remuneraciones.ENTRE_V1_V2, 500, 600,
				CargasHorarias.COMPLETA, PuestosLaborales.GERENCIAL, RangosEtarios.ENTRE_40_50, Experiencias.MUCHA,
				EstudiosPrevios.SECUNDARIO, Rubros.SALUD);
		
		UsuarioController uc = new UsuarioController();
		uc.agregarTicket(ep1, f1, PuestosLaborales.GERENCIAL);
		
//		Thread ep1Thread = new Thread(ep1, "Renzo");
		
//		empleadorThread1.start();
//		empleadorThread2.start();
//		ep1Thread.start();

	}

}
