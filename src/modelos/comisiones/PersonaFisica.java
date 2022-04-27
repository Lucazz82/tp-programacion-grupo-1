package modelos.comisiones;

import modelos.ITipoPersona;

public class PersonaFisica implements ITipoPersona {

	@Override
	public double enfrentarSalud() {
		return 0.6;
	}

	@Override
	public double enfrentarComercioLocal() {
		return 0.7;
	}

	@Override
	public double enfrentarComercioInternacional() {
		return 0.8;
	}

}