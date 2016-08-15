package project;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends Helper
{
	//WebDriver driver;
	
	@Test
	public void checkLogin()
	{
		StartBrowser("chrome","http://ezeepayservices.in:8086/ezeepayJdbc/");
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//div[@class='buttons']//a")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Nawaz");
		
		driver.findElement(By.name("password")).sendKeys("zeeshan");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println(driver.getTitle());
	
	
	
	//@Test
	//public void MainPage()
	//{
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[@id='txn']"))).build().perform();
		
		                                                                                         
		
		
		
		//"xpath", "//a[@id='txn']"
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='txnList']")));
		action.moveToElement(driver.findElement(By.xpath("//a[@id='txnList']"))).click().build().perform();
		
		
		//ele1.clear();
		
		driver.findElement(By.id("chk_txn")).click();
		driver.findElement(By.id("srch_txn_id")).sendKeys("asdfg12345");
		if(driver.findElement(By.id("srch_txn_id")).getAttribute("value").equalsIgnoreCase("asdfg12345")){
			System.err.println("Value entered in TransactionID matches the input");
		}
		
	}
	
	/*@AfterTest
	public void tearDown()
	{
		//driver.close();
		
		
	}*/
	
}