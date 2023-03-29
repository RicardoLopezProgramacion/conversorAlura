package conversor;

public class LibrasEsterlinasASoles extends Operaciones {

	
	public String conversion() {
		return "S/"+super.conversion("GBP","PEN");
	}
	
	/*@Override
	public String conversion() {
		return (double)Math.floor((getValor() *   4.61836 )*100.0)/100.0 + "$";
	}
*/
	@Override
	public String toString() {
		return "LIBRAS ESTERLINAS A SOLES";
	}

}
