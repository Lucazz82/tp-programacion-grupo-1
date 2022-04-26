package modelos.aspectos.factories;

import enums.PuestosLaborales;
import modelos.IEmpleado;
import modelos.comisiones.Gerencial;
import modelos.comisiones.Junior;
import modelos.comisiones.PuestoLaboralDecorator;
import modelos.comisiones.Senior;

public class PuestoLaboralFactory {
	public static PuestoLaboralDecorator getPuestoLaboral(PuestosLaborales puesto,IEmpleado empleado) {
		PuestoLaboralDecorator resultado = null;
		
		switch(puesto) {
		case GERENCIAL:
			resultado = new Gerencial(empleado);
			break;
		case JUNIOR:
			resultado = new Junior(empleado);/////////////////////////////
			break;
		case SENIOR:
			resultado = new Senior(empleado);
			break;		
		}
		
		return resultado;
	}
}
