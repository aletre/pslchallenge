package co.com.psl.challenge;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * CLase de utilidad que permite obtener el último número ordenado de un número dado. 
 * @author dtrejos
 */
public class LastOrderedNumber {
  
  /** Patrón compilado para validar la entrada al método. */
	private static Pattern VALID_INPUT_CHARS = Pattern.compile("\\d{1,19}");

	/**
	 * Obtiene el último número ordenado encontrado del numero ingresado como argumento.
	 * 
	 * Comienza revisando por pares si los números quedan ordenados y en caso de encontrar un cero adelante, se devuelve ordenando los números para
	 * retomar desde ese punto nuevamente y continuar con la validación del número ordenado.
	 * 
	 * @param number número a evaluar.
	 * @return último número ordenado.
	 */
	public String getLastOrderedNumberOf(String number) {
		if (validateNumberPreconditions(number)) {
			return "El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18";
		}
		if (number.length() == 1) {
			return number;
		}
		char[] evaluatedNumber = number.toCharArray();
		int i = 0, direction = 1, lastIterCounter = 0; 
		while (i < evaluatedNumber.length - 1) {
		  char current = evaluatedNumber[i];
      char next = evaluatedNumber[i + 1];
      if (current > next || next == '0' || direction == -1) {
        if (current != '9') {
          current--;
          if (current == '0' && i > 0) {
            current = '9';
            if (direction == 1) {
              direction = -1;
              lastIterCounter = i;
            }
          }
          evaluatedNumber[i] = current;
        }
        evaluatedNumber[i+1] = '9';
      }
		  
		  i += direction;
		  if (i < 0) {
		    i = lastIterCounter;
		    direction = 1;
		  }
		}
		return String.valueOf(evaluatedNumber).replace("0", "");
	}

	/**
	 * Valida las precondiciones del número a evaluar.
	 * 
	 * <pre>
   *  - Diferente de nulo.
   *  - Caracteres numéricos.
   *  - Diferente de cero.
   *  - Mayor o igual a 1.
   *  - Menor o igual a 10^18
   * </pre>
	 * @param number Número a evaluar.
	 * @return true si cumple las precondiciones.
	 */
  private boolean validateNumberPreconditions(String number) {
    return number == null || !VALID_INPUT_CHARS.matcher(number).matches() || "0".equals(number) || new BigDecimal(number).compareTo(new BigDecimal("1000000000000000001")) >= 0;
  }
}
