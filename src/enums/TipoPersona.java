package enums;

public enum TipoPersona {
	FISICA(0),
	JURIDICA(1);
	
	private int posicion;
	
	TipoPersona(int posicion) {
		this.posicion = posicion;
	}

	public int getPosicion() {
		return posicion;
	}
	
	
}
