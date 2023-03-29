package conversor;

public class KilogramoAgramos extends Operaciones {

	@Override
	public String conversion() {
		return super.getValor() * 1000 + "GR";
	}

	@Override
	public String toString() {
		return "KILOGRAMO A GRAMO";
	}

}
