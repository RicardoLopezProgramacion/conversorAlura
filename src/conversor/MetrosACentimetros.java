package conversor;

public class MetrosACentimetros extends Operaciones {

	@Override
	public String conversion() {
		return super.getValor() * 100+"CM";
	}

	@Override
	public String toString() {
		return "M a CM";
	}

}
