package co.com.psl.challenge;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author aletr
 */
public class OrderedNumbersTest {

	@Test
	public void validate_InvalidZero() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.lastOrderedNumberOf("0"));
	}
	
	@Test
	public void validate_Invalid_10_powered_18() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.lastOrderedNumberOf("1000000000000000001"));
	}
	
	@Test
	public void validate_Invalid_NumberSize() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.lastOrderedNumberOf("19172391827391273812t3162537123692987319827391827391827391263817263817253812531"));
	}
	
	@Test
	public void validate_Invalid_null() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.lastOrderedNumberOf(null));
	}
	
	@Test
	public void validate_Invalid_NotNumbers() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.lastOrderedNumberOf("No_Es_Numero"));
	}
	
	@Test
	public void validate_Valid_SingleNumbers() {
		OrderedNumbers on = new OrderedNumbers();
		for (int i = 1; i < 10; i++) {
			Assert.assertEquals(String.format("N=%s, O=%s", i, i), on.lastOrderedNumberOf(String.valueOf(i)));
		}
		char a = '9';
		System.out.println(a-1);
	}
	
	@Test
	public void validate_Valid_20() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("N=20, O=19", on.lastOrderedNumberOf("20"));
	}
	
	
	@Test
	public void validate_Valid_132() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("N=132, O=129", on.lastOrderedNumberOf("132"));
	}
	
	@Test
	public void validate_Valid_1000() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("N=1000, O=999", on.lastOrderedNumberOf("1000"));
	}
	
	@Test
	public void validate_Valid_11111110() {
		OrderedNumbers on = new OrderedNumbers();
		Assert.assertEquals("N=11111110, O=9999999", on.lastOrderedNumberOf("11111110"));
	}
}
