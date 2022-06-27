package modelos.aspectos;

import enums.Locaciones;
import modelos.IDoubleDispatch;

public class Presencial extends Locacion {

	public Presencial() {
		super(Locaciones.PRESENCIAL);
	}

	@Override
	public double enfrentar(IDoubleDispatch o) {
		return o.enfrentarSegundo();
	}

	@Override
	public double enfrentarPrimero() {
		return -1;
	}

	@Override
	public double enfrentarSegundo() {
		return 1;
	}

	@Override
	public double enfrentarTercero() {
		return -1;
	}

}
