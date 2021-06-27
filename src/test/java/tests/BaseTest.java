package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTests;
	static File file = new File(".\\Resources\\config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite(groups= {"valid" , "invalid"})
	public void setExtent(){
		extent=new ExtentReports(".\\Reports\\ExtentReport1.html");
		
	}
	
	@AfterSuite(groups= {"valid" , "invalid"})
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	@BeforeMethod(groups= {"valid" , "invalid"})
	public static void intializeWebdriver() {

		System.setProperty("webdriver.chrome.driver",".\\\\Drivers\\\\chromeDriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod(groups= {"valid", "invalid"})
	public static void openBrowser() {

		//driver.get("https://www.amazon.com");
		driver.get(prop.getProperty("url"));

	}

	@AfterMethod(groups= {"valid", "invalid"})
	public static void closeBrowser() {
		extent.endTest(extentTests);
		driver.close();
	}
	

}
