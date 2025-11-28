package practice;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_001Practice extends BaseClass{

	@Test
	public void m1() throws IOException
	{
//		ExcelUtility eUtil = new ExcelUtility();
//		PropertiesUtility pUtil = new PropertiesUtility();
//		SeleniumUtility sUtil = new SeleniumUtility();
//		WebDriver driver = new ChromeDriver();
//		sUtil.maximizeWindow(driver);
//		sUtil.implicitWait(driver, 15);
//		String URL = pUtil.getDataFromProperties("url");
//		sUtil.accessApplication(driver, URL);
//		String UN = pUtil.getDataFromProperties("username");
//		String PWD = pUtil.getDataFromProperties("password");
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApplication(UN, PWD);
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		String fName = eUtil.getSingleCellDataFromExcel("Leads", 1, 1);
		String lName = eUtil.getSingleCellDataFromExcel("Leads", 1, 2);
		String company = eUtil.getSingleCellDataFromExcel("Leads", 1, 3);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fName, lName, company);
//		hp.signOutOperation(driver);
//		sUtil.closeBrowser(driver);
	}
}
