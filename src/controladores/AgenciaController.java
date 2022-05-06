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
	
	public Logueable buscarUsuario(String nombreUsuario) throws UsuarioInexistenteException {
		Iterator<EmpleadoPretenso> empleados = agencia.getEmpleados();
		Logueable usuario = null;
		
		while(usuario == null && empleados.hasNext()) {
			Usuario empleado = empleados.next();
			if (empleado.getnombreUsuario().equals(nombreUsuario)) {
				usuario = empleado;
			}
		}
		
		Iterator<Empleador> empleadores = agencia.getEmpleadores();
		
		while(usuario == null && empleadores.hasNext()) {
			Usuario empleador = empleados.next();
			if (empleador.getnombreUsuario().equals(nombreUsuario)) {
				usuario = empleador;
			}
		}

		if(usuario == null) {
			throw new UsuarioInexistenteException(nombreUsuario + " no existe");
		}
		
		return usuario;
	}
}
