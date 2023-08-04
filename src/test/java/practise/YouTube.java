package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTube {
		@Test
		public void test3() throws Throwable {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.youtube.in");
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys("planet");
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(" ");;
			List<WebElement> allSugg = driver.findElements(By.xpath("//div[@class='sbqs_c' and contains(.,'planet')]"));
			int count = allSugg.size();
			System.out.println(count);
			for(WebElement a:allSugg) {
				
				System.out.println(a.getText());
			}
			driver.close();
}
}