package week2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search_name {

	public static void main(String[] args) throws InterruptedException, IOException {

      //To launch chrome driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//Load Google URL
		driver.get("https://www.google.co.in");
		//Get the title of the page(if else condition to verify title is google or not-later)
		 if(driver.getTitle().contains("google"));{
		 System.out.println("VERIFIED SUCCESSFULLY : Title contains 'google'");}
	
		//Load Name in the serach bar
		driver.findElementById("lst-ib").sendKeys("Karthikeyan",Keys.ENTER);
		Thread.sleep(10000);
		
		//Get all links
		List<WebElement> alllinks =driver.findElementsByTagName("a");
		
		System.out.println(alllinks.size());
		//Print Color
		System.out.println(alllinks.get(9).getCssValue("color"));
		
		//find first link which has length more than 20 
		for (WebElement firstlink : alllinks) {
		int size = firstlink.getText().length();
		if(size>20)
		{System.out.println("Size of the first link which is greater than 20 is : "+ firstlink.getText());
		break;
		}
		//Take snapshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Snapshot/snap2.jpeg"));
		
		
		
		}
		
		
		
		
		
		
	}

}
