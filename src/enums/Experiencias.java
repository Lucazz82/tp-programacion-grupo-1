package enums;

public enum Experiencias {
	NADA(0),
	MEDIA(1),
	MUCHA(2);
	private int posicion;
	private Experiencias(int posicion) {
		this.posicion = posicion;
	}
	public int getPosicion() {
		return this.posicion;
	}
}

