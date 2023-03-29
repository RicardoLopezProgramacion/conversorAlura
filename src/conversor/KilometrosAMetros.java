package conversor;

public class KilometrosAMetros extends Operaciones{

	@Override
	public String conversion() {
		return super.getValor() * 1000+"M";
	}

	@Override
	public String toString() {
		return "KM a M";
	}

}
