package nawaz;

import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class SelectExample extends WrapperMethods{
	
	@Test
	void salesforceDropdown(){
		launchDriver("https://developer.salesforce.com/signup?d=70130000000td6N", "chrome");
		//List<WebElement> ele=	driver.findElementsById("job_role");
		selectByVisibleIndex(By.id("job_role"), "Administrator");
		//selectByValue(By.id("job_role"), "IT Manager/Executive");
		//selectByIndex(By.id("job_role"), 2);
	}

}
