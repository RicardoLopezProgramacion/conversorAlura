package conversor;

public class CelciusAFahrenheit extends Operaciones {

	@Override
	public String conversion() {
		return (double) Math.round(((super.getValor() * 1.8) + 32) * 100.0) / 100.0 + "F°";
	}

	@Override
	public String toString() {
		return "CELCIUS A FAHRENHEIT";
	}

}
