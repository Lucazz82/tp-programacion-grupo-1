package modelos.aspectos;

import java.io.Serializable;

import enums.EstudiosPrevios;
import modelos.Enfrentable;

public class Estudios implements Enfrentable<Estudios>, Serializable {
	private EstudiosPrevios estudios;
	private int pos;

	public Estudios(EstudiosPrevios estudios, int pos) {
		this.estudios = estudios;
		this.pos = pos;
	}

	private static double[][] pesos = { { 1, 1.5, 2 }, { -0.5, 1, 1.5 }, { -2, -1.5, 1 } };

	public double enfrentar(Estudios o) {
		return pesos[this.pos][o.pos];
	}
	
	@Override
	public String toString() {
		return this.estudios.toString();
	}
}
