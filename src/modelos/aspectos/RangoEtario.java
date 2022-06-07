package modelos.aspectos;

import java.io.Serializable;

import modelos.Enfrentable;

public class RangoEtario implements Enfrentable<RangoEtario>, Serializable {
	private int pos;

	public RangoEtario(int pos) {
		this.pos = pos;
	}

	private static double[][] pesos = { { 1, -0.5, -1 }, { -0.5, 1, -0.5 }, { -1, 1, -0, 5 } };

	public double enfrentar(RangoEtario o) {
		return pesos[this.pos][o.pos];
	}
}
