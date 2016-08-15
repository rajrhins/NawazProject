package week2;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingWindows {

	public static void main(String[] args){

		// Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter URL - 
		driver.get("http://www.crystalcruises.com/");
		
		//storing window handle of the parent window
		String parentWindowHandle = driver.getWindowHandle();
		
		// clicking on GUEST CHECK-IN link
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		
		// Getting all window handles of open windows
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println("Total number of windows : " + handles.size());
		
		System.out.println("Title before switching through windows : " + driver.getTitle());
		
		//>> Current focus is on the first window
		
		//looping through all window handles in 'handles'
		for (String wHandle : handles) {
			driver.switchTo().window(wHandle);
		}
		
		//>> Current focus is on the second window
		System.out.println("Title after switching through windows : " + driver.getTitle());
		
		//switching back to the first window
		driver.switchTo().window(parentWindowHandle);
		
		//>> Current focus is on the first window
		System.out.println("Title after switching back to the first window : " + driver.getTitle());
		
		
		
		//close all open windows opened during the test run
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
	}
















}
