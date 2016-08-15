package week2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Week2_Assignment1_Editfields_Opentaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		

		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter URL - 
		driver.get("http://demo1.opentaps.org/opentaps/control/main");

		//Find all text fields in the page
		List<WebElement> txtfields= driver.findElementsByXPath("//input[@id='username' or @id='password']");
		//for (WebElement txtfield : txtfields) {
			int size = txtfields.size();
			System.out.println("Total number of text fields in the page: "+ size);
		
			driver.close();
	}

}
