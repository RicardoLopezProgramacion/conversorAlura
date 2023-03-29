package conversor;

public class CentimetrosAKilometros extends Operaciones {

	@Override
	public String conversion() {
		return ""+ super.getValor() * 0.01 * 0.001+"KM";
	}

	@Override
	public String toString() {
		return "CM a KM";
	}

}
