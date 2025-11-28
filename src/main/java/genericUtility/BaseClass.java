package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectRepo.HomePage;
import objectRepo.LoginPage;

public class BaseClass {

	public SeleniumUtility sUtil = new SeleniumUtility();
	public PropertiesUtility pUtil = new PropertiesUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriver driver;
	public static WebDriver sDriver;		//only for listeners
	
	@BeforeSuite(alwaysRun = true)
	public void createDBConnection()
	{
		System.out.println("DB connection created");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void browserLaunch(@Optional("chrome") String BROWSER) throws IOException
	{
		if(BROWSER.equals("chrome"))
			driver = new ChromeDriver();
		else if(BROWSER.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", ".\\src\\main\\resources\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		sDriver = driver;			//initializing the static driver with actual driver
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 20);
		String URL = pUtil.getDataFromProperties("url");
		sUtil.accessApplication(driver, URL);
		System.out.println("Browser launched successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginOperation() throws IOException
	{
		String UN = pUtil.getDataFromProperties("username");
		String PWD = pUtil.getDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		System.out.println("Login done successfully");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutOperation() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOperation(driver);
		System.out.println("Logout done successfully");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		sUtil.closeBrowser(driver);
		System.out.println("Browser closed successfully");
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDBConnection()
	{
		System.out.println("DB connection closed");
	}
}
