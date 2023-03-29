package conversor;

public class SolesAYenJapones extends Operaciones{
	
	public String conversion() {
		return "¥"+super.conversion("PEN","JPY");
	}

	@Override
	public String toString() {
		return "SOLES A YEN JAPONES";
	}

}
