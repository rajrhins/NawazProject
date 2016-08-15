package week3;

import java.io.IOException;

import org.junit.Test;

public class OpenTapsLogin extends WrapperMethods{
@Test
	public void WrapperOpenTaps() throws IOException{
		launchapp("chrome", "https://developer.salesforce.com/");
		
		//click signup
		driver.findElementByLinkText("Sign Up ›").click();
		
		 boolean flag =selectbyvisibletext_Byid("job_role", "Administrator");
		 System.out.println(flag);
		
		
		
	}
}



	


