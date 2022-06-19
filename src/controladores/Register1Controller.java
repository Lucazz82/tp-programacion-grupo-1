package controladores;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import excepciones.AgenciaYaExistenteException;
import modelos.Agencia;
import vista.Register1;

public class Register1Controller implements IController {
	private Register1 vista;

	public Register1Controller() {
		this.vista = new Register1();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Siguente")) {
			if(!vista.getUsuario().isBlank() && !vista.getContrasenia().isBlank()) {
				IController controller = null;
				
				switch (vista.getTipoUsuario()) {
				case AGENCIA:
					this.registrarAgencia();
					controller = new LoginController();
					break;
				case EMPLEADO:
					controller = new Register2EmpleadoController();
					
					break;
				case EMPLEADOR:
					controller = new Register2EmpleadorController();
					break;
				default:
					break;
				}		
				
				Sistema.getInstancia().cambiarController(controller);
				vista.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(vista, "Complete los campos");
			}
		} else if(e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new LoginController());
			vista.setVisible(false);
		}

	}

	private void registrarAgencia() {
		try {
			Agencia.registrarAgencia(vista.getUsuario(), vista.getContrasenia());
			JOptionPane.showMessageDialog(vista, "Agencia registrada con exito");	
		} catch (AgenciaYaExistenteException e) {
			JOptionPane.showMessageDialog(vista, "Ya existe una agencia");
		}		
	}
}
