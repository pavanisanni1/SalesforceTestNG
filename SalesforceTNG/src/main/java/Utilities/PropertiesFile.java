package Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	FileInputStream fileinput;
public String getProperty(String key) {
	
	//define the path of the file
	
	/*Instead of letting the system get the file path of (application.properties)- i am getting it!!
	 * String userDir=System.getProperty("user.dir");
	//String fileSeparator=System.getProperty("file.separator");
	
	//String filePath=userDir+fileSeparator+"properties"+fileSeparator+"application.properties";
	
	//System.out.println(filePath);
	*/
	
	String filePath="C:\\Workspace\\SalesforceTNG\\properties\\application.properties";
	
	//load this path into file object
	
	try {
		fileinput=new FileInputStream(filePath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//create the object as propertyfile
	Properties prop=new Properties();
	
	try {
		prop.load(fileinput);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//fetch the data from property file
	
	String value=prop.getProperty(key);
	System.out.println("-------------"+key+"---------------"+value);
	return value;
}
}
