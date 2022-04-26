package modelos.comisiones;

import modelos.ITipoPersona;

public class PersonaJuridica implements ITipoPersona {

	@Override
	public double enfrentarSalud() {
		return 0.8;
	}

	@Override
	public double enfrentarComercioLocal() {
		return 0.9;
	}

	@Override
	public double enfrentarComercioInternacional() {
		return 1.0;
	}

}
