package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonPage {
	
	public WebElement tabButton(WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Buttons']"));
	}
	public WebElement DblClkbutton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Double Click Me']"));
	}
	public WebElement RghtClkButton(WebDriver driver) {
		return driver.findElement(By.xpath("//button[text()='Right Click Me']"));
	}
}
