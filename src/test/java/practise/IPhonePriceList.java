package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class IPhonePriceList {

	@Test
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 13");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String ph="//div[@class='a-section a-spacing-small a-spacing-top-small' and contains(.,'Apple iPhone 13') and not(contains(.,'Cover')) and not(contains(.,'Case'))]/descendant::span[@class=\"a-size-medium a-color-base a-text-normal\"]";
		String pr = "//span[contains(text(),'Apple iPhone 13') and not(contains(.,'Cover')) and not(contains(.,'Case'))]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::div[@class='a-row a-size-base a-color-base']/descendant::span[@class='a-price']/descendant::span[@class='a-price-whole']";
		List<WebElement> phone_name = driver.findElements(By.xpath(ph));
		List<WebElement> price_list = driver.findElements(By.xpath(pr));
		int c1=phone_name.size();
		int c2=price_list.size();
		System.out.println(c1);
		System.out.println(c2);

		FileInputStream fis=new FileInputStream("./src/main/resources/PHONE.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println("enter the "+c1+" cell values");
		Sheet sh = wb.createSheet("IPHONE2");
		if(c1==c2)
		for(int i=0;i<c1;i++) {
			
			sh.createRow(i).createCell(0).setCellValue(phone_name.get(i).getText());
			
			sh.getRow(i).createCell(1).setCellValue(price_list.get(i).getText());
		}
		FileOutputStream fos=new FileOutputStream("./src/main/resources/PHONE.xlsx");
		wb.write(fos);			
		wb.close();
	}
}

