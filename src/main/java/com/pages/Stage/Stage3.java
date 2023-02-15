package com.pages.Stage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stage3 {
   WebDriver driver;
   @FindBy(xpath="(//input[@name='email'])[1]")
   public WebElement Emailadmin;
   @FindBy(xpath="//input[@name='password']")
   public WebElement Password;
   @FindBy(xpath="//button[@type='submit']")
   public WebElement submit;
   @FindBy(xpath="//a[@class='nav-link loadeffect']")
   public WebElement Bookingss;
   @FindBy(xpath="(//select[@id='booking_status'])[5]")
   public WebElement pending;
   @FindBy(xpath="(//option[text()='pending'])[5]")
   public WebElement selectPending;
   @FindBy(xpath="(//div[@class='d-flex justify-content-between align-items-center mb-2'])[2]")
   public WebElement pendingbBooking;
   @FindBy(xpath="//*[@id=\"data\"]/tbody/tr[5]/td[14]/a")
   public WebElement invoice;
   @FindBy(xpath="(//div[@class='d-flex justify-content-between align-items-center mb-2'])[3]")
   public WebElement cancelBooking;
   @FindBy(xpath="(//a[@class='nav-link'])[1]")
   WebElement WebLink;
   @FindBy(xpath="//th[text()='Booking Status']")
   public WebElement BookingText;
   @FindBy(xpath="//button[@id='dropdownMenuProfile']")
   public WebElement profile;
   @FindBy(xpath="(//div[@class='me-3'])[1]")
   public WebElement selectProfile;
   @FindBy(xpath="//div[text()='Profile Update']")
   public WebElement confirmProfile;
   @FindBy(xpath="(//select[@id='booking_status'])[8]")
   public WebElement BookingRecord;
   @FindBy(xpath="(//option[text()='Confirmed'])[7]")
   public WebElement confirmRecord;
   @FindBy(xpath="//a[text()='Website']")
   public WebElement website;
   @FindBy(xpath="(//button[@class='btn btn-danger'])[2]")
   public WebElement DeleteRecord;
   @FindBy(xpath="//a[@id='data_next']")
   public WebElement next;
   @FindBy(xpath="(//div[@class='display-5'])[2]")
   public WebElement pendingCount;
   


   public Stage3(WebDriver driver) {
	   this.driver=driver;
		PageFactory.initElements(driver, this);
	   
   }
   
   public void StageThreeInvalidAdmin() throws InterruptedException {
	   Emailadmin.sendKeys("adminone@phptravels.com");
	   Password.sendKeys("demoadmin");
	   submit.click();
	   Thread.sleep(2000);
	   }
   public void Stage3ValidAdmin(String strEmail,String strPassword) {
	   Emailadmin.sendKeys(strEmail);
	   Password.sendKeys(strPassword);
	   submit.click();
   }
   public void Links() throws InterruptedException {
	   Bookingss.click();
	   driver.switchTo().alert().accept();
	   

	   Thread.sleep(2000);
	  String BookingLink=BookingText.getText();
	   System.out.println(BookingLink);
	   driver.navigate().back();
	   profile.click();
	   selectProfile.click();
	   Thread.sleep(2000);
	   String profileValidation=confirmProfile.getText();
	   System.out.println(profileValidation);
	   
	   
   }
   public void BookingInvoice() throws InterruptedException {
	   Bookingss.click();
	   driver.switchTo().alert().accept();
	   JavascriptExecutor js = (JavascriptExecutor) driver;
   	js.executeScript("window.scrollBy(0,250)", "");

	   invoice.click();
	   Thread.sleep(2000);
	   
	   
   }
   public void Websitee() throws InterruptedException {
	   website.click();
	   Thread.sleep(2000);
   }
   public void RecordDelete() throws InterruptedException {
	   Bookingss.click();
	   driver.switchTo().alert().accept();

	   Thread.sleep(2000);
	   next.click();
	   Thread.sleep(2000);
	   DeleteRecord.click();
	   Thread.sleep(3000);
	   driver.switchTo().alert().dismiss();
	   
   }
   public void PendingConfirm() throws InterruptedException {
	   pendingbBooking.click();
	   String pendingCurrentcount=pendingCount.getText();
	   System.out.println(pendingCurrentcount);
	   pending.click(); 
	   Thread.sleep(2000);
	   selectPending.click();
   }
}