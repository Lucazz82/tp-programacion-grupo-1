package modelos.aspectos;

import java.io.Serializable;

import enums.RangosEtarios;
import modelos.Enfrentable;

public class RangoEtario implements Enfrentable<RangoEtario>, Serializable {
	private RangosEtarios tipo;
	private int pos;

	public RangoEtario(RangosEtarios tipo, int pos) {
		this.tipo = tipo;
		this.pos = pos;
	}

	private static double[][] pesos = { { 1, -0.5, -1 }, { -0.5, 1, -0.5 }, { -1, 1, -0, 5 } };

	public double enfrentar(RangoEtario o) {
		return pesos[this.pos][o.pos];
	}

	@Override
	public String toString() {
		return tipo.name();
	}
}
