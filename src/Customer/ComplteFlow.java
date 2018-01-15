package Customer;

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
import org.testng.annotations.Test;

public class ComplteFlow {
	public WebDriver driver;
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test(priority=0)
	public void login() throws InterruptedException, IOException {
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
		driver = new ChromeDriver(options);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 1, enabled = false)
	public void addCustomer() throws InterruptedException {
		driver.findElement(By.id("menu1")).click();
		driver.findElement(By.id("uc_menu_td_sub_menu1")).click();
		// Add customer link
		// Select Gender.
		Select dropdown = new Select(driver.findElement(By.id("ddlsal")));
		dropdown.selectByValue("Mr.");
		// Enter Name, Middle Name, Last Name
		driver.findElement(By.id("BodyContent_ctl00_txtfname")).sendKeys("Rahul");
		driver.findElement(By.id("BodyContent_ctl00_txtmname")).sendKeys("Ganesh");
		driver.findElement(By.id("BodyContent_ctl00_txtlname")).sendKeys("Chougala");
		Thread.sleep(2000);
		// Select Constitution.
		driver.findElement(By.id("BodyContent_ctl00_ddlconstitution")).sendKeys("Individual");
		Thread.sleep(2000);
		// Select Occupation.
		driver.findElement(By.xpath("//input[@id='txtoccup']")).sendKeys("Salaried");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='txtoccup']")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
		// Enter Date.
		driver.findElement(By.xpath("//input[@id='txtdobdate']")).sendKeys("25/10/1981");
		// Enter Caste.
		WebElement caste = driver.findElement(By.id("txtcaste"));
		caste.sendKeys("Hindu");
		Thread.sleep(2000);
		caste.sendKeys(Keys.ENTER);
		// Enter Address.
		driver.findElement(By.id("BodyContent_ctl00_txtcadd")).sendKeys("Gayatri Nagar,Rajaji Nagar");
		// Select State.
		driver.findElement(By.id("ddlcstate")).sendKeys("Karnataka");
		Thread.sleep(5000);
		driver.findElement(By.id("ddlcdistrict")).sendKeys("Belagavi");
		Thread.sleep(5000);
		driver.findElement(By.id("ddlccity")).sendKeys("Belagavi");
		// driver.findElement(By.id("ddlccity")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		// Enter Area.
		WebElement Area = driver.findElement(By.id("txtcarea"));
		Area.sendKeys("Malleshwaram");
		// Enter landmark.
		driver.findElement(By.id("BodyContent_ctl00_txtclandmark")).sendKeys("Near Rajaji Nagar Metro");
		// Enter Pincode.
		driver.findElement(By.id("BodyContent_ctl00_txtcpin")).sendKeys("590010");
		Thread.sleep(2000);
		// Select Permanent Address.
		driver.findElement(By.id("chkcopy")).click();
		Thread.sleep(2000);
		// Enter Pan
		driver.findElement(By.id("BodyContent_ctl00_txtpan")).sendKeys("HJNDG3078G");
		// Enter Adhar
		driver.findElement(By.id("BodyContent_ctl00_txtuid")).sendKeys("239941983490");
		// Enter Mobile Number.
		driver.findElement(By.id("BodyContent_ctl00_txtmno")).sendKeys("9886663045");
		// Enter email.
		driver.findElement(By.id("BodyContent_ctl00_txtemail")).sendKeys("RahulC123.g@gmail.com");
		Select Mar = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlMaritalStatus")));
		Mar.selectByValue("Single");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='fileIdProof']"))
				.sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\rahulid.jpg");
		driver.findElement(By.xpath(".//*[@id='fileAddProof']"))
				.sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\rahulaadhar.jpg");
		driver.findElement(By.xpath(".//*[@id='filephoto']"))
				.sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\rahul.jpg");
		driver.findElement(By.xpath(".//*[@id='filesign']"))
				.sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\signature.png");
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[@id='BodyContent_ctl00_btnSave']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.xpath("//*[@id='BodyContent_ctl00_btnSave']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnaddyes")).click();
		Thread.sleep(3000);
	}
	@Test(priority = 2, enabled = false)
	public void GLpaymentreceipt() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='menu3']/div[1]")).click();// transaction
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='uc_menu_td_sub_menu35']/div[1]/span")).click();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("txtsearchGl"));
		search.sendKeys("SHARE SUSPENSE ACCOUNT");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement ddl = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']"));
		Select slt = new Select(ddl);
		slt.selectByVisibleText("By Cash");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtamount']")).sendKeys("4000");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtremarks']")).sendKeys("4000 paid by cash");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnSaveNew")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 2, enabled = false)
	public void createshareAccount() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='menu2']/div[1]")).click();// accounts
																			// link
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu2']/div[1]/span")).click();
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.id("txtsearchcustomer"));
		search.sendKeys("Rahul");
		Thread.sleep(2000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='btnScustomer']")).click();
		Thread.sleep(2000);
		// Share Account
		WebElement ddl1 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlDepositType']"));
		Select slt1 = new Select(ddl1);
		slt1.selectByVisibleText("Share Account");
		Thread.sleep(5000);
		// SHARE A CLASS
		WebElement ddl2 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']"));
		Select slt2 = new Select(ddl2);
		slt2.selectByIndex(3);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtnominee']")).sendKeys("Manjunath");
		WebElement ddl3 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']"));
		Select slt3 = new Select(ddl3);
		slt3.selectByVisibleText("BROTHER");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSaveaccount"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSaveaccount']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 3, enabled = false)
	public void shareTransaction() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='menu3']/div[1]")).click();// transaction link
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='uc_menu_td_sub_menu31']/div[1]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_customers_btn_get_0")).click();
		WebElement ddl4 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltrantype']"));
		Select slt4 = new Select(ddl4);
		slt4.selectByVisibleText("Receipt");
		Thread.sleep(2000);
		WebElement ddl5 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']"));
		Select slt5 = new Select(ddl5);
		slt5.selectByVisibleText("By Cash");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtnoshares']")).sendKeys("2");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtremarks']")).sendKeys("Bought 2 shares");
		Thread.sleep(2000);
		// Buy shares
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnaddyes")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 4, enabled = false)
	public void createSBAccount() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='menu2']/div[1]")).click();// accounts link
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu2']/div[1]/span")).click();
		WebElement searc1 = driver.findElement(By.id("txtsearchcustomer"));
		searc1.sendKeys("Rahul");
		Thread.sleep(2000);
		searc1.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='btnScustomer']")).click();
		Thread.sleep(2000);
		WebElement ddl1 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlDepositType']"));
		Select slt1 = new Select(ddl1);
		slt1.selectByVisibleText("Saving/Current Account");
		Thread.sleep(2000);
		WebElement ddl2 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']"));
		Select slt2 = new Select(ddl2);
		slt2.selectByVisibleText("SAVING DEPOSIT");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSaveaccount"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		WebElement ddl3 = driver.findElement(By.id("BodyContent_ctl00_ddlschemename"));
		Select slt3 = new Select(ddl3);
		slt3.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtnominee']")).sendKeys("Usha");
		WebElement ddl4 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']"));
		Select slt4 = new Select(ddl4);
		slt4.selectByVisibleText("Mother");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSaveaccount']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 5, enabled = true)
	public void cashwindowDepositMNY() throws InterruptedException {
		driver.findElement(By.id("menu3")).click();// transaction link
		driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
		search.sendKeys("Rahul");
		Thread.sleep(2000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(2000);
		WebElement ddl10 = driver.findElement(By.id("ddltrantype"));
		Select slt10 = new Select(ddl10);
		slt10.selectByVisibleText("Deposit");
		Thread.sleep(2000);
		WebElement ddl11 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']"));
		Select slt11 = new Select(ddl11);
		slt11.selectByVisibleText("By Cash");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdammount']")).sendKeys("3000");
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtremarks']")).sendKeys("paid 3000");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("btnDWsave")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
