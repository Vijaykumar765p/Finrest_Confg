package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddOrg {
	public static Properties prop = null;
	public static FileInputStream ip = null;

	@Test
	public void addorganization() throws InterruptedException, IOException {
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
		WebDriver dr = new ChromeDriver(options);
		dr.get(prop.getProperty("url"));
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		dr.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		dr.findElement(By.id("uc_login_btnlogin")).click();
		dr.findElement(By.id("BodyContent_ctl00_txtsname"))
				.sendKeys("SHREE RIDDHI SIDDHI MULTIPURPOSE CO-OP. CREDIT SOCIETY");
		dr.findElement(By.id("BodyContent_ctl00_txtaddress"))
				.sendKeys("#1628/B,Shree Krishna Plaza,1st Floor,Ansurkar Galli,Belgaum");
		Thread.sleep(3000);
		WebElement d1 = dr.findElement(By.id("BodyContent_ctl00_ddlcstate"));
		Select slt1 = new Select(d1);
		slt1.selectByVisibleText("Karnataka");
		Thread.sleep(3000);
		WebElement d2 = dr.findElement(By.id("BodyContent_ctl00_ddlcdistrict"));
		Select slt2 = new Select(d2);
		slt2.selectByVisibleText("Belagavi");
		Thread.sleep(3000);
		WebElement d3 = dr.findElement(By.id("BodyContent_ctl00_ddlccity"));
		Select slt3 = new Select(d3);
		slt3.selectByVisibleText("Belagavi");
		Thread.sleep(3000);
		dr.findElement(By.id("txtstd")).sendKeys("0831");
		dr.findElement(By.id("BodyContent_ctl00_txttelephone")).sendKeys("4205492");
		dr.findElement(By.id("BodyContent_ctl00_txtmobile")).sendKeys("9845657574");
		dr.findElement(By.id("BodyContent_ctl00_txtpincode")).sendKeys("590001");
		dr.findElement(By.id("BodyContent_ctl00_txtemailid")).sendKeys("riddhi.siddhi.bgm@gmail.com");
		dr.findElement(By.id("filelogo")).sendKeys("C:\\Users\\vijay.p\\Downloads\\Images\\logo.png");
		dr.findElement(By.id("BodyContent_ctl00_txtdrictor")).sendKeys("Director");
		dr.findElement(By.id("BodyContent_ctl00_txtmanger")).sendKeys("Manager");
		dr.findElement(By.id("txttodate")).sendKeys("01/04/2017");
		Thread.sleep(1000);
		dr.findElement(By.id("BodyContent_ctl00_txtRegNo")).sendKeys("Reg.No. AR - 9/RSR/UOG/40270/10-11");
		WebElement d4 = dr.findElement(By.id("BodyContent_ctl00_cmbHoliday"));
		Select slt4 = new Select(d4);
		slt4.selectByVisibleText("Sunday");
		Thread.sleep(3000);
		WebElement clcik = dr.findElement(By.xpath(".//*[@id='BodyContent_ctl00_dtpRunningDate']"));
		clcik.sendKeys("01/04/2017");
		Thread.sleep(3000);
		WebElement element = dr.findElement(By.id("BodyContent_ctl00_btnValidate"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		dr.findElement(By.id("BodyContent_ctl00_btnValidate")).click();
		Thread.sleep(1000);
		dr.findElement(By.id("BodyContent_ctl00_btnSave")).click();
		Thread.sleep(2000);
		dr.quit();
	}
}
