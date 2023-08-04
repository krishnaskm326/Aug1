package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Youtube1 {

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("samsung s20");
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		try {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		}
		catch (Exception e) {
			e.getMessage();
		}
			
		driver.findElement(By.xpath("(//ytd-video-renderer)[position()=1]")).click();
		//driver.quit();
	}
	
	@Test
	public void test12() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[@type='text']")).click();
		
	}
	@Test
	public void test13() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("samsung s20");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(" ");
		
		List<WebElement> allSugg = driver.findElements(By.xpath("//div[@class='sbqs_c' and contains(.,'')]"));
		int count = allSugg.size();
		for(int i=0;i<count;i++) {
			System.out.println(allSugg.get(i).getText());
			if(allSugg.get(i).getText().contains("fe 5g review")) {
				allSugg.get(i).click();
				break;
			}
		}
	
	}
}
