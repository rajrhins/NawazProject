package week2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Secondwindow_close {

	public static void main(String[] args) {
		// Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		

		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// to get URL
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		String parentwindow = driver.getWindowHandle();
		//click contact us
		driver.findElementByLinkText("Contact Us").click();
		
		//Get windowhandle
		Set<String> whandles = driver.getWindowHandles();
		
		//switch to the secondwindow
		for (String whandle : whandles) {
			driver.switchTo().window(whandle);
			
		}
	     	     
	     //get url of the secondwindow
	     System.out.println(driver.getCurrentUrl());
	     
	  
	     driver.close();
	     
	     //switch to parent window
	     driver.switchTo().window(parentwindow);
	}
	

}
