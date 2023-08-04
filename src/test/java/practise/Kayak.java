package practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtilities.JavaUtilitity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kayak {
	@Test
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//div[@class=\"vvTc-item-button\"]/*[local-name()='svg']")).click();
		driver.findElement(By.xpath("//input[@class='k_my-input'  and @placeholder='From?']")).sendKeys("Delhi");
		List<WebElement> from = driver.findElements(By.xpath("//div[@class=\"JyN0-name-row\"]/span[@class=\"JyN0-name\"]"));
		String f="New Delhi, National Capital Territory of India, India";
		
		for(int i=0;i<from.size();i++) {
			Thread.sleep(300);
			String exp = from.get(i).getText();
			System.out.println(exp);
			Thread.sleep(300);
			if(f.equalsIgnoreCase(exp)) {
				Thread.sleep(300);
				from.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@class='k_my-input' and @placeholder='To?']")).sendKeys("bengaluru");
		
		List<WebElement> to = driver.findElements(By.xpath("//div[@class=\"JyN0-name-row\"]/span[@class=\"JyN0-name\"]"));
		String t="Bengaluru, Karnataka, India";
		for(int i=0;i<from.size();i++) {
			Thread.sleep(300);
			String exp = to.get(i).getText();
			System.out.println(exp);
			Thread.sleep(300);
			if(t.equalsIgnoreCase(exp)) {
				Thread.sleep(300);
				to.get(i).click();
				break;
			}
		}
		
		JavaUtilitity jlib=new JavaUtilitity();
		String fromDate = jlib.customDateFormat(15);
		String toDate = jlib.customDateFormat(20);
		System.out.println(fromDate+" "+toDate);
		
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		driver.findElement(By.xpath("//div[@class=\"ATGJ-navWrapper ATGJ-prev-month\"]/descendant::span[@class=\"tUEz-icon\"]/*[local-name()='svg' and 'path']")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='"+fromDate+"']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@aria-label='End date calendar input']")).click();
		driver.findElement(By.xpath("//div[@aria-label='"+toDate+"']")).click();
		driver.findElement(By.xpath("//div[@class='zEiP-formBody']//descendant::button[@type='submit']")).click();
		Thread.sleep(3000);
		 String currTitle=driver.getTitle();
		    Set<String> window=driver.getWindowHandles();
		    ArrayList<Integer> al=new ArrayList<Integer>(); 
		    
		    for(String wh:window) {
		    	driver.switchTo().window(wh);
		    	String title=driver.getTitle();
		    	System.out.println(title);
		    
		    	if(!currTitle.equals(title))
		    	{ 
		    driver.findElement(By.xpath("//div[text()='Other sort']")).click();
	 		driver.findElement(By.xpath("//span[text()='Earliest take-off (DEL)']")).click();
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
	 		for(WebElement p:allPrice) {
	 			String s=p.getText();
	 			String s1=s.substring(1);
	 			String s3=s1.replace(",","");
	 			String s4=s3.replace(" ","");
	 			int p1=Integer.parseInt(s4);
	 			al.add(p1);
	 		}
	 	
	 		for(int i=0;i<al.size();i++) {
	 			
	 			if(al.get(i)>=15000) {
	 				System.out.println(al.get(i));
	 			}
	 			
	 		}	
		
}
	}
}
}
