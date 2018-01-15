package GenericClasses;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
public class TestBase {
public static Properties prop=null;
public static FileInputStream ip = null;
public static WebDriver driver=null;
	@BeforeMethod
	public static void login() throws IOException{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
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
			driver.get("http://demo/FINREST_AUTOMATION/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("uc_login_txtusername")).sendKeys("admin");
			driver.findElement(By.id("uc_login_txtpassword")).sendKeys("adminfinrest@rscs");
			driver.findElement(By.id("uc_login_btnlogin")).click();
	}
	@BeforeTest
	public void initialize() throws IOException
	{
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Other\\xpaths.properties");
		prop.load(ip);
	}	
		public static  WebElement getObject(String identifier) throws IOException {
			if(prop.getProperty(identifier).startsWith("//"))
				{
					try{
							return driver.findElement(By.xpath(prop.getProperty(identifier)));
					   }catch(Throwable t)
						{
						   System.err.println("====ERROR ENCOUNTERED. OBJECT NOT FOUND====");	
						}	
				}
			else
			{
				try	{
						return driver.findElement(By.id(prop.getProperty(identifier)));
					}catch(Throwable t)
						{
							System.err.println("====ERROR ENCOUNTERED. OBJECT NOT FOUND====");	
						}	
			}
			return null;
		}	
		@AfterMethod
		public void close(){
			driver.quit();
		}	
	}
