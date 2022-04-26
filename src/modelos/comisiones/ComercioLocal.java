package modelos.comisiones;

import modelos.ITipoPersona;
import enums.Rubros;

public class ComercioLocal extends Rubro {

	public ComercioLocal() {
		super(Rubros.COMECIO_LOCAL);
	}

	public double enfrentar(ITipoPersona o) {
		return o.enfrentarComercioLocal();
	}

}
