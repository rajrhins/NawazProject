package sel_June_Week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;



public class OpenTapsChrome {

	public static void main(String[] args) {
		// Launch chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//Wait(Sleep)
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//load URL
		driver.get("http://demo1.opentaps.org/");
		
		
		
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
		String str = driver.findElementById("viewLead_companyName_sp").getText();
		String str1 = str.replaceAll("[^a-z A-Z]", "").trim();
		System.out.println(str1);
		boolean B= str1.equalsIgnoreCase("JGTestleaf");
		System.out.println(B);
		
		//close browser
		driver.close();
		
	}

}
