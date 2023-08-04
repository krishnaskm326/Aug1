package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JPProgramICCTest {

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/");
		driver.findElement(By.xpath("//a[contains(text(),'ICC Cricket')]")).click();
		WebElement resources = driver.findElement(By.xpath("//a[@class=\"sub-menu__link \" and contains(text(),'Rankings')]"));
		Actions a=new Actions(driver);
		a.moveToElement(resources).perform();
	}
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.tutorialspoint.com/");
		String page = driver.getPageSource();
		String url = driver.getCurrentUrl();
		System.out.println("page"+page);
		System.out.println("url"+url);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
}
	
	@Test
	public void test2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("C:\\Users\\aarathana\\Desktop\\page1.html");
		
		driver.findElement(By.id("t1")).sendKeys("a");
		driver.switchTo().frame("v1");
		driver.findElement(By.id("t2")).sendKeys("b");
		driver.switchTo().frame("v2");
		driver.findElement(By.id("t3")).sendKeys("c");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t1")).sendKeys("b");
		driver.switchTo().frame("v1");
		driver.findElement(By.id("t2")).sendKeys("c");
		driver.switchTo().frame("v2");
		driver.findElement(By.id("t3")).sendKeys("d");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t1")).sendKeys("1");
		driver.switchTo().frame("v2");
		//driver.findElement(By.id("t3")).sendKeys("2");
		
}
}
