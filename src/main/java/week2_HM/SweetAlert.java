package week2_HM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class SweetAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

		//Wait(Sleep)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//load URL
		driver.get("http://t4t5.github.io/sweetalert/");

		driver.findElementByXPath("/html/body/div[1]/button").click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		
		driver.findElementByXPath("/html/body/div[2]/button").click();
		
		Thread.sleep(5000);
		System.out.println(driver.findElementByXPath("/html/body/div[6]").getText());
		
		driver.findElementByXPath("/html/body/div[6]/div[7]/div/button").click();
		
		
		
		
		
	}

}
