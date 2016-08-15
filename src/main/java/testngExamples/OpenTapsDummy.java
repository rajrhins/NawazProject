package testngExamples;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class OpenTapsDummy extends TestngAnnotations {
	@Test(invocationCount =2, threadPoolSize = 2, description = "CreateLead with two diff data")
	public void createLead() {
		System.out.println("Only in chrome browser for two different data");
		System.out.println("Clicked on Leads tab and Create lead is performed ");
	}
	
	@Test(enabled = false, description = "MergeLead")
	public void mergeLead() {
		System.out.println("Firefox: Clicked on Leads tab and Merge lead is performed");
	}
	
	@Test(dependsOnMethods = "createLead", timeOut =1000 ,description = "editLead" )
	public void editLead() {
		System.out.println("Firefox: Clicked on Leads tab and edit lead is performed");
	}

	@BeforeMethod(description = "Launch the browser")
	public void launchbrowser() {
		System.out.println("Browser is launched");
	}

	@BeforeMethod (description = "Login to OpenTaps and Click CRM/SFA")
	public void loginAndClick() {
		System.out.println("loggedin and CRM/SFA is clicked");

	}

	@AfterMethod(alwaysRun = true, description = "Logout Close Browser")
	public void afterMethod() {
		System.out.println("Loggedout and browser is closed");
	}

}
