package enums;

public enum PuestosLaborales {
	JUNIOR(0), SENIOR(1), GERENCIAL(2);

	private int posicion;

	private PuestosLaborales(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicion() {
		return this.posicion;
	}
}
