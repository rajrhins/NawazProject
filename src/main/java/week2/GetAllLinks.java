package week2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinks {

	public static void main(String[] args) throws IOException  {

		// Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Enter URL - 
		driver.get("http://www.crystalcruises.com/Calendar.aspx");
		
		// get all the elements with text - Get A Quote
		List<WebElement> allLinks =driver.findElements(By.linkText("Get-a-Quote"));
		
		//Find how many links are available with text - Get A Quote
		System.out.println("No of Links: " +allLinks.size());
		
		// Find the text and href of the first link
		System.out.println("Text of the link: "+allLinks.get(0).getText());
		System.out.println("href value: "+allLinks.get(0).getAttribute("href"));
		
		//print all the urls of all the get a quote links
		for (WebElement eachLink : allLinks) {
			System.out.println("Printing all the classNames: "+eachLink.getAttribute("class"));
		}
		
		// Find the name of the last link and click on it
		int size = allLinks.size();
		System.out.println(allLinks.get(size-1).getText());
		
		// take snapshot

		File snap = driver.getScreenshotAs(OutputType.FILE);

		// copy the file from memory to physical file

		FileUtils.copyFile(snap, new File("./Snapshot/snap1.jpeg"));
		
		
	}
}











