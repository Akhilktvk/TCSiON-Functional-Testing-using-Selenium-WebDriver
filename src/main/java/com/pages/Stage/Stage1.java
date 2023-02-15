package com.pages.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stage1 {
	WebDriver driver;
	int i=7;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	public WebElement Emailuser;
	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement passworduser;
	@FindBy(xpath="//span[contains(text(),'Login')]")
	public WebElement Loginuser;
	@FindBy(xpath="//div[@class='message']")
	public WebElement  message;
	@FindBy(xpath="(//a[@class=' waves-effect'])[7]")
	 public  WebElement Dashboard;
	@FindBy(xpath="//strong[text()='Demo']")
	public WebElement profileName;
	@FindBy(xpath="(//a[@class=' waves-effect'])[8]")
	public WebElement Booking;
	@FindBy(xpath="(//a[@target='_blank'])[2]")
	public WebElement viewVoucher;
	@FindBy(xpath="(//a[@class=' waves-effect'])[11]")
	public WebElement Logout;
	@FindBy(xpath="(//a[@class=' waves-effect'])[9]")
	public WebElement addfund;
	@FindBy(xpath="//input[@type='number']")
	public WebElement amount;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement paynow;
	@FindBy(xpath="//a[text()='Back to Home']")
	public WebElement Backtoinvoice;
	@FindBy(xpath="//div[@class='btn-front']")
	public WebElement backToinvoice;
	@FindBy(xpath="//a[@class='yes']")
	public WebElement yes;
	@FindBy(xpath="(//a[@class=' waves-effect'])[10]")
	public WebElement profile;
	@FindBy(xpath="//input[@name='address1']")
	public WebElement address;
	@FindBy(xpath="//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div[3]/button")
	public WebElement submit;
	@FindBy(xpath="//p[text()='Please enter your account credentials below']")
	public WebElement confirmLogout;
	@FindBy(xpath="//h3[text()='My Bookings']")
	public WebElement textBooking;
	@FindBy(xpath="//h3[text()='Add Funds']")
	public WebElement textAddfund;
	@FindBy(xpath="//h3[text()='Profile Information']")
	public WebElement textProfile;
	
	
	
	public Stage1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void StageOneEmail(String strEmail) {
		Emailuser.sendKeys(strEmail);
		
	}
	public void StageOnePassword(String strPassword) {
		passworduser.sendKeys(strPassword);
	}
	public void Loguser(){
	Loginuser.click();
	String ProfileName=profileName.getText();
	System.out.println(ProfileName);
		
	}
	public void Logout() {
		Logout.click();
		
	}
	public void Links() throws InterruptedException {
		
			Dashboard.click();
			Thread.sleep(2000);
			
			Booking.click();
			String BookingText=textBooking.getText();
			System.out.println(BookingText);
            Thread.sleep(2000);
			profile.click();
			String ProfileText=textProfile.getText();
			System.out.println(ProfileText);
			Thread.sleep(2000);
			addfund.click();
			String Textaddfund=textAddfund.getText();
			System.out.println(Textaddfund);
			Thread.sleep(2000);
			
			
		
		
	}
	public void AddressUpdate() throws InterruptedException {
		profile.click();
		Thread.sleep(2000);
		address.sendKeys("Akhil123");
		}
	public void addressSubmit() throws InterruptedException {
		submit.click();
		Thread.sleep(3000);
		
	}
	public void payment() throws InterruptedException {
		addfund.click();
	   String TiTle= driver.getTitle();
		System.out.println(TiTle);
		paynow.click();
		Thread.sleep(2000);
	    driver.navigate().back();	
		Thread.sleep(3000);
		
       }
	public void Bookings() {
		Booking.click();
		viewVoucher.click();
	}
	
        public void logout() throws InterruptedException {
        	Logout.click();
        	Thread.sleep(20000);
        	String Verifylogout=confirmLogout.getText();
        	System.out.println(Verifylogout);
        	driver.quit();

        	
        }
}
