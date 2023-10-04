package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioBtnPage {
	
	public WebElement TabRadioBtn (WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Radio Button']"));
	}
	public WebElement RadioBtn (WebDriver driver,String Condition) {
		return driver.findElement(By.xpath("//label[text()='"+Condition+"']"));
	}
	public WebElement TextResult (WebDriver driver) {
		return driver.findElement(By.className("text-success"));
	}
}
