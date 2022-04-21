package modelos.aspectos;

import modelos.Enfrentable;

public class Presencial extends Locacion {

	@Override
	public double enfrentar(Enfrentable o) {
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
