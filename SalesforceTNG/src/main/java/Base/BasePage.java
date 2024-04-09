package Base;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectItem(WebElement e,String visibleText) {
		Select options=new Select(e);
		options.selectByVisibleText(visibleText);
	}
	
	public void eClick(WebElement e) {
		waitForElement(e);
		e.click();
	}
	
	@FindBy(id="userNavLabel")
	WebElement navlabel;
	
	@FindBy(xpath="//a[@title='Logout']")	
	WebElement logout;
	
	public void logOut() {
		eClick(navlabel);
		eClick(logout);
	}
	
	@FindBy(id="aboutTab")
	WebElement aboutTab;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement save;
	
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	WebElement profilename;
	
	public void abouttab() throws InterruptedException {
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("number of frames:" +size);
		
		
		driver.switchTo().frame(2);
		Thread.sleep(4000);
		
		eClick(aboutTab);
			Thread.sleep(4000);
			lastname.clear();	
		 lastname.sendKeys("changed-1");
		
		eClick(save);
		 
		 //switch back to original
		 driver.switchTo().defaultContent();
			System.out.print(profilename.getText());		
	}
	
	@FindBy(xpath="//a[contains(text(),'Other')]")
	WebElement other;
	
	 public void combo_8() {
		String parentWindow=driver.getWindowHandle();
		String subWindow=null;
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		while(it.hasNext()) {
			subWindow=it.next();
		}
		driver.switchTo().window(subWindow);//switching to sub window
		eClick(other);
		driver.switchTo().window(parentWindow);//switch back to parent window
		
	}
	
	public void combo_4() {
		String parentWindow=driver.getWindowHandle();
		String subWindow=null;
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		while(it.hasNext()) {
			subWindow=it.next();
		}
		driver.switchTo().window(subWindow);//switching to sub window
		eClick(other);
		driver.switchTo().window(parentWindow);//switch back to parent window

	}
}
