package co.com.psl.challenge;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author aletr
 */
public class LastOrderedNumberTest {

	@Test
	public void validate_InvalidZero() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.getLastOrderedNumberOf("0"));
	}
	
	@Test
	public void validate_Invalid_10_powered_18() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.getLastOrderedNumberOf("1000000000000000001"));
	}
	
	@Test
	public void validate_Invalid_NumberSize() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.getLastOrderedNumberOf("19172391827391273812t3162537123692987319827391827391827391263817263817253812531"));
	}
	
	@Test
	public void validate_Invalid_null() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.getLastOrderedNumberOf(null));
	}
	
	@Test
	public void validate_Invalid_NotNumbers() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("El valor ingresado debe ser: Numérico, No nulo, y Estar entre 1 y 10^18", on.getLastOrderedNumberOf("No_Es_Numero"));
	}
	
	@Test
	public void validate_Valid_SingleNumbers() {
		LastOrderedNumber on = new LastOrderedNumber();
		for (int i = 1; i < 10; i++) {
			Assert.assertEquals(String.valueOf(i), on.getLastOrderedNumberOf(String.valueOf(i)));
		}
		char a = '9';
		System.out.println(a-1);
	}
	
	@Test
	public void validate_Valid_20() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("19", on.getLastOrderedNumberOf("20"));
	}
	
	
	@Test
	public void validate_Valid_132() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("129", on.getLastOrderedNumberOf("132"));
	}
	
	@Test
	public void validate_Valid_1000() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("999", on.getLastOrderedNumberOf("1000"));
	}
	
	@Test
	public void validate_Valid_11111110() {
		LastOrderedNumber on = new LastOrderedNumber();
		Assert.assertEquals("9999999", on.getLastOrderedNumberOf("11111110"));
	}
	
	@Test
  public void validate_Valid_1111011110() {
    LastOrderedNumber on = new LastOrderedNumber();
    Assert.assertEquals("999999999", on.getLastOrderedNumberOf("1111011110"));
  }
	
	@Test
  public void validate_Valid_110() {
    LastOrderedNumber on = new LastOrderedNumber();
    Assert.assertEquals("99", on.getLastOrderedNumberOf("110"));
  }
}
