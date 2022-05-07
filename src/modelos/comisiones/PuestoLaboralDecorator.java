package modelos.comisiones;

import modelos.IComision;
import modelos.IDoubleDispatch;

public abstract class PuestoLaboralDecorator implements IComision, IDoubleDispatch {
	protected IComision encapsulado;
	
	public PuestoLaboralDecorator() {
		this.encapsulado = null;
	}

	public PuestoLaboralDecorator(IComision encapsulado) {
		this.encapsulado = encapsulado;
	}

	@Override
	public double calcularComision() {
		return this.calcularPorcentaje() * this.encapsulado.calcularComision();
	}
}
