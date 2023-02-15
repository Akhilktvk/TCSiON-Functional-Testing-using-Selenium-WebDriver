package com.configaration.screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Screenshot {
	 WebDriver driver;

	public void scr(WebDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ","-").replace(":","-");
		//System.out.println(screenshotfilename);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotfilename+".png"));
	}

}
