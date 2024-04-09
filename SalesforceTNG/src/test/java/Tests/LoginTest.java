package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Utilities.PropertiesFile;
import Utilities.ScreenshotUtility;

public class LoginTest extends BaseTest{

	WebDriver driver;
	LoginPage loginPage;
	PropertiesFile prop;	
	ScreenshotUtility screen = new ScreenshotUtility();
	
	@BeforeMethod
	public void beforeMethod() {
		driver=getDriver();
		//driver.get("https://login.salesforce.com/");		
		prop=new PropertiesFile();
		String url=prop.getProperty("url");
		driver.get(url);		
		loginPage=new LoginPage(driver);
		
	}
	@AfterMethod
	public void teardown() {
		screen.takescreenshot(driver);
		//closeDriver();
	}
	
	//TC1
	@Test(priority=1)
	public void loginNopassword() {
	String username=prop.getProperty("username");
	loginPage.enterusername(username,loginPage.username);
	loginPage.eClick(loginPage.loginBtn);
	}
	
	//TC2
	@Test(priority=2)
	public void login() {
		String username=prop.getProperty("username");
		loginPage.enterusername(username,loginPage.username);
		String password=prop.getProperty("password");
		loginPage.enterpassword(password);
		loginPage.eClick(loginPage.loginBtn);
		closeDriver();
	}
	
	//TC3
	@Test
	public void loginWithUsernameSaved() {
		String username=prop.getProperty("username");
		loginPage.enterusername(username,loginPage.username);
		String password=prop.getProperty("password");
		loginPage.enterpassword(password);
		loginPage.eClick(loginPage.checkbox);		
		loginPage.eClick(loginPage.loginBtn);
		loginPage.eClick(loginPage.userLabel);
		loginPage.eClick(loginPage.logout);
		
	}
	
	//TC4a
	@Test
	public void forgotPassword() {
		loginPage.eClick(loginPage.forgotPassword);
		String username=prop.getProperty("username");		
		loginPage.enterusername(username,loginPage.forgot_pass);
		loginPage.eClick(loginPage.continue_btn);		
	}
	
	//TC4b
	@Test	
	public void wrongLogin() {
	loginPage.clear(loginPage.username);
    String username=prop.getProperty("wusername");	
	loginPage.enterusername(username,loginPage.username);	
	String password=prop.getProperty("wpassword");	
	loginPage.enterpassword(password);			
	loginPage.eClick(loginPage.loginBtn);
	}
	
}
