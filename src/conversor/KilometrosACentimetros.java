package conversor;

public class KilometrosACentimetros extends Operaciones{

	@Override
	public String conversion() {
		return super.getValor() * 1000 * 100+"CM";
	}

	@Override
	public String toString() {
		return "KM A CM";
	}

}
