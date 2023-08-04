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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//div/div/button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("phones");
		driver.findElement(By.xpath("//button[@type='submit1']")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//1div[@class=\"_30jeq3 _1_WHN1\"]"));
		int count=prices.size();
		System.out.println(count);
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(WebElement all:prices) {
			String text=all.getText().replaceAll(",","");
			String text1=text.substring(1);
			list.add(Integer.parseInt(text1));

		}

		Collections.sort(list);
		System.out.println(list);
		int i=1;

		for(Integer p:list) {

			System.out.println(i+") "+p);
			i++;
		}

		Collections.reverse(list);
		int j=1;
		for(Integer p:list) {

			System.out.println(j+") "+p);
			j++;
		}
		System.out.println(list);
	}

	@Test(invocationCount = 0)
	public void test2() {

		int a[]= {1,2,3};
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {

				int sum=0;
				sum=a[i]+a[j];
				System.out.print(sum+",");
			}
		}
	}

	
	@Test(invocationCount = 0)
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//div/div/button[text()='✕']")).click();

		driver.findElement(By.name("q")).sendKeys("iphones");
		Thread.sleep(200);
		List<WebElement> autoSugg = driver.findElements(By.xpath("//ul[@class=\"col-12-12 _1MRYA1 _38UFBk\"]/descendant::div[@class=\"lrtEPN _17d0yO\"]"));
		int size=autoSugg.size();
		System.out.println(size);
		String a[]=new String[size];
		
		for(int i=0;i<size;i++) {
			Thread.sleep(200);
			a[i] = autoSugg.get(i).getText();
		System.out.println(a[i]);
		}
		
		
		for(int i=0;i<a.length;i++) {
			Thread.sleep(200);
			
			if(a[i].contains("iphone 14 pro")) {
			System.out.println("ok accepted");
			autoSugg.get(i).click();
			}
		}
		Thread.sleep(2000);
		String data = driver.findElement(By.xpath("//span[contains(text(),\"Showing 1 – 24 of 56 results for \")]")).getText();
		
		List<WebElement> fPage = driver.findElements(By.xpath("//div[@class=\"_2kHMtA\"]/a"));
		int fp=fPage.size();
		System.out.println("fp "+fp);
		
		driver.findElement(By.xpath("//a[@class=\"ge-49M\" and text()='2']")).click();
		Thread.sleep(3000);
		List<WebElement> sPage = driver.findElements(By.xpath("//div[@class=\"_2kHMtA\"]/a"));
		int sp=sPage.size();
		System.out.println("sp "+sp);
		
		driver.findElement(By.xpath("//a[@class=\"ge-49M\" and text()='3']")).click();
		Thread.sleep(3000);
		List<WebElement> tPage = driver.findElements(By.xpath("//div[@class=\"_2kHMtA\"]/a"));
		int tp=tPage.size();
		System.out.println("tp "+tp);

		
		String st[]=data.split(" ");
		System.out.println(st[5]);
		int sum=fp+sp+tp;
		
		if(sum==(Integer.parseInt(st[5]))) {
			System.out.println("is matched");
		}
		else {
			System.out.println("is not matched");
		}

	}
}



