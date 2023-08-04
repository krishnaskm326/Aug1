package testExecution;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.SampleBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example2Test {


	@Test(groups = "smoke")
	public void data1Test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("smoke test 2 executed");
		Thread.sleep(2000);
		//driver.get("https://www.google.com");
		
		//driver.close();
	}
	@Test(groups = "regression")
	public void data2Test() throws Throwable {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		System.out.println("regression test 2 executed");Thread.sleep(2000);
	//	driver.get("https://www.facebook.com");
		
		//driver.close();
	}
	
}
