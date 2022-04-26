package modelos.aspectos;

public class PuestoLaboral {

	private static double[][] pesos = { { 1, -0.5, -1 }, { -0.5, 1, -0.5 }, { -1, 1, -0, 5 } };

	public static double enfrentar(int puestoRequerido, int puestoConseguido) {
		return pesos[puestoRequerido][puestoConseguido];
	}
}
