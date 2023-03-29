package conversor;

public class MetrosAKilometros extends Operaciones {

	@Override
	public String conversion() {
		return ""+ super.getValor() * 0.001+"KM";
	}

	@Override
	public String toString() {
		return "M a KM";
	}

}
