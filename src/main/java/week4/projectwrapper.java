package week4;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class projectwrapper extends WrapperMethods{
	
	
	//RemoteWebDriver driver;
	//int sCount = 1;

	// Deepesh - 06/26/2016
	//Intitalizing the driver
	
	public void launchDriver(String URL, String browser){
		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	//Screenshot Method

	public void Screenshot() {

		//Take snapshot
		File ScreenShot = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(ScreenShot, new File("./Snapshots/snap"+ System.currentTimeMillis()+".jpeg"));
		} catch (IOException e) {
			System.out.println("IOException catched");
		}
		

	}

	//Method to find element by CLASSNAME and click

	
	public void switchtowindows() {
		

		try {
			Set<String> whandles = driver.getWindowHandles();
			
			//switch to the secondwindow
			for (String whandle : whandles) {
				driver.switchTo().window(whandle);
	//get url of the secondwindow
			     //System.out.println(driver.getCurrentUrl());
				 //System.out.println(driver.getTitle());
				//driver.close();
				  
			}
		} catch (NoSuchWindowException e) {
			
			System.out.println("The window you are trying access is not available");
		}
		finally{
			//Take snapshot
			Screenshot();
		}
		}
    public String getWindowHandle() {
    	
    	
    	String ParentWindow= null;;
		try {
			ParentWindow = driver.getWindowHandle();
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("The window you are trying access is not available");
		}
		finally{
			Screenshot();
		}
    			return ParentWindow;
    			
    }

    
    public void switchWindow(String winHandle) {

		try {
			driver.switchTo().window(winHandle);
		} catch (NoSuchWindowException e) {
			System.err.println("Target Window -"+winHandle+" not found");		}

		finally{
			Screenshot();
		}
	}
	public void SwitchToAlert() {
        try {
                        driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
                        System.err.println("issue with handling alert");
        }
        finally
        {
                     //   Screenshot();
        }
}
	public void AcceptAlert() {
        try {
                        driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
                        System.err.println("issue with handling alert");
        }
        finally
        {
                       // Screenshot();
        }

	}
	public boolean verifyTextEqualsByXpath(String Xpath, String Text) {
		boolean flag = false;
		try {
			String ActualText = driver.findElementByXPath(Xpath).getText();
			if (ActualText.equals(Text)){
				System.out.println("Text matches!");
			}
			else {
				System.out.println("Text doesnt match.");
			}
		} catch (NoSuchElementException e) {
			System.err.println("The element with Xpath - "+Xpath+" not found.");	
		}
		finally
		{
			Screenshot();
		}
		return flag;
}

	public void closeBrowser() 
	{
		try {
			driver.close();

		} catch (WebDriverException e) {
			System.out.println("Unable to close the browser...");
		}
		finally{
			Screenshot();
		}
	}
		public void login_opentaps() {

			
			//launchDriver("http://demo1.opentaps.org/opentaps/control/main", browser);
			enterTextById("username", "DemoSalesManager");
			enterTextById("password", "crmsfa");
			clickByClassName("decorativeSubmit");
			clickbyLinkText("CRM/SFA");
			clickbyLinkText("Leads");
			
			

			

		}

		public String getattributevalue(String xpath, String att)
		{
			String str= null;
			try {
				str = driver.findElementByXPath(xpath).getAttribute(att);
			} catch (NoSuchElementException e) {
				System.err.println("The element with Xpath - "+xpath+" not found.");	
			}
			finally
			{
				Screenshot();
			}
			return str;
		}

	}