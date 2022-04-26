package enums;

public enum Remuneraciones {
	HASTA_V1(0), ENTRE_V1_V2(1), MAS_DE_V2(2);

	private int posicion;

	private Remuneraciones(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicion() {
		return this.posicion;
	}
}
