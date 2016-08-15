package sel_June_Week1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Class2_Dropdown_Salesforce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Launch firefox browser
				//FirefoxDriver driver = new FirefoxDriver();
		// Chrome
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
				
				
				
				//Maximize browser
				driver.manage().window().maximize();
				//Wait(Sleep)
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				
				//load URL
				driver.get("https://developer.salesforce.com/");
				
				//click signup
				driver.findElementByLinkText("Sign Up ›").click();
				
				//select role  dropdown
				Select dropdown = new Select(driver.findElementById("job_role"));
				
				dropdown.selectByVisibleText("Administrator");
				
				
				List<WebElement> alloptions1 = dropdown.getOptions();
				
				
			    //select last country
				Select dropdown1 = new Select(driver.findElementById("country"));
				List<WebElement> alloptions = dropdown1.getOptions();
				int value	= alloptions.size()-1;
				dropdown1.selectByIndex(value);

				
				for (WebElement everyoption : alloptions1) {
					System.out.println(everyoption.getText());
					}
				
				
			
	}

}
