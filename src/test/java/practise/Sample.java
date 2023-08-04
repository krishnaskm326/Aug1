package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	@Test
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverManager.firefoxdriver().create();
		WebDriver driver1=new FirefoxDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.manage().window().maximize();
		driver1.get("https://www.flipkart.com/");
}
}