package modelos.comisiones;

import modelos.ITipoPersona;
import modelos.IRubro;

public class ComercioInternacional implements IRubro {

	@Override
	public double enfrentar(ITipoPersona o) {
		return o.enfrentarComercioInternacional();
	}

}
