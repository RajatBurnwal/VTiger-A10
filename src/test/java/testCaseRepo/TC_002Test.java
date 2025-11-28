package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

public class TC_002Test extends BaseClass {

	@Test(groups = {"Regression"})
	public void LE_002() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		String lName = eUtil.getSingleCellDataFromExcel("Leads", 4, 1);
		String company = eUtil.getSingleCellDataFromExcel("Leads", 4, 2);
		String title = eUtil.getSingleCellDataFromExcel("Leads", 4, 3);
		String leadSource = eUtil.getSingleCellDataFromExcel("Leads", 4, 4);
		String mobile = eUtil.getSingleCellDataFromExcel("Leads", 4, 5);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName, company, title, leadSource, mobile);
	}
}
