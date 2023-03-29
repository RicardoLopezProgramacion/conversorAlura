package conversor;

public class ToneladaAKilogramo extends Operaciones {

	@Override
	public String conversion() {
		return super.getValor() * 1000 + "KG";
	}

	@Override
	public String toString() {
		return "TONELADA A KILOGRAMO";
	}

}
