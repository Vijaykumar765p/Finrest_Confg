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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddShraesSetting {
	public static Properties prop = null;
public static FileInputStream ip = null;
	@Test
	public void addshares()
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
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_td_fess_penalty']/a")).click();
		// WebElement
		// list=driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlsharetypes']"));
		for (int i = 1; i < 5; i++) {
			FileInputStream fis = new FileInputStream("C:/java/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("ShareScheme");
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
			Select select = new Select(driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_ddlsharetypes']")));
			select.selectByValue(v);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='txtnoshares']")).sendKeys(v1);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtamountpershare']")).sendKeys(v2);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsharefee']")).sendKeys(v3);
			driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtentrancefee']")).sendKeys(v4);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnsaveshares']")).click();
			Thread.sleep(2000);
		}
		driver.quit();
	}
}
