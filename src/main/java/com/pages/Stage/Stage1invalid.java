package com.pages.Stage;

import org.openqa.selenium.WebDriver;

public class Stage1invalid extends Stage1{
	WebDriver driver;

	public Stage1invalid(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		public void Stageoneinvalidmail() {
			Emailuser.sendKeys("userone@phptravel.com");
			
		}
		public void StageoneinvalidPassword() {
			passworduser.sendKeys("demouser");
		}
		public void Logeinvaliduser() {
			Loginuser.click();
		}public void loginfailedmsg() {
			String validationmsg= message.getText();
			System.out.println(validationmsg);
		}
	}


