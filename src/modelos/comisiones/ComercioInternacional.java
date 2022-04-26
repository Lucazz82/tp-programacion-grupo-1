package modelos.comisiones;

import modelos.ITipoPersona;
import enums.Rubros;

public class ComercioInternacional extends Rubro {

	public ComercioInternacional() {
		super(Rubros.COMERCIO_INTERNACIONAL);
	}

	public double enfrentar(ITipoPersona o) {
		return o.enfrentarComercioInternacional();
	}

}
