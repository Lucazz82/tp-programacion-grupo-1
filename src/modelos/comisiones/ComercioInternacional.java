package modelos.comisiones;

import enums.Rubros;
import modelos.ITipoPersona;

public class ComercioInternacional extends Rubro {

	public ComercioInternacional() {
		super(Rubros.COMERCIO_INTERNACIONAL);
	}

	public double enfrentar(ITipoPersona o) {
		return o.enfrentarComercioInternacional();
	}

}
