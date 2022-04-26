package modelos.comisiones;

import modelos.IEmpleado;

public abstract class PuestoLaboralDecorator implements IEmpleado {
	protected IEmpleado encapsulado;

	public PuestoLaboralDecorator(IEmpleado encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	
}
