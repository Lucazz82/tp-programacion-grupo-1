package modelos.aspectos;

public class Remuneracion {
	private static double[][] pesos = { { 1, -0.5, -1 }, { 1, 1, -0.5 }, { 1, 1, 1 } };

	public static double enfrentar(int remuneracionRequerida, int remuneracionConseguida) {
		return pesos[remuneracionRequerida][remuneracionConseguida];
	}
}
