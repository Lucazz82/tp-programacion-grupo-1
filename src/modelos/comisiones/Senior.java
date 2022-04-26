package modelos.comisiones;

import modelos.IEmpleado;
import modelos.IEnfrentableAspectos;

public class Senior extends PuestoLaboralDecorator {

	public Senior(IEmpleado encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularComision() {
		return 0.9 * this.encapsulado.calcularComision();
	}

	@Override
	public double enfrentar(IEnfrentableAspectos o) {
		return o.enfrentarSegundo();
	}

	@Override
	public double enfrentarPrimero() {
		// TODO Auto-generated method stub
		return 0;
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
