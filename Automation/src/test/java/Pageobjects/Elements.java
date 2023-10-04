package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {

	//tabTextBox
	public WebElement tabTextBox (WebDriver driver) {
		return driver.findElement(By.xpath("//span[text()='Text Box']"));
	}
	//text box full name
	public WebElement txtFullName (WebDriver driver) {
		return driver.findElement(By.xpath("//label[text()='Full Name']//following::input[@placeholder='Full Name']"));
	}
	//text email id
	public  WebElement txtEmailid (WebDriver driver) {
		return driver.findElement(By.xpath("//label[text()='Email']//following::input[@placeholder='name@example.com']"));
	}
	//Current Address
	public  WebElement txtCurAddress (WebDriver driver) {
		return driver.findElement(By.xpath("//label[text()='Current Address']//following::textarea[@placeholder='Current Address']"));
	}
	//Permenant Address
	public  WebElement txtPerAddress (WebDriver driver) {
		return driver.findElement(By.xpath("//label[text()='Permanent Address']//following::textarea[@id='permanentAddress']"));
	}
	//Submit button
	public  WebElement btnSubmit (WebDriver driver) {
		return driver.findElement(By.id("submit"));
	}
}
