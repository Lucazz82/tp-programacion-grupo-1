package modelos.aspectos.factories;

import enums.PuestosLaborales;
import modelos.aspectos.PuestoLaboral;

public class PuestoLaboralFactory {
	public static PuestoLaboral getPuestoLaboral(PuestosLaborales puesto) {
		PuestoLaboral resultado = null;
		
		switch(puesto) {
		case GERENCIAL:
			resultado = new PuestoLaboral(2);
			break;
		case JUNIOR:
			resultado = new PuestoLaboral(0);
			break;
		case SENIOR:
			resultado = new PuestoLaboral(1);
			break;		
		}
		
		return resultado;
	}
}
