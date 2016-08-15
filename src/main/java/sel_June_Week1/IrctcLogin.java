package sel_June_Week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcLogin {

	public static void main(String[] args) throws InterruptedException {
		
		//Load Chrome driver and launch the browser ,maximize and with timeouts
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Load IRCTC signup page
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		//Load username using locator -ID 
		driver.findElementById("userRegistrationForm:userName").sendKeys("TestIrctc");
		
		//Click on Check availability using locator -ID
		driver.findElementById("userRegistrationForm:checkavail").click();
		
		//Wait time
		Thread.sleep(5000);

		//Load password and confirm password using locator -ID 
		driver.findElementById("userRegistrationForm:password").sendKeys("Test123");
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("Test123");
		
		//Select dropdown for secret question(Load Select Class to access dropdowns)
		Select Secretquestdropdown = new Select(driver.findElementById("userRegistrationForm:securityQ"));
		Secretquestdropdown.selectByIndex(7);
		
		//Fill the security answer (locator -ID )
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Maruthi");
		
		//Select dropdown for preferred lang(Load Select Class to access dropdowns)
		Select preflangdropdown = new Select(driver.findElementById("userRegistrationForm:prelan"));
		preflangdropdown.selectByValue("en");
		
		//Fill personal details(locator -ID )
		driver.findElementById("userRegistrationForm:firstName").sendKeys("Raj");
		driver.findElementById("userRegistrationForm:lastName").sendKeys("J");
		driver.findElementById("userRegistrationForm:gender:0").click();
		driver.findElementById("userRegistrationForm:maritalStatus:0").click();
		
		//Select dropdown for DOB(Load Select Class to access dropdowns)
		Select datedropdown = new Select(driver.findElementById("userRegistrationForm:dobDay"));
		datedropdown.selectByVisibleText("30");
		Select monthdropdown = new Select(driver.findElementById("userRegistrationForm:dobMonth"));
		monthdropdown.selectByVisibleText("MAY");
		Select yeardropdown = new Select(driver.findElementById("userRegistrationForm:dateOfBirth"));
		yeardropdown.selectByVisibleText("1986");
		
		//Select dropdown for Occupation(Load Select Class to access dropdowns)
		Select occdropdown = new Select(driver.findElementById("userRegistrationForm:occupation"));
		occdropdown.selectByVisibleText("Private");	
		
		//Fill emailid (locator -ID )
		driver.findElementById("userRegistrationForm:email").sendKeys("rajrhins@gmail.com");
		
		//Fill mobile (locator -ID )
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9841777777");
		
		//Select dropdown for Nationality(Load Select Class to access dropdowns)
	    Select natdropdown = new Select(driver.findElementById("userRegistrationForm:nationalityId"));
		natdropdown.selectByVisibleText("India");	
		
		//Fill doorno (locator -ID )
		driver.findElementById("userRegistrationForm:address").sendKeys("3/450A, D/G2, PaceEastApts");
		
		//Select dropdown for Occupation(Load Select Class to access dropdowns)
		Select countrydropdown = new Select(driver.findElementById("userRegistrationForm:countries"));
		countrydropdown.selectByVisibleText("India");	
		
		//Fill pincode & State (locator -ID )
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600037");
		driver.findElementById("userRegistrationForm:statesName").click();
		Thread.sleep(5000);
		
		//Select dropdown for City& PO(Load Select Class to access dropdowns)
		Select citydropdown = new Select(driver.findElementById("userRegistrationForm:cityName"));
		citydropdown.selectByVisibleText("Tiruvallur");
		Thread.sleep(5000);
		
		Select podropdown = new Select(driver.findElementById("userRegistrationForm:postofficeName"));
		podropdown.selectByVisibleText("Mogappair S.O");
				
		//Fill phone (locator -ID )
		driver.findElementById("userRegistrationForm:landline").sendKeys("044444444");
		driver.close();
	}

}
