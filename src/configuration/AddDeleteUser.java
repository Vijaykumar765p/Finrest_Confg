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

public class AddDeleteUser {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	public WebDriver driver;

	@Test(priority = 0)
	public void Login() throws InterruptedException, IOException {
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
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath("//div[text()='CONFIGURATION']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uc_menu_td_sub_menu53")).click();
	}

	@Test(priority = 1)
	public void addusr1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='BodyContent_ctl00_divbasicModaladduser']")).click();
		Thread.sleep(2000);
		Select slt1 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_branch")));
		slt1.selectByVisibleText("Head Office");
		Thread.sleep(3000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_dept")));
		slt2.selectByVisibleText("Manager");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtRegFullName")).sendKeys("ManagerHO");
		driver.findElement(By.id("BodyContent_ctl00_txtregusername")).sendKeys("manager@bid001");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtregpassword")).sendKeys("manager@bid001.rscs");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtconfirm")).sendKeys("manager@bid001.rscs");
		driver.findElement(By.id("BodyContent_ctl00_btn_update")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void addusr2() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select slt1 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_branch")));
		slt1.selectByVisibleText("Head Office");
		Thread.sleep(3000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_dept")));
		slt2.selectByVisibleText("Cashier");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtRegFullName")).sendKeys("CashierHO");
		driver.findElement(By.id("BodyContent_ctl00_txtregusername")).sendKeys("cashier@bid001");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtregpassword")).sendKeys("cashier@bid001rscs");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtconfirm")).sendKeys("cashier@bid001rscs");
		driver.findElement(By.id("BodyContent_ctl00_btn_update")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void addusr3() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select slt1 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_branch")));
		slt1.selectByVisibleText("Head Office");
		Thread.sleep(3000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_dept")));
		slt2.selectByVisibleText("Clerk");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtRegFullName")).sendKeys("ClerkHO");
		driver.findElement(By.id("BodyContent_ctl00_txtregusername")).sendKeys("clerk@bid001");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtregpassword")).sendKeys("clerk@bid001.bgm");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_txtconfirm")).sendKeys("clerk@bid001.bgm");
		driver.findElement(By.id("BodyContent_ctl00_btn_update")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='basicModaladduser']/div/div/div/button")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void deleteusr() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='BodyContent_ctl00_divbasicModalDel']")).click();
		Thread.sleep(2000);
		Select slt2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_depts")));
		slt2.selectByVisibleText("Clerk");
		Thread.sleep(3000);
		Select slt3 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddl_users")));
		slt3.selectByVisibleText("clerk@bid001");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btdelete")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnconfirm")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_inactive_users_btndeleteuser_0")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='BodyContent_ctl00_deluser']/div[1]/button")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
