package week2_HM;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import multiScreenShot.MultiScreenShot;

public class Popup_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

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
				System.out.println(driver.getCurrentUrl());
				
				//Get all the window Handles and loop through all windows using foreach
				Set<String> popups = driver.getWindowHandles();
				System.out.println(popups.size());
				MultiScreenShot m1 = new MultiScreenShot("./Snapshot/", "popup");
				
				for (String popup : popups) {
					
			    	if(!popup.equals(ParentWindow) ) {
			    		driver.switchTo().window(popup);
			    		String color= driver.findElementByTagName("body").getAttribute("bgcolor");
			    		if(!color.contains("#00C957"))
			    		{
			    		driver.close();}
			    	}
			    	
			    }
				Set<String> popups1 = driver.getWindowHandles();
				for (String popup : popups1) {m1.multiScreenShot(driver.switchTo().window(popup));
				System.out.println(driver.getCurrentUrl());
				}
				}
				
				/*m1.multiScreenShot(driver.switchTo().window(ParentWindow));
			    System.out.println(driver.getCurrentUrl());
			    driver.switchTo().window();*/
	}


