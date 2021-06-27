package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest
{
	
	
//	@Test(groups = {"valid"},priority =1)
//	public void validLogin() throws InterruptedException
//	{
//		LoginPage login = new LoginPage(driver);
//		login.clickSignInButton();
//		login.enterUserEmail("9450007762");
//		Thread.sleep(2000);
//	}
	
	SoftAssert softAssertion=new SoftAssert();
	
	@Test(groups = {"valid"},priority =1)
	@Parameters({"validUserName"})
	public void validLogin(String userName) throws InterruptedException {
		extentTests=extent.startTest("valid scanario test");
		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		AssertJUnit.assertEquals("Amazon $ign-In", driver.getTitle());//HARD ASSERTION
		softAssertion.assertEquals("$ign-In", login.getHeaderText() ,"Sign-In title issue");//SOFT ASSERT
		extentTests.log(LogStatus.PASS,"valid scanerio test case passed successfully");
		login.enterUserEmail(userName);
		Thread.sleep(2000);
		softAssertion.assertAll();
	}
	
	@Test(groups= {"invalid"},priority =3)
	@Parameters({"invalidUserName"})
	public void invalidLogin(String userName) throws InterruptedException {
		extentTests=extent.startTest("invalid scanario test");
		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		extentTests.log(LogStatus.PASS,"invalid scanerio test case passed successfully");
		login.enterUserEmail(userName);
		Thread.sleep(2000);
	}
	
	@Test(groups= {"invalid"},priority =2)
	@Parameters({"invalidUserName1"})
	public void invalidLogin1(String userName) throws InterruptedException {
		extentTests=extent.startTest("invalid scanario1 test");
		LoginPage login = new LoginPage(driver);
		login.clickSignIn();
		extentTests.log(LogStatus.PASS,"invalid scanerio1 test case passed successfully");
		login.enterUserEmail(userName);
		Thread.sleep(2000);
	}
	

}
