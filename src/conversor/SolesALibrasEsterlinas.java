package conversor;

public class SolesALibrasEsterlinas extends Operaciones {
	
	public String conversion() {
		return super.conversion("PEN","GBP")+"£";
	}

	@Override
	public String toString() {
		return "SOLES A LIBRAS ESTERLINAS";
	}

}
