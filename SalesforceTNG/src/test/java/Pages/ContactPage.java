package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class ContactPage extends BasePage{

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
	
	@FindBy(xpath="//a[@title='Contacts Tab']")
	public WebElement contactsTab;
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newBtn;
	
	@FindBy(xpath="//input[@name='name_lastcon2']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='con4']")
	WebElement accname;
	
	@FindBy(xpath="//input[@class='btn']")
	WebElement saveBtn;
	
	public void createnew() {
		eClick(newBtn);
		lastname.sendKeys("ABCD2");
		accname.sendKeys("One-one");
		eClick(saveBtn);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
    WebElement newView;
	
	@FindBy(xpath="//input[@id='fname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='devname']")
	WebElement viewunique;
	
	@FindBy(xpath="//input[@class='btn primary' and @data-uidsfdc='3']")
	WebElement create;
	
	public void newview() {
		eClick(newView);
		fname.sendKeys("New View5");
		viewunique.sendKeys("");
		eClick(create);
	}

	@FindBy(xpath="//select[@title='View:']")
	WebElement mycontact;
	
	public void mycontacts() {
		selectItem(mycontact,"My Contacts");		
	}
	
	@FindBy(xpath="(//a[contains(text(),'ABCD2')])[1]")
	WebElement recentcontact;
	
	public void contactsview() {
		waitForElement(recentcontact);
		eClick(recentcontact);		
	}
		
	public void errormsg() {
		eClick(newView);
		viewunique.sendKeys("EFGH2");
		eClick(create);
	}
	
	@FindBy(xpath="(//input[@title='Cancel'])[1]")
	WebElement cancelBtn;
	
	public void cancelcheck() {
		eClick(newView);
		fname.sendKeys("XYZ--");
		viewunique.sendKeys("ABCD--");
		eClick(cancelBtn);
	}
	
	@FindBy(xpath="(//input[@title='Save & New'])[1]")
	WebElement savenewBtn;
	public void savenew() {
		eClick(newBtn);
		lastname.sendKeys("Indian---");
		accname.sendKeys("One-one");
		eClick(savenewBtn);
	}
	
}
