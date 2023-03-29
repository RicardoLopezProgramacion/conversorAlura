package conversor;

public class GramoAKilogramo extends Operaciones {

	@Override
	public String conversion() {
		return super.getValor() * 0.001 + "KG";
	}

	@Override
	public String toString() {
		return "GRAMO A KILOGRAMO";
	}

}
