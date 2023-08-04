package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataIExcel {

	static Scanner sc;

	public static void main(String[] args) throws Throwable {
		sc = new Scanner(System.in);
		System.out.println("enter the data count");
		int n=sc.nextInt();		
		FileInputStream fis=new FileInputStream("./src/main/resources/PHONE.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println("enter the "+n+" cell values");
		Sheet sh = wb.createSheet("sheet324");
		for(int i=0;i<=n-1;i++) {
			
			String data=sc.next();
			sh.createRow(i).createCell(0).setCellValue(data);
			String data1=sc.next();
			sh.getRow(i).createCell(1).setCellValue(data1);
		}
		
		FileOutputStream fos=new FileOutputStream("./src/main/resources/PHONE.xlsx");
		wb.write(fos);			
		wb.close();
	}

}
