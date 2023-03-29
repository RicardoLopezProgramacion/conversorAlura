package conversor;

public class CelsiusAKelvin extends Operaciones {

	@Override
	public String conversion() {
		return (double) Math.floor(((super.getValor() + 273.15) * 1) * 100.0) / 100.0 + "K°";
	}

	@Override
	public String toString() {
		return "CELSIUS A KELVIN";
	}

}
