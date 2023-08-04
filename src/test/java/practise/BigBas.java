package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBas {
	@Test
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		WebElement res1 = driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']"));
		Actions a=new Actions(driver);
		a.moveToElement(res1).perform();
		WebElement res2 = driver.findElement(By.xpath("//a[@class='ng-binding' and text()='Fruits & Vegetables']"));
		a.moveToElement(res2).click();
		List<WebElement> allSugg = driver.findElements(By.xpath("//ul[@class='nav navbar-nav visible-md visible-lg']/descendant::ul[@class='dropdown-menu']/descendant::ul[@id='navBarMegaNav']/following-sibling::div[@class='tab-content col-md-9' ]/descendant::div[@class='col-md-3 pad-rt-0 desgn-fix']/ul/li/a"));
		int count=allSugg.size();
		for(int i=0;i<count;i++) {
			if(count==i) {
			break;
			}
			
			String data = allSugg.get(i).getText();
			WebElement res3 = driver.findElement(By.xpath("//ul[@class='nav navbar-nav visible-md visible-lg']/descendant::ul[@class='dropdown-menu']/descendant::ul[@id='navBarMegaNav']/following-sibling::div[@class='tab-content col-md-9' ]/descendant::div[@class='col-md-3 pad-rt-0 desgn-fix']/ul/li/a[text()='"+data+"']"));
			Actions a3=new Actions(driver);
			a3.moveToElement(res3).perform();
			
			System.out.println("===================================================");
			System.out.println(data+" ");
			Thread.sleep(2000);

			List<WebElement> allSugg2 = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']/following-sibling::div/descendant::div[@class='tabbable col-md-12 pad-rt-0']/div[@class='col-md-3 pad-rt-0 desgn-fix']/descendant::a[contains(.,'"+data+"')]/ancestor::div[@class='col-md-3 pad-rt-0 desgn-fix']/following-sibling::div[@class='col-md-9 no-boxshadow desgn-fix']/descendant::ul[@class='list-unstyled']/li/a"));

			Thread.sleep(2000);
			for(WebElement el1:allSugg2) {
				el1.getText();	
				System.out.println(el1.getText());

			}

		}



	}
}
