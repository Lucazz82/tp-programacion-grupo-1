package modelos.aspectos;

import java.io.Serializable;

import modelos.Enfrentable;

public class Remuneracion implements Enfrentable<Remuneracion>, Serializable {
	private int pos;
	private double V1;
	private double V2;

	public Remuneracion(int pos, double v1, double v2) {
		this.pos = pos;
		this.V1 = v1;
		this.V2 = v2;
	}

	private static double[][] pesos = { { 1, -0.5, -1 }, { 1, 1, -0.5 }, { 1, 1, 1 } };

	/**
	 * <b>Pre:</b> o no es null y pos esta entre 0 y 2. Recibe otra remuneracion por
	 * parametro y devuelve el costo correspondiente a enfrentarlos.
	 * 
	 * @param o elemento a enfrentar.
	 */
	public double enfrentar(Remuneracion o) {
		return pesos[this.pos][o.pos];
	}

	public double getSueldoPretendido() {
		double sueldoPretendido = 0;

		switch (this.pos) {
		case 0:
			sueldoPretendido = this.V1;
			break;
		case 1:
			sueldoPretendido = (this.V2 + this.V1) / 2;
			break;
		case 2:
			sueldoPretendido = this.V2;
			break;
		}

		return sueldoPretendido;
	}
}
