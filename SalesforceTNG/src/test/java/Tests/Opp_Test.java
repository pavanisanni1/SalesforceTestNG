package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.AccountPage;
import Pages.Opp_Page;
import Utilities.PropertiesFile;

public class Opp_Test extends BaseTest {
WebDriver driver;
Opp_Page opp_Page;
PropertiesFile prop;

@BeforeTest
public void BeforeMethod() {
	driver=getDriver();
	driver.manage().window().maximize();
	prop=new PropertiesFile();
    String url=prop.getProperty("url");
	driver.get(url);
	opp_Page=new Opp_Page(driver);	
}
@Test
public void login() {
	String username=prop.getProperty("username");
	opp_Page.enterusername(username);
	String password=prop.getProperty("password");
	opp_Page.enterpassword(password);
	opp_Page.eClick(opp_Page.loginBtn);	
	opp_Page.eClick(opp_Page.oppTab);
	
}

//TC15
@Test
public void oppSelect() {
	login();
	opp_Page.selectOpp();
}
//TC16
@Test
public void createOpp() {
	login();
	opp_Page.createNewOpp();
}

//TC17
@Test
public void pipeline() {
	login();
	opp_Page.pipelineReport();
}

//TC18
@Test
public void stuckOpp() {
	login();
	opp_Page.stuck();
}

//TC19
@Test
public void summary() {
	login();
	opp_Page.summaryReport();
}
}
