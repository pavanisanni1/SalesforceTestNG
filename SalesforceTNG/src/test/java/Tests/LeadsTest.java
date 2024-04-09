package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LeadsPage;
import Utilities.PropertiesFile;

public class LeadsTest extends BaseTest{
WebDriver driver;
LeadsPage leadsPage;
PropertiesFile prop;

@BeforeTest
public void BeforeMethod() {
	driver=getDriver();
	driver.manage().window().maximize();
	prop=new PropertiesFile();
    String url=prop.getProperty("url");
	driver.get(url);
	leadsPage=new LeadsPage(driver);
}
//TC20
@Test
public void login() {
	String username=prop.getProperty("username");
	leadsPage.enterusername(username);
	String password=prop.getProperty("password");
	leadsPage.enterpassword(password);
	leadsPage.eClick(leadsPage.loginBtn);
	leadsPage.eClick(leadsPage.leadsTab);
}
	
//TC21
@Test
public void leadsDropdown() {
	login();
	leadsPage.leadsselect();
}

//TC22
@Test
public void defaultView() {
	login();
	leadsPage.defaultview();
	BeforeMethod();
	login();
	leadsPage.go();
}

//TC23
@Test
public void todaysLeads() {
	login();
	leadsPage.todaysleads();	
}

//TC24
@Test
public void newLead() {
	login();
	leadsPage.addlead();
}

}
