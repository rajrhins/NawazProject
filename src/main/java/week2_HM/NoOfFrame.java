package week2_HM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoOfFrame {
	

	public static void main(String[] args) throws InterruptedException {
		// Launch chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

		//Wait(Sleep)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//load URL
		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html");

		//Find iframe by tagname locator
		List<WebElement> frames = driver.findElementsByTagName("iframe");
		int parentframe =frames.size();
		System.out.println("Total number of outer frame is :" + parentframe);
		int X=0;
		for (WebElement frame1 : frames) {
		
			driver.switchTo().frame(frame1);
			List<WebElement> frames2= driver.findElementsByTagName("iframe");
			int framess= frames2.size();
			System.out.println("Total number of Inner frame is :"+ framess );
			X=framess+X;
			driver.switchTo().defaultContent();
			
		}
		System.out.println("Total number of frames is :");
		System.out.print(X+parentframe);

		
	}

}
