package modelos.aspectos;

public class Estudios {
	private static double[][] pesos = { { 1, 1.5, 2 }, { -0.5, 1, 1.5 }, { -2, -1.5, 1 } };

	public static double enfrentar(int estudiosRequeridos, int estudiosConseguidos) {
		return pesos[estudiosRequeridos][estudiosConseguidos];
	}

}
