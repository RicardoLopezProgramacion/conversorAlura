package conversor;

public class ToneladaAGramos extends Operaciones {

	@Override
	public String conversion() {
		return super.getValor() * 1000 * 1000 + "GR";
	}

	@Override
	public String toString() {
		return "TONELADA A GRAMO";
	}

}
