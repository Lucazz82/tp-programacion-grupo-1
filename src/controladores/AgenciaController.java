package controladores;

import java.util.Iterator;

import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.Logueable;
import modelos.Usuario;

public class AgenciaController {
	private Agencia agencia = Agencia.getInstancia();

	public void generaListasAsignacion() {
		agencia.generarListasAsignacion();
		agencia.calcularPuntajes();
	}
}
