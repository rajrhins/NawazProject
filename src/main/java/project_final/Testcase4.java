package project_final;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Testcase4 extends ReadExcel_DataProvider {
	
	@Test(dataProvider ="exceldata")
	public void MergeLeads( String LeadId1, String LeadId2) throws InterruptedException, MalformedURLException {
		//, priority=4
		
		
		clickbyLinkText("Leads");
		clickbyLinkText("Merge Leads");
		String window = getParentWindowHandle();
		clickbyXpath("//img[@alt = 'Lookup']");
		Thread.sleep(3000);
		switchtowindows();
		enterTextByName("id", LeadId1);
		
		clickbyXpath("//button[contains (text(),'Find Leads')]");
		Thread.sleep(10000);
		clickbyXpath_B4ScreenShot("(//table/tbody/tr/td/div/a)[1]");
		
		switchWindow(window);
		clickbyXpath("(//img[@alt = 'Lookup'])[2]");
		Thread.sleep(3000);
		switchtowindows();
		enterTextByName("id", LeadId2);
		
		clickbyXpath("//button[contains (text(),'Find Leads')]");
		Thread.sleep(10000);
		clickbyXpath_B4ScreenShot("(//table/tbody/tr/td/div/a)[1]");
		switchWindow(window);
		clickbyLinkText_B4screenshot("Merge");
		Thread.sleep(3000);
		SwitchToAlert();
		AcceptAlert();
		clickbyLinkText("Find Leads");
		enterTextByName("id", LeadId1);
		clickbyXpath("//button[contains (text(),'Find Leads')]");
		Thread.sleep(10000);
		verifyTextEqualsByXpath("//div[@class='x-paging-info']", "No records to display");
	}

/*	@Parameters("browser")
	@BeforeMethod(description = "Launch the browser")

	public void remotebrowser(String browser) throws Exception {
		remoteLaunchDriver("http://demo1.opentaps.org/opentaps/control/main", browser);

		login_opentaps();

	}

	@AfterMethod(description = "Close browser")
	public void closebrowser() {
		closeBrowser();
	}*/

	@DataProvider(name = "exceldata")
	public Object[][] data() throws IOException {
		return exceldata("OpenTaps", 3);
	}
}
