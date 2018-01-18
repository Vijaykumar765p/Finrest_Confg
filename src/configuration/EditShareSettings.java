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

public class EditShareSettings {
	public static Properties prop = null;
	public static FileInputStream ip = null;

	@Test()
	public void EditShareSt() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_td_fess_penalty']/a")).click();
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_UpdatePanel12']/div[2]/div[1]/div/div/div[2]/a"))
				.click();
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlsharetypesinmodal']")));
		select.selectByVisibleText("NOMINAL SHARES MEMBER");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsearchshareinmodal']")).click();
		Thread.sleep(2000);
		WebElement min = driver.findElement(By.xpath(".//*[@id='im_txtnoshares']"));
		Thread.sleep(1000);
		min.clear();
		min.sendKeys("2");
		WebElement amt = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_im_txtamountpershare']"));
		Thread.sleep(1000);
		amt.clear();
		amt.sendKeys("15");
		WebElement fee = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_im_txtsharefee']"));
		Thread.sleep(1000);
		fee.clear();
		fee.sendKeys("10");
		WebElement amt1 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_im_txtentrancefee']"));
		Thread.sleep(1000);
		amt1.clear();
		amt1.sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnupdate_shares']")).click();
		Thread.sleep(1000);
		driver.quit();
	}
}
