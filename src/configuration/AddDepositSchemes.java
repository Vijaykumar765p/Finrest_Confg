package configuration;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddDepositSchemes {
	public static Properties prop = null;
	public static FileInputStream ip = null;

	@Test
	public void AddDeposit()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
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
		options.addArguments("disable-infobars");
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
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_td_deposit']")).click();
		// PYGMY DEPOSIT
		for (int i = 1; i < 2; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();
			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("PIGMY DEPOSIT");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v1);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v2);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtpigmycomm']")).sendKeys(v3);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtpigmyroi']")).sendKeys(v4);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtpigmypenalty']")).sendKeys(v5);
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlPenaltyGLCode']")));
			PGCODE.selectByVisibleText("HANDLING CHARGES");
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlCmspostingGl']")));
			PostingGl.selectByValue("89");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(3000);
		}
		// RECURRING DEPOSIT
		for (int i = 2; i < 6; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();

			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("RECURRING DEPOSIT");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddldepperiodtype']")));
			period.selectByVisibleText(v1);
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfrom']")).sendKeys(v2);
			Thread.sleep(2000);
			// from
			// to
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtto']")).sendKeys(v3);
			Thread.sleep(2000);
			// roi intrest
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v4);
			// min deposit
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v5);
			// penalty gl code
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlPenaltyGLCode']")));
			PGCODE.selectByVisibleText("RD PENALTY");
			// pre mat ROi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPe']")).sendKeys(v6);
			// seniorRoi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(3000);
		}
		// SHORT TERM DEPOSIT
		for (int i = 6; i < 11; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();
			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("SHORT TERM DEPOSIT");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddldepperiodtype']")));
			period.selectByVisibleText(v1);
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfrom']")).sendKeys(v2);
			Thread.sleep(2000);
			// from
			// to
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtto']")).sendKeys(v3);
			Thread.sleep(2000);
			// roi intrest
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v4);
			// min deposit
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v5);
			// pre mat ROi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPe']")).sendKeys(v6);
			// seniorRoi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(3000);
		}
		// MONTHLY INCOME SCHEMES
		for (int i = 11; i < 13; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();

			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("M.I.S. DEPOSIT (Monthly)");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddldepperiodtype']")));
			period.selectByVisibleText(v1);
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfrom']")).sendKeys(v2);
			Thread.sleep(2000);
			// from
			// to
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtto']")).sendKeys(v3);
			Thread.sleep(2000);
			// roi intrest
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v4);
			// min deposit
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v5);
			// pre mat ROi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPe']")).sendKeys(v6);
			// seniorRoi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(3000);
		}
		// Double deposit
		for (int i = 13; i < 14; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();
			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("DOUBLE DEPOSIT");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddldepperiodtype']")));
			period.selectByVisibleText(v1);
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfrom']")).sendKeys(v2);
			Thread.sleep(2000);
			// from
			// to
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtto']")).sendKeys(v3);
			Thread.sleep(2000);
			// roi intrest
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v4);
			// min deposit
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v5);
			// pre mat ROi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPe']")).sendKeys(v6);
			// seniorRoi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_chkDouble']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(3000);
		}
		// RSGFD
		for (int i = 14; i < 15; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();
			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("RIDDHI SIDDHI GOLDEN DEPOSIT");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddldepperiodtype']")));
			period.selectByVisibleText(v1);
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfrom']")).sendKeys(v2);
			Thread.sleep(2000);
			// from
			// to
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtto']")).sendKeys(v3);
			Thread.sleep(2000);
			// roi intrest
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v4);
			// min deposit
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v5);
			// pre mat ROi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPe']")).sendKeys(v6);
			// seniorRoi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_chkDouble']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(3000);
		}
		// Five Time deposit
		for (int i = 15; i < 16; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();
			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("FIVE TIMES DEPOSIT");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddldepperiodtype']")));
			period.selectByVisibleText(v1);
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfrom']")).sendKeys(v2);
			Thread.sleep(2000);
			// from
			// to
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtto']")).sendKeys(v3);
			Thread.sleep(2000);
			// roi intrest
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v4);
			// min deposit
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v5);
			// pre mat ROi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPe']")).sendKeys(v6);
			// seniorRoi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(3000);
		}
		// SRS Abhivruddhi
		for (int i = 16; i < 17; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DepositScheme");
			Row row = sh.getRow(i);
			Cell c = row.getCell(0);
			String v = c.toString();
			Cell c1 = row.getCell(1);
			String v1 = c1.toString();
			Cell c2 = row.getCell(2);
			String v2 = c2.toString();
			Cell c3 = row.getCell(3);
			String v3 = c3.toString();
			Cell c4 = row.getCell(4);
			String v4 = c4.toString();
			Cell c5 = row.getCell(5);
			String v5 = c5.toString();
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Cell c8 = row.getCell(8);
			String v8 = c8.toString();
			Cell c9 = row.getCell(9);
			String v9 = c9.toString();
			Select ddl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlaccounttypedeposit']")));
			ddl.selectByVisibleText("SRS ABHIVRUDHI DEPOSIT");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemedep']")));
			schName.selectByVisibleText("Add New Scheme");
			driver.findElement(By.xpath(".//*[@id='txtdepositschemes']")).sendKeys(v);
			Thread.sleep(2000);
			Select period = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddldepperiodtype']")));
			period.selectByVisibleText(v1);
			// schName.getOptions();
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtfrom']")).sendKeys(v2);
			Thread.sleep(2000);
			// from
			// to
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtto']")).sendKeys(v3);
			Thread.sleep(2000);
			// roi intrest
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdroi']")).sendKeys(v4);
			// min deposit
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdminamount']")).sendKeys(v5);
			// penalty gl code
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlPenaltyGLCode']")));
			PGCODE.selectByVisibleText("RD PENALTY");
			// pre mat ROi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPe']")).sendKeys(v6);
			// seniorRoi
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtSeniorIntRate']")).sendKeys(v7);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDate']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDate']")).sendKeys(v8);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtdepositdescription']")).sendKeys(v9);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsavedepositdts']")).click();
			Thread.sleep(2000);
		}
		driver.quit();
	}
}