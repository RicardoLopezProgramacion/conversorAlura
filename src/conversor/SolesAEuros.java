package conversor;

public class SolesAEuros extends Operaciones {
	
	public String conversion() {
		return super.conversion("PEN","EUR")+ "€";
	}

	@Override
	public String toString() {
		return "SOLES A EUROS";
	}

}
