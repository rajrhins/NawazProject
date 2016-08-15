package nawaz;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class WrapperMethods {

	static RemoteWebDriver driver;
	// int sCount = 1;

	// Deepesh - 06/26/2016
	// Intitalizing the driver

	public void launchDriver(String URL, String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void selectByVisibleIndex(By by, String name) {
		Select dropdown = new Select(driver.findElement(by));
		List<WebElement> ele = dropdown.getOptions();
		System.out.println(ele.size());
		for (WebElement webElement : ele) {
			String options = webElement.getText();
			System.out.println(options);

		}
		dropdown.selectByVisibleText(name);
	}

	public void selectByValue(By by, String value) {
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByValue(value);
	}

	public void selectByIndex(By by, int value) {
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByIndex(value);
	}

}
