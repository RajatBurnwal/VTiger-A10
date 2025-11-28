package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewOrganizationPage;
import objectRepo.HomePage;
import objectRepo.OrganizationsPage;

public class TC_004 extends BaseClass {

	@Test(groups = {"Regression","Sanity"})
	public void ORG_001() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsMenu();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrganizationIcon();
		String orgName = eUtil.getSingleCellDataFromExcel("Organizations", 1, 1);
		String website = eUtil.getSingleCellDataFromExcel("Organizations", 1, 2);
		String employees = eUtil.getSingleCellDataFromExcel("Organizations", 1, 3);
		int randNum = jUtil.generateRandomNumber(10000);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createNewOrganization(orgName+randNum, website, employees);
	}
}
