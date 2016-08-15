package project_final;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcase3 extends ReadExcel_DataProvider {

	@Test(dataProvider = "exceldata" )

	public void DeleteLead(String MobileNumber, String LeadId) throws IOException, InterruptedException {

		/*
		 * 3) Find by the phone number and delete - (In Chrome - 1 data) --
		 * Search by the Phone number -- Select the first resulting lead (Note
		 * the id) -- Click Delete -- Confirm that it is deleted by searching by
		 * id , priority=3
		 */
		
		clickbyLinkText("Leads");
		// Click Find leads
		clickbyLinkText("Find Leads");

		// Click on phone number
		clickbyXpath("//span[contains(text(),'Phone')]");

		// Enter phone number
		enterTextByName("phoneNumber", MobileNumber);

		// Click find leads button
		clickbyXpath("//button[contains(text(),'Find Leads')]");
		
		Thread.sleep(5000);

		LeadId = getTextByXpath("(//table/tbody/tr/td/div/a)[1]");
		

		// Click First Resulting lead - 10016
		
		clickbyXpath("(//table/tbody/tr/td/div/a)[1]");

		// Click on Delete button
		clickByClassName("subMenuButtonDangerous");

		// Click on FindLeads
		clickbyLinkText("Find Leads");

		// SendText to enter lead id 10016
		enterTextByName("id", LeadId);

		// Click find leads button
		clickbyXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);

		verifyTextEqualsByXpath("//div[@class='x-paging-info']", "No records to display");

	}

	@DataProvider(name = "exceldata")
	public Object[][] data() throws IOException {
		return exceldata("OpenTaps", 2);
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
	}*/

}
