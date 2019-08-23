package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox_P1 {
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
	
	public static void main(String[] args) throws Exception {
		Logger.getLogger("").setLevel(Level.OFF);
		p.load(new FileInputStream("./input.properties"));
		report = new FileWriter("./report_01.csv",false);
		String driverPath = "";
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/geckodriver";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "./resources/webdrivers/pc/geckodriver.exe";
		else throw new IllegalArgumentException("Unknown OS");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		
// HEADER
		
		System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
		report.write("#,Browser,Page,Field,isPresent,Value, Size, Location"); report.write(ls);

		// 01 :: Quotes				id="id_quotes"
				report.write("01,Firefox,index.php,Quotes," + 
						isElementPresent(By.id(p.getProperty("id_quotes"))) + "," +
						getValue(By.id(p.getProperty("id_quotes"))) + "," +
						getSize(By.id(p.getProperty("id_quotes"))) + "," +
						getLocation(By.id(p.getProperty("id_quotes"))) + "\n");
				System.out.print("02,Firefox,index.php,Quotes , " + 
						isElementPresent(By.id(p.getProperty("id_quotes"))) + "," +
						getValue(By.id(p.getProperty("id_quotes"))) + "," + 
						getSize(By.id(p.getProperty("id_quotes"))) + "," + 
						getLocation(By.id(p.getProperty("id_quotes"))) + "\n");
		
		
				// 02 :: Title				id="id_f_title"
				report.write("02,Firefox,index.php,Title," + 
						isElementPresent(By.id(p.getProperty("id_f_title"))) + "," +
						driver.getTitle() + "," +
						getSize(By.id(p.getProperty("id_f_title"))) + "," +
						getLocation(By.id(p.getProperty("id_f_title"))) + "\n");
				
				System.out.print("02,Firefox,index.php,Title , " + 
						isElementPresent(By.id(p.getProperty("id_f_title"))) + "," +
						driver.getTitle() + "," + 
						getSize(By.id(p.getProperty("id_f_title"))) + "," + 
						getLocation(By.id(p.getProperty("id_f_title"))) + "\n");
		
				// 03 :: Current Location 	id="id_current_location"
				report.write("03,Firefox,index.php,Location," + 
						isElementPresent(By.id(p.getProperty("id_current_location"))) + "," +
						getValue(By.id(p.getProperty("id_current_location"))) + "," +
						getSize(By.id(p.getProperty("fname_id"))) + "," +
						getLocation(By.id(p.getProperty("fname_id"))) + "\n");
				System.out.print("03,Firefox,index.php,Location , " + 
						isElementPresent(By.id(p.getProperty("id_current_location"))) + "," +
						getValue(By.id(p.getProperty("id_current_location"))) + "," + 
						getSize(By.id(p.getProperty("id_current_location"))) + "," + 
						getLocation(By.id(p.getProperty("id_current_location"))) + "\n");


				// 04 :: Weather Icon		id="id_weather_icon"
				report.write("04,Firefox,index.php,weatherIcon," + 
						isElementPresent(By.id(p.getProperty("id_weather_icon"))) + "," +
						getValue(By.id(p.getProperty("id_weather_icon"))) + "," +
						getSize(By.id(p.getProperty("id_weather_icon"))) + "," +
						getLocation(By.id(p.getProperty("id_weather_icon"))) + "\n");
				System.out.print("03,Firefox,index.php,weatherIcon , " + 
						isElementPresent(By.id(p.getProperty("id_weather_icon"))) + "," +
						getValue(By.id(p.getProperty("id_weather_icon"))) + "," +
						getSize(By.id(p.getProperty("id_weather_icon"))) + "," +
						getLocation(By.id(p.getProperty("id_weather_icon"))) + "\n");
		
/// 05 :: Temperature		id="id_temperature"
				report.write("05,Firefox,index.php,Temperature," + 
						isElementPresent(By.id(p.getProperty("id_temperature"))) + "," +
						getValue(By.id(p.getProperty("id_temperature"))) + "," +
						getSize(By.id(p.getProperty("id_temperature"))) + "," +
						getLocation(By.id(p.getProperty("id_temperature"))) + "\n");
		System.out.println("05,Firefox,index.php,Temperature," + 
				isElementPresent(By.id(p.getProperty("id_temperature"))) + "," +
				getValue(By.id(p.getProperty("id_temperature"))) + "," +
				getSize(By.id(p.getProperty("id_temperature"))) + "," +
				getLocation(By.id(p.getProperty("id_temperature"))) + "\n");
		
		// 06 :: Label First Name	id="id_f_label_fn"
				report.write("06,Firefox,index.php,FName label," + 
						isElementPresent(By.id(p.getProperty("id_f_label_fn"))) + "," +
						getValue(By.id(p.getProperty("id_f_label_fn"))) + "," +
						getSize(By.id(p.getProperty("id_f_label_fn"))) + "," +
						getLocation(By.id(p.getProperty("id_f_label_fn"))) + "\n");
				System.out.println("05,Firefox,index.php,Fname label," + 
						isElementPresent(By.id(p.getProperty("id_f_label_fn"))) + "," +
						getValue(By.id(p.getProperty("id_f_label_fn"))) + "," +
						getSize(By.id(p.getProperty("id_f_label_fn"))) + "," +
						getLocation(By.id(p.getProperty("id_f_label_fn"))) + "\n");

		
// 07 :: First Name		
		
		report.write("07,Firefox,index.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				p.getProperty("fname_value") + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
		 System.out.print("01,Firefox,index.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				p.getProperty("fname_value") + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n"); 

		setValue(By.id(p.getProperty("fname_id")),"fname_value");
		
		// 08 :: First Name Error	id="fname_error"
		report.write("08,Firefox,index.php,Fname Error," + 
				isElementPresent(By.id(p.getProperty("fname_error"))) + "," +
				getValue(By.id(p.getProperty("fname_error"))) + "," +
				getSize(By.id(p.getProperty("fname_error"))) + "," +
				getLocation(By.id(p.getProperty("fname_error"))) + "\n");
		System.out.println("08,Firefox,index.php,Fname Error," + 
				isElementPresent(By.id(p.getProperty("fname_error"))) + "," +
				getValue(By.id(p.getProperty("fname_error"))) + "," +
				getSize(By.id(p.getProperty("fname_error"))) + "," +
				getLocation(By.id(p.getProperty("fname_error"))) + "\n");
		
// 09 :: Label Last Name 	id="id_f_label_ln"
		report.write("09,Firefox,index.php,Lname label," + 
				isElementPresent(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_ln"))) + "\n");
		System.out.println("09,Firefox,index.php,Lname label," + 
				isElementPresent(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_ln"))) + "\n");

		
// 10 :: Last Name
		
		report.write("10,Firefox,index.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				p.getProperty("lname_value") + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		System.out.print("10,Firefox,index.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				p.getProperty("lname_value") + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		setValue(By.id(p.getProperty("lname_id")),"lname_value");

// 11 :: FLast Name Error	id="lname_error"
		report.write("11,Firefox,index.php,Lname Error," + 
				isElementPresent(By.id(p.getProperty("lname_error"))) + "," +
				getValue(By.id(p.getProperty("lname_error"))) + "," +
				getSize(By.id(p.getProperty("lname_error"))) + "," +
				getLocation(By.id(p.getProperty("lname_error"))) + "\n");
		System.out.println("11,Firefox,index.php,Lname Error," + 
				isElementPresent(By.id(p.getProperty("lname_error"))) + "," +
				getValue(By.id(p.getProperty("lname_error"))) + "," +
				getSize(By.id(p.getProperty("lname_error"))) + "," +
				getLocation(By.id(p.getProperty("lname_error"))) + "\n");
		
// 12 :: Label Email 		id="id_f_label_ea"		
		report.write("12,Firefox,index.php,Label emaiil," + 
				isElementPresent(By.id(p.getProperty("id_f_label_ea"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_ea"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_ea"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_ea"))) + "\n");
		System.out.println("12,Firefox,index.php, Label email," + 
				isElementPresent(By.id(p.getProperty("id_f_label_ea"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_ea"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_ea"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_ea"))) + "\n");

// 13 :: Email	
		
		report.write("13,Firefox,index.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				p.getProperty("email_value") + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		
		System.out.print("13,Firefox,index.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				p.getProperty("email_value") + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		setValue(By.id(p.getProperty("email_id")),"email_value");
		
// 14 :: Email Error		id="email_error"
		report.write("14,Firefox,index.php,Email Error," + 
				isElementPresent(By.id(p.getProperty("email_error"))) + "," +
				getValue(By.id(p.getProperty("email_error"))) + "," +
				getSize(By.id(p.getProperty("email_error"))) + "," +
				getLocation(By.id(p.getProperty("email_error"))) + "\n");
		System.out.println("14,Firefox,index.php,Email Error," + 
				isElementPresent(By.id(p.getProperty("email_error"))) + "," +
				getValue(By.id(p.getProperty("email_error"))) + "," +
				getSize(By.id(p.getProperty("email_error"))) + "," +
				getLocation(By.id(p.getProperty("email_error"))) + "\n");
		
		// TODO continue from here
		
// 15 :: Label Phone		id="id_f_label_pn"
		report.write("15,Firefox,index.php,Label Phone," + 
				isElementPresent(By.id(p.getProperty("id_f_label_pn"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_pn"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_pn"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_pn"))) + "\n");
		System.out.println("15,Firefox,index.php, Label Phone," + 
				isElementPresent(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_ln"))) + "\n");
		
// 16 :: Phone
		
		report.write("16,Firefox,index.php,Phone," + 
				isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
				p.getProperty("phone_value") + "," +
				getSize(By.id(p.getProperty("id_phone"))) + "," +
				getLocation(By.id(p.getProperty("id_phone"))) + "\n");
		
		System.out.print("16,Firefox,index.php,Phone," + 
				isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
				p.getProperty("phone_value") + "," +
				getSize(By.id(p.getProperty("id_phone"))) + "," +
				getLocation(By.id(p.getProperty("id_phone"))) + "\n");	
		
		setValue(By.id(p.getProperty("id_phone")),"phone_value");
		
// 17 :: Phone Error		id="phone_error"
		report.write("17,Firefox,index.php,Phone Error," + 
				isElementPresent(By.id(p.getProperty("phone_error"))) + "," +
				getValue(By.id(p.getProperty("phone_error"))) + "," +
				getSize(By.id(p.getProperty("phone_error"))) + "," +
				getLocation(By.id(p.getProperty("phone_error"))) + "\n");
		System.out.print("17,Firefox,index.php,Phone Error," + 
				isElementPresent(By.id(p.getProperty("phone_error"))) + "," +
				getValue(By.id(p.getProperty("phone_error"))) + "," +
				getSize(By.id(p.getProperty("phone_error"))) + "," +
				getLocation(By.id(p.getProperty("phone_error"))) + "\n");
		
// 18 :: Label Gender		id="id_rb_label_g"		
		report.write("18,Firefox,index.php,Label Gender," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_g"))) + "\n");
		System.out.print("18,Firefox,index.php,Label Gender," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_g"))) + "\n");


// 19 :: Label Gender Male	id="id_rb_label_m"
		report.write("19,Firefox,index.php,Label Gender," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_m"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_m"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_m"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_m"))) + "\n");
		System.out.print("19,Firefox,index.php,Label Gender," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_m"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_m"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_m"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_m"))) + "\n");
		
		
// 20 :: Gender Male		id="id_gender_male"
		report.write("20,Firefox,index.php,Gender Male," + 
				isElementPresent(By.id(p.getProperty("id_gender_male"))) + "," +
				getValue(By.id(p.getProperty("id_gender_male"))) + "," +
				getSize(By.id(p.getProperty("id_gender_male"))) + "," +
				getLocation(By.id(p.getProperty("id_gender_male"))) + "\n");
		System.out.print("20,Firefox,index.php,Gender Male," + 
				isElementPresent(By.id(p.getProperty("id_gender_male"))) + "," +
				getValue(By.id(p.getProperty("id_gender_male"))) + "," +
				getSize(By.id(p.getProperty("id_gender_male"))) + "," +
				getLocation(By.id(p.getProperty("id_gender_male"))) + "\n");
		
// 21 :: Label Gender Female	id="id_rb_label_f"
		report.write("21,Firefox,index.php,Label Gender Female," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_f"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_f"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_f"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_f"))) + "\n");
		System.out.print("21,Firefox,index.php, Label Gender Female," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_f"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_f"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_f"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_f"))) + "\n");
		
// 22 :: Gender Female		id="id_gender_female"
		report.write("22,Firefox,index.php,Gender Female," + 
				isElementPresent(By.id(p.getProperty("id_gender_female"))) + "," +
				getValue(By.id(p.getProperty("id_gender_female"))) + "," +
				getSize(By.id(p.getProperty("id_gender_female"))) + "," +
				getLocation(By.id(p.getProperty("id_gender_female"))) + "\n");
		System.out.print("22,Firefox,index.php,Gender Female," + 
				isElementPresent(By.id(p.getProperty("id_gender_female"))) + "," +
				getValue(By.id(p.getProperty("id_gender_female"))) + "," +
				getSize(By.id(p.getProperty("id_gender_female"))) + "," +
				getLocation(By.id(p.getProperty("id_gender_female"))) + "\n");
		
// 23 :: Label State		id="id_f_label_s"
		report.write("23,Firefox,index.php,Label state," + 
				isElementPresent(By.id(p.getProperty("id_f_label_s"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_s"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_s"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_s"))) + "\n");
		System.out.print("23,Firefox,index.php,Gender Female," + 
				isElementPresent(By.id(p.getProperty("id_f_label_s"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_s"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_s"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_s"))) + "\n");
		
// 24 :: State				id="id_state"
		report.write("24,Firefox,index.php,State," + 
				isElementPresent(By.id(p.getProperty("id_state"))) + "," +
				getValue(By.id(p.getProperty("id_state"))) + "," +
				getSize(By.id(p.getProperty("id_state"))) + "," +
				getLocation(By.id(p.getProperty("id_state"))) + "\n");
		System.out.print("24,Firefox,index.php,State," + 
				isElementPresent(By.id(p.getProperty("id_state"))) + "," +
				getValue(By.id(p.getProperty("id_state"))) + "," +
				getSize(By.id(p.getProperty("id_state"))) + "," +
				getLocation(By.id(p.getProperty("id_state"))) + "\n");

// 25 :: Terms				id="id_terms"
		report.write("25,Firefox,index.php,Terms," + 
				isElementPresent(By.id(p.getProperty("id_terms"))) + "," +
				getValue(By.id(p.getProperty("id_terms"))) + "," +
				getSize(By.id(p.getProperty("id_terms"))) + "," +
				getLocation(By.id(p.getProperty("id_terms"))) + "\n");
		System.out.print("04,Firefox,index.php,Terms," + 
				isElementPresent(By.id(p.getProperty("id_terms"))) + "," +
				getValue(By.id(p.getProperty("id_terms"))) + "," +
				getSize(By.id(p.getProperty("id_terms"))) + "," +
				getLocation(By.id(p.getProperty("id_terms"))) + "\n");
		
// 26 :: Label Terms		id="id_cb_label_t"
		report.write("25,Firefox,index.php,Label Terms," + 
				isElementPresent(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getValue(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getSize(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getLocation(By.id(p.getProperty("id_cb_label_t"))) + "\n");
		System.out.print("25,Firefox,index.php,Terms," + 
				isElementPresent(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getValue(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getSize(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getLocation(By.id(p.getProperty("id_cb_label_t"))) + "\n");
		

// 27 :: Error Line		id="ErrorLine"
		report.write("26,Firefox,index.php,ErrorLine," + 
				isElementPresent(By.id(p.getProperty("ErrorLine"))) + "," +
				getValue(By.id(p.getProperty("ErrorLine"))) + "," +
				getSize(By.id(p.getProperty("ErrorLine"))) + "," +
				getLocation(By.id(p.getProperty("ErrorLine"))) + "\n");
		System.out.print("26,Firefox,index.php,Terms," + 
				isElementPresent(By.id(p.getProperty("ErrorLine"))) + "," +
				getValue(By.id(p.getProperty("ErrorLine"))) + "," +
				getSize(By.id(p.getProperty("ErrorLine"))) + "," +
				getLocation(By.id(p.getProperty("ErrorLine"))) + "\n");
		
//		id="id_link_facebook"
		report.write("27,Firefox,index.php,Facebook Link," + 
				isElementPresent(By.id(p.getProperty("id_link_facebook"))) + "," +
				getValue(By.id(p.getProperty("id_link_facebook"))) + "," +
				getSize(By.id(p.getProperty("id_link_facebook"))) + "," +
				getLocation(By.id(p.getProperty("id_link_facebook"))) + "\n");
		System.out.print("27,Firefox,index.php,Facebook Link," + 
				isElementPresent(By.id(p.getProperty("id_link_facebook"))) + "," +
				getValue(By.id(p.getProperty("id_link_facebook"))) + "," +
				getSize(By.id(p.getProperty("id_link_facebook"))) + "," +
				getLocation(By.id(p.getProperty("id_link_facebook"))) + "\n");
		
//		id="id_img_facebook"
		report.write("28,Firefox,index.php,Facebook Img," + 
				isElementPresent(By.id(p.getProperty("id_img_facebook"))) + "," +
				getValue(By.id(p.getProperty("id_img_facebook"))) + "," +
				getSize(By.id(p.getProperty("id_img_facebook"))) + "," +
				getLocation(By.id(p.getProperty("id_img_facebook"))) + "\n");
		System.out.print("28,Firefox,index.php,Facebook Img," + 
				isElementPresent(By.id(p.getProperty("id_img_facebook"))) + "," +
				getValue(By.id(p.getProperty("id_img_facebook"))) + "," +
				getSize(By.id(p.getProperty("id_img_facebook"))) + "," +
				getLocation(By.id(p.getProperty("id_img_facebook"))) + "\n");
		
//		id="id_link_twitter"
		report.write("29,Firefox,index.php,Twitter Link," + 
				isElementPresent(By.id(p.getProperty("id_link_twitter"))) + "," +
				getValue(By.id(p.getProperty("id_link_twitter"))) + "," +
				getSize(By.id(p.getProperty("id_link_twitter"))) + "," +
				getLocation(By.id(p.getProperty("id_link_twitter"))) + "\n");
		System.out.print("29,Firefox,index.php,Twitter Link," + 
				isElementPresent(By.id(p.getProperty("id_link_twitter"))) + "," +
				getValue(By.id(p.getProperty("id_link_twitter"))) + "," +
				getSize(By.id(p.getProperty("id_link_twitter"))) + "," +
				getLocation(By.id(p.getProperty("id_link_twitter"))) + "\n");
		
//		id="id_img_twitter"
		report.write("30,Firefox,index.php,Twitter Img," + 
				isElementPresent(By.id(p.getProperty("id_img_twitter"))) + "," +
				getValue(By.id(p.getProperty("id_img_twitter"))) + "," +
				getSize(By.id(p.getProperty("id_img_twitter"))) + "," +
				getLocation(By.id(p.getProperty("id_img_twitter"))) + "\n");
		System.out.print("30,Firefox,index.php,Twitter Img," + 
				isElementPresent(By.id(p.getProperty("id_img_twitter"))) + "," +
				getValue(By.id(p.getProperty("id_img_twitter"))) + "," +
				getSize(By.id(p.getProperty("id_img_twitter"))) + "," +
				getLocation(By.id(p.getProperty("id_img_twitter"))) + "\n");
				
//		id="id_link_flickr"
		report.write("31,Firefox,index.php,Flickr link," + 
				isElementPresent(By.id(p.getProperty("id_link_flickr"))) + "," +
				getValue(By.id(p.getProperty("id_link_flickr"))) + "," +
				getSize(By.id(p.getProperty("id_link_flickr"))) + "," +
				getLocation(By.id(p.getProperty("id_link_flickr"))) + "\n");
		System.out.print("31,Firefox,index.php,Flickr Link," + 
				isElementPresent(By.id(p.getProperty("id_link_flickr"))) + "," +
				getValue(By.id(p.getProperty("id_link_flickr"))) + "," +
				getSize(By.id(p.getProperty("id_link_flickr"))) + "," +
				getLocation(By.id(p.getProperty("id_link_flickr"))) + "\n");
		
//		id="id_img_flickr"
		report.write("32,Firefox,index.php,Flickr img," + 
				isElementPresent(By.id(p.getProperty("id_img_flickr"))) + "," +
				getValue(By.id(p.getProperty("id_img_flickr"))) + "," +
				getSize(By.id(p.getProperty("id_img_flickr"))) + "," +
				getLocation(By.id(p.getProperty("id_img_flickr"))) + "\n");
		System.out.print("32,Firefox,index.php,Flickr Img," + 
				isElementPresent(By.id(p.getProperty("id_img_flickr"))) + "," +
				getValue(By.id(p.getProperty("id_img_flickr"))) + "," +
				getSize(By.id(p.getProperty("id_img_flickr"))) + "," +
				getLocation(By.id(p.getProperty("id_img_flickr"))) + "\n");
		
//		id="id_link_youtube"
		report.write("33,Firefox,index.php,Youtube link," + 
				isElementPresent(By.id(p.getProperty("id_link_youtube"))) + "," +
				getValue(By.id(p.getProperty("id_link_youtube"))) + "," +
				getSize(By.id(p.getProperty("id_link_youtube"))) + "," +
				getLocation(By.id(p.getProperty("id_link_youtube"))) + "\n");
		System.out.print("34,Firefox,index.php,Youtube Link," + 
				isElementPresent(By.id(p.getProperty("id_link_youtube"))) + "," +
				getValue(By.id(p.getProperty("id_link_youtube"))) + "," +
				getSize(By.id(p.getProperty("id_link_youtube"))) + "," +
				getLocation(By.id(p.getProperty("id_link_youtube"))) + "\n");
		
//		id="id_img_youtube"
		report.write("35,Firefox,index.php,Youtube Img," + 
				isElementPresent(By.id(p.getProperty("id_img_youtube"))) + "," +
				getValue(By.id(p.getProperty("id_img_youtube"))) + "," +
				getSize(By.id(p.getProperty("id_img_youtube"))) + "," +
				getLocation(By.id(p.getProperty("id_img_youtube"))) + "\n");
		System.out.print("35,Firefox,index.php,Youtube Img," + 
				isElementPresent(By.id(p.getProperty("id_img_youtube"))) + "," +
				getValue(By.id(p.getProperty("id_img_youtube"))) + "," +
				getSize(By.id(p.getProperty("id_img_youtube"))) + "," +
				getLocation(By.id(p.getProperty("id_img_youtube"))) + "\n");
		
// 36 :: Reset Button	id="id_reset_button"
		report.write("36,Firefox,index.php,Reset Button," + 
				isElementPresent(By.id(p.getProperty("id_reset_button"))) + "," +
				getValue(By.id(p.getProperty("id_reset_button"))) + "," +
				getSize(By.id(p.getProperty("id_reset_button"))) + "," +
				getLocation(By.id(p.getProperty("id_reset_button"))) + "\n");
		
// 37 :: Submit Button	id="id_submit_button"
		report.write("37,Firefox,index.php,Submit button," + 
				isElementPresent(By.id(p.getProperty("id_submit_button"))) + "," +
				getValue(By.id(p.getProperty("id_submit_button"))) + "," +
				getSize(By.id(p.getProperty("id_submit_button"))) + "," +
				getLocation(By.id(p.getProperty("id_submit_button"))) + "\n");
		
// 38 :: Timestamp		id="timestamp"
		report.write("38,Firefox,index.php,Timestamp," + 
				isElementPresent(By.id(p.getProperty("timestamp"))) + "," +
				getValue(By.id(p.getProperty("timestamp"))) + "," +
				getSize(By.id(p.getProperty("timestamp"))) + "," +
				getLocation(By.id(p.getProperty("timestamp"))) + "\n");
		
// 39 :: Copyright		id="copyright"
		report.write("39,Firefox,index.php,Copyright," + 
				isElementPresent(By.id(p.getProperty("copyright"))) + "," +
				p.getProperty("copyright") + "," +
				getSize(By.id(p.getProperty("copyright"))) + "," +
				getLocation(By.id(p.getProperty("copyright"))) + "\n");
		
// 40 :: OS & Browser	id="os_browser"
		report.write("40,Firefox,index.php,OS & Browser," + 
				isElementPresent(By.id(p.getProperty("os_browser"))) + "," +
				getValue(By.id(p.getProperty("os_browser"))) + "," +
				getSize(By.id(p.getProperty("os_browser"))) + "," +
				getLocation(By.id(p.getProperty("os_browser"))) + "\n");

// SUBMIT	

		driver.findElement(By.id(p.getProperty("submit_id"))).submit(); 
		WebDriverWait wait = new WebDriverWait(driver, 15); 
		wait.until(ExpectedConditions.titleIs("Confirmation"));

// 41 :: Title				id="id_f_title"
		report.write("41,Firefox,index.php,Title," + 
				isElementPresent(By.id(p.getProperty("id_f_title"))) + "," +
				driver.getTitle() + "," +
				getSize(By.id(p.getProperty("id_f_title"))) + "," +
				getLocation(By.id(p.getProperty("id_f_title"))) + "\n");
		
		System.out.print("42,Firefox,index.php,Title , " + 
				isElementPresent(By.id(p.getProperty("id_f_title"))) + "," +
				driver.getTitle() + "," + 
				getSize(By.id(p.getProperty("id_f_title"))) + "," + 
				getLocation(By.id(p.getProperty("id_f_title"))) + "\n");
		
// 42 :: Label First Name	id="id_f_label_fn"	
		report.write("43,Firefox,index.php,FName label," + 
				isElementPresent(By.id(p.getProperty("id_f_label_fn"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_fn"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_fn"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_fn"))) + "\n");
		System.out.println("44,Firefox,index.php,Fname label," + 
				isElementPresent(By.id(p.getProperty("id_f_label_fn"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_fn"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_fn"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_fn"))) + "\n");
		
// 43 :: First Name		
		
		report.write("45,Firefox,confirmation.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				getValue(By.id(p.getProperty("fname_id"))) + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
		System.out.print("45,Firefox,confirmation.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				getValue(By.id(p.getProperty("fname_id"))) + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");

// 44 :: id="id_f_label_ln"		
		report.write("46,Firefox,index.php,Lname label," + 
				isElementPresent(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_ln"))) + "\n");
		System.out.println("46,Firefox,index.php,Lname label," + 
				isElementPresent(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_ln"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_ln"))) + "\n");
		
// 45 :: Last Name
		
		report.write("47,Firefox,confirmation.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				getValue(By.id(p.getProperty("lname_id"))) + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		System.out.print("47,Firefox,confirmation.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				getValue(By.id(p.getProperty("lname_id"))) + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");

// 46 :: Label Email	id="id_f_label_ea"
		report.write("48,Firefox,index.php,Quotes," + 
				isElementPresent(By.id(p.getProperty("id_quotes"))) + "," +
				p.getProperty("quotes_value") + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
// 47 :: Email
		
		report.write("49,Firefox,confirmation.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				getValue(By.id(p.getProperty("email_id"))) + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		
		System.out.print("50,Firefox,confirmation.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				getValue(By.id(p.getProperty("email_id"))) + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");		

// 48 :: Label Phone	id="id_f_label_pn"
		report.write("51,Firefox,index.php,Label Phone," + 
				isElementPresent(By.id(p.getProperty("id_f_label_pn"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_pn"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_pn"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_pn"))) + "\n");
		
// 49 :: Phone
		
		report.write("52,Firefox,confirmation.php,Phone," + 
				isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
				getValue(By.id(p.getProperty("id_phone"))) + "," +
				getSize(By.id(p.getProperty("id_phone"))) + "," +
				getLocation(By.id(p.getProperty("id_phone"))) + "\n");
		
		System.out.print("53,Firefox,confirmation.php,Phone," + 
				isElementPresent(By.id(p.getProperty("id_phone"))) + "," +
				getValue(By.id(p.getProperty("id_phone"))) + "," +
				getSize(By.id(p.getProperty("id_phone"))) + "," +
				getLocation(By.id(p.getProperty("id_phone"))) + "\n");

// 50 :: Label Gender 	id="id_rb_label_g"
		report.write("54,Firefox,index.php,Label Gender," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_g"))) + "\n");
		
// 51 :: Gender			id="id_gender"
		report.write("55,Firefox,index.php,Gender," + 
				isElementPresent(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getValue(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getSize(By.id(p.getProperty("id_rb_label_g"))) + "," +
				getLocation(By.id(p.getProperty("id_rb_label_g"))) + "\n");
		
// 52 :: Label State	id="id_f_label_s"
		report.write("56,Firefox,index.php,Label State," + 
				isElementPresent(By.id(p.getProperty("id_f_label_s"))) + "," +
				getValue(By.id(p.getProperty("id_f_label_s"))) + "," +
				getSize(By.id(p.getProperty("id_f_label_s"))) + "," +
				getLocation(By.id(p.getProperty("id_f_label_s"))) + "\n");
		
// 53 :: State			id="id_state"
		report.write("57,Firefox,index.php,State," + 
				isElementPresent(By.id(p.getProperty("id_state"))) + "," +
				getValue(By.id(p.getProperty("id_state"))) + "," +
				getSize(By.id(p.getProperty("id_state"))) + "," +
				getLocation(By.id(p.getProperty("id_state"))) + "\n");
		
				
// 54 :: Label Terms	id="id_cb_label_t"
		report.write("58,Firefox,index.php,Label Terms," + 
				isElementPresent(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getValue(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getSize(By.id(p.getProperty("id_cb_label_t"))) + "," +
				getLocation(By.id(p.getProperty("id_cb_label_t"))) + "\n");
		
// 55 :: Terms			id="id_terms"
		report.write("59,Firefox,index.php,Terms," + 
				isElementPresent(By.id(p.getProperty("id_terms"))) + "," +
				getValue(By.id(p.getProperty("id_terms"))) + "," +
				getSize(By.id(p.getProperty("id_terms"))) + "," +
				getLocation(By.id(p.getProperty("id_terms"))) + "\n");
		
// 56 :: Back Button	id="id_back_button"
		report.write("60,Firefox,index.php,Back Button," + 
				isElementPresent(By.id(p.getProperty("id_back_button"))) + "," +
				getValue(By.id(p.getProperty("id_back_button"))) + "," +
				getSize(By.id(p.getProperty("id_back_button"))) + "," +
				getLocation(By.id(p.getProperty("id_back_button"))) + "\n");
		
// 57 :: Copyright		id="copyright"
		report.write("61,Firefox,index.php,Copyright," + 
				isElementPresent(By.id(p.getProperty("copyright"))) + "," +
				getValue(By.id(p.getProperty("copyright"))) + "," +
				getSize(By.id(p.getProperty("copyright"))) + "," +
				getLocation(By.id(p.getProperty("copyright"))) + "\n");
		
			
		report.flush();
		report.close();
		driver.quit();
	}
}
