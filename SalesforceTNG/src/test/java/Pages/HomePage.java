package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Base.BasePage;

public class HomePage extends BasePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="username")
	WebElement username;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="Login")
	public WebElement loginBtn;
	
	@FindBy(id="userNavLabel")
	public WebElement navLabel;
	
    @FindBy(xpath="//a[@title='My Profile']")
    public WebElement myProfile;
    
    @FindBy(xpath="//img[@title='Edit Profile']")
    WebElement contactEdit;
	
	public void enterusername(String strUsername) {
		username.sendKeys(strUsername);
	}

	public void enterpassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void eClick(WebElement e) {
		waitForElement(e);
		e.click();
	}
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveBtn;
	
	@FindBy(id="aboutTab")
	WebElement about;
	
	@FindBy(id="lastName")
	 WebElement lastName;
	
	public void contactAbout(WebDriver driver){
		waitForElement(contactEdit);
		eClick(contactEdit);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("number of frames:" +size);
				
		driver.switchTo().frame(3);
		waitForElement(about);	
		eClick(about);		
		
		waitForElement(lastName);	
		lastName.clear();		
		lastName.sendKeys("changed12");	
		
		eClick(saveBtn);
			 
		 //switch back to original
		 driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.id("tailBreadcrumbNode")).getText());
	}
	
	@FindBy(xpath="//span[contains(@class,'publisherattachtext') and text()='Post']")
	WebElement post;
	
	@FindBy(xpath="//body[@spellcheck='true']")
	WebElement postBox;
	
	@FindBy(xpath="//input[@name='publishersharebutton']")
	WebElement shareBtn;
	
	public void post(WebDriver driver){
		eClick(post);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		
		//switch to frame type and share
		driver.switchTo().frame(0);			
		waitForElement(postBox);	
		postBox.sendKeys("it is a check for post");
		driver.switchTo().defaultContent();
		
		waitForElement(shareBtn);
		eClick(shareBtn);
	}
	
	@FindBy(xpath="//span[contains(@class,'publisherattachtext') and text()='File']")
	WebElement fileLink;
	
	@FindBy(xpath="//a[@id='chatterUploadFileAction']")
	WebElement uploadFromComp;
	
	@FindBy(xpath="//input[@id='chatterFile']")
	WebElement selectFile;
	
	public void fileUpload(WebDriver driver){
		
		 //click on file link
		waitForElement(fileLink);
		eClick(fileLink);
		
		//click on upload button
		waitForElement(uploadFromComp);
	    eClick(uploadFromComp);
				
		//click on choose button
		selectFile.sendKeys("C:/test2.txt");
		eClick(shareBtn);
		
	}
	
	@FindBy(id="photoSection")
	WebElement photoHover;
	
	@FindBy(id="uploadLink")
	WebElement uploadLink;
		
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadInputFile'][1]")
	WebElement photoChoose;
	
	@FindBy(id="j_id0:uploadFileForm:uploadBtn")
	WebElement save;
	
	@FindBy(xpath="//input[@class=\"btn saveButton\"]")
	WebElement cropSave;		
	
	
	
	public void addPhoto(WebDriver driver){
		//hover on photo area
		Actions actions=new Actions(driver);
		actions.moveToElement(photoHover);
		//click on update link
		actions.moveToElement(uploadLink);
        actions.click().build().perform();
		
         //move to popup frame
        WebElement iframe=driver.findElement(By.id("uploadPhotoContentId"));
        driver.switchTo().frame(iframe);
        //send file to "choose file" button       
        photoChoose.sendKeys("C:/flower.jpg");
        //click save button
        waitForElement(save);
       eClick(save);   
        //crop and save the photo
        eClick(cropSave);		
	}
	
	/*public void selectItem(WebElement e,String visibleText) {
		Select options=new Select(e);
		options.selectByVisibleText(visibleText);
	}*/
	
	@FindBy(xpath="//a[@title='My Settings']")
	WebElement mySettings;
	
	@FindBy(id="PersonalInfo_font")
	WebElement personalTab;
	
	@FindBy(xpath="//span[contains(text(),'Login History')]")
	WebElement loginHistory;
	
	@FindBy(id="DisplayAndLayout_font")
	WebElement displayLayout;
	
	@FindBy(xpath="//span[@id='CustomizeTabs_font' and contains(text(),'Customize My Tabs')]")
	WebElement customiseMyTabs;
	
	@FindBy(xpath="//img[@alt='Add']")
	WebElement add;
	
	@FindBy(xpath="//select[@name='p4']")
	WebElement customApp;
	
	@FindBy(xpath="//select[@name='duel_select_0' and @id='duel_select_0']")
	WebElement availableTabs;
	
	@FindBy(id="EmailSetup_font")
	WebElement email;
	
	@FindBy(id="EmailSettings_font")
	WebElement emailSettings;
	
	@FindBy(xpath="//input[@id='sender_name' and @name='sender_name']")
	WebElement senderName;
	
	@FindBy(xpath="//input[@id='sender_email' and @name='sender_email']")
	WebElement senderEmail;
	
	@FindBy(xpath="//input[@type='submit' and @name='save']")
	WebElement submitSave;
	
	@FindBy(id="CalendarAndReminders_font")
	WebElement calendar;
	
	@FindBy(xpath="//span[@class='leafText' and contains(text(),'Activity Reminders')]")
	WebElement remainder;
	
	@FindBy(id="testbtn")
	WebElement testBtn;
	
	@FindBy(xpath="//a[@title='Developer Console (New Window)']")
	WebElement console;
	
	public void calendarPopup(WebDriver driver){
		//my settings from navlabel
		waitForElement(mySettings);
		eClick(mySettings);
		
		//personal tab
		waitForElement(personalTab);
		eClick(personalTab);
				
		waitForElement(loginHistory);
		eClick(loginHistory);
		
		//display & layout
		eClick(displayLayout);
		eClick(customiseMyTabs);		
		
		selectItem(customApp,"Salesforce Chatter");
		
		selectItem(availableTabs,"Reports");
		waitForElement(add);
		eClick(add);
		
		//email tab-my email settings
		eClick(email);
		eClick(emailSettings);
		senderName.clear();
		senderName.sendKeys("pavani_changed1");
		senderEmail.clear();
		senderEmail.sendKeys("pavanisanni@yahoo.com");		
		driver.findElement(By.xpath("//input[@id='auto_bcc1']")).click();
		eClick(submitSave);	
		
		//calendar popup
		eClick(calendar);
		eClick(remainder);
		eClick(testBtn);
	}
	
	//developer console	
	public void developerConsole(WebDriver driver) throws InterruptedException {
		eClick(console);
		Thread.sleep(3000);
		try {
		String parentWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows.size());
		for(String window:windows) {
			if (!window.equals(parentWindow)){
				driver.switchTo().window(window);
				break;
			}
		}		
		driver.close();
		System.out.println("pass:i closed the console");
		}
		catch(Exception E) {
			System.out.println("couldn't close the console");
		}
	}
	
	@FindBy(xpath="//a[@title='Logout']")
	WebElement logout;
	//logout
	public void logout(WebDriver driver) throws InterruptedException {
		eClick(logout);
		Thread.sleep(3000);
	       System.out.println(driver.getCurrentUrl());
	       String str=driver.getCurrentUrl();
	       if (str.contains("logout"))
		   System.out.println("pass:loggedout");
	}
		
	
}
