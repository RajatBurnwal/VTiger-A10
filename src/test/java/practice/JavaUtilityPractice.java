package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;

public class JavaUtilityPractice {

	public static void main(String[] args) {

		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		String dateStamp = jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
		int number = jUtil.generateRandomNumber(500);
		System.out.println(dateStamp);
		System.out.println(number);
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.accessApplication(driver, "https://www.facebook.com");
	}

}
