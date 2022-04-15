package modelos;

public class Agencia {
	// Singleton!1!1!
	private static Agencia _instancia=null;
	public static Agencia getInstancia() {
		if (_instancia == null)
			_instancia=new Agencia();
		return _instancia;
	}
	
}
