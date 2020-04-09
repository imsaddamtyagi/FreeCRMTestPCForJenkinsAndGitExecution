package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;



public class TestBase {
	
  public  static WebDriver driver;
  public  static Properties prop;
  public static EventFiringWebDriver e_driver;
  public static WebDriverEventListener eventListener;
  
	public TestBase() 	{     // 2
	try	{
	System.out.println("TestBase constructor started : loading property file");
	prop = new Properties();
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
	prop.load(ip);
	}	                                                                                                                                        catch(FileNotFoundException e)	  {e.printStackTrace();}	catch(IOException e)              {e.printStackTrace();}	
	System.out.println("TestBase constructor ended: prop loaded");
	}
	
	public static void initialization()    //5
	{
		
		System.out.println("Initialization method started: Browser selection begins");
	    String browserName=	prop.getProperty("browser");
	    if(browserName.equals("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
	    	driver = new ChromeDriver();
	    }
	    else if(browserName.equals("FF"))
	    {
	    	System.setProperty("webdriver.gecko.driver","./Drivers\\geckodriver.exe");
	    	driver = new FirefoxDriver();
	    }
	    
	    e_driver = new EventFiringWebDriver(driver);
	    //Now create object of EventListenerHandler to register it with EventFiringWebDriver
	    eventListener = new WebEventListener();
	    e_driver.register(eventListener);
	    driver = e_driver;
	     
	    	
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));    
	    System.out.println("initialization method END: Browser selected and launched with URL");
	}
	
	
	
	
	
}
