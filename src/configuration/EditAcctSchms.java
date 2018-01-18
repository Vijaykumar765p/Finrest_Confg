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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditAcctSchms {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test
	public void EditAcctScm() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
		prop.load(ip);
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
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath("//div[text()='CONFIGURATION']")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu51']/div[1]/span")).click();
		driver.findElement(By.xpath(".//*[@id='accounts']/div[2]/div[1]/div/div/div[2]/a")).click();
		Thread.sleep(2000);
		Select glname = new Select(driver.findElement(By.xpath(".//*[@id='ddlsearchad']")));
		glname.selectByVisibleText("SAVING DEPOSIT");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsearchad']")).click();
		Thread.sleep(2000);
		Select sname = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlmodalaccountscheme']")));
		sname.selectByVisibleText("2 Year Scheme");
		Thread.sleep(2000);
		WebElement rename = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtnewschemename']"));
		rename.clear();
		rename.sendKeys("1 Year Scheme");
		WebElement roi = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtroiacc']"));
		roi.clear();
		roi.sendKeys("5");
		WebElement mind = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtmammountacc']"));
		mind.clear();
		mind.sendKeys("1");
		WebElement desc = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtaccdescription']"));
		desc.clear();
		desc.sendKeys("1 Year Scheme");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnupdatead']")).click();
		driver.quit();
	}
}