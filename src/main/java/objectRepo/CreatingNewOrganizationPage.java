package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

/**
 * This is a Creating New Organization page POM class
 * @author QSP
 * @version 25-11-05
 */
public class CreatingNewOrganizationPage {

	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(name = "website")
	private WebElement websiteTextField;
	
	@FindBy(name = "employees")
	private WebElement employeesTextField;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name = "phone")
	private WebElement phoneTextField;
	
	@FindBy(name = "email1")
	private WebElement emailTextField;
	
	@FindBy(name = "ship_city")
	private WebElement shippingCityTextField;
	
	@FindBy(name = "ship_state")
	private WebElement shippingStateTextField;
	
	@FindBy(name = "ship_country")
	private WebElement shippingCountryTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getEmployeesTextField() {
		return employeesTextField;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getShippingCityTextField() {
		return shippingCityTextField;
	}

	public WebElement getShippingStateTextField() {
		return shippingStateTextField;
	}

	public WebElement getShippingCountryTextField() {
		return shippingCountryTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This is a business library to create new organization
	 * @param orgName
	 * @param website
	 * @param emp
	 */
	public void createNewOrganization(String orgName, String website, String emp)
	{
		getOrganizationNameTextField().sendKeys(orgName);
		getWebsiteTextField().sendKeys(website);
		getEmployeesTextField().sendKeys(emp);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create new organization
	 * @param orgName
	 * @param website
	 * @param industry
	 * @param phone
	 */
	public void createNewOrganization(String orgName, String website, 
			String industry, String phone)
	{
		getOrganizationNameTextField().sendKeys(orgName);
		getWebsiteTextField().sendKeys(website);
		new SeleniumUtility().selectoptionByValue(getIndustryDropdown(), industry);
		getPhoneTextField().sendKeys(phone);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create new organization
	 * @param orgName
	 * @param website
	 * @param phone
	 * @param email
	 * @param shipCity
	 * @param shipState
	 * @param shipCountry
	 */
	public void createNewOrganization(String orgName, String website,
			String phone, String email, String shipCity, String shipState,
			String shipCountry)
	{
		getOrganizationNameTextField().sendKeys(orgName);
		getWebsiteTextField().sendKeys(website);
		getPhoneTextField().sendKeys(phone);
		getEmailTextField().sendKeys(email);
		getShippingCityTextField().sendKeys(shipCity);
		getShippingStateTextField().sendKeys(shipState);
		getShippingCountryTextField().sendKeys(shipCountry);
		getSaveButton().click();
	}
}
