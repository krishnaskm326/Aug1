package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	
	@Test
		public  void test1Test() {
				
				WebDriverManager.firefoxdriver().create();
				WebDriver driver1=new FirefoxDriver();
				driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver1.manage().window().maximize();
				driver1.get("https://www.flipkart.com/");
		}
		}



