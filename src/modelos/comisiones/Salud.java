package modelos.comisiones;

import enums.Rubros;
import modelos.ITipoPersona;

public class Salud extends Rubro {

	public Salud() {
		super(Rubros.SALUD);
	}

	public double enfrentar(ITipoPersona o) {
		return o.enfrentarSalud();
	}

	@Override
	public String toString() {
		return "Salud";
	}
}
