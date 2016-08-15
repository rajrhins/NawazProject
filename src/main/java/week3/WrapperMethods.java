package week3;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class WrapperMethods  {

	RemoteWebDriver driver =null;

	public void launchapp(String browser, String url){
		try {
			if( browser.equalsIgnoreCase("firefox")){
				driver =new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("chrome")) {
				
			
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver =new ChromeDriver();			
			}

			//Maximise Firefox
			driver.manage().window().maximize();

			//Implicit wait(Default Timeout)
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			//Open URL
			driver.get(url);
		} catch (Exception e) {
			System.out.println("browser failed to lauch");
			
		}	
	}

	public void textByid(String id , String value){
		try {
			driver.findElementById(id).clear();
			driver.findElement(By.id(id)).sendKeys(value);
		} catch (NoSuchElementException e) {
			System.out.println("Failed to locate elemet"+id);
		}
	}
	
	public void clickByClassName(String value){
		try {
			driver.findElementByClassName(value).click();
		} catch (NoSuchElementException e) {
			System.out.println("Failed to locate elemet"+value);
		}
	}
	
	public boolean selectbyvisibletext_Byname(String name, String value) throws IOException{
	 boolean flag= false;
		int screenshotcount =1;
		try {
			Select dropdown1 = new Select(driver.findElementByName(name));
			List<WebElement> alloptions = dropdown1.getOptions();
			dropdown1.selectByVisibleText(value);
			int size=alloptions.size();
			
			for (WebElement everyoption : alloptions) {
				String text = everyoption.getText();
				System.out.println("Dropdowns 'options' are :" +text);
				}
			System.out.println("The size of the dropdown is :"+size);
		} catch (NoSuchElementException e) {
			
			System.out.println("The Element with id :"+name+"is not available");
		}
		finally{
			//Take snapshot
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
			screenshotcount++;
		}
		return flag;
		
	}
	public boolean selectbyvisibletext_Byid(String id, String value) throws IOException{
		 boolean flag= false;
			int screenshotcount =1;
			try {
				Select dropdown1 = new Select(driver.findElementById(id));
				List<WebElement> alloptions = dropdown1.getOptions();
				dropdown1.selectByVisibleText(value);
				int size=alloptions.size();
				
				for (WebElement everyoption : alloptions) {
					String text = everyoption.getText();
					System.out.println("Dropdowns 'options' are :" +text);
					}
				System.out.println("The size of the dropdown is :"+size);
			} catch (NoSuchElementException e) {
				
				System.out.println("The Element with id :"+id+"is not available");
			}
			finally{
				//Take snapshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
				screenshotcount++;
			}
			return flag;
			
		}
	public boolean selectbyvisibletext_Byclassname(String classname, String value) throws IOException{
		 boolean flag= false;
			int screenshotcount =1;
			try {
				Select dropdown1 = new Select(driver.findElementByClassName(classname));
				List<WebElement> alloptions = dropdown1.getOptions();
				dropdown1.selectByVisibleText(value);
				int size=alloptions.size();
				
				for (WebElement everyoption : alloptions) {
					String text = everyoption.getText();
					System.out.println("Dropdowns 'options' are :" +text);
					}
				System.out.println("The size of the dropdown is :"+size);
			} catch (NoSuchElementException e) {
				
				System.out.println("The Element with id :"+classname+"is not available");
			}
			finally{
				//Take snapshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
				screenshotcount++;
			}
			return flag;
			
		}
	public boolean selectbyvisibletext_Bytagname(String tagname, String value) throws IOException{
		 boolean flag= false;
			int screenshotcount =1;
			try {
				Select dropdown1 = new Select(driver.findElementByTagName(tagname));
				List<WebElement> alloptions = dropdown1.getOptions();
				dropdown1.selectByVisibleText(value);
				int size=alloptions.size();
				
				for (WebElement everyoption : alloptions) {
					String text = everyoption.getText();
					System.out.println("Dropdowns 'options' are :" +text);
					}
				System.out.println("The size of the dropdown is :"+size);
			} catch (NoSuchElementException e) {
				
				System.out.println("The Element with id :"+tagname+"is not available");
			}
			finally{
				//Take snapshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
				screenshotcount++;
			}
			return flag;
			
		}
	public boolean selectbyvisibletext_Byxpath(String xpath, String value) throws IOException{
		 boolean flag= false;
			int screenshotcount =1;
			try {
				Select dropdown1 = new Select(driver.findElementByXPath(xpath));
				List<WebElement> alloptions = dropdown1.getOptions();
				dropdown1.selectByVisibleText(value);
				int size=alloptions.size();
				
				for (WebElement everyoption : alloptions) {
					String text = everyoption.getText();
					System.out.println("Dropdowns 'options' are :" +text);
					}
				System.out.println("The size of the dropdown is :"+size);
			} catch (NoSuchElementException e) {
				
				System.out.println("The Element with id :"+xpath+"is not available");
			}
			finally{
				//Take snapshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
				screenshotcount++;
			}
			return flag;
			
		}
	public boolean selectbyvisibletext_Bycss(String css, String value) throws IOException{
		 boolean flag= false;
			int screenshotcount =1;
			try {
				Select dropdown1 = new Select(driver.findElementByClassName(css));
				List<WebElement> alloptions = dropdown1.getOptions();
				dropdown1.selectByVisibleText(value);
				int size=alloptions.size();
				
				for (WebElement everyoption : alloptions) {
					String text = everyoption.getText();
					System.out.println("Dropdowns 'options' are :" +text);
					}
				System.out.println("The size of the dropdown is :"+size);
			} catch (NoSuchElementException e) {
				
				System.out.println("The Element with id :"+css+"is not available");
			}
			finally{
				//Take snapshot
				File src = driver.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
				screenshotcount++;
			}
			return flag;
			
		}
	public void switchtowindows() throws IOException{
		int screenshotcount =1;

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
			// TODO Auto-generated catch block
			System.out.println("The window you are trying access is not available");
		}
		finally{
			//Take snapshot
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
			screenshotcount++;
		}
		}
    public String getParentWindowHandle() throws IOException{
    	
    	int screenshotcount =1;
    	String ParentWindow= null;;
		try {
			ParentWindow = driver.getWindowHandle();
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.out.println("The window you are trying access is not available");
		}
		finally{
			//Take snapshot
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
			screenshotcount++;
		}
    			return ParentWindow;
    }
    public void switchToFramesByIndex(int index) throws IOException{
    	
    	int screenshotcount =1;
    	try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.err.println("The Frame with index :"+index+"is not available");
		}
    	finally{
    		File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
			screenshotcount++;
    	}
    	
    }
    public void findFramesByTagName() throws IOException{
    	int screenshotcount =1;
    	try {
			List<WebElement> frames = driver.findElementsByTagName("iframe");
			int parentframe =frames.size();
			System.out.println("Total number of outer frame is :" + parentframe);
			
			for (WebElement frame1 : frames) {
			
				driver.switchTo().frame(frame1);
				List<WebElement> frames2= driver.findElementsByTagName("iframe");
				int framess= frames2.size();
				System.out.println("Total number of Inner frame is :"+ framess );
				driver.switchTo().defaultContent();
}
		} catch (NoSuchFrameException e) {
			System.err.println("The Frame is not available");
		}
    	finally{
    		File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Snapshot/snap"+screenshotcount+".jpeg"));
			screenshotcount++;
    	}
}
}


