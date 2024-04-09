package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;
import Utilities.PropertiesFile;

public class HomeTest extends BaseTest{
WebDriver driver;
HomePage homePage;
PropertiesFile prop;	

@BeforeMethod
public void BeforeMethod() {
	driver=getDriver();	
	driver.manage().window().maximize();
	prop=new PropertiesFile();
	String url=prop.getProperty("url");
	driver.get(url);
	homePage=new HomePage(driver);
}

//TC5
@Test
public void login() {
	String username=prop.getProperty("username");
	homePage.enterusername(username);
	String password=prop.getProperty("password");
	homePage.enterpassword(password);
	homePage.eClick(homePage.loginBtn);	
	homePage.eClick(homePage.navLabel);	
}

//TC6
@Test
public void addPhoto(){
	login();
	homePage.eClick(homePage.myProfile);	
	//homePage.contactAbout(driver);
	//homePage.post(driver);
	//homePage.fileUpload(driver);
	homePage.addPhoto(driver);
}

//TC7
@Test
public void calendar(){
	login();
	homePage.calendarPopup(driver);		
}	
//TC8
@Test
public void console() throws InterruptedException {
	login();
	homePage.developerConsole(driver);
}
//TC9
@Test
public void logout() throws InterruptedException {
	login();
	homePage.logout(driver);
}
}
