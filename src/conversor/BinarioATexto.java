package conversor;

public class BinarioATexto extends Operaciones {

	private SistemaBinario sB2 = new SistemaBinario();

	@Override
	public void setValor(String valor) {
		super.setValor(valor);
	}

	@Override
	public String conversion() {
		return sB2.binarioAString(super.getString());
	}

	@Override
	public String toString() {
		return "BINARIO A TEXTO";
	}

	public void deleteString2() {
		sB2.deleteString();
	}
	
}
