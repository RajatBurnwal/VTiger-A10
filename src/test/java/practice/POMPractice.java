package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import objectRepo.LoginPage;

public class POMPractice {

	@FindBy(id = "email")
	WebElement emailTF;
	
	public POMPractice(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {

		PropertiesUtility pUtil = new PropertiesUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		String URL = pUtil.getDataFromProperties("url");
		String UN = pUtil.getDataFromProperties("username");
		String PWD = pUtil.getDataFromProperties("password");
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 20);
		sUtil.accessApplication(driver, URL);
//		POMPractice p = new POMPractice(driver);
//		WebElement emailTF = driver.findElement(By.id("email"));
//		p.emailTF.sendKeys("robin");
//		driver.findElement(By.id("email")).sendKeys("robin");
//		Thread.sleep(2000);
//		driver.navigate().refresh();
//		Thread.sleep(2000);
//		p.emailTF.sendKeys("batman");
//		driver.findElement(By.id("email")).sendKeys("batman");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		sUtil.closeBrowser(driver);
	}

}
