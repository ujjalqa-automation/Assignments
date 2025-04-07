package pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver=null;
	DataReader dr;
	public static ExtentReports extent;
	ExtentSparkReporter spark;
	
	
	@BeforeSuite
	public void setUp() throws IOException{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		if(driver==null){
			WebDriverManager.chromedriver().setup();
//			    ChromeOptions options = new ChromeOptions();
//			    options.addArguments("--remote-allow-origins=*");
//			    options.addArguments("--disable-extensions");
//
//			    // ✅ Use safe writable directory
//			    String userDataDir = System.getProperty("java.io.tmpdir") + "chrome-user-data";
//			    new File(userDataDir).mkdirs();
//			    options.addArguments("user-data-dir=" + userDataDir);
//
//			    // ✅ Optional cache dir
//			    String cacheDir = System.getProperty("java.io.tmpdir") + "chrome-cache";
//			    new File(cacheDir).mkdirs();
//			    options.addArguments("disk-cache-dir=" + cacheDir);

			     driver = new ChromeDriver();
			   

			
			dr=new DataReader();
			driver.get(dr.getUrl());
			System.out.println("Application launched properly");
			extent=new ExtentReports();
			spark=new ExtentSparkReporter("TestReport\\index.html");
			extent.attachReporter(spark);
			
		}
	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
	 
	// Here will compare if test is failing then only it will enter into if condition
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	// Create refernce of TakesScreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	// Call method to capture screenshot
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	// Copy files to specific location here it will save all screenshot in our project home directory and
	// result.getName() will return name of test case so that screenshot name will be same
	Files.copy(source.toPath(), new File("./Screenshots/"+result.getName()+".png").toPath());
	 
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	}
	
	
@AfterSuite
public void tearDown(){
	driver.close();
	driver=null;
	extent.flush();
}

}

