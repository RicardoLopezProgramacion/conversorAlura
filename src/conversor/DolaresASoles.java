package conversor;

public class DolaresASoles extends Operaciones {

	public DolaresASoles() {
		super();
	}
	
	public String conversion() {
		return "S/"+super.conversion("USD","PEN");
	}

	/*@Override
	public String conversion() {
       return "S/" + (double)Math.floor((getValor() *   3.76814 )*100.0)/100.0;
    	   
	}*/

	@Override
	public String toString() {
		return "DOLARES A SOLES";
	}
	
}
