package week4;

import java.io.IOException;

import org.testng.annotations.Test;

public class OpenTaps {

	public class CreateLead extends OpenTapsRules{
		
		//Launch Browser
		
		@Test(invocationCount =2)
		public void login() throws IOException{
			
			
		
	    clickbyLinkText("Create Lead");
		enterTextById("createLeadForm_companyName", "Caffefills");
		
		enterTextById("createLeadForm_firstName","Govindaraja");
		enterTextById("createLeadForm_lastName","J");
		selectbyvisibletext_Byid("createLeadForm_dataSourceId", "Conference");
		selectbyindex_Byid("createLeadForm_marketingCampaignId",2);
		enterTextById("createLeadForm_primaryPhoneNumber","98417777777");
		
		enterTextById("createLeadForm_primaryEmail","test@gmail.com");
		
		clickByClassName("smallSubmit");
		//getTextByclassName("tabletext");
		
		String rt = getTextById("viewLead_companyName_sp").substring(12, 17);
		
	    System.out.println(rt);

	 
	    

	    
	}
	}
	public class DeleteLead extends OpenTapsRules {

		@Test(enabled = false)

		public void main() throws IOException, InterruptedException {

			/*
			 * 3) Find by the phone number and delete - (In Chrome - 1 data) --
			 * Search by the Phone number -- Select the first resulting lead (Note
			 * the id) -- Click Delete -- Confirm that it is deleted by searching by
			 * id
			 */


			// Click Find leads
			clickbyLinkText("Find Leads");

			// Click on phone number
			clickbyXpath("//span[contains(text(),'Phone')]");

			// Enter phone number
			enterTextByName("phoneNumber", "9790787600");

			// Click find leads button
			clickbyXpath("//button[contains(text(),'Find Leads')]");

			// Click First Resulting lead - 10016
			clickbyLinkText("10057");

			// Click on Delete button
			clickByClassName("subMenuButtonDangerous");

			// Click on FindLeads
			clickbyLinkText("Find Leads");

			// SendText to enter lead id 10016
			enterTextByName("id", "10057");

			// Click find leads button
			clickbyXpath("//button[contains(text(),'Find Leads')]");
			Thread.sleep(10000);

			// takeScreenshot
			Screenshot();

			// Close
	//		closeBrowser();

		}
		public class EditLead extends OpenTapsRules {
			/*
			 * Find by First Name and Edit - (In Chrome - 2 data) -- Search by the first
			 * name -- Select the first resulting lead -- Confirm the title of the view
			 * lead page -- Click Edit -- Change the source to another value -- Change
			 * the marketing campaign -- Update and confirm that it changed
			 */

			@Test
			public void projectWrapper() throws IOException {
				// Initialize and Login into Website
				
				// Clicking on findLeads Tab
				clickbyXpath("(//a[@href='/crmsfa/control/findLeads'])");
				// Finding lead by entering first name and clicking on FindLeads button
				enterByTextXpath("(//input[@name='firstName'])[3]", "Govind");
				clickbyXpath("//button[contains(text(),'Find Leads')]");
				// Selecting the first input in the given list
				clickbyXpath("(//a[@class='linktext'])[4]");
				// Verifying title
				verifyTitle("Find Leads | opentaps CRM");
				// Editing the details of Lead
				clickbyXpath("//a[contains(text(),'Edit')]");
				// Change the source
				selectByValue_UsingId("addDataSourceForm_dataSourceId", "LEAD_EMPLOYEE");
				// Click Add
				clickbyXpath("(//input[@value='Add'])[1]");
				// Change the marketing campaign
				selectbyvisibletext_Byid("addMarketingCampaignForm_marketingCampaignId",
						"Catalog Generating Marketing Campaigns");
				// Click Add
				clickbyXpath("(//input[@value='Add'])[2]");
				// Click Update
				clickbyXpath("(//input[@value='Update'])");
				// Confirm added source
				verifyTextContainsById("viewLead_dataSources_sp", "Employee");
				// Confirm added marketing campaign
				verifyTextContainsById("viewLead_marketingCampaigns_sp", "Catalog Generating Marketing Campaigns");
			}
		}
	}
	public class EditLead extends OpenTapsRules {
		/*
		 * Find by First Name and Edit - (In Chrome - 2 data) -- Search by the first
		 * name -- Select the first resulting lead -- Confirm the title of the view
		 * lead page -- Click Edit -- Change the source to another value -- Change
		 * the marketing campaign -- Update and confirm that it changed
		 */

		@Test
		public void projectWrapper() throws IOException {
			// Initialize and Login into Website
			
			// Clicking on findLeads Tab
			clickbyXpath("(//a[@href='/crmsfa/control/findLeads'])");
			// Finding lead by entering first name and clicking on FindLeads button
			enterByTextXpath("(//input[@name='firstName'])[3]", "Govind");
			clickbyXpath("//button[contains(text(),'Find Leads')]");
			// Selecting the first input in the given list
			clickbyXpath("(//a[@class='linktext'])[4]");
			// Verifying title
			verifyTitle("Find Leads | opentaps CRM");
			// Editing the details of Lead
			clickbyXpath("//a[contains(text(),'Edit')]");
			// Change the source
			selectByValue_UsingId("addDataSourceForm_dataSourceId", "LEAD_EMPLOYEE");
			// Click Add
			clickbyXpath("(//input[@value='Add'])[1]");
			// Change the marketing campaign
			selectbyvisibletext_Byid("addMarketingCampaignForm_marketingCampaignId",
					"Catalog Generating Marketing Campaigns");
			// Click Add
			clickbyXpath("(//input[@value='Add'])[2]");
			// Click Update
			clickbyXpath("(//input[@value='Update'])");
			// Confirm added source
			verifyTextContainsById("viewLead_dataSources_sp", "Employee");
			// Confirm added marketing campaign
			verifyTextContainsById("viewLead_marketingCampaigns_sp", "Catalog Generating Marketing Campaigns");
		}
	}
	public class MergeLead extends OpenTapsRules {
		
		@Test
		public void demoTaps() throws IOException, InterruptedException{
			
			
			clickbyLinkText("Merge Leads");
		    String window = getParentWindowHandle();
			clickbyXpath("//img[@alt = 'Lookup']");
			switchtowindows();
			enterTextByName("id", "10265");
			clickbyXpath("//button[contains (text(),'Find Leads')]");
			Thread.sleep(3000);
			clickbyXpath("//a[contains (text(),'10265')]");
			Thread.sleep(3000);
			switchWindow(window);
			clickbyXpath("(//img[@alt = 'Lookup'])[2]");
			switchtowindows();
			enterTextByName("id", "10052");
			Thread.sleep(3000);
			clickbyXpath("//button[contains (text(),'Find Leads')]");
			Thread.sleep(3000);
			clickbyXpath("//a[contains (text(),'10052')]");
			switchWindow(window);
			clickbyLinkText("Merge");
			SwitchToAlert();
			AcceptAlert();
			clickbyLinkText("Find Leads");
			enterTextByName("id", "10265");
			clickbyXpath("//button[contains (text(),'Find Leads')]");
			Thread.sleep(10000);
	        verifyTextEqualsByXpath("//div[@class='x-paging-info']", "No records to display");
		}

	}
}
