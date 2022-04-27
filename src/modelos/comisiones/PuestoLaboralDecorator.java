package modelos.comisiones;

import modelos.IEmpleado;
import modelos.IDoubleDispatch;

public abstract class PuestoLaboralDecorator implements IEmpleado, IDoubleDispatch {
	protected IEmpleado encapsulado;


	public PuestoLaboralDecorator(IEmpleado encapsulado) {
		this.encapsulado = encapsulado;
	}

	//DECORATOR QUE TIENE DOUBLE DISPATCH Y UTILIZA TEMPLATE
	@Override
	public double calcularComision() {
		return this.calcularPorcentaje()*this.encapsulado.calcularComision();
	}
	
	
}
