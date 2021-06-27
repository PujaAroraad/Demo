package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

//	WebDriver driver;
//	public LoginPage(WebDriver driver)
//	{
//		PageFactory.initElements(driver,this);
//		this.driver=driver;
//	}
//	@FindBy(how=How.XPATH,using="//*[@id='nav-link-accountList']")
//	 public WebElement signIn;
//	
//	@FindBy(how = How.XPATH, using ="//input[@id='ap_email']") 
//	 public WebElement userName;
//	
//	public void clickSignInButton()
//	{
//		signIn.click();
//	}
//	
//	public void enterUserEmail(String userNameEmail) {
//		 userName.sendKeys(userNameEmail);
//	 }
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	
	 @FindBy(how = How.XPATH, using ="//*[@id='nav-link-accountList']") 
	 public WebElement signIn; 
	
	 @FindBy(how = How.ID, using ="ap_email") 
	 public WebElement userName; 
	 
	 @FindBy(how = How.XPATH, using ="//h1") 
	 public WebElement pageHeader; 
	 
	 public void clickSignIn(){
		 signIn.click();
	 }
	 
	 public void enterUserEmail(String userNameEmail) {
		 userName.sendKeys(userNameEmail);
	 }
	
	 public String getHeaderText() {
		 return  pageHeader.getText();
	 }
}
