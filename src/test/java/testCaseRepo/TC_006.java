package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewOrganizationPage;
import objectRepo.HomePage;
import objectRepo.OrganizationsPage;

public class TC_006 extends BaseClass {

	@Test(groups = {"Smoke"})
	public void ORG_003() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsMenu();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrganizationIcon();
		String orgName = eUtil.getSingleCellDataFromExcel("Organizations", 7, 1);
		String website = eUtil.getSingleCellDataFromExcel("Organizations", 7, 2);
		String phone = eUtil.getSingleCellDataFromExcel("Organizations", 7, 3);
		String email = eUtil.getSingleCellDataFromExcel("Organizations", 7, 4);
		String shippingCity = eUtil.getSingleCellDataFromExcel("Organizations", 7, 5);
		String shippingState = eUtil.getSingleCellDataFromExcel("Organizations", 7, 6);
		String shippingCountry = eUtil.getSingleCellDataFromExcel("Organizations", 7, 7);
		int randNum = jUtil.generateRandomNumber(10000);
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createNewOrganization(orgName+randNum, website, phone, email, shippingCity,
				shippingState, shippingCountry);
		Thread.sleep(2000);
	}
}
