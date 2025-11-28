package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * This is an utility class which has the functionalities present in Selenium library
 * @author QSP
 * @version 25-11-03
 */
public class SeleniumUtility {

	/**
	 * This is a generic method to access a web application
	 * @param driver
	 * @param url
	 */
	public void accessApplication(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	/**
	 * This is a generic method to maximize the browser
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This is a generic method to provide implicit wait
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver, int maxTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
	
	/**
	 * This is a generic method to close the browser
	 * @param driver
	 */
	public void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	////////////********** Handling Dropdown ***********///////////
	
	/**
	 * This is a generic method to select an option in dropdown by its index
	 * @param dropdownEle
	 * @param index
	 */
	public void selectoptionByIndex(WebElement dropdownEle, int index)
	{
		Select sel = new Select(dropdownEle);
		sel.selectByIndex(index);
	}
	
	/**
	 * This is a generic method to select an option in dropdown by its value att.
	 * @param dropdownEle
	 * @param value
	 */
	public void selectoptionByValue(WebElement dropdownEle, String value)
	{
		Select sel = new Select(dropdownEle);
		sel.selectByValue(value);
	}
	
	/**
	 * This is a generic method to select an option in dropdown by its visible text
	 * @param dropdownEle
	 * @param visibleText
	 */
	public void selectoptionByVisibleText(WebElement dropdownEle, String visibleText)
	{
		Select sel = new Select(dropdownEle);
		sel.selectByVisibleText(visibleText);
	}
	
	///////////********* Handling Mouse Actions ***********///////////
	
	/**
	 * This is a generic method to perform mouse hovering action on webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHovering(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This is a generic method to perform right click operation on webelement
	 * @param driver
	 * @param element
	 */
	public void rightClickOperation(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This is a generic method to perform double click action on webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickOperation(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/////////////************ Handling Alert **********//////////////
	
	/**
	 * This is a generic method to accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This is a generic method to dismiss alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/////////////********** Handling Frames ***********////////////
	
	/**
	 * This is a generic method to switch to a frame using frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrameUsingFrameIndex(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/////////////********** Taking webpage screenshot *********///////////
	
	/**
	 * This is a generic method to take webpage screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String getWebpageScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath(); 			//used for listeners
	}
}
