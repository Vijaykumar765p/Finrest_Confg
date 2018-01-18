package configuration;

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
import org.testng.annotations.Test;

public class Preference {
	public static Properties prop = null;
	public static FileInputStream ip = null;

	@Test
	public void PreferenceTest() throws InterruptedException, IOException {
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
		WebDriver dr = new ChromeDriver(options);
		dr.get(prop.getProperty("url"));
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.findElement(By.id("uc_login_txtusername")).sendKeys(prop.getProperty("USERNAME"));
		dr.findElement(By.id("uc_login_txtpassword")).sendKeys(prop.getProperty("PASSWORD"));
		dr.findElement(By.id("uc_login_btnlogin")).click();
		Thread.sleep(2000);
		dr.findElement(By.xpath("//div[@id='menu5']")).click();
		Thread.sleep(2000);
		WebElement element = dr.findElement(By.xpath("//div[@id='menu5']"));
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(true);", element);
		dr.findElement(By.xpath("//span[contains(.,'PREFERENCES')]")).click();
		Thread.sleep(2000);
		// Denomination
		// Configure the Action
		WebElement element1 = dr.findElement(By.xpath(
				"/html/body/form/div[3]/div[3]/table/tbody/tr/td[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[2]/td[4]/label/div"));
		Actions action = new Actions(dr);
		// To click on the element1
		action.moveToElement(element1).click().perform();

		// Scroll down
		Actions actions = new Actions(dr);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

		// Edit interest details
		// Configure the Action
		WebElement element2 = dr.findElement(By.xpath(
				"/html/body/form/div[3]/div[3]/table/tbody/tr/td[2]/div/div[1]/div[2]/div[2]/table/tbody/tr[11]/td[2]/label/div"));
		Actions action1 = new Actions(dr);
		// To click on the element2
		action1.moveToElement(element2).click().perform();
		Thread.sleep(1000);
		dr.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnSave']")).click();
	}
}
