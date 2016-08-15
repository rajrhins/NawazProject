package week4;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



public class OpenTapsRules extends projectwrapper {
	@BeforeSuite
	public void launchBrowser(){
		launchDriver("http://demo1.opentaps.org/opentaps/control/main", "firefox");
	}
	@BeforeSuite
		public void logins(){
		login_opentaps();
}
	@AfterSuite
	public void closebrowser(){
		closeBrowser();
	}
		
	}


