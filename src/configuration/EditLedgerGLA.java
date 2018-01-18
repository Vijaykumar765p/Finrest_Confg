package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLedgerGLA {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test
	public void EditLedger() throws InvalidFormatException, IOException, InterruptedException {
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
		driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath(".//*[@id='menu5']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu54']/div[1]/span")).click();
		driver.findElement(By.xpath(".//*[@id='td_GL']/a")).click();
		driver.findElement(By.xpath(".//*[@id='GL']/div/div[1]/div/div/div[2]/a")).click();
		Thread.sleep(2000);
		WebElement searchgl = driver.findElement(By.xpath(".//*[@id='txtsearchglname']"));
		searchgl.sendKeys("RID");
		Thread.sleep(3000);
		searchgl.sendKeys(Keys.DOWN);
		searchgl.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnserachgldetails']")).click();
		Thread.sleep(2000);
		WebElement glname = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_m_txtglname']"));
		glname.clear();
		glname.sendKeys("Riddhi siddhi Savings Certificate");
		WebElement pl = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_m_txtpsblhead']"));
		pl.clear();
		pl.sendKeys("ass");
		Thread.sleep(2000);
		pl.sendKeys(Keys.DOWN);
		pl.sendKeys(Keys.ENTER);
		WebElement actype = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_m_txtacctype']"));
		actype.clear();
		actype.sendKeys("Fix");
		Thread.sleep(2000);
		actype.sendKeys(Keys.DOWN);
		actype.sendKeys(Keys.ENTER);
		WebElement openigbl = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_m_txtopeningbal']"));
		openigbl.clear();
		openigbl.sendKeys("100");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnupdate_gldtails']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
