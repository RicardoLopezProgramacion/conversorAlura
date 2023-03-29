package conversor;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public abstract class Operaciones {

	private double valor;
	private String string;
	private double valorBigDecimal;

	public Operaciones() {
		this.valor = valor;
		this.string = string;
		this.valorBigDecimal = valorBigDecimal;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

	public abstract String conversion();

	// API DE CONVERSIONES ↓ 
	
	public String conversion(String tipoDeMoneda, String tipoConversion) {

		try {

			URL url = new URL("https://v6.exchangerate-api.com/v6/ee301b010cb7ef0551129539/latest/" + tipoDeMoneda);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.setRequestMethod("GET");
			request.connect();
			int responsecode = request.getResponseCode();

			if (responsecode != 200) {
				throw new RuntimeException("HUBO UN ERROR: " + responsecode);
			} else {
				StringBuilder infoString = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());

				while (sc.hasNext()) {
					infoString.append(sc.nextLine());
				}

				sc.close();
				JSONObject dataObject = new JSONObject(String.valueOf(infoString));
				this.string = "" + dataObject.getJSONObject("conversion_rates").getBigDecimal(tipoConversion);
				this.valorBigDecimal = Double.parseDouble(this.string);
				System.out.println(this.valorBigDecimal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "" + (double)Math.floor((getValor() * this.valorBigDecimal )*100.0)/100.0;
	}

	public abstract String toString();

}
