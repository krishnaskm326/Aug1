package Script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.MycartPage;
import com.ObjectRepository.PaymentMethodPage;
import com.ObjectRepository.ProductCategoryPage;
import com.ObjectRepository.SigninPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkout {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitFOrPageLoad(driver);

		String url = fLib.readDataFromPropertyFile("User_URL");
		String userName = fLib.readDataFromPropertyFile("User_un");
		String password = fLib.readDataFromPropertyFile("User_pwd");
		
		
		driver.get(url);
		HomePage hp=new HomePage(driver);
		hp.clkLoginBtn();
	   
		SigninPage sp=new SigninPage(driver);
	    sp.userSignIn(userName, password);
	    
	    
	    String data = eLib.readDataFromExcel("Sheet2",0,1);
	    MycartPage mp=new MycartPage(driver);
	    hp.SearchProductTF(eLib, "Sheet2", 0, 1);;
	    
		//-----------------------------------------------------------------------------//
	    ProductCategoryPage pcp=new ProductCategoryPage(driver);
	    pcp.clkAddToCartBtn();
	    wLib.acceptAlert(driver);
	    hp.MyCartBtn();
	    mp.clkCheckOutBtn();
	    
	    PaymentMethodPage pmp=new PaymentMethodPage(driver);
	    pmp.clkCODPaymentOptions();
	    pmp.clkSubmitBtn();
	    
		String result = driver.getTitle();
		System.out.println(result);
		if(result.contains("Order")){
			System.out.println(result+" page displayed successfully"+" TC Pass");
			
		}
	}

}
