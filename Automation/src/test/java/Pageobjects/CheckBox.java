package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

	public WebElement tabCheckbox(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Check Box']"));
	}
	public WebElement chkbxHome(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Home']"));
	}
	public WebElement lblselection(WebDriver driver) {
		return driver.findElement(By.id("result"));
	}
}
