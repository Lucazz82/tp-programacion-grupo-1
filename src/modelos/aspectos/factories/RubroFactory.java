package modelos.aspectos.factories;

import enums.Rubros;
import modelos.comisiones.ComercioInternacional;
import modelos.comisiones.ComercioLocal;
import modelos.comisiones.Rubro;
import modelos.comisiones.Salud;

public class RubroFactory {
	public static Rubro getRubro(Rubros rubro) {
		Rubro resultado = null;
		
		switch (rubro) {
		case COMECIO_LOCAL:
			resultado = new ComercioLocal();
			break;
		case COMERCIO_INTERNACIONAL:
			resultado = new ComercioInternacional();
			break;
		case SALUD:
			resultado = new Salud();
			break;
		default:
			break;
		}
		
		return resultado;
	}
}
