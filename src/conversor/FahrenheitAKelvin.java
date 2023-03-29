package conversor;

public class FahrenheitAKelvin extends Operaciones {

	@Override
	public String conversion() {
		return (double) Math.round((((super.getValor() - 32) / 1.8) + 273.15) * 100.0) / 100.0 + "K°";
	}

	@Override
	public String toString() {
		return "FAHRENHEIT A KELVIN";
	}

}
