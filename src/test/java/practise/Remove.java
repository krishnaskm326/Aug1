package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Remove {

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//div/div/button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("phones");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//div[text()='Free delivery']/parent::div/parent::div/preceding-sibling::div/div[1]"));
		int count=prices.size();
		System.out.println(count);
		ArrayList<String> list=new ArrayList<String>();
		String a[]=null;
				for(WebElement all:prices) {
					list.add(all.getText());
				}
				//Collections.sort(list);

		for(int i=0;i<list.size();i++) {

			String s=list.get(i);
		//	System.out.println(s);
			char ch[]=s.toCharArray();
			String rev="";
			
			for(int j=1;j<ch.length;j++) {

				rev=rev+ch[j];
							
			}
			
			System.out.println(rev);
			a[i]=rev;
			
		}
		ArrayList<String> list1=new ArrayList<String>();
		for(int k=0;k<a.length;k++) {
			//list1.addAll(a);
		}
		Collections.sort(list);
		System.out.println(list);
		for(String abc:list) {
			System.out.println(abc);
		}

		}

}




