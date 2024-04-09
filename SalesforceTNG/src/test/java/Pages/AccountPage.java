package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
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

	@FindBy(xpath="//a[@title='Accounts Tab']")
	WebElement accountsTab;
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newAccount;
	
	@FindBy(id="acc2")
	WebElement newAccName;
	
	@FindBy(id="acc6")
	WebElement techType;
	
	@FindBy(id="00Nbm00000055qI")
	WebElement priority;
	
	@FindBy(xpath="//input[@tabindex='34']")
	WebElement save;
	
	public void addAccount(String straccname,String strtechtype,String strpriority) {
		eClick(accountsTab);
		eClick(newAccount);
		newAccName.sendKeys(straccname);
		selectItem(techType,strtechtype);
		selectItem(priority,strpriority);
		eClick(save);
	}
	
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement newview;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="devname")
	WebElement uniqueview;
	
	@FindBy(xpath="//input[@data-uidsfdc=\"3\"]")
	WebElement viewsave;
	
	public void view(String strview,String strunique) {
		eClick(accountsTab);
		eClick(newview);
		viewname.sendKeys(strview);
		uniqueview.sendKeys(strunique);
		eClick(viewsave);
	}
	
	@FindBy(xpath="//select[@id='fcf']")
	WebElement viewEdit;
	
	@FindBy(xpath="//a[normalize-space()='Edit']")
	WebElement edit;
	
	@FindBy(xpath="//input[@id='fname']")
	WebElement changedview;
	
	@FindBy(xpath="//select[@id='fcol1']")
	WebElement fields;
	
	@FindBy(xpath="//select[@id='fop1']")
	WebElement operators;
	
	@FindBy(xpath="//input[@id='fval1']")
	WebElement value;
	
	@FindBy(xpath="//option[@value='SOCIAL_PERSONA_FACEBOOK']")
	WebElement availableFields;
	
	@FindBy(xpath="//a[@id='colselector_select_0_right']//img[@title='Add']")
	WebElement addBtn;
	
	@FindBy(xpath="//input[@data-uidsfdc='5']")
	WebElement saveBtn;
	
	public void editview(){
		eClick(accountsTab);				
		//Thread.sleep(3000);		
		selectItem(viewEdit,"Recently Added New View2");
		eClick(edit);
		changedview.sendKeys("Changed2 Recently Added New View2..");
		selectItem(fields,"Account Name");
		selectItem(operators,"contains");
		value.sendKeys("a");
		eClick(availableFields);
		eClick(addBtn);
		eClick(saveBtn);		
	}
	
	@FindBy(xpath="//a[contains(text(),'Merge Accounts')]")
	WebElement mergeLink;
	
	@FindBy(xpath="//input[@id='srch']")
	WebElement searchLetter;
	
	@FindBy(xpath="//div[@class='pbWizardBody']//input[2]")
	WebElement findAccounts;
	
	@FindBy(xpath="//input[@id='cid0']")
	WebElement acc1;
	
	@FindBy(xpath="//input[@id='cid1']")
	WebElement acc2;
	
	@FindBy(xpath="//div[@class='pbBottomButtons']//input[@title='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath="//div[@class='pbTopButtons']//input[@title='Merge']")
	WebElement mergeBtn;
	
	@FindBy(xpath="//select[@id='hotlist_mode']")
	WebElement views;
	
	public void merge(WebDriver driver){
		eClick(accountsTab);	
		eClick(mergeLink);
		searchLetter.sendKeys("te");
		eClick(findAccounts);
		if(!acc1.isSelected())eClick(acc1);
		if(!acc2.isSelected()) eClick(acc2);
		
		eClick(nextBtn);
		waitForElement(mergeBtn);
		eClick(mergeBtn);
		driver.switchTo().alert().accept();
		selectItem(views,"Recently Viewed");
	}
	
	@FindBy(xpath="//a[normalize-space()='Accounts with last activity > 30 days']")
	WebElement lastActivity;
	
	@FindBy(xpath="//img[@id='ext-gen148']")
	WebElement dateField;
	
	@FindBy(xpath="//div[contains(text(),'Created Date')]")
	WebElement createdDate;
	
	@FindBy(xpath="//img[@id='ext-gen152']")
	WebElement datePicker;
	
	@FindBy(xpath="//button[@id='ext-gen281']")
	WebElement todayDate;
	
	@FindBy(xpath="//input[@name='endDate']")
	WebElement endDate;
	
	@FindBy(xpath="//img[@id='ext-gen154']")
	WebElement sideClick;
	
	@FindBy(xpath="//button[@id='ext-gen61']")
	WebElement btn;
	
	@FindBy(xpath="//button[@id='ext-gen49']")
	WebElement saveBtn2;
	
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']")
	WebElement saveReport;
	
	@FindBy(xpath="//input[@name='reportDevName']")
	WebElement reportName;
	
	@FindBy(xpath="//button[contains(text(),'Save and Run Report')]")
	WebElement saveRun;
	
	public void createReport() throws InterruptedException {
		eClick(accountsTab);
		
		        //click on reports>30 days		
				eClick(lastActivity);				
				//click on datefield
				eClick(dateField);
				//select created date
				eClick(createdDate);				
		        //click on date picker
				eClick(datePicker);
		        //select today's date		
				eClick(todayDate);				
				
		       //click on date picker-not locating so sending value.			
				endDate.clear();
				eClick(sideClick);
				endDate.sendKeys("03/23/2024");
				eClick(btn);
				eClick(sideClick);				
				
				eClick(saveBtn2);//click save
				
				saveReport.sendKeys("Report8");
				reportName.sendKeys("Report8");
				//waitForElement(saveRun);//save and run
				Thread.sleep(4000);
				eClick(saveRun);
	}
	
}
