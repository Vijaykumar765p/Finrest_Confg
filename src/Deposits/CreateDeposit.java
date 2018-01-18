package Deposits;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
public class CreateDeposit {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	public WebDriver driver;
	@Test
	public void login() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
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
		driver = new ChromeDriver(options);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
	}
	@Test(priority = 1,enabled = true)
	public void fixedDeposit() throws InterruptedException {
// Create STFD
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
		WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
		search.sendKeys("rahul");
		Thread.sleep(2000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
		driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
		Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
		Relation.selectByVisibleText("Father");
		Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
		GL.selectByVisibleText("SHORT TERM DEPOSIT");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfdamount']")).sendKeys("10000");
		Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		scName.selectByIndex(1);
		Thread.sleep(2000);
		Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		period.selectByIndex(1);
		Thread.sleep(2000);
		WebElement tenture = driver.findElement(By.id("txtTenure"));
		tenture.clear();
		tenture.sendKeys("20");
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		
// Transaction STFD
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='menu3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu3']")).click();
		Thread.sleep(1000);
		WebElement search1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
		search1.sendKeys("00104400001");
		Thread.sleep(2000);
		search1.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Select Occupation = new Select(driver.findElement(By.id("ddltrantype")));
		Occupation.selectByValue("Deposit");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']")).sendKeys("By Cash");
		driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("10000");
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(4000);
		driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("By Cash");
		driver.findElement(By.xpath(".//*[@id='btnDWsave']")).click();
		Thread.sleep(4000);
//		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		Thread.sleep(1000);
	}
	@Test(priority = 2,enabled=true)
	private void pigmyaccont() throws InterruptedException {
// CreatePD
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
		WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
		search.sendKeys("Rahul");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
		driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
		Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
		Relation.selectByVisibleText("Father");
		Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
		GL.selectByVisibleText("PIGMY DEPOSIT");
		Thread.sleep(2000);
		WebElement agent = driver.findElement(By.id("BodyContent_ctl00_txtagentacno1"));
		agent.sendKeys("001");
		Thread.sleep(2000);
		agent.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("btnsearchagentaccountNo")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_txtpigmyamount")).sendKeys("100");
		Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		scName.selectByIndex(1);
		Thread.sleep(2000);
		Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		period.selectByIndex(1);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		
// PigmyCollection
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='menu3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu33']")).click();
		Thread.sleep(1000);
		WebElement searchagent = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchacc']"));
		searchagent.sendKeys("001");
		Thread.sleep(1000);
		searchagent.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
		Thread.sleep(1000);
		WebElement pigmy = driver.findElement(By.xpath("//input[@id='txtaccno']"));
		Thread.sleep(1000);
		pigmy.sendKeys("001");
		Thread.sleep(1000);
		pigmy.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		WebElement amount = driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_txtamount']"));
		Thread.sleep(1000);
		amount.sendKeys("100");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnAdd']")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("BodyContent_ctl00_btnsave")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_Button1")).click();
		driver.findElement(By.xpath("//div[@id='menu3']")).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
	}
	@Test(priority = 3,enabled=true)
	private void recuringDeposit() throws InterruptedException {
// CreateRD
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
		WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
		search.sendKeys("001");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
		driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
		Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
		Relation.selectByVisibleText("Father");
		Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
		GL.selectByVisibleText("RECURRING DEPOSIT");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_txtrdamount")).sendKeys("5000");
		Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		scName.selectByIndex(1);
		Thread.sleep(2000);
		Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		period.selectByIndex(1);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		
// Transaction RD
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='menu3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu3']")).click();
		Thread.sleep(1000);
		WebElement search1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
		search1.sendKeys("0010000000 - RAHUL GANESH CHOUGALA - 00104900001 - RD");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement element11 = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element11);
		Thread.sleep(4000);
		Select Occupation = new Select(driver.findElement(By.id("ddltrantype")));
		Occupation.selectByValue("Deposit");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']")).sendKeys("By Cash");
		driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("5000");
		driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("By Cash");
		driver.findElement(By.xpath(".//*[@id='btnDWsave']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		Thread.sleep(1000);
	}
	@Test(priority = 4,enabled=true)
	public void MonthlyScheme() throws InterruptedException {
// Create MIS
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
		WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
		search.sendKeys("001");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
		driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
		Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
		Relation.selectByVisibleText("Father");
		Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
		GL.selectByVisibleText("M.I.S. DEPOSIT (Monthly)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfdamount']")).sendKeys("10000");
		Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		scName.selectByIndex(1);
		Thread.sleep(1000);
		Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		period.selectByIndex(1);
		Thread.sleep(1000);
//		WebElement tenture = driver.findElement(By.id("txtTenure"));
//		tenture.clear();
//		tenture.sendKeys("20");
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		
// Transaction Mis
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='menu3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu3']")).click();
		Thread.sleep(1000);
		WebElement search1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
		search1.sendKeys("0010000000 - RAHUL GANESH CHOUGALA - 00110100001 - MIS");
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Select Occupation = new Select(driver.findElement(By.id("ddltrantype")));
		Occupation.selectByValue("Deposit");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']")).sendKeys("By Cash");
		driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("10000");
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(4000);
		driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("By Cash");
		driver.findElement(By.xpath(".//*[@id='btnDWsave']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		Thread.sleep(1000);
	}
		@Test(priority = 5,enabled = true)
		public void doubleDeposit() throws InterruptedException {
//	Create Double Deposit
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
			driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
			WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
			search.sendKeys("001");
			Thread.sleep(1000);
			search.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
			driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
			Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
			Relation.selectByVisibleText("Father");
			Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
			GL.selectByVisibleText("DOUBLE DEPOSIT");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfdamount']")).sendKeys("100000");
			Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
			scName.selectByIndex(1);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
			period.selectByIndex(1);
			Thread.sleep(2000);
//			WebElement tenture = driver.findElement(By.id("txtTenure"));
//			tenture.clear();
//			tenture.sendKeys("20");
			WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			
	// TransactionFD
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menu3']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu3']")).click();
			Thread.sleep(1000);
			WebElement search1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
			search1.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - 00105900001 - FD");
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
			Select Occupation = new Select(driver.findElement(By.id("ddltrantype")));
			Occupation.selectByValue("Deposit");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']")).sendKeys("By Cash");
			driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("100000");
			WebElement element1 = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(4000);
			driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("By Cash");
			driver.findElement(By.xpath(".//*[@id='btnDWsave']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			Thread.sleep(1000);
		}
		@Test(priority = 6,enabled = true)
		public void RSGFDeposit() throws InterruptedException {
//	Create RSGF Deposit
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
			driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
			WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
			search.sendKeys("001");
			Thread.sleep(1000);
			search.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
			driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
			Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
			Relation.selectByVisibleText("Father");
			Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
			GL.selectByVisibleText("RIDDHI SIDDHI GOLDEN DEPOSIT");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfdamount']")).sendKeys("50000");
			Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
			scName.selectByIndex(1);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
			period.selectByIndex(1);
			Thread.sleep(2000);
//			WebElement tenture = driver.findElement(By.id("txtTenure"));
//			tenture.clear();
//			tenture.sendKeys("20");
			WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			
	// Transaction RSGFD
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menu3']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu3']")).click();
			Thread.sleep(1000);
			WebElement search1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
			search1.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - 00124600001 - FD");
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
			Select Occupation = new Select(driver.findElement(By.id("ddltrantype")));
			Occupation.selectByValue("Deposit");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']")).sendKeys("By Cash");
			driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("50000");
			WebElement element1 = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(4000);
			driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("By Cash");
			driver.findElement(By.xpath(".//*[@id='btnDWsave']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			Thread.sleep(1000);
		}
		@Test(priority = 7,enabled = true)
		public void FiveTimesDeposit() throws InterruptedException {
//	Create Five Times Deposit
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
			driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
			WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
			search.sendKeys("001");
			Thread.sleep(1000);
			search.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
			driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
			Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
			Relation.selectByVisibleText("Father");
			Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
			GL.selectByVisibleText("FIVE TIMES DEPOSIT");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfdamount']")).sendKeys("10000");
			Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
			scName.selectByIndex(1);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
			period.selectByIndex(1);
			Thread.sleep(2000);
//			WebElement tenture = driver.findElement(By.id("txtTenure"));
//			tenture.clear();
//			tenture.sendKeys("20");
			WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			
	// Transaction FTD
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='menu3']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu3']")).click();
			Thread.sleep(1000);
			WebElement search1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
			search1.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - 00130500001 - FD");
			Thread.sleep(1000);
			driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
			Select Occupation = new Select(driver.findElement(By.id("ddltrantype")));
			Occupation.selectByValue("Deposit");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']")).sendKeys("By Cash");
			driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("10000");
			WebElement element1 = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(4000);
			driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("By Cash");
			driver.findElement(By.xpath(".//*[@id='btnDWsave']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			Thread.sleep(1000);
		}
		@Test(priority = 8,enabled=true)
		private void SRSabhivruddi() throws InterruptedException {
// Create SRS Abhivruddhi
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='menu10']/div[1]")).click();
			driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu10']/div[1]/span")).click();
			WebElement search = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsearchcustomer']"));
			search.sendKeys("001");
			Thread.sleep(1000);
			search.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnScustomer']")).click();
			driver.findElement(By.id("txtnominee")).sendKeys("Ganesh Chougla");
			Select Relation = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']")));
			Relation.selectByVisibleText("Father");
			Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']")));
			GL.selectByVisibleText("SRS ABHIVRUDHI DEPOSIT");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtlinkaccno']")).sendKeys(Keys.ENTER);
			driver.findElement(By.id("BodyContent_ctl00_txtrdamount")).sendKeys("1100");
			Select scName = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
			scName.selectByIndex(1);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
			period.selectByIndex(1);
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnSavedeposit")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			
// Transaction SRS
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@id='menu3']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu3']")).click();
			Thread.sleep(1000);
			WebElement search1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
			search1.sendKeys("0010000000 - RAHUL GANESH CHOUGALA - 00131300001 - RD");
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
			WebElement element11 = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element11);
			Thread.sleep(4000);
			Select Occupation = new Select(driver.findElement(By.id("ddltrantype")));
			Occupation.selectByValue("Deposit");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']")).sendKeys("By Cash");
			driver.findElement(By.id("BodyContent_ctl00_txtdammount")).sendKeys("1100");
			driver.findElement(By.id("BodyContent_ctl00_txtremarks")).sendKeys("By Cash");
			driver.findElement(By.xpath(".//*[@id='btnDWsave']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			Thread.sleep(1000);
		}
		@AfterTest
		private void terminate(){
			driver.quit();
		}
}
