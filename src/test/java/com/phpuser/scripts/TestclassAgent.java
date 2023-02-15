package com.phpuser.scripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.configaration.screenshot.Screenshot;
import com.pages.Stage.Stage2;
import com.phpuser.utitlities.Excelutility; 

public class TestclassAgent extends DriverSetup1 {
	Stage2 objstg2;
	Screenshot objscr;
    SoftAssert softassert=new SoftAssert();

	@Test(priority=1)
	public void VerifyAgentlogs() throws InterruptedException, IOException {
		objstg2 = new Stage2(driver);
        objscr = new Screenshot();

	   	 driver.get(prop.getProperty("url"));
		    driver.manage().window().maximize();
		    String url=driver.getCurrentUrl();
		    System.out.println(url);

         objstg2.AgentinvalidLog();
         objscr.scr(driver);

		Thread.sleep(2000);
		
		
	}
	@Test(priority=2)
	public void validLogin() throws IOException {
		objstg2.AgentLogin(Excelutility.getCellDataAgent(2, 0), Excelutility.getCellDataAgent(2, 1));
        objscr.scr(driver);
        String CurrentURL=driver.getCurrentUrl() ;
        String expectedUrl="https://phptravels.net/account/dashboard";
        softassert.assertEquals(CurrentURL, expectedUrl);

	}
	@Test(priority=4)
	public void VerifyLinkAction() throws InterruptedException, IOException  {
		objstg2.LinksAction();
        objscr.scr(driver);

		
	}
	@Test(priority=5)
	public void UsdToInr() throws InterruptedException, IOException {
		objstg2.UsdTOInr();
		Thread.sleep(3000);
        objscr.scr(driver);

	}
	@Test(priority=3)
	public void SearchHotelss() throws InterruptedException {
		objstg2.SearchHotels();
	     Thread.sleep(3000);
		driver.close();
	}
	@Test(priority=6)
	public void Logout() throws InterruptedException {
	driver.close();
	//objstg2.Logout();	
	Thread.sleep(2000);
	driver.quit();
	}

}
