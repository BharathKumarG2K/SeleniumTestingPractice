package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPage {
	
	public WebElement SingleFrame(WebDriver driver) {
		return driver.findElement(By.id("singleframe"));
	}
	public WebElement TextBoxF1 ( WebDriver driver) {
		return driver.findElement(By.xpath("//input[@type='text']"));
	}
	public WebElement NestedFrame1(WebDriver driver) {
		return driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
	}
	public WebElement tabNestFrame(WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
	}
	public WebElement NestedFrame2(WebDriver driver) {
		return driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
	}
}
