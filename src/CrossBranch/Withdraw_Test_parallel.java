package CrossBranch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Withdraw_Test_parallel {
	public static Properties prop = null;
	public static FileInputStream ip = null;

	// @Test (invocationCount = 10)
	@Test(enabled = true)
	public void getmoney1() throws InterruptedException, IOException {
		// First session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
		prop.load(ip);
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("js-flags=--expose-gc");
		options.addArguments("enable-precise-memory-info");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.addArguments("disable-extensions");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
		// Withdraw money
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("00105000001");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Select slt = new Select(driver.findElement(By.xpath("//select[@id='ddltrantype']")));
		slt.selectByVisibleText("Withdraw");
		Thread.sleep(1000);
		Select slt1 = new Select(driver.findElement(By.xpath("//select[@id='BodyContent_ctl00_ddltype']")));
		slt1.selectByVisibleText("To Cash");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100 rs Withdrawn");

		WebElement element = driver.findElement(By.id("btnDWsave"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.id("btnDWsave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
		driver.quit();
	}

	@Test(enabled = true)
	public void getmoney2() throws InterruptedException, IOException {
		// Second session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
		prop.load(ip);
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("js-flags=--expose-gc");
		options.addArguments("enable-precise-memory-info");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.addArguments("disable-extensions");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME1"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD1"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.id("menu3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
		// Withdraw money
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("00505000003");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Select slt = new Select(driver.findElement(By.xpath("//select[@id='ddltrantype']")));
		slt.selectByVisibleText("Withdraw");
		Thread.sleep(1000);
		Select slt1 = new Select(driver.findElement(By.xpath("//select[@id='BodyContent_ctl00_ddltype']")));
		slt1.selectByVisibleText("To Cash");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100 rs Withdrawn");

		WebElement element = driver.findElement(By.id("btnDWsave"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.id("btnDWsave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
		driver.quit();
	}

	@Test(enabled = true)
	public void getmoney3() throws InterruptedException, IOException {
		// Third session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
		prop.load(ip);
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("js-flags=--expose-gc");
		options.addArguments("enable-precise-memory-info");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.addArguments("disable-extensions");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME1"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD1"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.id("menu3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
		// Deposit money
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("00505000021");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Select slt = new Select(driver.findElement(By.xpath("//select[@id='ddltrantype']")));
		slt.selectByVisibleText("Deposit");
		Thread.sleep(1000);
		Select slt1 = new Select(driver.findElement(By.xpath("//select[@id='BodyContent_ctl00_ddltype']")));
		slt1.selectByVisibleText("By Cash");
		driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("500");
		driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("500rs Withdrawn");

		WebElement element = driver.findElement(By.id("btnDWsave"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.id("btnDWsave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
		driver.quit();
	}

	@Test(enabled = true)
	public void getmoney4() throws InterruptedException, IOException {
		// Fourth session of WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
		prop.load(ip);
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("js-flags=--expose-gc");
		options.addArguments("enable-precise-memory-info");
		options.addArguments("disable-popup-blocking");
		options.addArguments("disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.addArguments("disable-extensions");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.id("menu3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
		// Deposit money
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("00105000359");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Select slt = new Select(driver.findElement(By.xpath("//select[@id='ddltrantype']")));
		slt.selectByVisibleText("Deposit");
		Thread.sleep(1000);
		Select slt1 = new Select(driver.findElement(By.xpath("//select[@id='BodyContent_ctl00_ddltype']")));
		slt1.selectByVisibleText("By Cash");
		driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("300");
		driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("300rs Withdrawn");

		WebElement element = driver.findElement(By.id("btnDWsave"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.id("btnDWsave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
		driver.quit();
	}

	@Test(enabled = true)
	 public void getmoney5() throws InterruptedException, IOException {
	 // Fifth session of WebDriver
		 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			prop = new Properties();
			ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
			prop.load(ip);
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("js-flags=--expose-gc");
			options.addArguments("enable-precise-memory-info");
			options.addArguments("disable-popup-blocking");
			options.addArguments("disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			options.addArguments("disable-extensions");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME1"));
			driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD1"));
			driver.findElement(By.id("uc_login_btnlogin")).click();
			driver.findElement(By.id("menu3")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
			// Withdraw money
			driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("00505000027");
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			Select slt = new Select(driver.findElement(By.xpath("//select[@id='ddltrantype']")));
			slt.selectByVisibleText("Withdraw");
			Thread.sleep(1000);
			Select slt1 = new Select(driver.findElement(By.xpath("//select[@id='BodyContent_ctl00_ddltype']")));
			slt1.selectByVisibleText("To Cash");
			driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("300");
			driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("300rs Withdrawn");

			WebElement element = driver.findElement(By.id("btnDWsave"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			driver.findElement(By.id("btnDWsave")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
			driver.quit();
	 }
	
	@Test(enabled = true)
	 public void getmoney6() throws InterruptedException, IOException {
	 // Sixth session of WebDriver
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.p\\workspace\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			prop = new Properties();
			ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
			prop.load(ip);
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("js-flags=--expose-gc");
			options.addArguments("enable-precise-memory-info");
			options.addArguments("disable-popup-blocking");
			options.addArguments("disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			options.addArguments("disable-extensions");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
			driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
			driver.findElement(By.id("uc_login_btnlogin")).click();
			driver.findElement(By.id("menu3")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
			// Withdraw money
			driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("00105000003");
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			Select slt = new Select(driver.findElement(By.xpath("//select[@id='ddltrantype']")));
			slt.selectByVisibleText("Withdraw");
			Thread.sleep(1000);
			Select slt1 = new Select(driver.findElement(By.xpath("//select[@id='BodyContent_ctl00_ddltype']")));
			slt1.selectByVisibleText("To Cash");
			driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("300");
			driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("300rs Withdrawn");

			WebElement element = driver.findElement(By.id("btnDWsave"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			driver.findElement(By.id("btnDWsave")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
			driver.quit();
	 }
	
	// @Test
	// public void getmoney7() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney8() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney9() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney10() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney11() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney12() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney13() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney14() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney15() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney16() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney17() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney18() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney19() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
	//
	// @Test
	// public void getmoney20() throws InterruptedException {
	// // Third session of WebDriver
	// System.setProperty("webdriver.chrome.driver",
	// "C:\\java\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("http://demo/finrest_automation");
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	// driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_txtpassword")).sendKeys("admin");
	// driver.findElement(By.id("uc_login_btnlogin")).click();
	// driver.findElement(By.id("menu3")).click();
	// Thread.sleep(2000);
	// driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
	// // Withdraw money
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys("rahul");
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_txtsearchacc")).sendKeys(Keys.ENTER,
	// Keys.ENTER);
	// Thread.sleep(1000);
	// Select slt = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltrantype")));
	// slt.selectByVisibleText("Withdraw");
	// Thread.sleep(1000);
	// Select slt1 = new
	// Select(driver.findElement(By.id("BodyContent_ctl00_ddltype")));
	// slt1.selectByVisibleText("By Cash");
	// driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100");
	// driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("100rs
	// Withdrawn");
	//
	// WebElement element = driver.findElement(By.id("btnDWsave"));
	// ((JavascriptExecutor)
	// driver).executeScript("arguments[0].scrollIntoView(true);", element);
	//
	// driver.findElement(By.id("btnDWsave")).click();
	// Thread.sleep(1000);
	// driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
	// }
}
