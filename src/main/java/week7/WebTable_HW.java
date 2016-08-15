package week7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable_HW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// FirefoxDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Navigate to the url
		driver.get("http://erail.in/");

		// Maximize the browser
		driver.manage().window().maximize();

		// Set default waiting time for finding an element (after the page
		// loads)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Enter Origin
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("txtStationFrom")));
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MAS", Keys.TAB);

		// Enter Destination
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("MYS", Keys.TAB);

		WebElement table = driver.findElementByXPath("//div[@id='divTrainsList']/table[1]");

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		int r = rows.size();

		 for (int i = 0; i < r; i++) {
			WebElement iRow = rows.get(i);
			List<WebElement> columns = iRow.findElements(By.tagName("td"));
			System.out.println(columns.get(0).getText());

		}
		driver.close();

	}

}
