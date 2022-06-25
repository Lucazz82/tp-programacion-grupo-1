package controladores;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

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
		if(e.getActionCommand().equalsIgnoreCase("Siguiente")) {
			EmpleadoPretenso empleado = new EmpleadoPretenso(usuario, contrasenia, this.vista.getNombre(), this.vista.getApellido(), this.vista.getTelefono(), new Date(this.vista.getFecha()));
			
			try {
				Agencia.getInstancia().registrarUsuario(empleado);
			} catch (AgenciaInexistenteException e1) {}
			
			JOptionPane.showMessageDialog(vista, "Usuario registrado con exito");
			Sistema.getInstancia().cambiarController(new TicketEmpleadoController(empleado));
			this.vista.setVisible(false);
		} else if(e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new Register1Controller());
			this.vista.setVisible(false);
		}
	}

}
