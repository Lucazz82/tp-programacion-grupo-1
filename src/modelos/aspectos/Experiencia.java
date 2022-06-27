package modelos.aspectos;

import java.io.Serializable;

import enums.Experiencias;
import modelos.Enfrentable;

public class Experiencia implements Enfrentable<Experiencia>, Serializable {
	private Experiencias experiencia;
	private int pos;

	public Experiencia(Experiencias experiencia, int pos) {
		this.experiencia = experiencia;
		this.pos = pos;
	}

	private static double[][] pesos = { { 1, 1.5, 2 }, { -0.5, 1, 1.5 }, { -2, -1.5, 1 } };

	public double enfrentar(Experiencia o) {
		return pesos[this.pos][o.pos];
	}

	@Override
	public String toString() {
		return experiencia.toString();
	}
}
