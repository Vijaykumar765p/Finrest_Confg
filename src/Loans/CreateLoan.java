package Loans;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CreateLoan {
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
	}

	@Test(priority = 1, enabled = true)
	public void CCL() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='menu4']/div[1]")).click();
//		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu4']/div[1]/span")).click();
//		// search Customer
//		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).sendKeys("0010000001 - RAHUL GANESH CHOUGALA");
//		Thread.sleep(2000);
//		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
//		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnnext"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		driver.findElement(By.id("BodyContent_ctl00_btnnext")).click();
//		Thread.sleep(3000);
//		// Create LoanType
//		Select LT = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlproposedloantype")));
//		LT.selectByVisibleText("CASH CREDIT LOAN");
//		Thread.sleep(2000);
//		// scheme name
//		Select SN = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
//		SN.selectByVisibleText("CASH CREDIT LOAN SCHEME");
//		Thread.sleep(2000);
//		// proposed period
//		Select PP = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
//		PP.selectByIndex(1);
//		// required amount
//		driver.findElement(By.id("BodyContent_ctl00_txtramt")).sendKeys("10000");
//		// loan purpose
//		driver.findElement(By.id("BodyContent_ctl00_txtLoanPurpose")).sendKeys("Personal");
//		// gurantor1
//		WebElement grt1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchGuarantor1"));
//		grt1.sendKeys("Nid");
//		Thread.sleep(2000);
//		grt1.sendKeys(Keys.ENTER);
//		driver.findElement(By.id("BodyContent_ctl00_btnGuarantor1")).click();
//		Thread.sleep(2000);
//		// gurantor2
//		WebElement grt2 = driver.findElement(By.id("BodyContent_ctl00_txtsearchGuarantor2"));
//		grt2.sendKeys("Namr");
//		Thread.sleep(2000);
//		grt2.sendKeys(Keys.ENTER);
//		driver.findElement(By.id("BodyContent_ctl00_btnGuarantor2")).click();
//		Thread.sleep(2000);
//		// employment Type
//		Select Et = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlemptype")));
//		Et.selectByVisibleText("Salaried");
//		Thread.sleep(2000);
//		// employeer business
//		driver.findElement(By.id("BodyContent_ctl00_txtcom")).sendKeys("Job");
//		// annual income
//		driver.findElement(By.id("BodyContent_ctl00_txtmincome")).sendKeys("50000");
//		WebElement element1 = driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
//		// upload documents
//		driver.findElement(By.id("fileproperyphoto")).sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\home.jpg");
//		driver.findElement(By.id("fileincomepaper")).sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\ipaper.jpg");
//		driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
//		Thread.sleep(1000);
//		// Loan request
//		driver.findElement(By.xpath("//div[@id='uc_menu_td_sub_menu42']")).click();
//		// search customer
//		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
//		search.sendKeys("rahul");
//		Thread.sleep(1000);
//		search.sendKeys(Keys.ENTER);
//		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("BodyContent_ctl00_grd_pendingloandetails_btn_get_0")).click();
//		WebElement element2 = driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
//		Thread.sleep(2000);
//		driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0")).click();
//		// release amount
//		driver.findElement(By.id("BodyContent_ctl00_txtdamt")).sendKeys("10000");
//		// duration
//		Select pp = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
//		pp.selectByIndex(1);
//		driver.findElement(By.id("BodyContent_ctl00_btnsaveloan")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
//		Thread.sleep(1000);
		// LOAN DISBURSEMENT
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu43']")).click();
		// search customer
		WebElement ld = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		ld.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - CCL");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloans_btn_get_0")).click();
		WebElement element3 = driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0")).click();
		Thread.sleep(2000);
		// release amount
		Actions action = new Actions(driver);
		WebElement click=driver.findElement(By.id("BodyContent_ctl00_txtsbacno"));
		Thread.sleep(2000);
		//Double click
		action.doubleClick(click).perform();
		Thread.sleep(2000);
		click.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_txtreliaseamt")).sendKeys("10000");
		driver.findElement(By.id("BodyContent_ctl00_btntransfettosbasp")).click();
		Thread.sleep(1000);
