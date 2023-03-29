package conversor;

public class FahrenheitACelcius extends Operaciones {

	@Override
	public String conversion() {
		return (double) Math.round(((super.getValor() - 32) / 1.8) * 100.0) / 100.0 + "C°";
	}

	@Override
	public String toString() {
		return "FAHRENHEIT A CELCIUS";
	}

}
