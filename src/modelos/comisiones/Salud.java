package modelos.comisiones;

import modelos.ITipoPersona;
import enums.Rubros;

public class Salud extends Rubro {

	public Salud() {
		super(Rubros.SALUD);
	}

	public double enfrentar(ITipoPersona o) {
		return o.enfrentarSalud();
	}

}
