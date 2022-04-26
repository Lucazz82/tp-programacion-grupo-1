package modelos.comisiones;

import modelos.ITipoPersona;
import modelos.IRubro;

public class Salud implements IRubro {

	@Override
	public double enfrentar(ITipoPersona o) {
		return o.enfrentarSalud();
	}

}
