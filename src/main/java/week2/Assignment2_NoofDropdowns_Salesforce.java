package week2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2_NoofDropdowns_Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Chrome
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();

				// Maximize
				driver.manage().window().maximize();

				// Set timeouts
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		//load URL
		driver.get("https://developer.salesforce.com/signup?d=70130000000td6N");
		
		//click signup
		//driver.findElementByLinkText("Sign Up ›").click();
		
		//Find total number of dropdown in the signup page
		
		List<WebElement> dropdown = driver.findElementsByTagName("select");
		System.out.println("Total number of dropdowns in the page is : "+ dropdown.size());
		
		driver.close();

	}

}
