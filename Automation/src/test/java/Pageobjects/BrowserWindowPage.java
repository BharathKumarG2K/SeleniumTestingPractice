package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserWindowPage {
	
	public WebElement btn_NewTab(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='New Tab']"));
	}
	
	public WebElement lbl_text(WebDriver driver) {
		return driver.findElement(By.xpath("//h1[text()='This is a sample page']"));
	}
	public WebElement btn_NewWin(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='New Window']"));
	}
	public WebElement btn_NewWinMes(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='New Window Message']"));
	}
	public WebElement lbl_Text2(WebDriver driver) {
		return driver.findElement(By.xpath("//body[text()='Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.']"));
	}
	
}
