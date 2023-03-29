package conversor;

public class MetroSegundoAKilometroHora extends Operaciones{

	@Override
	public String conversion() {
		return (double)Math.round(((super.getValor() * 1 * 3600)/(1000 * 1))*100.0)/100.0 + " KM/H";
	}
	
	@Override
	public String toString() {
		return "M/S a KM/H";
	}

}
