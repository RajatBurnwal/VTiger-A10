package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

/**
 * This is a Home page POM class
 * @author QSP
 * @version 25-11-05
 */
public class HomePage {

	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Leads']")
	private WebElement leadsMenu;
	
	@FindBy(xpath = "//td[@class='tabUnSelected']/a[text()='Organizations']")
	private WebElement organizationsMenu;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement accountsIcon;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Sign Out']")
	private WebElement signOutOption;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadsMenu() {
		return leadsMenu;
	}

	public WebElement getOrganizationsMenu() {
		return organizationsMenu;
	}

	public WebElement getAccountsIcon() {
		return accountsIcon;
	}

	public WebElement getSignOutOption() {
		return signOutOption;
	}
	
	/**
	 * This is a business library to click on Leads menu
	 */
	public void clickOnLeadsMenu()
	{
		getLeadsMenu().click();
	}
	
	/**
	 * This is a business library to click on Organizations menu
	 */
	public void clickOnOrganizationsMenu()
	{
		getOrganizationsMenu().click();
	}
	
	/**
	 * This is a business library to perform sign out operation
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void signOutOperation(WebDriver driver) throws InterruptedException
	{
		SeleniumUtility sUtil = new SeleniumUtility();
		sUtil.mouseHovering(driver, getAccountsIcon());
		Thread.sleep(1000);
		getSignOutOption().click();
	}
}