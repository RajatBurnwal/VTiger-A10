package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

/**
 * This is a Creating New Lead page POM class
 * @author QSP
 * @version 25-11-05
 */
public class CreatingNewLeadPage {

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTextfield;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTextfield;
	
	@FindBy(xpath = "//input[@name='company']")
	private WebElement companyTextfield;
	
	@FindBy(xpath = "//input[@name='designation']")
	private WebElement titleTextfield;
	
	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//input[@id='mobile']")
	private WebElement mobileTextfield;
	
	@FindBy(xpath = "//input[@id='noofemployees']")
	private WebElement noOfEmployeesTextfield;
	
	@FindBy(xpath = "//input[@id='city']")
	private WebElement cityTextfield;
	
	@FindBy(xpath = "//input[@id='state']")
	private WebElement stateTextfield;
	
	@FindBy(xpath = "//input[@id='country']")
	private WebElement countryTextfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public CreatingNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public WebElement getCompanyTextfield() {
		return companyTextfield;
	}

	public WebElement getTitleTextfield() {
		return titleTextfield;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getMobileTextfield() {
		return mobileTextfield;
	}

	public WebElement getNoOfEmployeesTextfield() {
		return noOfEmployeesTextfield;
	}

	public WebElement getCityTextfield() {
		return cityTextfield;
	}

	public WebElement getStateTextfield() {
		return stateTextfield;
	}

	public WebElement getCountryTextfield() {
		return countryTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This is a business library to create new lead
	 * @param fName
	 * @param lName
	 * @param company
	 */
	public void createNewLead(String fName, String lName, String company)
	{
		getFirstNameTextfield().sendKeys(fName);
		getLastNameTextfield().sendKeys(lName);
		getCompanyTextfield().sendKeys(company);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create new lead
	 * @param lName
	 * @param company
	 * @param title
	 * @param leadSource
	 * @param mobile
	 */
	public void createNewLead(String lName, String company, String title, 
			String leadSource, String mobile)
	{
		getLastNameTextfield().sendKeys(lName);
		getCompanyTextfield().sendKeys(company);
		getTitleTextfield().sendKeys(title);
		SeleniumUtility sUtil = new SeleniumUtility();
		sUtil.selectoptionByValue(getLeadSourceDropdown(), leadSource);
		getMobileTextfield().sendKeys(mobile);
		getSaveButton().click();
	}
	
	/**
	 * This is a business library to create new lead
	 * @param lName
	 * @param company
	 * @param title
	 * @param noOfEmployees
	 * @param mobile
	 * @param city
	 * @param state
	 * @param country
	 */
	public void createNewLead(String lName, String company, String title,
			String noOfEmployees, String mobile, String city, String state,
			String country)
	{
		getLastNameTextfield().sendKeys(lName);
		getCompanyTextfield().sendKeys(company);
		getTitleTextfield().sendKeys(title);
		getNoOfEmployeesTextfield().sendKeys(noOfEmployees);
		getMobileTextfield().sendKeys(mobile);
		getCityTextfield().sendKeys(city);
		getStateTextfield().sendKeys(state);
		getCountryTextfield().sendKeys(country);
		getSaveButton().click();
	}
}
