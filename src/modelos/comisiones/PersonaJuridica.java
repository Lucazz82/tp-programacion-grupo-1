package modelos.comisiones;

import java.io.Serializable;

import modelos.ITipoPersona;

public class PersonaJuridica implements ITipoPersona, Serializable {

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
