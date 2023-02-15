package com.phpuser.scripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.configaration.screenshot.Screenshot;
import com.pages.Stage.Stage4;
import com.phpuser.utitlities.Excelutility;

public class TestclassSupplier extends DriverSetup1 {
	
        Stage4 objstage4;
        Screenshot objscr;
        SoftAssert softassert=new SoftAssert();
        
        @Test(priority=1)
        public void SupplierInvalid() throws InterruptedException, IOException {
        objstage4 = new Stage4(driver);
        objscr = new Screenshot();
        driver.get(prop.getProperty("url3"));
		driver.manage().window().maximize();
        objstage4.Stage4invalidLogin();
        Thread.sleep(2000);
        objscr.scr(driver);
        }
        
        @Test(priority=2)
        public void SupplierValid() throws IOException {
             objstage4.Stage4validSupplier(Excelutility.getCellData(4, 0), Excelutility.getCellData(4, 1));;
        	objscr.scr(driver);
        	String currentlink=driver.getCurrentUrl();
        	String expectedUrl="https://phptravels.net/api/supplier";
        	softassert.assertEquals(currentlink, expectedUrl);
        }
       
        @Test(priority=3)
        public void Textverification() throws IOException, InterruptedException {
        	objstage4.Text();
        	objscr.scr(driver);
        	Thread.sleep(3000);
        }
        @Test(priority=4)
        public void RevenueBreakDown() throws IOException, InterruptedException {
        	objstage4.RevenueBreakDown();
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("window.scrollBy(0,250)", "");
        	Thread.sleep(3000);
        	objscr.scr(driver);
        	Thread.sleep(2000);
        }
        @Test(priority=5)
        public void BookingDisplay() throws InterruptedException, IOException
        {
        	objstage4.Bookinss();
        
        	objscr.scr(driver);
        	driver.navigate().back();
        	Thread.sleep(2000);
        	}
        @Test(priority=6)
        public void TestLinkss() throws InterruptedException, IOException {
        	objstage4.childDoc();
        	Thread.sleep(2000);
        	
        	Set<String> windowhandles = driver.getWindowHandles();
        	
        	Iterator<String>iterator = windowhandles.iterator();
        	String parentwindow=iterator.next();
        	System.out.println(parentwindow);
        	String childwindow=iterator.next();
        	System.out.println(childwindow);
        	
        	driver.switchTo().window(childwindow);
        	System.out.println("childwindow");
        	String CurentURL=driver.getCurrentUrl();
        	System.out.println(CurentURL);
        	String expectedurl="https://docs.phptravels.com/";
        	softassert.assertEquals(CurentURL, expectedurl);
        	//objstage4.FlightLinkss();
        	//objstage4.Tourslink();
        	objscr.scr(driver);
        	driver.navigate().back();
        	driver.switchTo().window(childwindow).close();
       

        	driver.switchTo().window(parentwindow);

        }
        
        @Test(priority=7)
        public void Logout() throws InterruptedException {
        	objstage4.Logoutt();
        	String logoutUrl=driver.getCurrentUrl();
        	String ExpectUrl="https://phptravels.net/api/supplier";
        	softassert.assertEquals(logoutUrl, ExpectUrl);
        }
        }

