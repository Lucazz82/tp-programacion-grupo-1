package controladores;

import modelos.Agencia;

public class AgenciaController {
	private Agencia agencia = Agencia.getInstancia();

	public void generaListasAsignacion() {
		agencia.generarListaAsignacion();
		agencia.calcularPuntajes();
	}
}
