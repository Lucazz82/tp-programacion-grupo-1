package controladores;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
import modelos.Usuario;
import vista.AgenciaVista;

public class AgenciaController extends Controller {
	private AgenciaVista vista;
	
	public AgenciaController() {
		this.vista = new AgenciaVista();
		this.vista.setActionListener(this);
		this.setListaUsuarios();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Agencia agencia = null;
		try {
			agencia = Agencia.getInstancia();
		} catch (AgenciaInexistenteException e1) {}
		
		if(e.getActionCommand().equalsIgnoreCase("Cerrar Sesion")) {
			Sistema.getInstancia().cambiarController(new LoginController());
			this.vista.setVisible(false);
		} else if(e.getActionCommand().equalsIgnoreCase("Generar Listas de Asignacion")) {
			agencia.generarListasAsignacion();
			JOptionPane.showMessageDialog(vista, "Listas de asignacion generadas con exito");
		} else if(e.getActionCommand().equalsIgnoreCase("Ver Listas de Asignacion")) {
			
		} else if(e.getActionCommand().equalsIgnoreCase("Iniciar Ronda de Contratacion")) {
			agencia.rondaContratacion();
			JOptionPane.showMessageDialog(vista, "Ronda de contratacion generada con exito");
		} else if(e.getActionCommand().equalsIgnoreCase("Ver Coincidencias")) {
			Sistema.getInstancia().cambiarController(new CoincidenciasController());
			this.vista.setVisible(false);
		}
	}
	
	private void setListaUsuarios() {
		Agencia agencia = null;
		try {
			 agencia = Agencia.getInstancia();
		} catch (AgenciaInexistenteException e) {}
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(agencia.getEmpleadores());
		usuarios.addAll(agencia.getEmpleados());
		
		this.vista.setListaUsuarios(usuarios);
	}

}
