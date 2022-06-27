package modelos.comisiones;

import modelos.IComision;
import modelos.IDoubleDispatch;

public class Senior extends PuestoLaboralDecorator {
	public Senior() {
	}

	public Senior(IComision encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double enfrentar(IDoubleDispatch o) {
		return o.enfrentarSegundo();
	}

	@Override
	public double enfrentarPrimero() {
		// TODO Auto-generated method stub
		return -0.5;
	}

	@Override
	public double enfrentarSegundo() {
		// TODO Auto-generated method stub
		return 1.0;
	}

	@Override
	public double enfrentarTercero() {
		// TODO Auto-generated method stub
		return -0.5;
	}

	@Override
	public double calcularPorcentaje() {
		double porcentaje = this.encapsulado.calcularPorcentaje();
		double valor;

		if (porcentaje >= 0.9)
			valor = 0;
		else
			valor = 0.9 - porcentaje;

		return valor;
	}
	
	@Override
	public String toString() {
		return "Junior";
	}

}
