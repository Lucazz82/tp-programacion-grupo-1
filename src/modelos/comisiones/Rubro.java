package modelos.comisiones;

import enums.Rubros;
import modelos.ITipoPersona;

public abstract class Rubro {
	private Rubros rubro;

	public Rubro(Rubros rubro) {
		this.rubro = rubro;
	}

	public boolean mismoRubro(Rubro o) {
		return this.rubro == o.rubro;
	}
	
	public abstract double enfrentar(ITipoPersona o);
}
