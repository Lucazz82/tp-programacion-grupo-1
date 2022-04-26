package enums;

public enum Rubros {
	SALUD(0), COMECIO_LOCAL(1), COMERCIO_INTERNACIONAL(2);

	private int posicion;

	Rubros(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicion() {
		return posicion;
	}

}
