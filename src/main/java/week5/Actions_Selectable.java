package week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Selectable {

	public static void main(String[] args) {
		// Set the system properties
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

				// Launch Browser - Google Chrome
				ChromeDriver driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

				// Maximize the browser
				driver.manage().window().maximize();

				// Navigate to URL
				driver.get("http://jqueryui.com/selectable/");
				
				driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
				
				WebElement list1 =driver.findElementByXPath("//*[@id='selectable']/li[1]");
				WebElement list3 =driver.findElementByXPath("//*[@id='selectable']/li[3]");
				// find the first element
				Actions builder = new Actions(driver);
				
				builder.clickAndHold(list1).clickAndHold(list3).release().build().perform();
				

	}

}
