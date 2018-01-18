package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditIntrestposting {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	public WebDriver driver;

	@Test(priority = 0)
	public void editIntPost() throws InterruptedException, IOException {
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
		driver = new ChromeDriver(options);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys("adminfinrest@rscs");
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath("//div[text()='CONFIGURATION']")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu51']/div[1]/span")).click();
		driver.findElement(By.xpath("//div/ul/li/a[text()='INTEREST POSTING SETTING']")).click();
		driver.findElement(By.xpath("//*[@id='BodyContent_ctl00_UpdatePanel13']/div/div/div/div/div/a")).click();
		Thread.sleep(2000);
		Select slt1 = new Select(driver.findElement(By.xpath("//*[@id='BodyContent_ctl00_ddlacctypeinmodal']")));
		slt1.selectByVisibleText("SAVING DEPOSIT");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnsearchinposting")).click();
		Thread.sleep(3000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttypeinmodal")));
		slt2.selectByVisibleText("Productive");
		Thread.sleep(3000);
		Select slt3 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlintpostingtypeinmodal")));
		slt3.selectByVisibleText("Half Yearly");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnpdateintpost']")).click();
		driver.quit();
	}
}
