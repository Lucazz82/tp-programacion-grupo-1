package controladores;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;

import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
import modelos.EmpleadoPretenso;
import vista.Register2Empleado;

public class Register2EmpleadoController extends Controller {
	private Register2Empleado vista;
	private String usuario;
	private String contrasenia;

	public Register2EmpleadoController(String usuario, String contrasenia) {
		this.vista = new Register2Empleado();
		vista.setActionListener(this);
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Siguente")) {
			EmpleadoPretenso empleado = new EmpleadoPretenso(usuario, contrasenia, this.vista.getNombre(), this.vista.getApellido(), this.vista.getTelefono(), new Date(this.vista.getFecha()));
			
			try {
				Agencia.getInstancia().registrarUsuario(empleado);
			} catch (AgenciaInexistenteException e1) {}
			
			Sistema.getInstancia().cambiarController(new TicketEmpleadoController());
			
		} else if(e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new Register1Controller());
			this.vista.setVisible(false);
		}
	}

}
