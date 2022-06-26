package modelos.aspectos;

import java.io.Serializable;

import enums.Locaciones;
import modelos.IDoubleDispatch;

public abstract class Locacion implements IDoubleDispatch, Serializable{
	private Locaciones locacion;
	
	public Locacion(Locaciones locacion) {
		this.locacion = locacion;
	}
	
	public boolean mismaLocacion(Locacion o) {
		return locacion == o.locacion;
	}

	@Override
	public String toString() {
		return locacion.toString();
	}
}
