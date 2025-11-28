package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewOrganizationPage;
import objectRepo.HomePage;
import objectRepo.OrganizationsPage;

public class TC_005 extends BaseClass {

	@Test(groups = {"Regression"})
	public void ORG_002() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsMenu();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrganizationIcon();
		String orgName = eUtil.getSingleCellDataFromExcel("Organizations", 4, 1);
		String website = eUtil.getSingleCellDataFromExcel("Organizations", 4, 2);
		String industry = eUtil.getSingleCellDataFromExcel("Organizations", 4, 3);
		String phone = eUtil.getSingleCellDataFromExcel("Organizations", 4, 4);
		int randNum = jUtil.generateRandomNumber(10000);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createNewOrganization(orgName+randNum, website, industry, phone);
	}
}
