package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericClasses.DataProviderTest;
import GenericClasses.TestBase;

public class AddCaste extends TestBase {
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "DP")
	public void addcaste(String caste) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='menu5']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'menu53')]")).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//div[contains(@id,'divmodalcaste')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@id,'divmodalcaste')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtcaste']")).sendKeys("Hindu");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='BodyContent_ctl00_txtsubcaste']")).sendKeys(caste);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='BodyContent_ctl00_btnsavecaste']")).click();
	}
}
