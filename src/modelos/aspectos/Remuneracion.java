package modelos.aspectos;

public class Remuneracion {
	private int pos;
	public Remuneracion(int pos) {
		this.pos=pos;
	}
	private static double[][] pesos = { { 1, -0.5, -1 }, { 1, 1, -0.5 }, { 1, 1, 1 } };

	public  double enfrentar(Remuneracion o) {
		return pesos[this.pos][o.pos];
	}
	
	public int getPos() {
		return this.pos;
	}
}
