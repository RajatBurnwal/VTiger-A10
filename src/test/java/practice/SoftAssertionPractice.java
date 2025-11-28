package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionPractice {

	@Test
	public void strictLevelSoftAssertion()
	{
		String expectedValue = "Selenium";
		String actualValue = "selenium";
		System.out.println("Strict level soft assertion starts");
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualValue, expectedValue);
		s.assertAll();
		System.out.println("Strict level soft assertion ends");
	}
	
	@Test
	public void containsLevelSoftAssertion()
	{
		String expectedValue = "don";
		String actualValue = "London";
		System.out.println("Contains level soft assertion starts");
		SoftAssert s = new SoftAssert();
		s.assertTrue(actualValue.contains(expectedValue));
		System.out.println("Contains level soft assertion ends");
		s.assertEquals(actualValue.contains(expectedValue), false);
		s.assertAll();
	}
}
