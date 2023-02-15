package com.phpuser.scripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.configaration.screenshot.Screenshot;
import com.pages.Stage.Stage3;
import com.phpuser.utitlities.Excelutility;

public class TestClassAdmin extends DriverSetup1 {
	 
	Stage3 objStage3;
    Screenshot objscr;

    SoftAssert softassert=new SoftAssert();

	
	@Test(priority=1)
	public void AdminInvalidLogin() throws InterruptedException {
		objStage3 = new Stage3(driver);
		driver.get(prop.getProperty("url2"));
		driver.manage().window().maximize();
		objStage3.StageThreeInvalidAdmin();
		driver.navigate().refresh();
	}
	@Test(priority=2)
	public void AdminValidLogin() throws IOException {
		objStage3.Stage3ValidAdmin(Excelutility.getCellData(3, 0), Excelutility.getCellData(3, 1));
	}
	
	@Test(priority=3)
	public void BookingInvoicee() throws InterruptedException {
		objStage3.BookingInvoice();
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
    	String expectedurl="https://phptravels.net/hotels/booking/invoice/5894/37";
    	softassert.assertEquals(CurentURL, expectedurl);
    	Thread.sleep(2000);

    	driver.switchTo().window(parentwindow);
    	Thread.sleep(2000);
    	
	}
	
	
	
	@Test(priority=4)
	public void WebSite() throws InterruptedException {
		objStage3.Websitee();
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
    	String expectedurl="https://phptravels.net/";
    	softassert.assertEquals(CurentURL, expectedurl);
    	Thread.sleep(2000);
    	driver.close();

    	driver.switchTo().window(parentwindow);
    	Thread.sleep(2000);
    	}
	@Test(priority=5)
	public void Linkss() throws InterruptedException {
		objStage3.Links();
	}
	

	
	@Test(priority=6)
   public void DeleteRecordd() throws InterruptedException {
		objStage3.RecordDelete();
		driver.navigate().refresh();
	}
	@Test(priority=7)
	public void pendingToconfirm() throws InterruptedException {
	objStage3.PendingConfirm();
	driver.navigate().refresh();
	String pendingCount=objStage3.pendingCount.getText();
	System.out.println(pendingCount);
	}
	

	}
