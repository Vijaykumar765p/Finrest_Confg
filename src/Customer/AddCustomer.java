package Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class AddCustomer {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	public WebDriver driver;

	@Test
	public void login() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
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
		driver.findElement(By.id("menu1")).click();
	}

	@Test(priority = 1, enabled = true)
	public void addcustomer()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		for (int i = 1; i < 8; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Addcustomer");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(01);
			String v1 = c1.toString();
			Cell c2 = row.getCell(02);
			String v2 = c2.toString();
			Cell c3 = row.getCell(03);
			String v3 = c3.toString();
			Cell c4 = row.getCell(04);
			String v4 = c4.toString();
			Cell c5 = row.getCell(05);
			String v5 = c5.toString();
			Cell c6 = row.getCell(06);
			String v6 = c6.toString();
			Cell c7 = row.getCell(07);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();
			Cell c10 = row.getCell(10);
			String v10 = c10.toString();
			Cell c11 = row.getCell(11);
			String v11 = c11.toString();
			Cell c12 = row.getCell(12);
			String v12 = c12.toString();
			Cell c13 = row.getCell(13);
			String v13 = c13.toString();
			Cell c14 = row.getCell(14);
			String v14 = c14.toString();
			Cell c15 = row.getCell(15);
			String v15 = c15.toString();
			Cell c16 = row.getCell(16);
			String v16 = c16.toString();
			Cell c17 = row.getCell(17);
			String v17 = c17.toString();
			Cell c18 = row.getCell(18);
			String v18 = c18.toString();
			Cell c19 = row.getCell(19);
			String v19 = c19.toString();
			Cell c20 = row.getCell(20);
			String v20 = c20.toString();
			Cell c21 = row.getCell(21);
			String v21 = c21.toString();
			Cell c22 = row.getCell(22);
			String v22 = c22.toString();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu1']")).click();
			// Select Gender.
			Select dropdown = new Select(driver.findElement(By.id("ddlsal")));
			dropdown.selectByValue(v);
			// Enter Name, Middle Name, Last Name
			driver.findElement(By.id("BodyContent_ctl00_txtfname")).sendKeys(v1);
			driver.findElement(By.id("BodyContent_ctl00_txtmname")).sendKeys(v2);
			driver.findElement(By.id("BodyContent_ctl00_txtlname")).sendKeys(v3);
			Thread.sleep(2000);
			// Select Constitution.
			driver.findElement(By.id("BodyContent_ctl00_ddlconstitution")).sendKeys("Individual");
			Thread.sleep(2000);
			// Select Occupation.
			driver.findElement(By.xpath("//input[@id='txtoccup']")).sendKeys("Salaried");
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//input[@id='txtoccup']")).sendKeys(Keys.ENTER);
			// Thread.sleep(5000);
			// Enter Date.
			Thread.sleep(5000);
			driver.findElement(By.id("txtdobdate")).sendKeys(v4);
			Thread.sleep(1000);
			// Enter Caste.
			WebElement caste = driver.findElement(By.id("txtcaste"));
			caste.sendKeys(v5);
			Thread.sleep(1000);
			caste.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			// Enter Address.
			driver.findElement(By.id("BodyContent_ctl00_txtcadd")).sendKeys(v6);
			Thread.sleep(4000);
			// Select State.
			driver.findElement(By.id("ddlcstate")).sendKeys(v7);
			Thread.sleep(4000);
			driver.findElement(By.id("ddlcdistrict")).sendKeys(v8);
			Thread.sleep(5000);
			driver.findElement(By.id("ddlccity")).sendKeys(v9);
			Thread.sleep(4000);
			// Enter Area.
			WebElement Area = driver.findElement(By.id("txtcarea"));
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Area.sendKeys(v10);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("txtcarea")).sendKeys(Keys.DOWN);
			driver.findElement(By.id("txtcarea")).sendKeys(Keys.DOWN);
			driver.findElement(By.id("txtcarea")).sendKeys(Keys.TAB);
			Thread.sleep(4000);
			// Enter landmark.
			driver.findElement(By.id("BodyContent_ctl00_txtclandmark")).sendKeys(v11);
			Thread.sleep(4000);
			// Enter Pincode.
			driver.findElement(By.id("BodyContent_ctl00_txtcpin")).sendKeys(v12);
			Thread.sleep(4000);
			// Select Permanent Address.
			driver.findElement(By.id("chkcopy")).click();
			Thread.sleep(4000);
			// Enter Pan
			driver.findElement(By.id("BodyContent_ctl00_txtpan")).sendKeys(v13);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			// Enter Adhar
			driver.findElement(By.id("BodyContent_ctl00_txtuid")).sendKeys(v14);
			Thread.sleep(3000);
			// Enter Mobile Number.
			driver.findElement(By.id("BodyContent_ctl00_txtmno")).sendKeys(v15);
			Thread.sleep(000);
			// Enter email.
			driver.findElement(By.id("BodyContent_ctl00_txtemail")).sendKeys(v16);
			Thread.sleep(1000);
			// Select Customer Type.
			Select cust = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlmtype")));
			cust.selectByValue(v17);
			// Select Martial Status.
			Select Mar = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlMaritalStatus")));
			Mar.selectByValue("Single");
			// Enter Introducer.
			driver.findElement(By.id("BodyContent_ctl00_txtintrunm")).sendKeys(v18);
			Thread.sleep(1000);
			// Introducer.click();
			driver.findElement(By.id("BodyContent_ctl00_txtintrunm")).sendKeys(Keys.DOWN);
			driver.findElement(By.id("BodyContent_ctl00_txtintrunm")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(".//*[@id='fileIdProof']")).sendKeys(v19);
			driver.findElement(By.xpath(".//*[@id='fileAddProof']")).sendKeys(v20);
			driver.findElement(By.xpath(".//*[@id='filephoto']")).sendKeys(v21);
			driver.findElement(By.xpath(".//*[@id='filesign']")).sendKeys(v22);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnSave']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnaddyes")).click();
		}
	}

