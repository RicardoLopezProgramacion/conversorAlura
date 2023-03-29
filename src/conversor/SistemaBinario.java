package conversor;

import java.util.function.IntBinaryOperator;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

public class SistemaBinario {

	private char arrayChar[] = null;
	private int arrayInt[] = null;
	private String arrayString[] = null;
	private String string2 = "";
	private String string1;
	private int n[] = null;
	private char l;
	private int contador;
	private long numero;

	public String stringABinario(String string) {
		arrayChar = new char[string.length()];
		arrayInt = new int[string.length()];
		for (int i = 0; i < string.length(); i++) {

			arrayChar[i] = string.charAt(i);
			arrayInt[i] = arrayChar[i];

			for (int j = 7; j >= 0; j--) {

				string2 += arrayInt[i] >= Math.pow(2, j) ? "1" : "0";
				arrayInt[i] -= arrayInt[i] >= Math.pow(2, j) ? Math.pow(2, j) : 0;
				if (j == 0 && i != (string.length() - 1)) {
					string2 += " ";
				}
			}

		}

		return string2 + "\n";

	}

	public String binarioAString(String string) {

		try {

			String newExample = "";
			String newExample2 = "";

			for (int i = 0; i < string.length(); i++) {

				if ((string.charAt(i) == ' ') == false) {
					newExample += string.charAt(i);
				}
			}

			for (int i = 0; i < newExample.length(); i++) {

				if (i >= 8 && i % 8 == 0) {
					newExample2 += " ";
					newExample2 += newExample.charAt(i);
				} else {
					newExample2 += newExample.charAt(i);
				}

			}

			arrayString = newExample2.split(" ");

			n = new int[arrayString.length];

			for (int i = 0; i < arrayString.length; i++) {

				for (int j = (arrayString[i].length() - 1); j >= 0; j--) {

					if (arrayString[i].length() == 8) {

						string1 = arrayString[i];

						if (string1.charAt(j) == '1') {

							n[i] += Math.pow(2, contador);
						}

						contador++;

					}

					else {
						JOptionPane.showMessageDialog(null,
								"INGRESA 8 DIGITOS EN EL CONJUNTO: [" + arrayString[i] + "]");
						throw new ClaseErrores("ERROR LANZADO POR NO HABER INGRESADO 8 DIGITOS");
					}

				}
				contador = 0;

				l = (char) (n[i]);

				string2 += l;
			}

		} catch (ClaseErrores c) {

			string2 = "";
		}

		return string2 + "\n";
	}

	public String decimalABinario(String string) {

		arrayChar = new char[1];

		numero = Long.parseLong(string);

		string2 = Long.toBinaryString(numero);

		return string2 + "\n";

	}

	public String binarioADecimal(String string) {

		long decimal = Long.parseLong(string, 2);
		string2 = "" + decimal;
		return string2;
	}

	public void deleteString() {

		string2 = "";

	}

}
