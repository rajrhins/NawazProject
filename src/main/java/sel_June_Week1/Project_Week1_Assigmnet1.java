package sel_June_Week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Project_Week1_Assigmnet1 {

	public static void main(String[] args) {
		// Launch firefox browser
		FirefoxDriver driver = new FirefoxDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		
		//load URL
		driver.get("http://demo1.opentaps.org/");
		
		//Wait(Sleep)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Login
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Access CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		
		//click on createlead
		driver.findElementByLinkText("Create Lead").click();
		
		//Fill Mandatory Info
		driver.findElementById("createLeadForm_companyName").sendKeys("JGTestleaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("JGTest");
		driver.findElementById("createLeadForm_lastName").sendKeys("Leaf");
		
		//Submit
		driver.findElementByName("submitButton").click();
		
		//print title
		System.out.println(driver.getTitle());
		
		//Print company Name 
		System.out.println(driver.findElementById("viewLead_companyName_sp").getText());
		
		//close browser
		driver.close();
        
		
		
	}

}
