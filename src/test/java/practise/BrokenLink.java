package practise;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	@Test
	public void test2() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
	    List<WebElement> allLink = driver.findElements(By.xpath("//a"));
	    ArrayList<String> list_of_broken_link = new ArrayList<String>();
	    ArrayList<String> list_of_link = new ArrayList<String>();
	    
	    for(int i=0;i<allLink.size();i++) {
	    	
	    	String text=allLink.get(i).getAttribute("href");
	    	
	    	if(text== null) {
	    	list_of_broken_link.add(text+" null value");
	    	}else if(text.contains("http")) 
	    	{
	    	  list_of_link.add(text+" link with http protocols");
	      	}
	    	else {
	    		list_of_broken_link.add(text+" without http protocols");
	    }
	    }
	    for(String link:list_of_link) {
	    try {
	    	URL url=new URL(link);
	    	URLConnection con=url.openConnection();
	    	HttpURLConnection http=(HttpURLConnection)con;
	    	int status_code = http.getResponseCode();
	    	String message = http.getResponseMessage();
	    	if(status_code>=400) {
	    		list_of_broken_link.add(link+" wrong statuscode");
	    	}
	    	
	    }
	    catch(Throwable e) {
	    list_of_broken_link.add(link+" not connected");
	    }
	    }
	    for(String allValidLink:list_of_link) {
	    	System.out.println(allValidLink);
	    }
	    
	    driver.close();
}
	    }

