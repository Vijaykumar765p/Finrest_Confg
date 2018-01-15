package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.Properties;

public class ResetPW {
	public static Properties prop = null;
	public static FileInputStream ip = null;

	@Test
	public void rstpwd() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
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
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys("adminfinrest@rscs");
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath("//div[text()='CONFIGURATION']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu53']/div[1]/span")).click();
		driver.findElement(By.xpath("//div[@id='BodyContent_ctl00_divbasicModalpassword']")).click();
		Thread.sleep(3000);
		Select slt1 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlbranch")));
		slt1.selectByVisibleText("Head Office");
		Thread.sleep(3000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddldept")));
		slt2.selectByVisibleText("Cashier");
		Thread.sleep(3000);
		Select slt3 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlname")));
		slt3.selectByVisibleText("cashier@bid001");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtnewpassword")).sendKeys("cashier@bid001.rscs");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtconfirmpassword")).sendKeys("cashier@bid001.rscs");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnupdatepassword")).click();
		Thread.sleep(4000);
		driver.quit();
	}
}
