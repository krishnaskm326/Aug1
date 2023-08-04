 package com.GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shadow {

	@Test
	public void test() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("chrome://downloads/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		WebElement element=(WebElement)js.executeScript("document.querySelector('downloads-manager').shadowRoot\r\n"
//				+ "			 .querySelector('downloads-toolbar') .shadowRoot\r\n"
//				+ "			 .querySelector('cr-toolbar').shadowRoot  \r\n"
//				+ "			 .querySelector('#search').shadowRoot.querySelector('input')")
	}
	
}
