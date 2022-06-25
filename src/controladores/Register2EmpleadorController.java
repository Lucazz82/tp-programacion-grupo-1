package controladores;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
import modelos.Empleador;
import modelos.ITipoPersona;
import modelos.aspectos.factories.RubroFactory;
import modelos.comisiones.ComercioInternacional;
import modelos.comisiones.ComercioLocal;
import modelos.comisiones.PersonaFisica;
import modelos.comisiones.PersonaJuridica;
import modelos.comisiones.Rubro;
import vista.Register2Empleador;

public class Register2EmpleadorController extends Controller {
	private Register2Empleador vista;
	private String nombreUsuario;
	private String contrasenia;

	public Register2EmpleadorController(String nombreUsuario, String contrasenia) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.vista = new Register2Empleador();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Siguente")) {
			if (!nombreUsuario.isBlank() && !contrasenia.isBlank()) {
				try {
					Agencia agencia = Agencia.getInstancia();
					
					Rubro rubro = RubroFactory.getRubro(vista.getRubro());
					
					ITipoPersona tipoPersona = null;

					switch (vista.getTipoPersona()) {
					case FISICA:
						tipoPersona = new PersonaFisica();
						break;
					case JURIDICA:
						tipoPersona = new PersonaJuridica();
						break;
					default:
						break;
					}
					
					agencia.registrarUsuario(new Empleador(nombreUsuario, contrasenia, tipoPersona, rubro));
					Sistema.getInstancia().cambiarController(new EmpleadorController());
					vista.setVisible(false);
				} catch (AgenciaInexistenteException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(vista, "Complete los campos");
			}
		} else if (e.getActionCommand().equalsIgnoreCase("Volver")){
			Sistema.getInstancia().cambiarController(new Register1Controller());
			vista.setVisible(false);
		}
	}

}
