package conversor;

public class BinarioADecimal extends Operaciones{

	SistemaBinario sB4 = new SistemaBinario();
	
	@Override
	public String conversion() {
		return ""+ sB4.binarioADecimal(super.getString());
	}

	@Override
	public String toString() {
		return "BINARIO A DECIMAL";
	}

	public void deleteString4() {
		sB4.deleteString();
	}
	
}
