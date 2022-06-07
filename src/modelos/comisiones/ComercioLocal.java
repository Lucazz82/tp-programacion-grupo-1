package modelos.comisiones;

import enums.Rubros;
import modelos.ITipoPersona;

public class ComercioLocal extends Rubro {

	public ComercioLocal() {
		super(Rubros.COMERCIO_LOCAL);
	}

	public double enfrentar(ITipoPersona o) {
		return o.enfrentarComercioLocal();
	}

}
