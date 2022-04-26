package modelos.comisiones;

import modelos.IEmpleado;
import modelos.IEnfrentableAspectos;

public class Junior extends PuestoLaboralDecorator {

	public Junior(IEmpleado encapsulado) {
		super(encapsulado);
	}

	@Override
	public double calcularComision() {
		return 0.8*this.encapsulado.calcularComision();
	}

	@Override
	public double enfrentar(IEnfrentableAspectos o) {
		// TODO Auto-generated method stub
		return o.enfrentarPrimero();
	}

	@Override
	public double enfrentarPrimero() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double enfrentarSegundo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double enfrentarTercero() {
		// TODO Auto-generated method stub
		return 0;
	}

}
