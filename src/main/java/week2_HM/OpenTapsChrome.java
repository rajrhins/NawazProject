package week2_HM;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class OpenTapsChrome {

	public static void main(String[] args) throws InterruptedException {
		// Launch chrome browser
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();*/
		FirefoxDriver driver = new FirefoxDriver();

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

		//click on Leads
		driver.findElementByLinkText("Leads").click();

		//click on merge leads
		driver.findElementByLinkText("Merge Leads").click();

		//Click on From lead button(relative xpath)
		driver.findElementByXPath("//img[@alt = 'Lookup']").click();

		//Store parent window
		String parentwindow = driver.getWindowHandle();

		//to switch to second window, get window handles
		Set<String> whandles= driver.getWindowHandles();

		//Loop through the windows using for each and switch to the window
		for (String handle : whandles) {
			driver.switchTo().window(handle);
		}

		//Sendkeys ->lead id, locate the element by name
		driver.findElementByName("id").sendKeys("10005");

		//Click on Findleads,locate using relative XPath
		driver.findElementByXPath("//button[contains (text(),'Find Leads')]").click();

		//Click on the found lead
		driver.findElementByXPath("//a[contains (text(),'10005')]").click();

		//Switch to default window
		driver.switchTo().window(parentwindow);

		//Click on From lead button(relative xpath)
		driver.findElementByXPath("(//img[@alt = 'Lookup'])[2]").click();

		//to switch to second window, get window handles
		Set<String> whandles1= driver.getWindowHandles();

		//Loop through the windows using for each and switch to the window
		for (String handle1 : whandles1) {
			driver.switchTo().window(handle1);
		}

		//Sendkeys ->lead id, locate the element by name
		driver.findElementByName("id").sendKeys("10006");

		//Click on Findleads,locate using relative XPath
		driver.findElementByXPath("//button[contains (text(),'Find Leads')]").click();

		//Click on the lead , locate using relative XPath 
		driver.findElementByXPath("//a[contains (text(),'10006')]").click();

		//Switch to default window
		driver.switchTo().window(parentwindow);

		//click on merge,locate using LinkText
		driver.findElementByLinkText("Merge").click();
		
		//Verify the alert text
		if(driver.switchTo().alert().getText().contains("Are you sure?"))
		{
		System.out.println("Text 'Are you sure?' verified sucessfully");
		
		//Dismiss the alert 
		driver.switchTo().alert().dismiss();

		//close browser
		driver.close();

		
			
	}
		
		
	}

}
