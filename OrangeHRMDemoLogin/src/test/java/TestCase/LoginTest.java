package TestCase;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage lp;
	
	
	@Test(priority=2,description="Verify user is able to login into the application")
	public void loginTest() throws InterruptedException{
		lp=new LoginPage(driver);
		lp.getUserName();
//		Thread.sleep(5000);
		lp.getPassword();
//		Thread.sleep(5000);
		lp.clickLogin();
//		Thread.sleep(5000);
		System.out.println("Login successful");
		
		
	}
	

}
