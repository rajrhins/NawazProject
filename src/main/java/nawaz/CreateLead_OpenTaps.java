package nawaz;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead_OpenTaps 
{

	@Test(dataProvider="test")
	public void setup(String companyname,String firstname,String lastname)
	{
		RemoteWebDriver driver = new FirefoxDriver();
		
		driver.get("http://demo1.opentaps.org/");
		
		//Login
				driver.findElementById("username").sendKeys("DemoSalesManager");
				driver.findElementById("password").sendKeys("crmsfa");
				driver.findElementByClassName("decorativeSubmit").click();

				//Access CRM/SFA
				driver.findElementByLinkText("CRM/SFA").click();

				//click on Leads
				driver.findElementByLinkText("Leads").click();

				//Create Lead
				driver.findElementByLinkText("Create Lead").click();
				
				driver.findElementById("createLeadForm_companyName").sendKeys(companyname);
				
				driver.findElementById("createLeadForm_firstName").sendKeys(firstname);
				
				driver.findElementById("createLeadForm_lastName").sendKeys(lastname);
				
				driver.findElementByXPath("//input[@name='submitButton']").click();
				
		
		
		
	}
	
	@DataProvider(name="test")
	public Object[][] getData()
	{
		Object[][] obj=new Object[1][3];
		
	obj[0][0]="xyz";
	obj[0][1]="abc";
	obj[0][2]="mno";
		
		return obj;
	}
}
