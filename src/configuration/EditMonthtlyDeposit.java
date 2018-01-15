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

public class EditMonthtlyDeposit {
	public static Properties prop = null;
	public static FileInputStream ip = null;

	@Test
	public void editmis() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//div/ul/li/a[text()='DEPOSITS SCHEMES']")).click();
		driver.findElement(By.xpath("//div[@id='deposits']/div/div/div/div/div/a")).click();
		Thread.sleep(2000);
		Select slt1 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlsearchdeposit")));
		slt1.selectByVisibleText("M.I.S. DEPOSIT (Monthly)");
		System.out.println(slt1);
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnserachdeposit")).click();
		Thread.sleep(3000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddldepositedlsinmodal")));
		slt2.selectByVisibleText("1 years to 2 years MIS");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnupdatedepositschememodal")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtnewdepositeschemename")).clear();
		driver.findElement(By.id("BodyContent_ctl00_txtnewdepositeschemename")).sendKeys("M I S MONTHLY SCHEME");
		driver.findElement(By.id("BodyContent_ctl00_btnupdatedepositschememodal")).click();
		Thread.sleep(3000);
		// Update
		Select slt3 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlsearchdeposit")));
		slt3.selectByVisibleText("M.I.S. DEPOSIT (Monthly)");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnserachdeposit")).click();
		Thread.sleep(3000);
		Select slt4 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddldepositedlsinmodal")));
		slt4.selectByVisibleText("M I S MONTHLY SCHEME");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_im_txtdroi")).clear();
		driver.findElement(By.id("BodyContent_ctl00_im_txtdroi")).sendKeys("13");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_im_txtminamount")).clear();
		driver.findElement(By.id("BodyContent_ctl00_im_txtminamount")).sendKeys("1000");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtPMIntUpDate")).clear();
		driver.findElement(By.id("BodyContent_ctl00_txtPMIntUpDate")).sendKeys("2.50");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtSeniorCitUpdate")).clear();
		driver.findElement(By.id("BodyContent_ctl00_txtSeniorCitUpdate")).sendKeys("0");
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateUpdate']"));
		ele.sendKeys("01/04/2017");
		ele.click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateUpdate']"));
		ele1.sendKeys("01/04/2025");
		ele1.click();
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_im_txtdescription")).clear();
		driver.findElement(By.id("BodyContent_ctl00_im_txtdescription")).sendKeys("M I S MONTHLY SCHEME");
		Thread.sleep(1000);
		// update
		driver.findElement(By.id("BodyContent_ctl00_btnupdatedeposit")).click();
		Thread.sleep(4000);
		driver.quit();
	}
}