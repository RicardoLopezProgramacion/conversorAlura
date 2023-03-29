package conversor;

public class TextoABinario extends Operaciones {

	private SistemaBinario sB = new SistemaBinario();

	@Override
	public void setValor(String valor) {
		super.setValor(valor);
	}

	@Override
	public String conversion() {
		return sB.stringABinario(super.getString());
	}

	@Override
	public String toString() {
		return "TEXTO A BINARIO";
	}

	public void deleteString() {
		sB.deleteString();
	}

}
