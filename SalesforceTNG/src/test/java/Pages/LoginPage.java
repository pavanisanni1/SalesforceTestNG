package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class LoginPage extends BasePage {
WebDriver driver;
public LoginPage(WebDriver driver) {
	super(driver);
}

@FindBy(id="username")
public WebElement username;

@FindBy(id="password")
WebElement password;

@FindBy(id="Login")
public WebElement loginBtn;

@FindBy(xpath="//input[@class='r4 fl mr8']")
public WebElement checkbox;

@FindBy(xpath="//a[@title='Logout']")
public WebElement logout;

public void enterusername(String strUsername,WebElement e) {
	//username.sendKeys("pavani@lta.com");
	e.sendKeys(strUsername);
}

public void enterpassword(String strPassword) {
	//password.sendKeys("password123");
	password.sendKeys(strPassword);
}

public void eClick(WebElement e) {
	waitForElement(e);
	e.click();
}
public void clear(WebElement e) {
	e.clear();
}

@FindBy(id="userNavLabel")
public WebElement userLabel;

@FindBy(id="forgot_password_link")
public WebElement forgotPassword;

@FindBy(id="un")
public WebElement forgot_pass;

@FindBy(xpath="//input[@type='submit']")
public WebElement continue_btn;
}
