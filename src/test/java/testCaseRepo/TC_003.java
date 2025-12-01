package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_003 extends BaseClass {

	@Test(groups = {"Smoke"})
	public void LE_003() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		String lName = eUtil.getSingleCellDataFromExcel("Leads", 7, 1);
		String company = eUtil.getSingleCellDataFromExcel("Leads", 7, 2);
		String title = eUtil.getSingleCellDataFromExcel("Leads", 7, 3);
		String noOfEmployees = eUtil.getSingleCellDataFromExcel("Leads", 7, 4);
		String mobile = eUtil.getSingleCellDataFromExcel("Leads", 7, 5);
		String city = eUtil.getSingleCellDataFromExcel("Leads", 7, 6);
		String state = eUtil.getSingleCellDataFromExcel("Leads", 7, 7);
		String country = eUtil.getSingleCellDataFromExcel("Leads", 7, 8);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName, company, title, noOfEmployees, mobile, city, state, country);
	}
}
