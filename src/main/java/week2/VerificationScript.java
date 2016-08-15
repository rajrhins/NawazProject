package week2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VerificationScript {

	public static void main(String[] args){

		// Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter URL - 
		driver.get("http://demo1.opentaps.org/opentaps/control/main");

		// Find the title of the browser
		System.out.println("Title : " + driver.getTitle());
//		Can compare using 
		if (driver.getTitle().contains("Opentaps")) {
			System.out.println("VERIFIED SUCCESSFULLY : Title contains 'Opentaps'");
		}

		// Find the current URL
		System.out.println("Current URL : " + driver.getCurrentUrl());

		// Find background color of opentaps login element
		System.out.println("BG Color : " + driver.findElementByTagName("h2").getCssValue("background-color"));

		// Find the destination URL for the 'Read all'
		System.out.println("Destination URL of Read All : " + driver.findElement(By.linkText("Read all")).getAttribute("href"));

		// Find the entered text on the user name
		driver.findElement(By.id("username1")).sendKeys("Kader",Keys.TAB);
		System.out.println("Entered Username : " + driver.findElement(By.id("username")).getAttribute("value"));
		
		// Find the size of the label: user name
		System.out.println("Size of the username label : " + driver.findElement(By.xpath("//*[@id='login']/p[1]/label")).getSize());
		System.out.println("Height of the username label : " + driver.findElement(By.xpath("//*[@id='login']/p[1]/label")).getSize().getHeight());
		
		// Find the position of the label: password
		System.out.println("Position of the password label : " + driver.findElement(By.xpath("//*[@id='login']/p[2]/label")).getLocation());
		System.out.println("X coordinate of the password label : " + driver.findElement(By.xpath("//*[@id='login']/p[2]/label")).getLocation().getX());
		
		// Get the tag name of the element
		System.out.println("Tag name of password field : " + driver.findElement(By.id("password")).getTagName());
		
		
		
	}
















}
