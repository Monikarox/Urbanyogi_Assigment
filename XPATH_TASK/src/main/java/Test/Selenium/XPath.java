package Test.Selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XPath {

	String ADDREMOVEELEMENTURL=null, DOM=null,CHECKBOXESURL=null, DROPDOWNURL=null,
	NOTIF_URL=null, WINDOW_URL=null, STATUS=null, GEO_URL=null, INPUT_URL=null, TABLES=null, TYPOS= null, LARGE=null,
    DYNAMICCONTENTURL=null, DYNAMICLOADINGURL=null, FRAMESURL=null;
			
	
	static Logger logger = Logger.getLogger(XPath.class);
	
	WebDriver driver;
	
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver","D://chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeClass
	public void XPath() 
	{
	
	ADDREMOVEELEMENTURL = "https://the-internet.herokuapp.com/add_remove_elements/";
	DOM                 = "https://the-internet.herokuapp.com/challenging_dom";
    CHECKBOXESURL       = "https://the-internet.herokuapp.com/checkboxes";	
	DROPDOWNURL         = "https://the-internet.herokuapp.com/dropdown";
	DYNAMICCONTENTURL   = "https://the-internet.herokuapp.com/dynamic_content";
	DYNAMICLOADINGURL   = "https://the-internet.herokuapp.com/dynamic_loading";
	FRAMESURL           = "https://the-internet.herokuapp.com/frames";
	NOTIF_URL           = "https://the-internet.herokuapp.com/notification_message_rendered";
	WINDOW_URL          = "https://the-internet.herokuapp.com/windows";
	STATUS              = "https://the-internet.herokuapp.com/windows";
	GEO_URL             = "https://the-internet.herokuapp.com/geolocation";
	INPUT_URL           = "https://the-internet.herokuapp.com/inputs";
	TABLES              = "https://the-internet.herokuapp.com/tables";
	TYPOS               = "https://the-internet.herokuapp.com/typos";
	LARGE               =  "https://the-internet.herokuapp.com/large";

	}

	@Test
	public void AddRemoveElementTest() throws InterruptedException {
		driver.get(ADDREMOVEELEMENTURL);
		WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
		for (int i = 0; i < 10; i++)
			{addElementButton.click(); Thread.sleep(200);}

		List<WebElement> deleteButton = driver.findElements(By.xpath("//button[@class='added-manually']"));
		assertEquals(deleteButton.size(), 10);
		if (deleteButton.size() == 10) {
			deleteButton.forEach(action -> action.click());
		}
	}

	@Test
	public void ChallengingDOM() {
	
		driver.get(DOM);
		WebElement button = driver.findElement(By.xpath("//a[@class='button']"));
		button.click();
		String tableCellData = driver
				.findElement(By.xpath(
						"//*/canvas[@id='canvas']/ancestor::div[@class='large-10 columns']/table/tbody/tr[2]/td[6]"))
				.getText();
		assertEquals(tableCellData, "Phaedrum1");
	}

	@Test
	public void checkBoxes() {
	
		driver.get( CHECKBOXESURL);
		WebElement checkbox1 = driver.findElement(By.xpath("//form/input[@type='checkbox'][1]"));
		if (!checkbox1.isSelected())
			checkbox1.click();
		assertTrue(checkbox1.isSelected());
	}

	@Test
	public void dropdown() throws InterruptedException {
		driver.get(	DROPDOWNURL );
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByVisibleText("Option 1");
		Thread.sleep(2000);
		dropdown.selectByVisibleText("Option 2");
		assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");
	}

	@Test
	public void dynamicContent() {
	
		driver.get(	DYNAMICCONTENTURL);
		String content1 = driver.findElement(By.xpath("//div[@id='content']/div[@class='row'][3]")).getText();
		WebElement button = driver.findElement(By.xpath("//div[@class='example']/p/a[text()='click here']"));
		button.click();
		String content2 = driver.findElement(By.xpath("//div[@id='content']/div[@class='row'][3]")).getText();
		assertNotEquals(content1, content2);

	}

	@Test
	public void dynamicLoading() {
	
		driver.navigate().to(DYNAMICLOADINGURL);
		WebElement link1 = driver.findElement(By.xpath("//*/a[@href='/dynamic_loading/1']"));
		link1.click();
		WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
		startButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[@id='finish']/h4")))
				.getText();
		logger.info("Diplayed test is " + text);
		driver.navigate().back();

		WebElement link2 = driver.findElement(By.xpath("//*/a[@href='/dynamic_loading/2']"));
		link2.click();
		WebElement startButton2 = driver.findElement(By.xpath("//div[@id='start']/button"));
		startButton2.click();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		String text2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[@id='finish']/h4")))
				.getText();
		logger.info("Diplayed test is " + text2);
		driver.navigate().back();
	}

	@Test
	public void frameTest() {

		driver.navigate().to(FRAMESURL );
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='content']//a[1]")).click();
		driver.switchTo().frame(0);
		driver.switchTo().frame(2);
		logger.info(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);
		logger.info(driver.findElement(By.xpath("//body")).getText());
	}

	@Test
	public void large() throws InterruptedException {
		
		String url =LARGE;
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(3000);

		String lastDivText = driver.findElement(By.xpath("//div[@id='siblings']/descendant::div[last()]")).getText();
		assertEquals(lastDivText, "50.3");
		Thread.sleep(3000);
		String lastDivText2 = driver.findElement
		(By.xpath("//table[@id='large-table']/tbody/tr[last()]/td[last()]")).getText();
		assertEquals(lastDivText, "50.50");
	}

	@Test
	public void typos() throws InterruptedException {


		String url = TYPOS;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(url);
		Thread.sleep(1000);
		WebElement paragraph = driver.findElement(By.xpath("//div[@class='example']//p[2]"));
		String text = paragraph.getText();
		if (text.equals("Sometimes you'll see a typo, other times you won't.")) {
			logger.info("Typo not present");
		} else {
			logger.info("Typo present");
		}
	}

	@Test
	public void tables() throws InterruptedException {

		final long WAITTIME = 1500;

		int i;
	
		driver.navigate().to(TABLES);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
		int count = elements.size();
		List<String> oldColumn = new ArrayList<String>();
		for (i = 0; i < count; i++)
			oldColumn.add(elements.get(i).getText());
		Thread.sleep(WAITTIME);
		driver.findElement(By.xpath("//table[@id='table1']//span[text()='Last Name']")).click();
		elements = driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
		List<String> newColumn = new ArrayList<String>();
		for (i = 0; i < count; i++)
			newColumn.add(elements.get(i).getText());

		Collections.sort(oldColumn);
		assertEquals(newColumn, oldColumn);
		logger.info("Sorting of Table Verified Successfully.");
	}

	@Test
	public void input() {

	
		driver.navigate().to(INPUT_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement num = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input"));
		num.sendKeys("12345");

	}

	@Test
	public void geolocation() throws InterruptedException {
	
		String url = GEO_URL;

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(1000);
		WebElement button = driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
		button.click();
		String latValue = driver.findElement(By.id("lat-value")).getText();
		String longValue = driver.findElement(By.id("long-value")).getText();
		logger.info(longValue + " " + latValue);
	}

	@Test
	public void statuscodes() {
	
		driver.get(STATUS);

		String url = driver.getCurrentUrl().toString();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		WebElement t = driver.findElement(By.xpath("//a[contains(@href,'status_codes/200')]"));
		t.click();
		WebElement here = driver.findElement(By.xpath("//a[contains(@href,'/status_codes')]"));
		here.click();
		String newUrl = driver.getCurrentUrl().toString();
		assertEquals(url, newUrl);
	}

	@Test
	public void windowOpening() throws InterruptedException {
		
		String url = WINDOW_URL;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
		WebElement a = driver.findElement(By.xpath("//a[@href='/windows/new']"));
		a.click();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		assertEquals(newTab.size(), 2);
		for (String tab : newTab) {
			driver.switchTo().window(tab);
		}
	}

	@Test
	public void notification() throws InterruptedException {
		String elementXpath = "//a[@href=\"/notification_message\"]";
		
		driver.get(NOTIF_URL);
		while (true) {
			Thread.sleep(4000);
			driver.findElement(By.xpath(elementXpath)).click();
			if (driver.findElement(By.id("flash")).getText().contains("successful")) {
				break;
			}
			Thread.sleep(1000);
		}

	}

}