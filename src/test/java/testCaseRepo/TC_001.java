package testCaseRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepo.CreatingNewLeadPage;
import objectRepo.HomePage;
import objectRepo.LeadsPage;

@Listeners(genericUtility.ListenersImplementation.class)
public class TC_001 extends BaseClass {

	int i=0;
	
	@Test(retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class ,groups = {"Smoke","Sanity"})
	public void LE_001() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnLeadsMenu();
		LeadsPage lep = new LeadsPage(driver);
		lep.clickOnCreateNewLeadIcon();
		if(i<3)
		{
			i++;
			Assert.fail();
		}
		String fName = eUtil.getSingleCellDataFromExcel("Leads", 1, 1);
		String lName = eUtil.getSingleCellDataFromExcel("Leads", 1, 2);
		String company = eUtil.getSingleCellDataFromExcel("Leads", 1, 3);
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(fName, lName, company);
	}
}
