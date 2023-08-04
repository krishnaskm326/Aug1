package testExecution;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Inter {

	
	@Test
	public void javaTest() throws AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		String curr_window_title = driver.getTitle();
		String curr_win_id = driver.getWindowHandle();
		Set<String> all_win_id = driver.getWindowHandles();
		int count =  all_win_id.size();
		System.out.println(count);
		System.out.println(curr_window_title);
		
		for(String allId:all_win_id) {
			
			driver.switchTo().window(allId);
			if(!allId.equals(curr_win_id)) {
				driver.get("https://www.flipkart.com/");
				//break;
			}
		}
	     
		
		
		
		
		
	}
	
}