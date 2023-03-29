package conversor;

public class KelvinACelsius extends Operaciones {

	@Override
	public String conversion() {
		return (double) Math.floor(((super.getValor() - 273.15) * 1) * 100.0) / 100.0 + "C°";

	}

	@Override
	public String toString() {
		return "KELVIN A CELCIUS";
	}

}
