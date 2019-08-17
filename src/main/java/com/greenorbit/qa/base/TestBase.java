package com.greenorbit.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.greenorbit.qa.util.TestUtil;
import com.greenorbit.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("D:\\JavaProgram\\GreenOrbitTest\\src\\main\\java\\com\\greenorbit\\qa\\config\\config.properties");
	    try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		
		}
		
				
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\savita.jadhav\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\savita.jadhav\\Downloads\\chromedriver_win32\\geckodriver.exe");
	         driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//Now create object of EventListenerHandler to register it with EventFiringWebDriver
		e_driver.register(eventListener);
		//driver= e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
