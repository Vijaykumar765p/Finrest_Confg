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

public class AddAcctSchms {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test
	public void Addacct() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
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
		Thread.sleep(2000);
		Select glname = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
		glname.selectByVisibleText("SAVING DEPOSIT");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtscheme']")).sendKeys("2 Year Scheme");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtroi']")).sendKeys("2");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtmammount']")).sendKeys("100");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtaccountdescription']")).sendKeys("2 Year Scheme");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavead']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
