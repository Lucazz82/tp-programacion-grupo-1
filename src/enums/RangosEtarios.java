package enums;

public enum RangosEtarios {
	MENOS_DE_40(0), ENTRE_40_50(1), MAS_DE_50(2);

	private int posicion;

	private RangosEtarios(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicion() {
		return this.posicion;
	}
}
