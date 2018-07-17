package co.com.psl.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class OrderedNumbers {
	private static Pattern VALID_INPUT_CHARS = Pattern.compile("\\d{1,19}");

	public String lastOrderedNumberOf(String number) {
		if (number == null || !VALID_INPUT_CHARS.matcher(number).matches() || "0".equals(number) || new BigDecimal(number).compareTo(new BigDecimal("1000000000000000001")) >= 0 ) {
			return "El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18";
		}
		
		if (number.length() == 1) {
			return printResult(number, number);
		}
		
		char[] evaluatedNumber = number.toCharArray();
		StringBuilder resultNumber = new StringBuilder();
		for (int i = 0; i < evaluatedNumber.length - 1; i++) {
			int current = Character.getNumericValue(evaluatedNumber[i]);
			int next = Character.getNumericValue(evaluatedNumber[i + 1]);
			if (current > next || next == 0) {
				next = 9;
				if (current != 9) {
					current--;
				}
				evaluatedNumber[i+1] = '9';
			}
			resultNumber.append(current);
		}
		resultNumber.append(evaluatedNumber[evaluatedNumber.length - 1]);
		return printResult(number, resultNumber.toString());
	}

	private String printResult(String number, String orderedNumber) {
		return String.format("N=%s, O=%s", number, orderedNumber);
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("");
		OrderedNumbers on = new OrderedNumbers();
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	
		    }
		}
	}
}
