package com.GenericUtilities;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Parameters;


	import io.github.bonigarcia.wdm.WebDriverManager;

	public class SampleBaseClass {
		
		
		public WebDriver driver;
		
		@BeforeSuite(groups =  {"smoke","regression"})
		public void connectToDB() throws Throwable {
		} 
		
		@Parameters("BROWSER")
		@BeforeClass(groups =  {"smoke","regression"})
		public void openTheBrowser(String BROWSER) throws Throwable {
			
			
			if(BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if (BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("EDGE")){
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			     }
			
		   }
		
		@BeforeMethod(groups =  {"smoke","regression"})
		public void userLogin() throws Throwable {
		}

		@AfterMethod(groups =  {"smoke","regression"})
		public void userLogout() {
		}
		
		@AfterClass(groups =  {"smoke","regression"})
		public void closeTheBrowser() {
			driver.quit();
		}
		
		@AfterSuite(groups =  {"smoke","regression"})
		public void closeDbConnection() throws Throwable {

		}

	}


