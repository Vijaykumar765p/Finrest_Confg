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

public class AddLoanSchemes {
	public WebDriver driver;
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test
	public void Addloan() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
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
		driver = new ChromeDriver(options);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath("//div[text()='CONFIGURATION']")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu51']/div[1]/span")).click();
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_td_loans']/a")).click();
		// HYPOTHICATION LOAN ON ELECTRONICS
		for (int i = 1; i < 2; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("LoanScheme");
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
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Select ddl = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
			ddl.selectByVisibleText("HYPOTHICATION (Electrical) LOAN");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
			// period
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
			PGCODE.selectByVisibleText("Months");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
			// enterperiod
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
			// roi
			WebElement instal = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
			instal.clear();
			instal.sendKeys(v3);
			// penalty
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
			PostingGl.selectByVisibleText("INTEREST ON LOANS");
			Thread.sleep(2000);
			Select recovery = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
			recovery.selectByVisibleText("HANDLING CHARGES");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
			Thread.sleep(4000);
		}
		// HYPOTHICATION LOAN
		for (int i = 2; i < 3; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("LoanScheme");
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
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Select ddl = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
			ddl.selectByVisibleText("HYPOTHECATION LOAN");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
			// period
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
			PGCODE.selectByVisibleText("Months");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
			// enterperiod
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
			// roi
			WebElement instal = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
			instal.clear();
			instal.sendKeys(v3);
			// penalty
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
			PostingGl.selectByVisibleText("INTEREST ON LOANS");
			Thread.sleep(2000);
			Select recovery = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
			recovery.selectByVisibleText("HANDLING CHARGES");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
			Thread.sleep(4000);
		}
		// PERSONAL LOAN
		for (int i = 3; i < 4; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("LoanScheme");
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
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Select ddl = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
			ddl.selectByVisibleText("PERSONAL LOAN");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
			// period
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
			PGCODE.selectByVisibleText("Months");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
			// enterperiod
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
			// roi
			WebElement instal = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
			instal.clear();
			instal.sendKeys(v3);
			// penalty
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
			PostingGl.selectByVisibleText("INTEREST ON LOANS");
			Thread.sleep(2000);
			Select recovery = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
			recovery.selectByVisibleText("HANDLING CHARGES");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
			Thread.sleep(4000);
		}
		// MORTGAGE LOAN
		for (int i = 4; i < 6; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("LoanScheme");
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
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Select ddl = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
			ddl.selectByVisibleText("MORTGAGE LOAN");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
			// period
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
			PGCODE.selectByVisibleText("Months");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
			// enterperiod
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
			// roi
			WebElement instal = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
			instal.clear();
			instal.sendKeys(v3);
			// penalty
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
			PostingGl.selectByVisibleText("INTEREST ON LOANS");
			Thread.sleep(2000);
			Select recovery = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
			recovery.selectByVisibleText("HANDLING CHARGES");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
			Thread.sleep(4000);
		}
		// FIXED DEPOSIT LOAN
		for (int i = 6; i < 7; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("LoanScheme");
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
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Select ddl = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
			ddl.selectByVisibleText("FIXED DEPOSIT LOAN");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
			// period
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
			PGCODE.selectByVisibleText("Months");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
			// enterperiod
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
			// roi
			WebElement instal = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
			instal.clear();
			instal.sendKeys(v3);
			// penalty
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
			PostingGl.selectByVisibleText("INTEREST ON LOANS");
			Thread.sleep(2000);
			Select recovery = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
			recovery.selectByVisibleText("HANDLING CHARGES");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
			Thread.sleep(4000);
		}
		// // LOAN ON RECURRING DEPOSIT
		// for (int i = 7; i < 8; i++) {
		//
		// FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
		// Workbook wb = WorkbookFactory.create(fis);
		// Sheet sh = wb.getSheet("LoanScheme");
		// Row row = sh.getRow(i);
		// Cell c = row.getCell(0);
		// String v = c.toString();
		// Cell c1 = row.getCell(1);
		// String v1 = c1.toString();
		// Cell c2 = row.getCell(2);
		// String v2 = c2.toString();
		// Cell c3 = row.getCell(3);
		// String v3 = c3.toString();
		// Cell c4 = row.getCell(4);
		// String v4 = c4.toString();
		// Cell c6 = row.getCell(6);
		// String v6 = c6.toString();
		// Cell c7 = row.getCell(7);
		// String v7 = c7.toString();
		// Select ddl = new
		// Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
		// ddl.selectByVisibleText("RECURRING DEPOSIT LOAN");
		// Thread.sleep(2000);
		// Select schName = new
		// Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
		// schName.selectByVisibleText("Add New Scheme");
		// // schName.getOptions();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
		// // period
		//
		// Select PGCODE = new
		// Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
		// PGCODE.selectByVisibleText("Years");
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
		// // enterperiod
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
		// // roi
		// WebElement instal =
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
		// instal.clear();
		// instal.sendKeys(v3);
		// // penalty
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
		//
		// Select PostingGl = new
		// Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
		// PostingGl.selectByVisibleText("INTEREST ON LOANS");
		// Thread.sleep(2000);
		// Select recovery = new
		// Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
		// recovery.selectByVisibleText("RD PENALTY");
		// Thread.sleep(2000);
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
		// WebElement element =
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Thread.sleep(2000);
		// driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
		// Thread.sleep(4000);
		//
		// }
		// LOAN ON PIGMY DEPOSIT
		for (int i = 7; i < 8; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("LoanScheme");
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
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Select ddl = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
			ddl.selectByVisibleText("PIGMY DEPOSIT LOAN");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
			// period
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
			PGCODE.selectByVisibleText("Months");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
			// enterperiod
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
			// roi
			WebElement instal = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
			instal.clear();
			instal.sendKeys(v3);
			// penalty
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
			PostingGl.selectByVisibleText("INTEREST ON LOANS");
			Thread.sleep(2000);
			Select recovery = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
			recovery.selectByVisibleText("HANDLING CHARGES");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
			Thread.sleep(4000);
		}
		// CASH CREDIT LOAN
		for (int i = 8; i < 9; i++) {

			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("LoanScheme");
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
			Cell c6 = row.getCell(6);
			String v6 = c6.toString();
			Cell c7 = row.getCell(7);
			String v7 = c7.toString();
			Select ddl = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloantype']")));
			ddl.selectByVisibleText("CASH CREDIT LOAN");
			Thread.sleep(2000);
			Select schName = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlschemeloan']")));
			schName.selectByVisibleText("Add New Scheme");
			// schName.getOptions();
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtloanscheme']")).sendKeys(v);
			// period
			Select PGCODE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlloanperiodtype']")));
			PGCODE.selectByVisibleText("Months");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanperiod']")).sendKeys(v1);
			// enterperiod
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanroi']")).sendKeys(v2);
			// roi
			WebElement instal = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtPMonths']"));
			instal.clear();
			instal.sendKeys(v3);
			// penalty
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloanpenalty']")).sendKeys(v4);
			Select PostingGl = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanReceivableGLCode']")));
			PostingGl.selectByVisibleText("INTEREST ON LOANS");
			Thread.sleep(2000);
			Select recovery = new Select(
					driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlLoanrecoveryGLCode']")));
			recovery.selectByVisibleText("HANDLING CHARGES");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtStartDateLoan']")).sendKeys("01/04/2017");
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtEndDateLoan']")).sendKeys(v6);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtloandescription']")).sendKeys(v7);
			WebElement element = driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_btnsaveld']")).click();
			Thread.sleep(4000);
		}
		driver.quit();
	}
}
