package com.pages.Stage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Stage2 {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	public WebElement Emailagent;
	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement Passwordagent;
	@FindBy(xpath="//span[contains(text(),'Login')]")
	public WebElement logAgent;
	@FindBy(xpath="//a[@title='tours']")
	public WebElement Tours;
	@FindBy(xpath="//a[@title='visa']")
	public WebElement visa;
	@FindBy(xpath="//a[@title='offers']")
	public WebElement offers;
	@FindBy(xpath="//a[@title='flights']")
	public WebElement flights;
	@FindBy(xpath="//a[@title='hotels']")
	public WebElement hotels;
	@FindBy (xpath="//a[@title='blog']")
	public WebElement blog;
	@FindBy (xpath="//span[@class='select2-selection select2-selection--single']")
	public WebElement Searchhotel;
	@FindBy(xpath="//input[@class='select2-search__field']")
	public WebElement dubai;
	@FindBy(xpath="//div[@class='main_search contact-form-action']")
	public WebElement dubaiHotel;
	@FindBy(id="(//button[@id='submit']")
    public WebElement searchDubai;	
	@FindBy(xpath="(//a[@class=' waves-effect'])[11]")
	public WebElement LogoutStage2;
	@FindBy(xpath="(//a[@class=' waves-effect'])[10]")
	public WebElement addfund;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement paynow;
	@FindBy(xpath="//div[@class='btn-front']")
	public WebElement backToinvoice;
	@FindBy(xpath="//a[@class='yes']")
	public WebElement yes;
	@FindBy(xpath="(//button[@id='currency'])[1]")
	public WebElement Currency;
	@FindBy(xpath="(//a[@class='dropdown-item waves-effect'])[20]")
	public WebElement INR;
	@FindBy(xpath="(//button[@id='currency'])[2]")
	public WebElement account;
	@FindBy(xpath="//a[text()=' Logout']")
	public WebElement logout;
	
	
	
	
	
 
    
	public Stage2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void AgentLogin(String strEmail,String strPassword) {
		Emailagent.sendKeys(strEmail);
		Passwordagent.sendKeys(strPassword);
		logAgent.click();

	}
	public void AgentinvalidLog() {
		Emailagent.sendKeys("agentone@phptravels.com");
		Passwordagent.sendKeys("demoagent");
		logAgent.click();
	}
	public void LinksAction() throws InterruptedException {
		offers.click();
		Thread.sleep(2000);
		blog.click();
		Thread.sleep(3000);
		flights.click();
		Thread.sleep(2000);
		visa.click();
		Thread.sleep(2000);
		Tours.click();
		Thread.sleep(2000);
	}
	public void SearchHotels() throws InterruptedException {
		//Select selectobj = new Select(driver.findElement(By.xpath("//select[@id='hotels_city']"))); 

		hotels.click();
		Searchhotel.click();
		dubai.sendKeys("Dubai");
		Thread.sleep(2000);
		
		WebElement test1 = driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']"));
		
		test1.click();
		
		searchDubai.click();
		
		
	}
	public void UsdTOInr() throws InterruptedException {
		Currency.click();
		INR.click();
		
	}
	public void pay50() throws InterruptedException {
		addfund.click();
		paynow.click();
		Thread.sleep(3000);
		backToinvoice.click();
		yes.click();
	}
	public void Logout() throws InterruptedException {
		account.click();
		Thread.sleep(2000);
		logout.click();
	}
}
