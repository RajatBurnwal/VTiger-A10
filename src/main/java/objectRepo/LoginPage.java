package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a Login page POM class
 * @author QSP
 * @version 25-11-04
 */
public class LoginPage {

	//Locating the webelements
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement usernameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//Initializing the webelements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Public getter methods
	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Utilizing the webelements
	
	/**
	 * This is a business library to perform login operation to the web application
	 * @param UN
	 * @param PWD
	 */
	public void loginToApplication(String UN, String PWD)
	{
		getUsernameTextField().sendKeys(UN);
		getPasswordTextField().sendKeys(PWD);
		getLoginBtn().click();
	}
}
