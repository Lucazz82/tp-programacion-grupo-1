package modelos;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.UsuarioInexistenteException;

public class Agencia {
	private static Agencia _instancia=null;
	private ArrayList<EmpleadoPretenso> empleados = new ArrayList<EmpleadoPretenso>();
	private ArrayList<TicketEmpleo> busquedasEmpleo = new ArrayList<TicketEmpleo>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private ArrayList<TicketEmpleado> busquedasEmpleado = new ArrayList<TicketEmpleado>();
	
	private Agencia() {
		
	}
	
	public static Agencia getInstancia() {
		if (_instancia == null)
			_instancia=new Agencia();
		return _instancia;
	}
	
//	public Usuario buscarUsuario(String nombreUsuario) throws UsuarioInexistenteException {
//		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) empleados.clone();
//		usuarios.addAll(empleadores);
//		
//		int i = 0;		
//		Usuario usuario = usuarios.get(i);
//		while(i < usuarios.size() && usuario.getnombreUsuario().equals(nombreUsuario)) {
//			i++;
//			usuario = usuarios.get(i);
//		}
//		
//		if(i < usuarios.size()) {			
//			return usuario;
//		} else {
//			throw new UsuarioInexistenteException(nombreUsuario + " no existe");
//		}
//	}
	
	public Usuario buscarUsuario(String nombreUsuario) throws UsuarioInexistenteException {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) empleados.clone();
		usuarios.addAll(empleadores);
		
		for(Usuario usuario : usuarios) {
			if(usuario.getnombreUsuario().equals(nombreUsuario)) {
				return usuario;
			}
		}
		
		throw new UsuarioInexistenteException(nombreUsuario + " no existe");
	}

	public Iterator<EmpleadoPretenso> getEmpleados() {
		return empleados.iterator();
	}

	public Iterator<TicketEmpleo> getBusquedasEmpleo() {
		return busquedasEmpleo.iterator();
	}

	public Iterator<Empleador> getEmpleadores() {
		return empleadores.iterator();
	}

	public Iterator<TicketEmpleado> getBusquedasEmpleado() {
		return busquedasEmpleado.iterator();
	}
	
	
}
