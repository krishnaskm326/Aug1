package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelData_5 {
	
	@Test
	public void readData() throws EncryptedDocumentException, IOException {
		FileInputStream fio=new FileInputStream("./src/main/resources/PHONE.xlsx");
		Workbook wb=WorkbookFactory.create(fio);
		 String data = wb.getSheet("IPHONE2").getRow(0).getCell(0).getStringCellValue();
		 System.out.println(data);
		
	}
	
		
		@Test
		public void writeData() throws EncryptedDocumentException, IOException {
			FileInputStream fio=new FileInputStream("./src/main/resources/PHONE.xlsx");
			Workbook wb=WorkbookFactory.create(fio);
			 wb.getSheet("IPHONE2").getRow(0).getCell(0).setCellValue("Apple iPhone 13 (128GB) - BLUE");
			 FileOutputStream fos=new FileOutputStream("./src/main/resources/PHONE.xlsx");
			 wb.write(fos);
			 wb.close();
			
		}

	
}
