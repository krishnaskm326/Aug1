package practise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class kayakya {
	@Test
	
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/flights/DEL-BLR/2023-07-12/2023-07-14?sort=bestflight_a");
		 Thread.sleep(3000);
 		driver.findElement(By.xpath("//div[text()='Other sort']")).click();
 		driver.findElement(By.xpath("//span[text()='Less CO₂']")).click();
 		JavascriptExecutor js1=(JavascriptExecutor)driver;
 		
 		for(int i=1;i<=7;i++) {
 		
 		js1.executeScript("window.scrollBy(window.scrollBy(0,600))");
 		Thread.sleep(500);
 		    }
 		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='Oihj']/descendant::div[@class='M_JD']/child::div[@class='oVHK']"));
 		System.out.println(allPrice.size());
 		WebDriverWait wait=new WebDriverWait(driver, 10);
 		wait.until(ExpectedConditions.visibilityOfAllElements(allPrice));
 		Thread.sleep(3000);
 		ArrayList<Integer> al=new ArrayList<Integer>(); 
 		for(WebElement p:allPrice) {
 			String s=p.getText();
 			String s1=s.substring(1);
 			String s3=s1.replace(",","");
 			System.out.println(s3);
// 			int p1=Integer.parseInt(s3);
// 			System.out.println(p1);
// 			al.add(p1);
 		}
 	
// 		for(int i=0;i<al.size();i++) {
// 			
// 			if(al.get(i)>=1000) {
// 				System.out.println(al.get(i));
// 			}
// 			
// 		}	

}
}