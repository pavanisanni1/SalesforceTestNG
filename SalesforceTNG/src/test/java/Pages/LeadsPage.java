package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	@FindBy(id="username")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="Login")
	public WebElement loginBtn;
	
	public void enterusername(String strUsername) {
		username.sendKeys(strUsername);
	}

	public void enterpassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	
	@FindBy(xpath="//a[normalize-space()='Leads']")
	public WebElement leadsTab;
	
	@FindBy(xpath="//select[@id='fcf']")
	WebElement leads;
	
	public void leadsselect() {
		eClick(leads);
	}
	
	@FindBy(xpath="//input[@title='Go!']")
	WebElement goBtn;
	
	public void defaultview() {
		selectItem(leads,"My Unread Leads");
		logOut();		
	}
	public void go() {
		eClick(goBtn);
	}
	
	@FindBy(xpath="//select[@title='View:']")
	WebElement todayslead;
	
	public void todaysleads() {
		selectItem(todayslead,"Today's Leads");
	}
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newBtn;
	
	@FindBy(xpath="//input[@id='name_lastlea2']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='lea3']")
	WebElement company;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	WebElement saveBtn;
	
	public void addlead() {
		eClick(newBtn);
		lastname.sendKeys("ABCD1");
		company.sendKeys("ABCD1");
		eClick(saveBtn);
	}
	
	
}
