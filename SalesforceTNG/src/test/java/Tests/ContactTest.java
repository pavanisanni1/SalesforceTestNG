package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.ContactPage;
import Utilities.PropertiesFile;

public class ContactTest extends BaseTest {
WebDriver driver;
ContactPage contactPage;
PropertiesFile prop;

@BeforeTest
public void BeforeMethod() {
	driver=getDriver();
	driver.manage().window().maximize();
	prop=new PropertiesFile();
    String url=prop.getProperty("url");
	driver.get(url);
	contactPage=new ContactPage(driver);
}
	
@Test
public void login() {
	String username=prop.getProperty("username");
	contactPage.enterusername(username);
	String password=prop.getProperty("password");
	contactPage.enterpassword(password);
	contactPage.eClick(contactPage.loginBtn);
	contactPage.eClick(contactPage.contactsTab);
}
	
//TC25
@Test
public void newContact() {
	login();
	contactPage.createnew();
}

//TC26
@Test
public void newView() {
	login();
	contactPage.newview();
}
	//TC27
@Test
public void checkUpdatedView() {
	login();	
}

//TC28
@Test
public void myContacts() {
	login();
	contactPage.mycontacts();
}

//TC29
@Test
public void contactsView() {
	login();
	contactPage.contactsview();
}

//TC30
@Test
public void errorMsg() {
	login();
	contactPage.errormsg();
}

//TC31
@Test
public void cancelCheck() {
	login();
	contactPage.cancelcheck();
}

//TC32
@Test
public void saveNew() {
	login();
	contactPage.savenew();
}

}
