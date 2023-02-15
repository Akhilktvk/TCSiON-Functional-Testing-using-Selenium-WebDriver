package com.pages.Stage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stage4 {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement emailsupplier;
	@FindBy(xpath="//input[@type='password']")
	public WebElement passwordSupplier;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement Logsupplier;
	@FindBy(xpath="//div[@class='text-muted']")
	public WebElement Text2;
	@FindBy(xpath="//div[text()='Invalid Login Credentials']")
	public WebElement invalidText;
	@FindBy(xpath="//h2[text()='Revenue Breakdown 2023']")
	public WebElement revenue;
	@FindBy(xpath="//div[text()='Stats of year 2023']")
	public WebElement status;
	@FindBy(xpath="//a[text()='Website']")
	public WebElement websitelink;
	@FindBy(xpath="//a[text()='Bookings']")
	public WebElement Bookings;
	@FindBy(xpath="//button[@id='dropdownMenuProfile']")
	public WebElement Menu;
	@FindBy(xpath="//div[text()='Logout']")
	public WebElement Logout;
	@FindBy(xpath="//a[text()='Docs']")
	public WebElement docs;
	@FindBy(xpath="(//div[text()='Flights'])[1]")
	public WebElement flightLink;
	@FindBy(xpath="(//div[text()='Tours'])[1]")
	public WebElement ToursLink;
	
	
	
	public Stage4(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	public void Stage4invalidLogin() throws InterruptedException {
		emailsupplier.sendKeys("supplierone@phptravels.com");
		passwordSupplier.sendKeys("demosupplier");
		Logsupplier.click();
		Thread.sleep(2000);
		String invalidtext=invalidText.getText();
		System.out.println(invalidtext);
		driver.navigate().refresh();
	}
	public void Stage4validSupplier(String strEmail,String strPassword) {
		emailsupplier.sendKeys(strEmail);
		passwordSupplier.sendKeys(strPassword);
		Logsupplier.click();
	}
	public void Text() {
		String text1= "Sales overview & summary";
		String Text2String = Text2.getText();
		if (text1.equals(Text2String)) {
			System.out.println("Passed");
			}
		else {
			System.out.println("failed");
		}
	}
	public void RevenueBreakDown() {
		
		String revenueText=revenue.getText();
		System.out.println(revenueText);
	String StatusText=	status.getText();	
		System.out.println(StatusText);

	}
	public void Bookinss() throws InterruptedException {
		Bookings.click();
		Thread.sleep(2000);
	}
	public void Logoutt() throws InterruptedException {
		Menu.click();
		Thread.sleep(2000);
		Logout.click();
	}
	public void childDoc()  {
		docs.click();

	}
	public void FlightLinkss() throws InterruptedException {
	
		flightLink.click();
		Thread.sleep(2000);
		driver.navigate().back();


}
	public void Tourslink() throws InterruptedException {
		ToursLink.click();
		Thread.sleep(2000);
		
	}
	
	

}
