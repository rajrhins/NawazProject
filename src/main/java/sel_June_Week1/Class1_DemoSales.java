package sel_June_Week1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Class1_DemoSales {

	public static void main(String[] args) {
		
		//Launch Firefox
		FirefoxDriver driver = new FirefoxDriver();

		//Open URL
		driver.get("http://demo1.opentaps.org/");
		
		//Maximise Firefox
		driver.manage().window().maximize();
		
		//Implicit wait(Default Timeout)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Enter Username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		
		//Click LoginButton
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Print Welcome Message
		System.out.println(driver.findElementByXPath("//*[@id='form']/h2").getText());
		
		//Print Title
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getTitle());

		driver.close();
	} //closing main method

}//closing class
