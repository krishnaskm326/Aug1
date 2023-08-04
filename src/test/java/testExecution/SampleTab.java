package testExecution;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTab {
	@Test
	public void tab() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		String Current = driver.getTitle();
		String pWindow = driver.getWindowHandle();
		WebElement data = driver.findElement(By.id("input"));
		
		
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);

		System.out.println("new tab opened");
		Thread.sleep(2000);
		Set<String> cwindow = driver.getWindowHandles();//2 
		//System.out.println(cwindow.size());
		for(String tab:cwindow)
		{
			System.out.println( driver.getTitle());
			System.out.println(tab);
			//System.out.println(tab);
			if(!tab.equals(pWindow))
			{
				System.out.println("switching to the new tab");
				driver.switchTo().window(tab);	
				break;
			}
		}
		System.out.println( driver.getTitle());
		Thread.sleep(2000);
		driver.get("https://www.amazon.com");
		System.out.println( driver.getTitle());
		System.out.println( driver.getTitle());
	}
}
