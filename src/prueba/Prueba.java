package prueba;

import modelos.Agencia;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.Usuario;

public class Prueba {

	public static void main(String[] args) {
		Agencia agencia = Agencia.getInstancia();
		
		Usuario u1 = new EmpleadoPretenso("Teo", "Puto");
		Usuario u2 = new Empleador("Lucas", "Peron");
	}

}
