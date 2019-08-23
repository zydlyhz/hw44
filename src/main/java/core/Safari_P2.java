package core;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.*;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Safari_P2 {
	static Properties p = new Properties();
    static Writer report;
    static String ls = System.getProperty("line.separator");
	static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty()) return true; else return false;}
	
	public static String getSize(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getRect().getDimension().toString().replace(", ", "x"); else return "null";}

	public static String getLocation(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getRect().getPoint().toString().replace(", ", "x"); else return "null";}
	
	public static void setValue(By by, String value) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	     	  driver.findElement(by).sendKeys(p.getProperty(value));}
	
	public static String getValue(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getText(); else return "null";}
	
	public static void checkCheckBox(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && 
	    	  driver.findElement(by).isDisplayed() && 
	    	 !driver.findElement(by).isSelected())
	    	 driver.findElement(by).click();}

	public static void checkRadioButton(By by) {
	     if (!driver.findElements(by).isEmpty() && 
		      driver.findElement(by).isDisplayed() && 
		     !driver.findElement(by).isSelected())
		     driver.findElement(by).click();}
	
	public static void selectDropDown(By by, String value) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 // new Select(driver.findElement(by)).selectByIndex(5);
	    	 // new Select(driver.findElement(by)).selectByValue(value);  // <option value="CA">
	    	 new Select(driver.findElement(by)).selectByVisibleText(value);
	     	}
	
	public static void main(String[] args) throws Exception {
		Logger.getLogger("").setLevel(Level.OFF);
		p.load(new FileInputStream("./input.properties"));
		report = new FileWriter("./report_01.csv",false);
		
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		
// HEADER
		
		System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
		report.write("#,Browser,Page,Field,isPresent,Value, Size, Location"); report.write(ls);
			
// 01 :: First Name		
		
		report.write("01,Safari,index.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				p.getProperty("fname_value") + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
		System.out.print("01,Safari,index.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				p.getProperty("fname_value") + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");

		setValue(By.id(p.getProperty("fname_id")),"fname_value");
		
// 02 :: Last Name
		
		report.write("02,Safari,index.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				p.getProperty("lname_value") + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		System.out.print("02,Safari,index.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				p.getProperty("lname_value") + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		setValue(By.id(p.getProperty("lname_id")),"lname_value");
		
// 03 :: Email	
		
		report.write("03,Safari,index.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				p.getProperty("email_value") + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		
		System.out.print("03,Safari,index.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				p.getProperty("email_value") + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		setValue(By.id(p.getProperty("email_id")),"email_value");
		
// 04 :: Phone
		
		report.write("04,Safari,index.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				p.getProperty("phone_value") + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		
		System.out.print("04,Safari,index.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				p.getProperty("phone_value") + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");	
		
		setValue(By.id(p.getProperty("phone_id")),"phone_value");

// 05 :: Gender
		
		report.write("05,Safari,index.php,Gender," + 
				isElementPresent(By.id(p.getProperty("gender_male_id"))) + "," +
				p.getProperty("gender_male_value") + "," +
				getSize(By.id(p.getProperty("gender_male_id"))) + "," +
				getLocation(By.id(p.getProperty("gender_male_id"))) + "\n");
		
		System.out.print("05,Safari,index.php,Gender," + 
				isElementPresent(By.id(p.getProperty("gender_male_id"))) + "," +
				p.getProperty("gender_male_value") + "," +
				getSize(By.id(p.getProperty("gender_male_id"))) + "," +
				getLocation(By.id(p.getProperty("gender_male_id"))) + "\n");	
		
		checkCheckBox(By.id(p.getProperty("gender_male_id")));
		
// 06 :: State
		
		report.write("06,Safari,index.php,State," + 
				isElementPresent(By.id(p.getProperty("state_id"))) + "," +
				p.getProperty("state_value") + "," +
				getSize(By.id(p.getProperty("state_id"))) + "," +
				getLocation(By.id(p.getProperty("state_id"))) + "\n");
		
		System.out.print("06,Safari,index.php,Phone," + 
				isElementPresent(By.id(p.getProperty("state_id"))) + "," +
				p.getProperty("state_value") + "," +
				getSize(By.id(p.getProperty("state_id"))) + "," +
				getLocation(By.id(p.getProperty("state_id"))) + "\n");	
		
		selectDropDown(By.id("id_state"),"California");
		
// 07 :: Terms
		
		report.write("07,Safari,index.php,Terms," + 
				isElementPresent(By.id(p.getProperty("terms_id"))) + "," +
				p.getProperty("terms_value") + "," +
				getSize(By.id(p.getProperty("terms_id"))) + "," +
				getLocation(By.id(p.getProperty("terms_id"))) + "\n");
		
		System.out.print("07,Safari,index.php,Terms," + 
				isElementPresent(By.id(p.getProperty("terms_id"))) + "," +
				p.getProperty("terms_value") + "," +
				getSize(By.id(p.getProperty("terms_id"))) + "," +
				getLocation(By.id(p.getProperty("terms_id"))) + "\n");	
		
		checkRadioButton(By.id(p.getProperty("terms_id")));
		
// SUBMIT	
		
		driver.findElement(By.id(p.getProperty("submit_id"))).submit(); 
		WebDriverWait wait = new WebDriverWait(driver, 15); 
		wait.until(ExpectedConditions.titleIs("Confirmation"));
		
// 08 :: First Name		
		
		report.write("08,Safari,confirmation.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				getValue(By.id(p.getProperty("fname_id"))) + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
		System.out.print("08,Safari,confirmation.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				getValue(By.id(p.getProperty("fname_id"))) + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
// 09 :: Last Name
		
		report.write("09,Safari,confirmation.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				getValue(By.id(p.getProperty("lname_id"))) + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		System.out.print("09,Safari,confirmation.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				getValue(By.id(p.getProperty("lname_id"))) + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
// 10 :: Email
		
		report.write("10,Safari,confirmation.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				getValue(By.id(p.getProperty("email_id"))) + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		
		System.out.print("10,Safari,confirmation.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				getValue(By.id(p.getProperty("email_id"))) + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");		

// 11 :: Phone
		
		report.write("11,Safari,confirmation.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				getValue(By.id(p.getProperty("phone_id"))) + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		
		System.out.print("11,Safari,confirmation.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				getValue(By.id(p.getProperty("phone_id"))) + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		
// 12 :: Radio Button
		
				report.write("12,Safari,confirmation.php,Gender," + 
						isElementPresent(By.id(p.getProperty("gender_id"))) + "," +
						getValue(By.id(p.getProperty("gender_id"))) + "," +
						getSize(By.id(p.getProperty("gender_id"))) + "," +
						getLocation(By.id(p.getProperty("gender_id"))) + "\n");
				
				System.out.print("12,Safari,confirmation.php,Gender," + 
						isElementPresent(By.id(p.getProperty("gender_id"))) + "," +
						getValue(By.id(p.getProperty("gender_id"))) + "," +
						getSize(By.id(p.getProperty("gender_id"))) + "," +
						getLocation(By.id(p.getProperty("gender_id"))) + "\n");
				
// 13 :: State
				
				report.write("13,Safari,confirmation.php,State," + 
						isElementPresent(By.id(p.getProperty("state_id"))) + "," +
						getValue(By.id(p.getProperty("state_id"))) + "," +
						getSize(By.id(p.getProperty("state_id"))) + "," +
						getLocation(By.id(p.getProperty("state_id"))) + "\n");
				
				System.out.print("13,Safari,confirmation.php,State," + 
						isElementPresent(By.id(p.getProperty("state_id"))) + "," +
						getValue(By.id(p.getProperty("state_id"))) + "," +
						getSize(By.id(p.getProperty("state_id"))) + "," +
						getLocation(By.id(p.getProperty("state_id"))) + "\n");
				
// 14 :: Checkbox
				
				report.write("14,Safari,confirmation.php,Terms," + 
						isElementPresent(By.id(p.getProperty("terms_id"))) + "," +
						getValue(By.id(p.getProperty("terms_id"))) + "," +
						getSize(By.id(p.getProperty("terms_id"))) + "," +
						getLocation(By.id(p.getProperty("terms_id"))) + "\n");
				
				System.out.print("14,Safari,confirmation.php,Terms," + 
						isElementPresent(By.id(p.getProperty("terms_id"))) + "," +
						getValue(By.id(p.getProperty("terms_id"))) + "," +
						getSize(By.id(p.getProperty("terms_id"))) + "," +
						getLocation(By.id(p.getProperty("terms_id"))) + "\n");
				
//		System.out.print("00," + getSize(By.id("copyright")) + "," + getLocation(By.id("copyright")) + "\n");

		report.flush();
		report.close();
		driver.quit();
	}
}
