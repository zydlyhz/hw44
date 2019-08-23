package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Safari {

	static Properties p = new Properties();
	static Writer report;
	static String ls = System.getProperty("line.separator");
	static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if  (!driver.findElements(by).isEmpty())
			return true;
		else return false;
	}
	public static String getSize(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			return driver.findElement(by).getRect().getDimension().toString().replace(", ", "x");
		else return "null";
	}
	public static String getLocation(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			return driver.findElement(by).getRect().getPoint().toString().replace(", ", "x");
		else return "null";
	}
	public static void setValue(By by, String value) {
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			driver.findElement(by).sendKeys(p.getProperty(value));
		
	}
	public static String getValue(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			return driver.findElement(by).getText();
		else return "null";
		
	}
	public static void main(String[] args) throws Exception {
		
		Logger.getLogger("").setLevel(Level.OFF);
		p.load(new FileInputStream("./input.properties"));
		report = new FileWriter("./report_04.csv", false);
		
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		
// HEADER
		
		System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
		report.write("#,Browser,Page,Field,isPresent,Value,Size,Location");
		report.write(ls);
		
// 01 :: First Name
		report.write("01,Safari,index.php,First Name, " + 
						isElementPresent(By.id(p.getProperty("fname_id"))) + "," + 
						p.getProperty("fname_value") + "," + 
						getSize(By.id(p.getProperty("fname_id"))) + "\n");
		System.out.print("01,Safari,index.php,First Name, " + 
						isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
						p.getProperty("fname_value") + "," + 
						getSize(By.id(p.getProperty("fname_id"))) + "," + 
						getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
				setValue(By.id(p.getProperty("fname_id")), "fname_value");
		
// 02 :: Last Name
				
		report.write("02,Safari,index.ohp,Last Name," + 
						isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
						p.getProperty("lname_value") + "," + 
						getSize(By.id(p.getProperty("lname_id"))) + "," + 
						getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		setValue(By.id(p.getProperty("lname_id")), "lname_value");
		
		
// 03 :: Email
		report.write("03,Safari,index.php,Email, " + 
						isElementPresent(By.id(p.getProperty("email_id"))) + "," +
						p.getProperty("email_value") + "," + 
						getSize(By.id(p.getProperty("email_id"))) + 
						getLocation(By.id(p.getProperty("email_id"))) + "\n");
		setValue(By.id(p.getProperty("email_id")), "email_value");
		
// 04 :: Phone
		report.write("04,Safari,index.php,Phone, " + 
						isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
						p.getProperty("email_value") + "," + 
						getSize(By.id(p.getProperty("phone_id"))) + "," + 
						getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		
		System.out.print("04,Safari,index.php,Phone," + 
						isElementPresent(By.id(p.getProperty("phone_id"))) + "," + 
						p.getProperty("phone_value") + "," + 
						getSize(By.id(p.getProperty("phone_id"))) + "," + 
						getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		
		setValue(By.id(p.getProperty("phone_id")), "phone_value");
		
		
// SUBMIT 
		driver.findElement(By.id((p.getProperty("submit_id")))).submit();
		
// Thread.sleep(1000)
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs("Confirmation"));
		
// 05 :: First Name
		report.write("05,Safari,confirmation.php,First Name," + 
						isElementPresent(By.id(p.getProperty("fname_value"))) + "," + 
						p.getProperty("fname_value") + "," + 
						getSize(By.id(p.getProperty("fname_id"))) + "," + 
						getLocation(By.id("fname_id")) + "\n");
		System.out.print("05,Safari,confirmation.php,First Name," + 
						isElementPresent(By.id(p.getProperty("fname_id"))) + "," + 
						p.getProperty("fname_value") + "," + 
						getSize(By.id(p.getProperty("fname_id"))) + "," + 
						getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
// 06 :: Last Name
	report.write("06,Safari,confirmation.php,Last Name," +
		 isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
		 p.getProperty("lname_value") + "," +
		 getSize(By.id(p.getProperty("lname_id"))) + "," +
		 getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
	System.out.print("06,Safari,confirmation.php,Last Name," +
		 isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
		 p.getProperty("lname_value") + "," +
		 getSize(By.id(p.getProperty("lname_id"))) + "," +
		 getLocation(By.id(p.getProperty("lname_id"))) + "\n");		
		
// 07 :: Email
report.write("07,Safari,confirmation.php,Email," +
	 isElementPresent(By.id(p.getProperty("email_id"))) + "," +
	 p.getProperty("email_value") + "," +
	 getSize(By.id(p.getProperty("email_id"))) + "," +
	 getLocation(By.id(p.getProperty("email_id"))) + "\n");
	
System.out.print("07,Safari,confirmation.php,Email," +
	 isElementPresent(By.id(p.getProperty("email_id"))) + "," +
	 p.getProperty("email_value") + "," +
	 getSize(By.id(p.getProperty("email_id"))) + "," +
	 getLocation(By.id(p.getProperty("email_id"))) + "\n");
		

//08 :: Phone
report.write("08,Safari,confirmation.php,Phone," +
			isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
			p.getProperty("phone_value") + "," +
			getSize(By.id(p.getProperty("phone_id"))) + "," +
			getLocation(By.id(p.getProperty("phone_id"))) + "\n");

 	System.out.print("08,Safari,confirmation.php,Phone," +
 			isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
 			p.getProperty("phone_value") + "," +
 			getSize(By.id(p.getProperty("phone_id"))) + "," +
 			getLocation(By.id(p.getProperty("phone_id"))) + "\n");
 	report.flush(); report.close(); driver.quit();
		
		
	}
	
	
}
