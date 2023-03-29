package conversor;

public class KilogramoATonelada extends Operaciones {

	@Override
	public String conversion() {
		return super.getValor() * 0.001 + "TN";
	}

	@Override
	public String toString() {
		return "KILOGRAMO A TONELADA";
	}

}
