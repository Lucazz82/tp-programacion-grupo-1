package enums;

public enum Estudios {
	PRIMARIO(0), SECUNDARIO(1), TERCIARIO(2);

	private int posicion;

	private Estudios(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicion() {
		return this.posicion;
	}
}
