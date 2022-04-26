package modelos.comisiones;

import modelos.IEmpleado;
import modelos.IEnfrentableAspectos;

public class Gerencial extends PuestoLaboralDecorator {

	public Gerencial(IEmpleado encapsulado) {
		super(encapsulado);

	}

	@Override
	public double calcularComision() {

		return this.encapsulado.calcularComision();
	}

	@Override
	public double enfrentar(IEnfrentableAspectos o) {

		return o.enfrentarTercero();
	}

	@Override
	public double enfrentarPrimero() {

		return 0;
	}

	@Override
	public double enfrentarSegundo() {

		return 0;
	}

	@Override
	public double enfrentarTercero() {

		return 0;
	}

}
