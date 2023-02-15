package com.phpuser.scripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.configaration.screenshot.Screenshot;
import com.pages.Stage.Stage1;
import com.pages.Stage.Stage1invalid;
import com.phpuser.utitlities.Excelutility;

public class TestclassCustomer extends DriverSetup1{
	 
	Stage1 objStage1;
	Stage1invalid objinvalid1;
	Screenshot objscr;
	SoftAssert softassert=new SoftAssert();

	
	@Test(priority=2)
	public void VerifyStage1Login() throws IOException, InterruptedException{
	objStage1 = new Stage1(driver);
	objscr = new Screenshot();
	driver.get(prop.getProperty("url"));

    objStage1.StageOneEmail(Excelutility.getCellDataCustomer(1, 0));
	objStage1.StageOnePassword(Excelutility.getCellDataCustomer(1, 1));
	objStage1.Loguser();
	objscr.scr(driver);
	Thread.sleep(2000);
	
    
	
	}
	@Test(priority=1)
	public void VerifyInvalid1() throws InterruptedException, IOException {
		objinvalid1 = new Stage1invalid(driver);
		objscr = new Screenshot();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
        objinvalid1.Stageoneinvalidmail();
		objinvalid1.StageoneinvalidPassword();
		objinvalid1.Logeinvaliduser();
		Thread.sleep(2000);
		objinvalid1.loginfailedmsg();
		String Excpectedvalidation="Wrong credentials. try again!";
		softassert.assertEquals(Excpectedvalidation,"Wrong credentials. try again!");
		objscr.scr(driver);



	}
	@Test(priority=3)
	public void Linkss() throws InterruptedException {
		objStage1.Links();
		String actualink=driver.getCurrentUrl();
		String expectLink="https://phptravels.net/account/add_funds";
		softassert.assertEquals(actualink, expectLink);
	}
	@Test(priority=4)
	public void payment50() throws InterruptedException {
		objStage1.payment();
		driver.navigate().back();
		
		
	}
	@Test(priority=5)
	public void AddressUpdate() throws InterruptedException {
		objStage1.AddressUpdate();
		objStage1.addressSubmit();
	}
	@Test(priority=6)
	public void Logout() {
		objStage1.Logout();
		
	}
	
	
	}



