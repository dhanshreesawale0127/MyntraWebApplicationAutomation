package com.myntra.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver  {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;

	public static Logger log=LogManager.getLogger(Driver.class.getName());

	
	public Driver(){
		try {
			prop = new Properties();
			log.info("Reading property file.........");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\myntra\\resources\\properties.properties");
			prop.load(ip);
			log.info("Property file loaded successfully!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialize(){
		String browserName = prop.getProperty("Browser");
		log.info("Getting browser from property file");
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();	
			log.info("Loading ChromeDriver");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			 WebDriverManager.firefoxdriver().setup();
			log.info("Loading firefox driver");
			driver = new FirefoxDriver(); 
		}
		
		
		
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Triggering url");
		driver.get(prop.getProperty("url"));
		log.info("Triggered "+prop.getProperty("url"));
		
	}
	
	public void tearDown() {
		log.info("Closing the browser");
		driver.quit();
	}
		
		

}
