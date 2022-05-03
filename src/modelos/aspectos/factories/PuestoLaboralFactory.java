package modelos.aspectos.factories;

import enums.PuestosLaborales;
import modelos.IComision;
import modelos.comisiones.Gerencial;
import modelos.comisiones.Junior;
import modelos.comisiones.PuestoLaboralDecorator;
import modelos.comisiones.Senior;

public class PuestoLaboralFactory {
	public static PuestoLaboralDecorator getPuestoLaboral(PuestosLaborales puesto, IComision empleado) {
		PuestoLaboralDecorator resultado = null;

		switch (puesto) {
		case GERENCIAL:
			resultado = new Gerencial(empleado);
			break;
		case JUNIOR:
			resultado = new Junior(empleado);
			break;
		case SENIOR:
			resultado = new Senior(empleado);
			break;
		}

		return resultado;
	}
}
