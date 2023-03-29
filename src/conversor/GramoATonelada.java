package conversor;

public class GramoATonelada extends Operaciones {

	@Override
	public String conversion() {
		return super.getValor() * 0.001 * 0.001 + "TN";
	}

	@Override
	public String toString() {
		return "GRAMO A TONELADA";
	}

}