//		driver.findElement(By.id("BodyContent_ctl00_btntransferConfirm")).click();
	}

	// don't execute
	@Test(priority = 2, enabled = false)
	public void goldloan() throws InterruptedException {
		// create loan
		driver.findElement(By.xpath(".//*[@id='menu4']/div[1]")).click();
		// search customer
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu4']/div[1]/span")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).sendKeys("0010000001 - RAHUL GANESH CHOUGALA");
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnnext"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("BodyContent_ctl00_btnnext")).click();
		Thread.sleep(3000);
		// loan type
		Select LT = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlproposedloantype")));
		LT.selectByVisibleText("GOLD LOAN");
		Thread.sleep(2000);
		// scheme name
		Select SN = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		SN.selectByVisibleText("0 to 1 Year GL");
		Thread.sleep(2000);
		// proposed period
		Select PP = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		PP.selectByIndex(1);
		Thread.sleep(1000);
		// articles
		driver.findElement(By.id("BodyContent_ctl00_txtGoldGoods")).sendKeys("bangles");
		// net weight
		driver.findElement(By.id("BodyContent_ctl00_txtGoodsNtWt")).sendKeys("10");
		// gross weight
		driver.findElement(By.id("BodyContent_ctl00_txtGrossWt")).sendKeys("9");
		// rate
		driver.findElement(By.id("BodyContent_ctl00_txtgoldRate")).sendKeys("2700");
		// reqiured amount
		driver.findElement(By.id("BodyContent_ctl00_txtramt")).sendKeys("18000");
		// loan purpose
		driver.findElement(By.id("BodyContent_ctl00_txtLoanPurpose")).sendKeys("Personal");
		// image of article
		driver.findElement(By.id("fileproperyphoto")).sendKeys("C:\\Users\\mahesh.b\\Downloads\\Bangle-131.jpg");
		// save
		WebElement element1 = driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu42']/div[1]/span")).click();
		// search customer
		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		search.sendKeys("rahul");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_pendingloandetails_btn_get_0")).click();
		WebElement element2 = driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0")).click();
		// realease amount
		driver.findElement(By.id("BodyContent_ctl00_txtdamt")).sendKeys("18000");
		// duration
		Select pp = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		pp.selectByIndex(1);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// LOAN DISBUSRMENT
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu43']")).click();
		// search customer
		WebElement ld = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		ld.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - GL");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloans_btn_get_0")).click();
		WebElement element3 = driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0")).click();
		// relaese amount
		driver.findElement(By.id("BodyContent_ctl00_txtreliaseamt")).sendKeys("18000");
		driver.findElement(By.id("BodyContent_ctl00_btntransfettosbasp")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btntransferConfirm")).click();
	}

	@Test(priority = 3, enabled = false)
	public void HYPOTHICATIONLOAN() throws InterruptedException {
		// Create loan
		driver.findElement(By.xpath(".//*[@id='menu4']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu4']/div[1]/span")).click();
		// search customer
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).sendKeys("0010000001 - RAHUL GANESH CHOUGALA");
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnnext"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("BodyContent_ctl00_btnnext")).click();
		Thread.sleep(3000);
		// loan type
		Select LT = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlproposedloantype")));
		LT.selectByVisibleText("HYPOTHECATION LOAN");
		Thread.sleep(2000);
		// scheme name
		Select SN = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		SN.selectByVisibleText("HYPOTHECATION LOAN SCHEME");
		Thread.sleep(2000);
		// proposed period
		Select PP = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		PP.selectByIndex(1);
		// reqiured amount
		driver.findElement(By.id("BodyContent_ctl00_txtramt")).sendKeys("10000");
		// Loan Purpose
		driver.findElement(By.id("BodyContent_ctl00_txtLoanPurpose")).sendKeys("Personal");
		// gurantor1
		WebElement grt1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchGuarantor1"));
		grt1.sendKeys("Nid");
		Thread.sleep(2000);
		grt1.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnGuarantor1")).click();
		// gurantor2
		Thread.sleep(1000);
		WebElement grt2 = driver.findElement(By.id("BodyContent_ctl00_txtsearchGuarantor2"));
		grt2.sendKeys("Namrata");
		Thread.sleep(2000);
		grt2.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnGuarantor2")).click();
		Thread.sleep(2000);
		// employment type
		WebElement element2 = driver.findElement(By.id("BodyContent_ctl00_txtmincome"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(2000);
		// employer business
		Select Et = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlemptype")));
		Et.selectByVisibleText("Salaried");
		driver.findElement(By.id("BodyContent_ctl00_txtcom")).sendKeys("Business");
		// annual income
		driver.findElement(By.id("BodyContent_ctl00_txtmincome")).sendKeys("50000");
		WebElement element1 = driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(1000);
		// upload documents
		driver.findElement(By.id("fileproperyphoto")).sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\home2.jpg");
		driver.findElement(By.id("fileincomepaper")).sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\sitedoc1.png");
		driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// Loan request
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu42']/div[1]/span")).click();
		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		search.sendKeys("rahul");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_pendingloandetails_btn_get_0")).click();
		WebElement element3 = driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0")).click();
		// Release amount
		driver.findElement(By.id("BodyContent_ctl00_txtdamt")).sendKeys("10000");
		Select pp = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		pp.selectByIndex(1);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);

		// LOAN DISBURSEMENT
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu43']")).click();
		WebElement ld = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		ld.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - HL");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloans_btn_get_0")).click();
		WebElement element4 = driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtreliaseamt")).sendKeys("10000");
		driver.findElement(By.id("BodyContent_ctl00_btntransfettosbasp")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btntransferConfirm")).click();
	}

	@Test(priority = 4, enabled = false)
	public void FixedDepositLoan() throws InterruptedException {
		// CreateLoan
		driver.findElement(By.xpath(".//*[@id='menu4']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu4']/div[1]/span")).click();
		// Search Customer
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).sendKeys("0010000001 - RAHUL GANESH CHOUGALA");
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnnext"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("BodyContent_ctl00_btnnext")).click();
		Thread.sleep(3000);
		// Loan Type
		Select LT = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlproposedloantype")));
		LT.selectByVisibleText("FIXED DEPOSIT LOAN");
		Thread.sleep(2000);
		// scheme name
		Select SN = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		SN.selectByVisibleText("LOAN ON FIXED DEPOSIT SCHEME");
		Thread.sleep(2000);
		// proposed period
		Select PP = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		PP.selectByIndex(1);
		// select accountype
		driver.findElement(By.id("BodyContent_ctl00_grdFDDetails_chkallow_0")).click();
		// required amount
		driver.findElement(By.id("BodyContent_ctl00_txtramt")).sendKeys("6000");
		// loan purpose
		driver.findElement(By.id("BodyContent_ctl00_txtLoanPurpose")).sendKeys("Personal");
		WebElement element1 = driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// Loan Request
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu42']/div[1]/span")).click();
		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		search.sendKeys("rahul");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_pendingloandetails_btn_get_0")).click();
		WebElement element2 = driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtdamt")).sendKeys("6000");
		Select pp = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		pp.selectByIndex(1);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// LOAN DISBUSRMENT
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu43']")).click();
		WebElement ld = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		ld.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - LAFD");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloans_btn_get_0")).click();
		WebElement element3 = driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtreliaseamt")).sendKeys("6000");
		driver.findElement(By.id("BodyContent_ctl00_btntransfettosbasp")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btntransferConfirm")).click();
	}

	@Test(priority = 5, enabled = false)
	public void pigmyloan() throws InterruptedException {
		// Create loan
		driver.findElement(By.xpath(".//*[@id='menu4']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu4']/div[1]/span")).click();
		// search customer
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).sendKeys("0010000001 - RAHUL GANESH CHOUGALA");
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnnext"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("BodyContent_ctl00_btnnext")).click();
		Thread.sleep(3000);
		// Loan Type
		Select LT = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlproposedloantype")));
		LT.selectByVisibleText("PIGMY DEPOSIT LOAN");
		Thread.sleep(2000);
		// scheme name
		Select SN = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		SN.selectByVisibleText("LOAN ON PIGMY DEPOSIT SCHEME");
		Thread.sleep(2000);
		// proposed period
		Select PP = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		PP.selectByIndex(1);
		// select accountype
		driver.findElement(By.id("BodyContent_ctl00_grdFDDetails_chkallow_0")).click();
		// required amount
		driver.findElement(By.id("BodyContent_ctl00_txtramt")).sendKeys("300");
		// loan purpose
		driver.findElement(By.id("BodyContent_ctl00_txtLoanPurpose")).sendKeys("Personal");
		WebElement element1 = driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// Loan Request
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu42']/div[1]/span")).click();
		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		search.sendKeys("rahul");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_pendingloandetails_btn_get_0")).click();
		WebElement element2 = driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0")).click();
		// release amount
		driver.findElement(By.id("BodyContent_ctl00_txtdamt")).sendKeys("300");
		Select pp = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		pp.selectByIndex(1);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// Loan disbursement
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu43']")).click();
		WebElement ld = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		ld.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - LAPD");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloans_btn_get_0")).click();
		WebElement element3 = driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtreliaseamt")).sendKeys("300");
		driver.findElement(By.id("BodyContent_ctl00_btntransfettosbasp")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btntransferConfirm")).click();
	}

	// Don't execute
	@Test(priority = 6, enabled = false)
	public void recuringloan() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='menu4']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu4']/div[1]/span")).click();
		// search customer
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).sendKeys("0010000001 - RAHUL GANESH CHOUGALA");
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnnext"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("BodyContent_ctl00_btnnext")).click();
		Thread.sleep(2000);
		// Loan Type
		Select LT = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlproposedloantype")));
		LT.selectByVisibleText("RECURRING DEPOSIT LOAN");
		Thread.sleep(2000);
		// scheme name
		Select SN = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		SN.selectByVisibleText("0 to 1 Year LRD");
		Thread.sleep(2000);
		// proposed period
		Select PP = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		PP.selectByIndex(1);
		// select accountype
		driver.findElement(By.id("BodyContent_ctl00_grdFDDetails_chkallow_0")).click();
		// required amount
		driver.findElement(By.id("BodyContent_ctl00_txtramt")).sendKeys("3500");
		// loan purpose
		driver.findElement(By.id("BodyContent_ctl00_txtLoanPurpose")).sendKeys("Personal");
		WebElement element1 = driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// loan request
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu42']/div[1]/span")).click();
		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		search.sendKeys("rahul");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_pendingloandetails_btn_get_0")).click();
		WebElement element2 = driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0")).click();
		// grant amount
		driver.findElement(By.id("BodyContent_ctl00_txtdamt")).sendKeys("3500");
		Select pp = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		pp.selectByIndex(1);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// loan disbursment
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu43']")).click();
		WebElement ld = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		ld.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - LARD");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloans_btn_get_0")).click();
		WebElement element3 = driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtreliaseamt")).sendKeys("3500");
		driver.findElement(By.id("BodyContent_ctl00_btntransfettosbasp")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btntransferConfirm")).click();
		// search loan
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu41']/div[1]/span")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtsearch"))
				.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - 00101800001 - LARD");
		driver.findElement(By.id("BodyContent_ctl00_btgo")).click();
	}

	@Test(priority = 7, enabled = false)
	public void MidTermLoan() throws InterruptedException {
		// Create loan
		driver.findElement(By.xpath(".//*[@id='menu4']/div[1]")).click();
		// search customer
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu4']/div[1]/span")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).sendKeys("0010000001 - RAHUL GANESH CHOUGALA");
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		WebElement element = driver.findElement(By.id("BodyContent_ctl00_btnnext"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.id("BodyContent_ctl00_btnnext")).click();
		Thread.sleep(3000);
		// Loan Type
		Select LT = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlproposedloantype")));
		LT.selectByVisibleText("MORTGAGE LOAN");
		Thread.sleep(2000);
		// scheme name
		Select SN = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlschemename")));
		SN.selectByVisibleText("MORTGAGE LOAN FOR 60 MONTHS");
		Thread.sleep(2000);
		// proposed period
		Select PP = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		PP.selectByIndex(1);
		// required amount
		driver.findElement(By.id("BodyContent_ctl00_txtramt")).sendKeys("50000");
		// loan purpose
		driver.findElement(By.id("BodyContent_ctl00_txtLoanPurpose")).sendKeys("Personal");
		// gurantor1
		WebElement grt1 = driver.findElement(By.id("BodyContent_ctl00_txtsearchGuarantor1"));
		grt1.sendKeys("Manish");
		Thread.sleep(2000);
		grt1.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnGuarantor1")).click();
		// gurantor2
		Thread.sleep(2000);
		WebElement grt2 = driver.findElement(By.id("BodyContent_ctl00_txtsearchGuarantor2"));
		grt2.sendKeys("Revati");
		Thread.sleep(2000);
		grt2.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_btnGuarantor2")).click();
		Thread.sleep(2000);
		//// employment Type
		Select Et = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlemptype")));
		Et.selectByVisibleText("Salaried");
		Thread.sleep(2000);
		// employeer business
		driver.findElement(By.id("BodyContent_ctl00_txtcom")).sendKeys("Job");
		// annual income
		driver.findElement(By.id("BodyContent_ctl00_txtmincome")).sendKeys("50000");
		WebElement element1 = driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		// upload document
		driver.findElement(By.id("fileproperyphoto")).sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\bike2.jpg");
		driver.findElement(By.id("fileincomepaper")).sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\ipaper.jpg");
		driver.findElement(By.id("BodyContent_ctl00_btnSavenewloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// loan request
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu42']/div[1]/span")).click();
		WebElement search = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		search.sendKeys("rahul");
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_pendingloandetails_btn_get_0")).click();
		WebElement element2 = driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(2000);
		driver.findElement(By.id("BodyContent_ctl00_grd_borrower_dtls_btnapprove_0")).click();
		// grant amount
		driver.findElement(By.id("BodyContent_ctl00_txtdamt")).sendKeys("50000");
		// duration
		Select pp = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlperiod")));
		pp.selectByIndex(1);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveloan")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnyes")).click();
		Thread.sleep(1000);
		// loan disbursement
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu43']")).click();
		WebElement ld = driver.findElement(By.id("BodyContent_ctl00_txtsearchcustomer"));
		ld.sendKeys("0010000001 - RAHUL GANESH CHOUGALA - ML");
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btnScustomer")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloans_btn_get_0")).click();
		WebElement element3 = driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_grd_approvedloan_details_btnCompleteloan_0")).click();
		driver.findElement(By.id("BodyContent_ctl00_txtreliaseamt")).sendKeys("50000");
		driver.findElement(By.id("BodyContent_ctl00_btntransfettosbasp")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BodyContent_ctl00_btntransferConfirm")).click();
	}

	@AfterTest
	public void quit() {
//		driver.quit();
	}
}
