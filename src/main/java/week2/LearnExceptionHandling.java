package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class LearnExceptionHandling {
	public static void main(String[] args) throws InterruptedException,
			Exception {

		// Compile time / checked exception
		Thread.sleep(3000);

		// Run time exception
		// eg. NoSuchElementException

		// Older Code >>>>
		// Declare driver as a ChromeDriver
		ChromeDriver driver = null;

		try {
			// IllegalStateException -> if exe is missed in the driver path.
			// IllegalStateException -> if system property case is not proper.
			System.setProperty("webdriver.chrome.driver",
					"./drivers/chromedriver.exe");

			// initializing chrome driver and assigning it to driver
			driver = new ChromeDriver();

		} catch (Exception e) {
			// Handle or ignore the exception
			// System.out.println("Wrong chrome driver settings");

			// Throw a new exception
			throw new Exception("Inform Karim");
		}

		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter URL -
		driver.get("http://demo1.opentaps.org/opentaps/control/main");

		// Find the title of the browser
		System.out.println("Title : " + driver.getTitle());

		// #try-multi catch blocks
		try {
			/*
			 * Possible exceptions with the below line of code >
			 * NoSuchElementException > ElementNotVisibleException >
			 * UnreachableBrowserException
			 */
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		} catch (NoSuchElementException e) {
			System.out.println("Element not found");
		} catch (ElementNotVisibleException e) {
			System.out.println("Element not visible");
		} catch (UnreachableBrowserException e) {
			System.out.println("Browser not reachable");
		} catch (WebDriverException e) {
			// Super class for all selenium exceptions
			System.out.println("unknown browser exception");
		}

		// #try-catch-finally blocks

		try {
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		} catch (NoSuchElementException e) {
			System.out.println("Element not found");
		} finally {
			// Code for taking screenshots
			// Executes in case of pass or failure
		}

	}
}
