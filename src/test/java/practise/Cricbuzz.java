package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class Cricbuzz {

	@Test
	public void test3() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//a[text()='Archives']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'ICC Cricket World Cup Qualifiers 2023')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Nepal vs Zimbabwe, 1st Match, Group A')]")).click();
		driver.findElement(By.xpath("//a[text()='Scorecard']")).click();
		String p_name = "//div[@class='cb-col cb-col-100 cb-scrd-sub-hdr cb-bg-gray']/following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms ']/descendant::a[@class='cb-text-link']";
		List<WebElement> bowler = driver.findElements(By.xpath(p_name));
	    List<WebElement> wicket = driver.findElements(By.xpath("//a[contains(text(),'') and @class='cb-text-link']/parent::div[@class='cb-col cb-col-38']/following-sibling::div[@class='cb-col cb-col-8 text-right text-bold']"));
		int a=bowler.size();
		int b=wicket.size();
		System.out.println(a);
		System.out.println(b);
		System.out.println("    bowler_name ========= wickets ");
//		for(int i=0;i<bowler.size();i++) {
//			
//			System.out.print("     "+bowler.get(i).getText()+"     ");
//			System.out.print(wicket.get(i).getText());
//			System.out.println();
//			
//		}
		FileInputStream fis=new FileInputStream("./src/main/resources/PHONE.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println("enter the "+a+" cell values");
		Sheet sh = wb.createSheet("SHARMA");
		if(a==b)
		for(int i=0;i<a;i++) {
			
			sh.createRow(i).createCell(0).setCellValue(bowler.get(i).getText());
			
			sh.getRow(i).createCell(1).setCellValue(wicket.get(i).getText());
		}
		FileOutputStream fos=new FileOutputStream("./src/main/resources/PHONE.xlsx");
		wb.write(fos);			
		wb.close();
}
}
