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

public class CricbuzzSharma {
	@Test
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//span[@class='cb-ico cb-search-input-icon cb-search-input-icon-nav']")).click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@id='search_bar_menu']")).sendKeys("Ishant sharma");
		driver.findElement(By.xpath("//a[text()='SEARCH']")).click();
		driver.findElement(By.xpath("//span[text()='Ishant Sharma']")).click();
		
		String  match = "//div[text()='Bowling Career Summary']/parent::div[@class='cb-plyr-tbl']/descendant::td[@class='cb-col-8']/strong";
			
		
		List<WebElement> match_type = driver.findElements(By.xpath(match));
		int a=match_type.size();
		
		String wick ;
		WebElement wicket = null;
		HashMap<String, String> map=new HashMap<String, String>();
		FileInputStream fis=new FileInputStream("./src/main/resources/PHONE.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println("enter the "+a+" cell values");
		Sheet sh = wb.createSheet("ISHANT_SHARMA1");
		for(int i=0;i<a;i++) {
			String mat = match_type.get(i).getText();
			System.out.print(mat  +"  ");
			Thread.sleep(300);
		    wick ="//div[text()='Bowling Career Summary']/parent::div[@class='cb-plyr-tbl']/descendant::td[@class='cb-col-8']/strong[text()='"+mat+"']/parent::td[@class='cb-col-8']/following-sibling::td[@class='text-right'][4]";
		    Thread.sleep(300);
		    wicket = driver.findElement(By.xpath(wick));
	        String wi = wicket.getText();
	        System.out.println(wi);
	        sh.createRow(i).createCell(0).setCellValue(match_type.get(i).getText());
			
			sh.getRow(i).createCell(1).setCellValue(wi);
			FileOutputStream fos=new FileOutputStream("./src/main/resources/PHONE.xlsx");
			wb.write(fos);	
		}
				
		wb.close();
	}
	}


