package modelos.aspectos;

public class RangoEtario {

	private static double[][] pesos = {{1, -0.5, -1}, {-0.5, 1, -0.5}, {-1, 1, -0,5}};
	
	public static double enfrentar(int rangoRequerido, int rangoConseguido) {
		return pesos[rangoRequerido][rangoConseguido];
	}
}
