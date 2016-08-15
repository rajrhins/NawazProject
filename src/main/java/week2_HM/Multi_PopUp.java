package week2_HM;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.Windows;

import multiScreenShot.MultiScreenShot;



public class Multi_PopUp {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		
		//Launch Browser
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();*/
		FirefoxDriver driver = new FirefoxDriver();
		
	

		//Maximize browser
		driver.manage().window().maximize();

		//Wait(Sleep)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//load URL
		driver.get("http://popuptest.com/");
		
		//Click on the "Multi-PopUp Test #2" link using LinkText
		driver.findElementByLinkText("Multi-PopUp Test #2").click();
		driver.findElementByXPath("/html/body/table[2]/tbody/tr/td/form/input").click();
		
		//Get the parentwindow handle and store in the String
		String ParentWindow = driver.getWindowHandle();
		
		//Get all the window Handles and loop through all windows using foreach
		Set<String> popups = driver.getWindowHandles();
		
		MultiScreenShot m1 = new MultiScreenShot("./Snapshot/", "popup");
		
	    for (String popup : popups) {
	    	if(!popup.equals(ParentWindow)){
	    		
	    		m1.multiScreenShot(driver.switchTo().window(popup));
	    		driver.close();
	    	}
	    }
	    
	    m1.multiScreenShot(driver.switchTo().window(ParentWindow));
	    System.out.println(driver.getCurrentUrl());

	}

}
