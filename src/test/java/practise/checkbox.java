package practise;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.JavaUtilitity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkbox {

	@Test
	public void checkBox() {

		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com");
		boolean status = driver.findElement(By.xpath("//input[@id='keepLoggedInCheckBox']")).isSelected();
		if(status==true) {

			System.out.println("is selected");
		}
		else {

			System.out.println("is not selected");
		}

		driver.close();		
	}
	@Test
	public String[] testDate(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE dd MMMM, yyyy");
		Date dt=new Date();  //Monday 3 July, 2023
		String getDateandTime = dateFormat.format(dt);
		String s=getDateandTime;
		String s1[]=s.split(" ");
		String s2=date;
		String s3 = null;
		int num = Integer.parseInt(s2);
		if(num>=01  && num < 10) {
			s3 = s2.substring(1);
			s1[1]=s3;
		}
		String s4 = s1[1].replaceAll(s2, s3);
		s1[1]=s4;
		for(int i=0;i<s1.length;i++) {

			System.out.print(s1[i]+" ");
		}
		return s1;

	}

	@Test
	public void date() {
		JavaUtilitity jlib=new JavaUtilitity();

		//fetching current month date								// 5 july 2023

		SimpleDateFormat dateFormat = new SimpleDateFormat("M yyyy");
		Date dt=new Date();
		String getDateandTime = dateFormat.format(dt);
		String s[]=getDateandTime.split(" ");

		String month=s[0];
		int currMonth=Integer.parseInt(month);
		String year=s[1];
		int currYear=Integer.parseInt(year)-1900;
		System.out.println(currMonth+" "+currYear);




		SimpleDateFormat dateFormat2 = new SimpleDateFormat("EEEEE dd MMMM, yyyy");
		Date dt2=new Date(currYear,currMonth-1,6);//yyy,mm,date
		String getDateandTime2 = dateFormat2.format(dt2);
		System.out.println(getDateandTime2); 

	}
	
	@Test
	public void test() {
	JavaUtilitity jlib=new JavaUtilitity();
	String fromDate = jlib.customDateFormat(10);
	String toDate = jlib.customDateFormat(20);
	System.out.println(fromDate+" "+toDate);
}
	
}

