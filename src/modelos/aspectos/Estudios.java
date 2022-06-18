package modelos.aspectos;

import java.io.Serializable;

import modelos.Enfrentable;

public class Estudios implements Enfrentable<Estudios>, Serializable {
	private int pos;

	public Estudios(int pos) {
		this.pos = pos;
	}

	private static double[][] pesos = { { 1, 1.5, 2 }, { -0.5, 1, 1.5 }, { -2, -1.5, 1 } };

	public double enfrentar(Estudios o) {
		return pesos[this.pos][o.pos];
	}

}
