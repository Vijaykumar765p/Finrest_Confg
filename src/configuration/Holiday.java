package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Holiday {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test
	public void hlydy() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
		prop.load(ip);
		options.addArguments("--disable-extensions");
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath("//div[text()='CONFIGURATION']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uc_menu_td_sub_menu53")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='BodyContent_ctl00_divmodalholiday']")).click();
		Thread.sleep(3000);
		WebElement cl = driver.findElement(By.id("txtHDate"));
		cl.sendKeys("15/08/2017");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("BodyContent_ctl00_txtHReason"));
		ele.sendKeys("Independence Day");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnSaveHoliday']")).click();
		Thread.sleep(1000);
		// Edit Holiday
		driver.findElement(By.id("BodyContent_ctl00_btnList")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnEditHoliday")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='txtHDate']")).sendKeys("02/10/2017");

		WebElement ele2 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtHReason']"));
		Thread.sleep(3000);
		ele2.clear();
		Thread.sleep(2000);
		ele2.sendKeys("Gandhi jayanti");
		WebElement UPDATE = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSaveHoliday']"));
		UPDATE.click();
		Thread.sleep(1000);
		driver.quit();
	}
}
