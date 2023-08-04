package practise;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RajaInterView {

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		WebElement home = driver.findElement(By.xpath("//a[@href='/shop/home-living' and @class='desktop-main' and text()='Home & Living']"));
		Actions a=new Actions(driver);
		a.moveToElement(home).perform();

		List<WebElement> mul = driver.findElements(By.xpath("//a[@class=\"desktop-categoryName\" and text()='Home Décor']/parent::li/parent::ul/*"));
		int count=mul.size();
		System.out.println(count);
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<count;i++) {
			list.add(mul.get(i).getText());
		}
		for(String el:list) {
			System.out.println(el);
		}
	}
	@Test
	public void test2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		String value="/shop/home-living";
		
		WebElement home = driver.findElement(By.xpath("//a[@href='"+value+"' and @class='desktop-main' and text()='Home & Living']"));
		Actions a=new Actions(driver);
		a.moveToElement(home).perform();
		List<WebElement> mul = driver.findElements(By.xpath("//a[@class=\"desktop-categoryName\" and text()='Home Décor']/parent::li/parent::ul/*"));
		int count=mul.size();
		System.out.println(count);
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<count;i++) {
			list.add(mul.get(i).getText());
		}
		for(String el:list) {
			System.out.println(el);
		}
}
	@Test
	public void test3() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		
		WebElement home = driver.findElement(By.xpath("//a[@class='desktop-main' and @href='/shop/men']"));
		Actions a=new Actions(driver);
		a.moveToElement(home).perform();
		driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
		Thread.sleep(200);
		List<WebElement> allImg = driver.findElements(By.xpath("//img[@class=\"img-responsive\"]"));
		int count=allImg.size();
		System.out.println(count);
	
}
	@Test
	public void test4() throws Throwable  {
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		
		WebElement home = driver.findElement(By.xpath("//a[@class='desktop-main' and @href='/shop/men']"));
		Actions a=new Actions(driver);
		a.moveToElement(home).perform();
		driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
		driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite sort-downArrow sprites-downArrow\"]")).click();
		driver.findElement(By.xpath("//label[text()='Customer Rating']")).click();
		Thread.sleep(3000);
		
		driver.close();
	}
	@Test
	public void test5() throws Throwable  {
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("mango man");
		driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite desktop-iconSearch sprites-search\"]")).click();
		List<WebElement> allProduct = driver.findElements(By.xpath("//h3[@class=\"product-brand\" and text()='MANGO MAN']//following-sibling::h4[contains(text(),'shirt')]"));
	    int count = allProduct.size();
	    System.out.println(count);
	    for(int i=0;i<count;i++) {
	    	String actual=allProduct.get(i).getText();
	    	Boolean flag=false;
	    	
	    	if(actual.contains("T-shirt")) {
	    		flag=true;
	    		    	}
	    	//System.out.println(actual);
	    	Assert.assertTrue(flag);
	        
	    }
	}
	@Test
	public void test6() throws Throwable  {
		WebDriverManager.chromedriver().setup();
		
		String expeResult="Mango Man - Buy Mango Man Apparels Online in India | Myntra";
	
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("mango man");
		driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite desktop-iconSearch sprites-search\"]")).click();
		driver.findElement(By.xpath("//img[@class='img-responsive' and @title='MANGO MAN Floral Printed Flowy Sustainable Casual Shirt']")).click();
		Set<String> allWin = driver.getWindowHandles();	
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(expeResult));
		for(String wh:allWin) {
			String text=driver.getTitle();
			
			System.out.println(text);
			if(expeResult.contains(text)) {
			driver.switchTo().window(wh);
		}
		}
		driver.findElement(By.xpath("//p[contains(text(),'38')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();
		int expResult=1;
		// last one
		driver.findElement(By.xpath("//span[text()='Bag']")).click();
		String data = driver.findElement(By.xpath("//span[contains(text(),'Qty: ')]")).getText();
		System.out.println(data);
		String[] s=data.split(" ");
		int a=Integer.parseInt(s[1]);
		boolean flag=false;
		if(expResult==a) {
			flag=true;
		}
		Assert.assertTrue(flag); 
		System.out.println("Assert success");
	}
	
	@Test
	public void test() throws Throwable  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.covid19india.org/");
		String st="//div[text()='Tamil Nadu']";
		String State=driver.findElement(By.xpath(st)).getText();
		String Active=driver.findElement(By.xpath("//div[text()='Tamil Nadu']/parent::div[@class='cell']/following-sibling::div[@class=\"cell statistic\"]/child::div[@class=\"delta is-recovered\"]/following-sibling::div")).getText();
		System.out.println(State+" "+Active);
	}
	@Test
	public void test7() throws Throwable  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("");
		Thread.sleep(200);
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenShot/s3.png");
		FileUtils.copyFile(src, dest);
	
}
}