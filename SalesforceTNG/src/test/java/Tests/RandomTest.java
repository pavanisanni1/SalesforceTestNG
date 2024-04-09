package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.RandomPage;
import Utilities.PropertiesFile;

public class RandomTest extends BaseTest{
WebDriver driver;
RandomPage randomPage;
PropertiesFile prop;

@BeforeTest
public void BeforeMethod() {
	driver=getDriver();
	driver.manage().window().maximize();
	prop=new PropertiesFile();
    String url=prop.getProperty("url");
	driver.get(url);
	randomPage=new RandomPage(driver);
}
	
@Test
public void login() {
	String username=prop.getProperty("username");
	randomPage.enterusername(username);
	String password=prop.getProperty("password");
	randomPage.enterpassword(password);
	randomPage.eClick(randomPage.loginBtn);	
}
	
//TC33
@Test
	public void userName() {
	login();
	randomPage.verifyuser();
}
	
//TC34
@Test
public void editLastname() throws InterruptedException {
	login();
	randomPage.editlastname();	
}

//TC35
@Test
public void allTab() {
	login();
	randomPage.alltab();
}

//TC36
@Test
public void blockEvent() {
	login();
	randomPage.blockevent();
}

//TC37
@Test
public void blockWeekly() {
	login();
	randomPage.blockweekly();
}
}
