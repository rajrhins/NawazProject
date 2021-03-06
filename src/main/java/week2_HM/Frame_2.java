package week2_HM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Maximize
		driver.manage().window().maximize();

		// Set timeouts
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//load URL
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		
		driver.switchTo().frame("childIframe");
		driver.findElementByXPath("/html/body/div[2]/p/button").click();
		driver.switchTo().defaultContent();
		driver.findElementByXPath("/html/body/div[1]/p[1]/button").click();
		driver.switchTo().frame("childIframe");
		driver.findElementByXPath("/html/body/div[3]/p/button").click();
		driver.switchTo().defaultContent();
		driver.findElementByXPath("/html/body/div[2]/p/button").click();
		

	}

}
