package conversor;

public class KelvinAFahrenheit extends Operaciones {

	@Override
	public String conversion() {
		return (double) Math.round((((super.getValor() - 273.15) * 1.8) + 32) * 100.0) / 100.0 + "F°";
	}

	@Override
	public String toString() {
		return "KELVIN A FAHRENHEIT";
	}

}
