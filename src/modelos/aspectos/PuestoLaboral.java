package modelos.aspectos;

public class PuestoLaboral {
	private int pos;

	public PuestoLaboral(int pos) {
		this.pos = pos;
	}

	private static double[][] pesos = { { 1, -0.5, -1 }, { -0.5, 1, -0.5 }, { -1, 1, -0, 5 } };

	public double enfrentar(PuestoLaboral o) {
		return pesos[this.pos][o.pos];
	}

}
