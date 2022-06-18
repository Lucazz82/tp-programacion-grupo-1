package controladores;

public class Sistema {
	private static Sistema _instancia = null;

	private IController controladorActual;

	private Sistema() {

	}

	public static Sistema getInstancia() {
		if (_instancia == null)
			_instancia = new Sistema();
		return _instancia;
	}

	public void iniciarSistema() {
		controladorActual = new LoginController();
	}

	public void cambiarController(IController controller) {
		controladorActual = controller;
	}
}
