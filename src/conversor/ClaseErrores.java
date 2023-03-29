package conversor;

public class ClaseErrores extends RuntimeException {

	public ClaseErrores(String message) {
		super(message);
		printStackTrace();
	}


	
}
