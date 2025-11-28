package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;

public class FetchingDataFromPropertiesFile {

	public static void main(String[] args) throws IOException, InterruptedException {

//		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Desktop\\TestData.properties");
//		Properties prop = new Properties();
//		prop.load(fis);
//		String URL = prop.getProperty("url");
//		String UN = prop.getProperty("username");
		PropertiesUtility pUtil = new PropertiesUtility();
		String URL = pUtil.getDataFromProperties("url");
		String UN = pUtil.getDataFromProperties("username");
		System.out.println(UN);
		System.out.println(URL);
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
	}

}
