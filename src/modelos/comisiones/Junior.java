package modelos.comisiones;

import modelos.IEmpleado;
import modelos.IDoubleDispatch;

public class Junior extends PuestoLaboralDecorator {

	public Junior(IEmpleado encapsulado) {
		super(encapsulado);
	}

	@Override
	public double enfrentar(IDoubleDispatch o) {
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
		return -0.5;
	}

	@Override
	public double enfrentarTercero() {
		// TODO Auto-generated method stub
		return -1;
	}
	@Override
	public double calcularPorcentaje() {
		double porcentaje = this.encapsulado.calcularPorcentaje();
		double valor;
		
		if (porcentaje>=0.8)
			valor=0;
		else
			valor = 0.8-porcentaje;
		
		return valor;
	}


}
