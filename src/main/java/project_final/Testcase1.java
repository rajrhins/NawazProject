package project_final;

import java.io.IOException;

import org.hamcrest.core.SubstringMatcher;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Testcase1 extends ReadExcel_DataProvider {
	int i=0;
	// Launch Browser ,priority=1

	@Test(dataProvider ="exceldata")
	public void CreateLead(String CompanyName, String FirstName ,String LastName, String SourceId, String MobileNumber,String eMail ) throws IOException, InterruptedException {
		
		
			
			clickbyLinkText("Create Lead");
			enterTextById("createLeadForm_companyName", CompanyName);
			enterTextById("createLeadForm_firstName", FirstName);
			enterTextById("createLeadForm_lastName", LastName);
			selectbyvisibletext_Byid("createLeadForm_dataSourceId", SourceId);
			selectbyindex_Byid("createLeadForm_marketingCampaignId", 2);
			enterTextById("createLeadForm_primaryPhoneNumber", MobileNumber);
			enterTextById("createLeadForm_primaryEmail", eMail);
			clickByClassName("smallSubmit");
			String rt1 = getTextById("viewLead_companyName_sp");
			String rt2= removebrace(rt1);
			System.out.println(rt2);
			excelWrite("OpenTaps", 3, 1, i, rt2);
			i++;
			
			
		
	}
		

	
	@DataProvider(name= "exceldata")
	public Object[][] data() throws IOException{
		return exceldata("OpenTaps", 0);
	}
	
	
	
}
