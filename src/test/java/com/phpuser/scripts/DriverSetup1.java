package com.phpuser.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class DriverSetup1 {
	 WebDriver driver;
	    public static Properties prop = null;
	    String driverPath = "C:\\Users\\Admin\\Downloads\\chromedriverlatest\\chromedriver.exe";
	    public static void DriverSetup1() {
	        try {
	        	//Below line creates an object of Properties called 'prop'
	            prop = new Properties();
	          //Below line creates an object of FileInputStream called 'ip'. 
	          //Give the path of the properties file which you have created
	            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
	                    + "/config.properties");
	            prop.load(ip);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    @BeforeTest
	    public void onSetup() throws InterruptedException {
	    	DriverSetup1(); // for loading the configurations
	        String browserName = prop.getProperty("browser");

	        if (browserName.equals("chrome")) {
	        	System.setProperty("webdriver.chrome.driver",driverPath);
	            driver = new ChromeDriver();

	        }
	        else if (browserName.equals("firefox")) {
	        	
	        	System.setProperty("webdriver.gecko.driver", driverPath);
	            driver = new FirefoxDriver();
	        }
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	    
	    }

}
