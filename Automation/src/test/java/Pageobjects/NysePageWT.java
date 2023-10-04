package Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NysePageWT {

	public List<WebElement> ListCols (WebDriver driver) {
		return driver.findElements(By.xpath("//table[@class='table-data w-full table-border-rows']//tr[3]//th"));
	}
	public List<WebElement> ListRows (WebDriver driver) { 
		return driver.findElements(By.xpath("//tbody//tr"));
	}
	public WebElement FinanceProceeds (WebDriver driver) {
		return driver.findElement(By.xpath("//tbody//tr//td[text()='Technology']//following::td[1]"));
	}
	public List<WebElement> NumberDeals (WebDriver driver){
		return driver.findElements(By.xpath("//td[3]"));
	}
	public WebElement MinSector (WebDriver driver,int MinimumVal) {
		return driver.findElement(By.xpath("//td[text()='"+ MinimumVal +"']/parent::*//td[1]"));
	}
}
