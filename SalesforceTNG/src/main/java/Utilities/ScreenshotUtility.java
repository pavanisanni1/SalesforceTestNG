package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
public void takescreenshot(WebDriver driver) {
		
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);		
		Date current=new Date();
		String timestamp=new SimpleDateFormat("yyyy-mm-dd HH-mm-ss").format(current);
		String filepath="C:\\Workspace\\SalesforceTNG\\Screenshots\\Salesforce"+timestamp+".jpeg";
		
		File destFile=new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
