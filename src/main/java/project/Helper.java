package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Helper
{
	private static final WebElement WebElement = null;
	static WebDriver driver;
	
	
	
	public static WebDriver StartBrowser(String browserName,String url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			 driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Internet Explorer"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
	}
	
	public WebElement ByAllLocators(By by)
	{
		driver.findElement(by);
				return WebElement;
	}

}
