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

public class AddIntrestPostinSt {
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test()
	public void addintrest() throws InterruptedException, IOException {
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
		driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
		driver.findElement(By.id("uc_login_txtpassword")).sendKeys("adminfinrest@rscs");
		driver.findElement(By.id("uc_login_btnlogin")).click();
		driver.findElement(By.xpath("//div[text()='CONFIGURATION']")).click();
		driver.findElement(By.xpath(".//*[@id='uc_menu_td_sub_menu51']/div[1]/span")).click();
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_td_interestposting']/a")).click();
		Select GL = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlacctypeforint']")));
		// Saving deposit
		GL.selectByVisibleText("SAVING DEPOSIT");
		Thread.sleep(1000);
		Select TYPE = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlinttype']")));
		TYPE.selectByVisibleText("Compound");
		Thread.sleep(1000);
		Select IP = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlintposttype']")));
		IP.selectByVisibleText("Yearly");
		Thread.sleep(1000);
		Select PAID = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlgltype']")));
		PAID.selectByVisibleText("Interest Paid");
		Thread.sleep(1000);
		Select GLPAID = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlpaid_payableGL']")));
		GLPAID.selectByVisibleText("INT PAID ON SAVING DEPOSIT");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnsaveintpost']")).click();
		Thread.sleep(3000);
		// Pygmy
		Select slt6 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlacctypeforint")));
		slt6.selectByVisibleText("PIGMY DEPOSIT");
		Thread.sleep(3000);
		Select slt7 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttype")));
		slt7.selectByVisibleText("Compound");
		Thread.sleep(3000);
		Select slt8 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlintposttype")));
		slt8.selectByVisibleText("Yearly");
		Thread.sleep(3000);
		Select slt9 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlgltype")));
		slt9.selectByVisibleText("Interest Payable");
		Thread.sleep(3000);
		Select slt10 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlpaid_payableGL")));
		slt10.selectByVisibleText("OTHER RECEIPTS");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveintpost")).click();
		Thread.sleep(2000);
		// Recurring
		Select slt16 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlacctypeforint")));
		slt16.selectByVisibleText("RECURRING DEPOSIT");
		Thread.sleep(3000);
		Select slt17 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttype")));
		slt17.selectByVisibleText("Productive");
		Thread.sleep(3000);
		Select slt18 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlintposttype")));
		slt18.selectByVisibleText("Quarterly");
		Thread.sleep(3000);
		Select slt19 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlgltype")));
		slt19.selectByVisibleText("Interest Payable");
		Thread.sleep(3000);
		Select slt20 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlpaid_payableGL")));
		slt20.selectByVisibleText("INTREST PAYABLE R.D.");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveintpost")).click();
		Thread.sleep(2000);
		// SRS Abhiruddhi Recurring
		Select sl = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlacctypeforint")));
		sl.selectByVisibleText("SRS ABHIVRUDHI DEPOSIT");
		Thread.sleep(3000);
		Select sl2 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttype")));
		sl2.selectByVisibleText("Productive");
		Thread.sleep(3000);
		Select sl3 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlintposttype")));
		sl3.selectByVisibleText("Quarterly");
		Thread.sleep(3000);
		Select sl4 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlgltype")));
		sl4.selectByVisibleText("Interest Payable");
		Thread.sleep(3000);
		Select sl5 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlpaid_payableGL")));
		sl5.selectByVisibleText("INTREST PAYABLE R.D.");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveintpost")).click();
		Thread.sleep(2000);
		// Short term deposit
		Select slt26 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlacctypeforint")));
		slt26.selectByVisibleText("SHORT TERM DEPOSIT");
		Thread.sleep(3000);
		Select slt27 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttype")));
		slt27.selectByVisibleText("Simple");
		Thread.sleep(3000);
		Select slt28 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlintposttype")));
		slt28.selectByVisibleText("Half Yearly");
		Thread.sleep(3000);
		Select slt29 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlgltype")));
		slt29.selectByVisibleText("Interest Payable");
		Thread.sleep(3000);
		Select slt30 = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlpaid_payableGL")));
		slt30.selectByVisibleText("INT. PAYABLE SHORT TERM");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveintpost")).click();
		Thread.sleep(3000);
		//// Double
		// Select slt31 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlacctypeforint")));
		// slt31.selectByVisibleText("DOUBLE DEPOSIT");
		// Thread.sleep(3000);
		// Select slt32 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttype")));
		// slt32.selectByVisibleText("Compound");
		// Thread.sleep(3000);
		// Select slt33 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlintposttype")));
		// slt33.selectByVisibleText("Half Yearly");
		// Thread.sleep(3000);
		// Select slt34 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlgltype")));
		// slt34.selectByVisibleText("Interest Paid");
		// Thread.sleep(3000);
		// Select slt35 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlpaid_payableGL")));
		// slt35.selectByVisibleText("INT PAID ON FDL/OD A/C");
		// Thread.sleep(3000);
		// driver.findElement(By.id("BodyContent_ctl00_btnsaveintpost")).click();
		// Thread.sleep(3000);
		//// RSGFD
		// Select slt36 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlacctypeforint")));
		// slt36.selectByVisibleText("RIDDHI SIDDHI GOLDEN DEPOSIT");
		// Thread.sleep(3000);
		// Select slt37 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttype")));
		// slt37.selectByVisibleText("Compound");
		// Thread.sleep(3000);
		// Select slt38 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlintposttype")));
		// slt38.selectByVisibleText("Half Yearly");
		// Thread.sleep(3000);
		// Select slt39 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlgltype")));
		// slt39.selectByVisibleText("Interest Paid");
		// Thread.sleep(3000);
		// Select slt40 = new
		//// Select(driver.findElement(By.id("BodyContent_ctl00_ddlpaid_payableGL")));
		// slt40.selectByVisibleText("INT PAID ON FDL/OD A/C");
		// Thread.sleep(3000);
		// driver.findElement(By.id("BodyContent_ctl00_btnsaveintpost")).click();
		// Thread.sleep(3000);
		// MIS
		Select Glname = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlacctypeforint")));
		Glname.selectByVisibleText("M.I.S. DEPOSIT (Monthly)");
		Thread.sleep(3000);
		Select CalType = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlinttype")));
		CalType.selectByVisibleText("Simple");
		Thread.sleep(3000);
		Select intrpost = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlintposttype")));
		intrpost.selectByVisibleText("Monthly");
		Thread.sleep(3000);
		Select paid = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlgltype")));
		paid.selectByVisibleText("Interest Paid");
		Thread.sleep(3000);
		Select Glpaid = new Select(driver.findElement(By.id("BodyContent_ctl00_ddlpaid_payableGL")));
		Glpaid.selectByVisibleText("INT PAID ON FDL/OD A/C");
		Thread.sleep(3000);
		driver.findElement(By.id("BodyContent_ctl00_btnsaveintpost")).click();
		driver.quit();
	}
}
