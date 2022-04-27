package modelos.comisiones;

import enums.Rubros;
import modelos.Enfrentable;
import modelos.ITipoPersona;

public abstract class Rubro implements Enfrentable<ITipoPersona> {
	private Rubros rubro;

	public Rubro(Rubros rubro) {
		this.rubro = rubro;
	}

	public boolean mismoRubro(Rubro o) {
		return this.rubro == o.rubro;
	}
}
