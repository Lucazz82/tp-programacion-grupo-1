package modelos.aspectos;

import java.io.Serializable;

import enums.PuestosLaborales;
import modelos.Enfrentable;

public class PuestoLaboral implements Enfrentable<PuestoLaboral>, Serializable {
	private PuestosLaborales tipo;
	private int pos;

	public PuestoLaboral(PuestosLaborales tipo, int pos) {
		this.tipo = tipo;
		this.pos = pos;
	}

	private static double[][] pesos = { { 1, -0.5, -1 }, { -0.5, 1, -0.5 }, { -1, 1, -0, 5 } };

	public double enfrentar(PuestoLaboral o) {
		return pesos[this.pos][o.pos];
	}
	
	@Override
	public String toString() {
		return tipo.name();
	}

}
