package pages;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.DataReader;

public class LoginPage extends BaseClass {
	WebDriverWait wait;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//input[@name='username']")
private WebElement username;
@FindBy(xpath="//input[@name='password']")
private WebElement password;

@FindBy(xpath="//button[@type='submit']")
private WebElement login;

public void getUserName() throws InterruptedException{
	try {
		dr=new DataReader();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getCause());
	}
	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(username));
//	Thread.sleep(20000);
	username.sendKeys(dr.getUsername());
}

public void getPassword(){
	try {
		dr=new DataReader();
	} catch (IOException ex) {
		// TODO Auto-generated catch block
		System.out.println(ex.getCause());
	}
	password.sendKeys(dr.getPassword());
}

public void clickLogin(){
	login.click();
	
}
}
