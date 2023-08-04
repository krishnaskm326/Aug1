package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Properties_6 {

	@Test
	public void commonData() throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\aarathana\\Desktop\\common1.property");
		Properties p=new Properties();
		p.load(fis); 
		String b_name = p.getProperty("browser");
		System.out.println(b_name);
	}
}
