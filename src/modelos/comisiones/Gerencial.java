package modelos.comisiones;

import modelos.IEmpleado;
import modelos.IEnfrentableAspectos;

public class Gerencial extends PuestoLaboralDecorator {

	public Gerencial(IEmpleado encapsulado) {
		super(encapsulado);

	}



	@Override
	public double enfrentar(IEnfrentableAspectos o) {

		return o.enfrentarTercero();
	}

	@Override
	public double enfrentarPrimero() {

		return -1.0;
	}

	@Override
	public double enfrentarSegundo() {

		return -0.5;
	}

	@Override
	public double enfrentarTercero() {

		return 1;
	}

	@Override
	public double calcularPorcentaje() {
		double porcentaje = this.encapsulado.calcularPorcentaje();
		double valor;
		
		if (porcentaje>=1)
			valor=0;
		else
			valor = 1.0-porcentaje;
		
		return valor;
	}

}
