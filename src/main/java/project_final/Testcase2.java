package project_final;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase2 extends ReadExcel_DataProvider {
	/*
	 * Find by First Name and Edit - (In Chrome - 2 data) -- Search by the first
	 * name -- Select the first resulting lead -- Confirm the title of the view
	 * lead page -- Click Edit -- Change the source to another value -- Change
	 * the marketing campaign -- Update and confirm that it changed
	 */

	@Test(dataProvider = "exceldata")
	public void EditLead(String FirstName, String SourceId, String CampaignId)
			throws IOException, InterruptedException {
		// Initialize and Login into Website , priority=2
		
		clickbyXpath("(//a[@href='/crmsfa/control/findLeads'])");
		// Finding lead by entering first name and clicking on FindLeads button
		enterByTextXpath("(//input[@name='firstName'])[3]", FirstName);
		clickbyXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		// Selecting the first input in the given list
		clickbyXpath("(//table/tbody/tr/td[1]/div/a)[1]");
		// Verifying title
		verifyTitle("Find Leads | opentaps CRM");
		// Editing the details of Lead
		clickbyXpath("//a[contains(text(),'Edit')]");
		Thread.sleep(3000);
		// Change the source
		selectbyvisibletext_Byid("addDataSourceForm_dataSourceId", SourceId);
		// Click Add
		clickbyXpath("(//input[@value='Add'])[1]");
		// Change the marketing campaign
		selectbyvisibletext_Byid("addMarketingCampaignForm_marketingCampaignId", CampaignId);
		// Click Add
		clickbyXpath("(//input[@value='Add'])[2]");
		// Click Update
		clickbyXpath("(//input[@value='Update'])");
		// Confirm added source
		verifyTextContainsById("viewLead_dataSources_sp", SourceId);
		// Confirm added marketing campaign
		verifyTextContainsById("viewLead_marketingCampaigns_sp", CampaignId);
	}

	@DataProvider(name = "exceldata")
	public Object[][] data() throws IOException {
		return exceldata("OpenTaps", 1);
	}

	/*@Parameters("browser")
	@BeforeMethod(description = "Launch the browser")

	public void launchbrowser(String browser) throws Exception {
		remoteLaunchDriver("http://demo1.opentaps.org/opentaps/control/main", browser);

		login_opentaps();

	}

	@AfterMethod(description = "Close browser")
	public void closebrowser() {
		closeBrowser();
	}
*/
}