//	@Test(priority = 2, enabled = false)
//	public void GLpaymentreceipt() throws InterruptedException {
//		driver.findElement(By.xpath("//*[@id='menu3']/div[1]")).click();// transaction
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id='uc_menu_td_sub_menu35']/div[1]/span")).click();
//		Thread.sleep(2000);
//		WebElement search = driver.findElement(By.id("txtsearchGl"));
//		search.sendKeys("SHARE");
//		Thread.sleep(2000);
//		search.sendKeys(Keys.DOWN);
//		// search.sendKeys(Keys.DOWN);
//		search.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
//		WebElement ddl = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']"));
//		Select slt = new Select(ddl);
//		slt.selectByVisibleText("By Cash");
//		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtamount']")).sendKeys("10000");
//		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtremarks']")).sendKeys("10000 paid by cash");
//		driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("BodyContent_ctl00_btnSaveNew")).click();
//		Thread.sleep(2000);
//	}

	@Test(priority = 3, enabled = true)
	public void createshareAccount()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		driver.findElement(By.xpath(".//*[@id='menu2']/div[1]")).click();// accounts
		Thread.sleep(1000);
		for (int i = 8; i < 15; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Addcustomer");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(01);
			String v1 = c1.toString();
			Cell c2 = row.getCell(02);
			String v2 = c2.toString();
			Cell c3 = row.getCell(03);
			String v3 = c3.toString();
			Cell c4 = row.getCell(04);
			String v4 = c4.toString();
			Cell c5 = row.getCell(05);
			String v5 = c5.toString();
			driver.findElement(By.id("uc_menu_td_sub_menu2")).click();
			WebElement search = driver.findElement(By.id("txtsearchcustomer"));
			search.sendKeys(v);
			Thread.sleep(1000);
			search.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='btnScustomer']")).click();
			Thread.sleep(2000);
			// Share Account
			WebElement ddl1 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlDepositType']"));
			Select slt1 = new Select(ddl1);
			slt1.selectByVisibleText("Share Account");
			Thread.sleep(3000);
			// SHARE CLASS
			WebElement ddl2 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttype']"));
			Select slt2 = new Select(ddl2);
			slt2.selectByIndex(3);
			Thread.sleep(3000);
			// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtApplicationDate']")).sendKeys(v1);
			// WebElement res =
			// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtResolutionNo']"));
			// res.clear();
			// Thread.sleep(2000);
			// res.sendKeys(v2);
			// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtResolutionDate']")).sendKeys(v3);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtnominee']")).sendKeys(v4);
			WebElement ddl3 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']"));
			Select slt3 = new Select(ddl3);
			slt3.selectByVisibleText(v5);
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnSaveaccount"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSaveaccount']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
			Thread.sleep(4000);
		}
	}

	@Test(priority = 4, enabled = true)
	public void shareTransaction()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		driver.findElement(By.xpath("//*[@id='menu3']/div[1]")).click();// transaction
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='uc_menu_td_sub_menu31']/div[1]/span")).click();
		Thread.sleep(2000);
		for (int i = 15; i < 22; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Addcustomer");
			Row row = sh.getRow(i);
			System.out.println();
			Cell c = row.getCell(0);
			System.out.println(c);
			String v = c.toString();
			Cell c1 = row.getCell(01);
			String v1 = c1.toString();
			Cell c2 = row.getCell(02);
			String v2 = c2.toString();
			WebElement name = driver.findElement(By.id("txtsearchcustomer"));
			name.sendKeys(v);
			Thread.sleep(2000);
			name.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnsearch")).click();
			WebElement ddl4 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltrantype']"));
			Select slt4 = new Select(ddl4);
			slt4.selectByVisibleText("Receipt");
			Thread.sleep(2000);
			WebElement ddl5 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddltype']"));
			Select slt5 = new Select(ddl5);
			slt5.selectByVisibleText("By Cash");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtnoshares']")).sendKeys(v1);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtremarks']")).sendKeys(v2);
			// Buy shares
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSave']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnaddyes")).click();
			Thread.sleep(2000);
		}
	}

	@Test(priority = 5, enabled = true)
	public void createSBAccount()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		driver.findElement(By.id("menu2")).click();// accounts link
		Thread.sleep(1000);
		for (int i = 22; i < 29; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Addcustomer");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(01);
			String v1 = c1.toString();
			Cell c2 = row.getCell(02);
			String v2 = c2.toString();

			driver.findElement(By.id("uc_menu_td_sub_menu2")).click();
			WebElement search = driver.findElement(By.id("txtsearchcustomer"));
			search.sendKeys(v);
			Thread.sleep(2000);
			search.sendKeys(Keys.ENTER);
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
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtnominee']")).sendKeys(v1);
			WebElement ddl4 = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtreln']"));
			Select slt4 = new Select(ddl4);
			slt4.selectByVisibleText(v2);
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnSaveaccount']")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
			Thread.sleep(2000);
		}
	}

	@Test(priority = 6, enabled = true)
	public void cashwindowDepositMNY()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		driver.findElement(By.id("menu3")).click();// transaction link
		Thread.sleep(1000);
		for (int i = 29; i < 36; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Addcustomer");
			Row row = sh.getRow(i);

			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(01);
			String v1 = c1.toString();
			Cell c2 = row.getCell(02);
			String v2 = c2.toString();

			driver.findElement(By.id("uc_menu_td_sub_menu3")).click();
			WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchacc"));
			search.sendKeys(v);
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
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdammount']")).sendKeys(v1);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtremarks']")).sendKeys(v2);
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath(".//*[@id='btnDWsave']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			driver.findElement(By.id("btnDWsave")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("BodyContent_ctl00_btnSave")).click();
			Thread.sleep(2000);
		}
	}

	@Test(priority = 7, enabled = true)
	public void terminate() {
		driver.quit();
	}
}
