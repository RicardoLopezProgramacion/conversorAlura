package conversor;

public class DecimalABinario extends Operaciones {

	private SistemaBinario sB3 = new SistemaBinario();
	
	@Override
	public String conversion() {
		return ""+ sB3.decimalABinario(super.getString());
	}

	@Override
	public String toString() {
		return "DECIMAL A BINARIO";
	}

	public void deleteString3() {
		sB3.deleteString();
	}
	
}
