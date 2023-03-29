package conversor;

public class SolesADolares extends Operaciones {

	public SolesADolares() {
		super();
	}

	@Override
	public String conversion() {
		return super.conversion("PEN", "USD")+"$";
	}

	@Override
	public String toString() {
		return "SOLES A DOLARES";
	}
	


}
