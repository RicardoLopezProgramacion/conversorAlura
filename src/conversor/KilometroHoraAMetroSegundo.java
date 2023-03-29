package conversor;

public class KilometroHoraAMetroSegundo extends Operaciones{

	@Override
	public String conversion() {
		return  (double)Math.round(((super.getValor() * 1000 * 1)/(1 * 3600))*100.0)/100.0 + " M/S";
	}

	@Override
	public String toString() {
		return "KM/H a M/S";
	}

}
