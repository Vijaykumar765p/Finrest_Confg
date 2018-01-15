package configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddLedgerGL {
	@Test
	public void AddLedger() throws InvalidFormatException, IOException, InterruptedException

	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		Map<String, Object> prefs = new HashMap<String, Object>();
	 	prefs.put("credentials_enable_service", false);
	 	prefs.put("password_manager_enabled", false); 
	 	options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://demo/finrest/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath(".//*[@id='menu5']/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu54']/div[1]/span")).click();
		driver.findElement(By.xpath(".//*[@id='td_GL']/a")).click();
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtglname']")).sendKeys("Ridhi Savings Certificate");
		WebElement PL = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtpsblhead']"));
		PL.sendKeys("DEP");
		Thread.sleep(1000);
		PL.sendKeys(Keys.DOWN);
		PL.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement ac = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtacctype']"));
		ac.sendKeys("Fix");
		Thread.sleep(1000);
		ac.sendKeys(Keys.DOWN);
		ac.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtopeningbal']")).sendKeys("0");
		Thread.sleep(1000);
		Select Constitution = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlopeningtype']")));
		Constitution.selectByValue("Cr");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavegldetails']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
