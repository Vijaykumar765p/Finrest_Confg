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

public class addeditLocker {
	public WebDriver driver;
	public static Properties prop = null;
	public static FileInputStream ip = null;
	@Test
	public void Addacct() throws InterruptedException, IOException {
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
      driver.findElement(By.xpath("//div[@id='menu5']")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("uc_menu_td_sub_menu53")).click();
  }
  @Test(enabled=true)
  public void addlckr1() throws InterruptedException{
	  Thread.sleep(1000);
      driver.findElement(By.id("BodyContent_ctl00_divmodallocker")).click();    
      Thread.sleep(2000);
      Select slt1 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockerbranch")));
      slt1.selectByVisibleText("Head Office");
      Thread.sleep(2000);
      Select slt2 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockertypes")));
      slt2.selectByVisibleText("Add New Type");
      Thread.sleep(2000);
      driver.findElement(By.id("BodyContent_ctl00_txtlockertype")).sendKeys("Type A");
      driver.findElement(By.id("BodyContent_ctl00_txtbreadth")).sendKeys("10");
      driver.findElement(By.id("BodyContent_ctl00_txtheight")).sendKeys("10");
      driver.findElement(By.id("BodyContent_ctl00_txtnolockers")).sendKeys("20");
      driver.findElement(By.id("BodyContent_ctl00_txtamount")).sendKeys("1000");
      Thread.sleep(2000);
      
//      driver.findElement(By.id("BodyContent_ctl00_btncreatelocker")).click();
//      Thread.sleep(2000);
//      driver.findElement(By.xpath("//*[@id='modallocker']/div/div/div/button")).click();
      Thread.sleep(2000);
  }
  @Test(enabled=false)
  public void addlckr2() throws InterruptedException{
	  driver.findElement(By.xpath("//div[@id='div_img_locker']")).click(); 
	  Thread.sleep(2000);
      Select slt1 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockerbranch")));
      slt1.selectByVisibleText("Head Office");
      Thread.sleep(2000);
      Select slt2 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockertypes")));
      slt2.selectByVisibleText("Add New Type");
      Thread.sleep(2000);
      driver.findElement(By.id("BodyContent_ctl00_txtlockertype")).sendKeys("Type B");
      driver.findElement(By.id("BodyContent_ctl00_txtbreadth")).sendKeys("20");
      driver.findElement(By.id("BodyContent_ctl00_txtheight")).sendKeys("20");
      driver.findElement(By.id("BodyContent_ctl00_txtnolockers")).sendKeys("10");
      driver.findElement(By.id("BodyContent_ctl00_txtamount")).sendKeys("2000");
      Thread.sleep(3000);
      
      driver.findElement(By.id("BodyContent_ctl00_btncreatelocker")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='modallocker']/div/div/div/button")).click();
      Thread.sleep(2000);
  }
  @Test(enabled=false)
  public void addlckr3() throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.id("BodyContent_ctl00_divmodallocker")).click();
	  Thread.sleep(2000);
      Select slt1 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockerbranch")));
      slt1.selectByVisibleText("Head Office");
      Thread.sleep(2000);
      Select slt2 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockertypes")));
      slt2.selectByVisibleText("Add New Type");
      Thread.sleep(2000);
      driver.findElement(By.id("BodyContent_ctl00_txtlockertype")).sendKeys("Type C");
      driver.findElement(By.id("BodyContent_ctl00_txtbreadth")).sendKeys("15");
      driver.findElement(By.id("BodyContent_ctl00_txtheight")).sendKeys("15");
      driver.findElement(By.id("BodyContent_ctl00_txtnolockers")).sendKeys("25");
      driver.findElement(By.id("BodyContent_ctl00_txtamount")).sendKeys("1500");
      Thread.sleep(3000);
      driver.findElement(By.id("BodyContent_ctl00_btncreatelocker")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='modallocker']/div/div/div/button")).click();
      Thread.sleep(2000);
  }
  @Test(enabled=false)
  public void addlckr4() throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.id("BodyContent_ctl00_divmodallocker")).click();
	  Thread.sleep(2000);
      Select slt1 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockerbranch")));
      slt1.selectByVisibleText("Chinchwadgaon Branch");
      Thread.sleep(2000);
      Select slt2 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockertypes")));
      slt2.selectByVisibleText("Add New Type");
      Thread.sleep(2000);
      driver.findElement(By.id("BodyContent_ctl00_txtlockertype")).sendKeys("Type D");
      driver.findElement(By.id("BodyContent_ctl00_txtbreadth")).sendKeys("25");
      driver.findElement(By.id("BodyContent_ctl00_txtheight")).sendKeys("25");
      driver.findElement(By.id("BodyContent_ctl00_txtnolockers")).sendKeys("10");
      driver.findElement(By.id("BodyContent_ctl00_txtamount")).sendKeys("1000");
      Thread.sleep(3000);
      driver.findElement(By.id("BodyContent_ctl00_btncreatelocker")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='modallocker']/div/div/div/button")).click();
      Thread.sleep(2000);
  }
  @Test(enabled=false)
  public void editlckr5() throws InterruptedException{
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.id("BodyContent_ctl00_divmodallocker")).click();
	  Thread.sleep(2000);
      Select slt1 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockerbranch")));
      slt1.selectByVisibleText("Chinchwadgaon Branch");
      Thread.sleep(2000);
      Select slt2 =new Select(driver.findElement(By.id("BodyContent_ctl00_ddllockertypes")));
      slt2.selectByVisibleText("Type D");
      Thread.sleep(2000);
      driver.findElement(By.id("BodyContent_ctl00_txtbreadth")).clear();
      driver.findElement(By.id("BodyContent_ctl00_txtbreadth")).sendKeys("10");
      driver.findElement(By.id("BodyContent_ctl00_txtheight")).clear();
      driver.findElement(By.id("BodyContent_ctl00_txtheight")).sendKeys("10");
      driver.findElement(By.id("BodyContent_ctl00_txtnolockers")).clear();
      driver.findElement(By.id("BodyContent_ctl00_txtnolockers")).sendKeys("10");
      driver.findElement(By.id("BodyContent_ctl00_txtamount")).clear();
      driver.findElement(By.id("BodyContent_ctl00_txtamount")).sendKeys("1000");
      Thread.sleep(3000);
      driver.findElement(By.id("BodyContent_ctl00_btncreatelocker")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id='modallocker']/div/div/div/button")).click();
      Thread.sleep(2000);
      driver.quit();
  }
}
