package DemoQA.Automation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import Pageobjects.BrowserWindowPage;
import Pageobjects.ButtonPage;
import Pageobjects.CheckBox;
import Pageobjects.Elements;
import Pageobjects.FramesPage;
import Pageobjects.NysePageWT;
import Pageobjects.RadioBtnPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testscript {
	WebDriver driver = new ChromeDriver();	
	Actions action = new Actions(driver);

	@BeforeTest
	public void LaunchChrome() {
		WebDriverManager.chromedriver().setup();
		Dimension D = new Dimension(1920,1080);
		driver.manage().window().setSize(D);
		driver.get("https://demoqa.com/elements");
		String PageTitle = driver.getTitle();
		if(PageTitle.equalsIgnoreCase("DEMOQA") ) {
			Reporter.log("DEMO QA page is loaded properly");
		}
		else {
			Reporter.log("<br>Page isnot loaded properly");
		}
	}
	@AfterTest
	public void CloseBrowser(){
		driver.quit();
	}
	
	@Test(priority = 1)
	public void Elements() {
		//Handling Elements
		Elements Elementspage = new Elements(); 
		Elementspage.tabTextBox(driver).click();
		Elementspage.txtFullName(driver).isDisplayed();
		Elementspage.txtFullName(driver).sendKeys("Govind");
		Elementspage.txtEmailid(driver).sendKeys("sampleemail@gmail.com");
		Elementspage.txtCurAddress(driver).sendKeys("Sowkarpet");
		Elementspage.txtPerAddress(driver).sendKeys("Madipakkam");
		Elementspage.btnSubmit(driver).click();

	}
	@Test(priority = 2)
	public void Checkbox() {
		//Handling CheckBox
		CheckBox Chkboxpage = new CheckBox();
		Chkboxpage.tabCheckbox(driver).click();
		Chkboxpage.chkbxHome(driver).isDisplayed();
		Chkboxpage.chkbxHome(driver).click();
		Chkboxpage.chkbxHome(driver).isSelected();
		Chkboxpage.lblselection(driver).isDisplayed();
	}
	@Test(priority = 3)
	public void RadioButtons() throws InterruptedException {
		//Handling Radio buttons
		RadioBtnPage radiobtnpage = new RadioBtnPage();
		radiobtnpage.TabRadioBtn(driver).click();
		radiobtnpage.RadioBtn(driver,"Yes").click();
		String result = radiobtnpage.TextResult(driver).getText();
		Reporter.log(result + "button is clicked");
		radiobtnpage.RadioBtn(driver,"Impressive").click();
		String result1 = radiobtnpage.TextResult(driver).getText();
		Reporter.log("<br>"+result1+" button is clicked");			
	}
	@Test(priority=4)
	public void Buttons() throws IOException {
		//Handling Buttons
		ButtonPage Btnpage = new ButtonPage();
		Btnpage.tabButton(driver).click();
		action.doubleClick(Btnpage.DblClkbutton(driver)).perform();
		action.contextClick(Btnpage.RghtClkButton(driver)).perform();
		TakesScreenshot Screenshot = (TakesScreenshot)driver;
		File Sourcefile = Screenshot.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./Screenshots/sample.png");
		FileHandler.copy(Sourcefile, Dest);
	}
	@Test(priority=5)
	public void Webtables() throws InterruptedException {
		//Handling WebTables
		driver.get("https://www.nyse.com/ipo-center/ipo-pricing-stats");
		Thread.sleep(3000);
		NysePageWT WebTable = new NysePageWT();
		//ROW COUNT
		int columncount = WebTable.ListCols(driver).size();
		Reporter.log("The total number of columns = " + columncount);
		//COLUMN COUNT
		int rowcount = WebTable.ListRows(driver).size();
		Reporter.log("<br>The total number of rows = " + rowcount);
		//Dynamic Value Changing Field
		String FinanProceeds = WebTable.FinanceProceeds(driver).getText();
		Reporter.log("<br>Technology Proceedings in $ = "+ FinanProceeds);
		List<Integer> NumberList = new ArrayList<Integer>();
		for(WebElement WElement : WebTable.NumberDeals(driver)) {
			String numbers = WElement.getText();
			NumberList.add(Integer.parseInt(numbers));
		}
		int MinVal = Collections.min(NumberList);
		String SectorName = WebTable.MinSector(driver, MinVal).getText();
		Reporter.log("<br>The Minium number of Deals is "+ MinVal + " and the Sector is " + SectorName);
	}
	@Test (priority =6)
	public void IFrames() throws InterruptedException {
		//Handling Frames
		driver.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(3000);
		FramesPage FPage = new FramesPage();
		driver.switchTo().frame(FPage.SingleFrame(driver));
		Reporter.log("Driver is changed to SingleFrame");
		Boolean VerifytxtBox1 = FPage.TextBoxF1(driver).isDisplayed();
		if(VerifytxtBox1.toString().equalsIgnoreCase("true"));{
			Reporter.log("<br>The text box is interactable");	
		}
		driver.switchTo().defaultContent();
		FPage.tabNestFrame(driver).click();
		Thread.sleep(2000);
		driver.switchTo().frame(FPage.NestedFrame1(driver));
		driver.switchTo().frame(FPage.NestedFrame2(driver));
		Boolean VerifytxtBox2 = FPage.TextBoxF1(driver).isDisplayed();
		Assert.assertTrue(VerifytxtBox2, "The Text Box should be interactable");
		driver.switchTo().defaultContent();
		}
	@Test(priority=7)
	public void WindowHandle () throws IOException {
		driver.get("https://demoqa.com/browser-windows");
		BrowserWindowPage window = new BrowserWindowPage();
		String ParentHandle = driver.getWindowHandle();
		window.btn_NewTab(driver).click();
		Set <String> navWindow1 = driver.getWindowHandles();
		for(String iterator : navWindow1 ) { 
			driver.switchTo().window(iterator);
		}
		String label1 = window.lbl_text(driver).getText();
		Reporter.log( "<br>"+label1+ "Window is switched and Driver can locate the text");
		driver.switchTo().window(ParentHandle);
		window.btn_NewWin(driver).click();
		Set <String> navWindow2 = driver.getWindowHandles();
		for(String iterator : navWindow2 ) { 
			driver.switchTo().window(iterator);
		}
		String label2 = window.lbl_text(driver).getText();
		File lbl1 = window.lbl_text(driver).getScreenshotAs(OutputType.FILE);
		File slbl1 = new File("./Screenshots/"+label2+".png");
		FileHandler.copy(lbl1, slbl1);
		Reporter.log("<br>"+ label2+ "Window is switched and Driver can locate the text");

	}	
}
