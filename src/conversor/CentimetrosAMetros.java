package conversor;

public class CentimetrosAMetros extends Operaciones {

	@Override
	public String conversion() {
		return ""+ super.getValor() * 0.01+"M";
	}

	@Override
	public String toString() {
		return "CM a M";
	}

}
