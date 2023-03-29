package conversor;

public class EurosASoles extends Operaciones {

	/*@Override
	public String conversion() {
		return "S/" + getValor() * 4.02;
	}*/
	
	public String conversion() {
		return "S/"+super.conversion("EUR","PEN");
	}

	@Override
	public String toString() {
		return "EUROS A SOLES";
	}

}
