package conversor;

public class YenJaponesASoles extends Operaciones {

	@Override
	public String conversion() {
		return "S/"+conversion("JPY", "PEN");
	}

	@Override
	public String toString() {
		return "YEN JAPONES A SOLES";
	}

}
