package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class RandomPage extends BasePage{

	public RandomPage(WebDriver driver) {
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
	
	@FindBy(id="userNavLabel")
	WebElement usernav;
	
	@FindBy(xpath="//a[@title='My Profile']")
	WebElement myprofile;
	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	WebElement profilename;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath="(//a[@href='/_ui/core/userprofile/UserProfilePage'][normalize-space()='Pavani changed12'])[1]")
	WebElement userhome;
	
	public void verifyuser() {
		eClick(usernav);
		eClick(myprofile);
		String profileuser=profilename.getText();
		System.out.println("profile name from 'My Profile': "+profileuser);
		
		eClick(home);
		String user=userhome.getText();
		System.out.println(user+" user from Home page");
		eClick(userhome);
		
		if (profileuser.contains(user))
			System.out.println("same page from home and profile:pass");		
	}
	
	@FindBy(xpath="//img[@title='Edit Profile']")
	WebElement edituser;
	public void editlastname() throws InterruptedException {
		eClick(home);
		eClick(userhome);
		eClick(edituser);		
		abouttab();		
	}
	
	@FindBy(xpath="//img[@title='All Tabs']")
	WebElement alltabs;
	
	@FindBy(xpath="//input[@value='Customize My Tabs']")
	WebElement customizetabs;
	
	@FindBy(id="duel_select_1")
	WebElement tabs;
	
	@FindBy(xpath="//img[@title='Remove']")
	WebElement remove;
	
	@FindBy(xpath="//input[@name='save']")
	WebElement save;
	
	public void alltab() {
		eClick(alltabs);
		eClick(customizetabs);
		
		selectItem(tabs,"Libraries");
		eClick(remove);
		eClick(save);		
	}
	
	@FindBy(xpath="(//a[normalize-space()='Tuesday April 2, 2024'])[1]")
	WebElement datelink;
	
	@FindBy(xpath="//a[normalize-space()='8:00 PM']")
	WebElement event8;
	
	@FindBy(xpath="(//img[@title='Subject Combo (New Window)'])[1]")
	WebElement subjectcombo;
	
	public void blockevent() {
		eClick(home);
		eClick(datelink);
		eClick(event8);
		eClick(subjectcombo);
		combo_8();		
		waitForElement(enddate);
		eClick(enddate);
		eClick(datepicker_8);
		 eClick(saveBtn);
	}
	@FindBy(xpath="//a[normalize-space()='4:00 PM']")
	WebElement event4;
	
	@FindBy(xpath="//input[@id='EndDateTime_time']")
	WebElement enddate;
	
	@FindBy(xpath="//div[@id='timePickerItem_42']")
	WebElement datepicker_8;
	
	@FindBy(xpath="//input[@tabindex='14']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@id='timePickerItem_38']")
	WebElement datepicker_4;
	
	@FindBy(xpath="//input[@id='IsRecurrence']")
	WebElement checkrecurr;
	
	@FindBy(xpath="//input[@id='RecurrenceEndDateOnly']")
	WebElement recurrendonly;
	
	@FindBy(xpath="//img[@alt='Next Month']")
	WebElement rightarrow;
	
	@FindBy(xpath="//td[normalize-space()='10']")
	WebElement date;//click on april 10th
	
	@FindBy(xpath="//img[@alt='Month View']")
	WebElement monthview;
	
	public void blockweekly() {
		eClick(home);
		eClick(datelink);
		eClick(event4);
		eClick(subjectcombo);
		combo_4();
		waitForElement(enddate);
		eClick(enddate);
		eClick(datepicker_4);
		eClick(checkrecurr);
		recurrendonly.clear();
		eClick(recurrendonly);
		eClick(rightarrow);
		eClick(date);
		eClick(saveBtn);
		eClick(monthview);		
	}
	
}
