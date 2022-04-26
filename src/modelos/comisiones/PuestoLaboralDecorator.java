package modelos.comisiones;

import modelos.IEmpleado;
import modelos.IEnfrentableAspectos;

public abstract class PuestoLaboralDecorator implements IEmpleado,IEnfrentableAspectos {
	protected IEmpleado encapsulado;


	public PuestoLaboralDecorator(IEmpleado encapsulado) {
		this.encapsulado = encapsulado;
	}

	
	@Override
	public double calcularComision() {
		return this.calcularPorcentaje()*this.encapsulado.calcularComision();
	}
	
	
}
