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

public class EditLoanSchms {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test
	public void loanscm() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//div/ul/li/a[text()='LOAN SCHEMES']")).click();
		driver.findElement(By.xpath("//div[@id='loans']/div/div/div/div/div/a")).click();
		Thread.sleep(2000);
		Select slt1 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlsearchloantypes")));
		slt1.selectByVisibleText("MORTGAGE LOAN");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnsearchloans")).click();
		Thread.sleep(2000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_loanschemes_im")));
		slt2.selectByVisibleText("MORTGAGE LOAN SCHEME");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btneditloansname")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtloanrenameschemname_im")).clear();
		driver.findElement(By.id("BodyContent_ctl00_txtloanrenameschemname_im"))
				.sendKeys("MORTGAGE LOAN FOR 60 MONTHS");
		driver.findElement(By.id("BodyContent_ctl00_btneditloansname")).click();
		// Update loan scheme button
		Thread.sleep(2000);
		Select slt3 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlsearchloantypes")));
		slt3.selectByVisibleText("MORTGAGE LOAN");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnsearchloans")).click();
		Thread.sleep(2000);
		Select slt4 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_loanschemes_im")));
		slt4.selectByVisibleText("MORTGAGE LOAN FOR 60 MONTHS");
		Thread.sleep(2000);
		Select slt5 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_loanperiods_im")));
		slt5.selectByVisibleText("60 Months");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_txtloanroi_im")).clear();
		driver.findElement(By.id("BodyContent_ctl00_txtloanroi_im")).sendKeys("15");
		driver.findElement(By.id("BodyContent_ctl00_txtloanpenalty_im")).clear();
		driver.findElement(By.id("BodyContent_ctl00_txtloanpenalty_im")).sendKeys("3");
		Thread.sleep(2000);
		Select slt6 = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_im_LoanReceivableGL']")));
		slt6.selectByValue("4");
		Thread.sleep(2000);
		Select slt7 = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_im_LoanRecoveryGL']")));
		slt7.selectByValue("160");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_im_txtStartDateLoan']"));
		ele.sendKeys("01/04/2017");
		ele.click();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_im_txtEndDateLoan']"));
		ele1.sendKeys("01/04/2026");
		ele1.click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_txtloandescription_im")).clear();
		driver.findElement(By.id("BodyContent_ctl00_txtloandescription_im")).sendKeys("Updated");
		// radio Button
		driver.findElement(By.id("BodyContent_ctl00_rdbloanstatusactive")).click();
		Thread.sleep(2000);
		// update
		driver.findElement(By.id("BodyContent_ctl00_btnupdateloanDetails")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@id='BodyContent_ctl00_updateloan']/div/div/div/button")).click();
		driver.quit();
	}
}
