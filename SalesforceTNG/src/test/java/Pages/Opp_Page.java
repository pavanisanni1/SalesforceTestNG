package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;

public class Opp_Page extends BasePage {

	public Opp_Page(WebDriver driver) {
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

	@FindBy(xpath="//a[@title='Opportunities Tab']")
	public WebElement oppTab;
	
	@FindBy(xpath="//select[@id='fcf']")
	WebElement selectOpp;
	
	public void selectOpp() {
		eClick(selectOpp);
	}
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newBtn;
	
	@FindBy(xpath="//input[@id='opp3']")
	WebElement input1;
	
	@FindBy(xpath="//input[@id='opp4']")
	WebElement input2;
	
	@FindBy(xpath="//input[@id='opp9']")
	WebElement input3;
	
	@FindBy(xpath="//a[@class='calToday']")
	WebElement calToday;
	
	@FindBy(xpath="//select[@id='opp11']")
	WebElement stages;
	
	@FindBy(xpath="//input[@id='opp12']")
	WebElement oppInput;
	
	@FindBy(xpath="//select[@id='opp6']")
	WebElement source;
	
	@FindBy(xpath="//input[@id='opp17']")
	WebElement oppName;
	
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	WebElement oppSave;
	
	public void createNewOpp() {
		eClick(newBtn);
		
		//input details for new opportunity
		input1.sendKeys("NewOpp2--");
		input2.sendKeys("One-one");
		eClick(input3);
		eClick(calToday);		
		
		selectItem(stages,"Needs Analysis");
		
		oppInput.sendKeys("");
	
		selectItem(source,"Partner Referral");
		
		oppName.sendKeys("DM Campaign to Top Customers - Nov 12-23, 2001");
		eClick(oppSave);
	}
	
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
	WebElement pipeline;
	
	public void pipelineReport() {
		eClick(pipeline);
	}
	
	@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]")
	WebElement stuckopp;
	public void stuck() {
		eClick(stuckopp);
	}
	
	@FindBy(xpath="//select[@id='quarter_q']")
	WebElement interval;
	
	@FindBy(xpath="//select[@id='open']")
	WebElement include;
	
	@FindBy(xpath="//input [@value='Run Report']")
	WebElement runReport;
	public void summaryReport() {
		selectItem(interval,"Next FQ");		
		selectItem(include,"Open Opportunities");
		eClick(runReport);
	}
	
}
