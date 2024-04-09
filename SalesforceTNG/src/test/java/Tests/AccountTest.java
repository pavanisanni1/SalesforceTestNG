package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.AccountPage;
import Utilities.PropertiesFile;

public class AccountTest extends BaseTest {
WebDriver driver;
AccountPage accountPage;	
PropertiesFile prop;

@BeforeTest
public void BeforeMethod() {
	driver=getDriver();
	driver.manage().window().maximize();
	prop=new PropertiesFile();
    String url=prop.getProperty("url");
	driver.get(url);
	accountPage=new AccountPage(driver);	
}

@Test
public void login() {
	String username=prop.getProperty("username");
	accountPage.enterusername(username);
	String password=prop.getProperty("password");
	accountPage.enterpassword(password);
	accountPage.eClick(accountPage.loginBtn);	
	//driver.findElement(By.xpath("//a[@title='Accounts Tab']")).click();
}

//TC10
@Test
public void addAccount() {
	login();
	String accname=prop.getProperty("accname");
	String techtype=prop.getProperty("techtype");
	String priority=prop.getProperty("priority");
	accountPage.addAccount(accname,techtype,priority);
}

//TC11
@Test
public void newView() {
	login();
	String view=prop.getProperty("view");
	String unique=prop.getProperty("unique");
	accountPage.view(view,unique);	
}

//TC12
@Test
public void editView(){
	login();	
	accountPage.editview();	
}

//TC13
@Test
public void mergeAccounts() {
	login();
	accountPage.merge(driver);
}

//TC14
@Test
public void report() throws InterruptedException {
	login();
	accountPage.createReport();
}
}
