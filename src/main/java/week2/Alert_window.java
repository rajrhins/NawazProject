package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_window {

	public static void main(String[] args) {
		
		// Chrome
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				
				

				// Maximize
				driver.manage().window().maximize();

				// Set timeouts
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				// to get URL
				driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
				
				//switch to frame
				driver.switchTo().frame("iframeResult");
				
				//click try it button
				driver.findElementByXPath("/html/body/button").click();
				
				//swicth to alert 
				driver.switchTo().alert().dismiss();
				
				//confirm the text contains "You pressed cancel"
				if(driver.findElementById("demo").getText().contains("You pressed Cancel!"));
				{
					System.out.println("Verified successfully that text is 'you pressed cancel'");
					
				}
	
				
				

	}

}
