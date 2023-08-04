package practise;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class Date1 {
	@Test
	public String[] customDateFormat1(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE dd MMMM, yyyy");
		System.out.println(dateFormat);
		Date dt=new Date();  //Monday 3 July, 2023
		String getDateandTime = dateFormat.format(dt);
		String s=getDateandTime;
		String s1[]=s.split(" ");
		String s2=date;
		String s4 = s1[1].replaceAll(s1[1], s2);
		s1[1]=s4;
		for(int i=0;i<s1.length;i++) {

			System.out.print(s1[i]+" ");
		}
		return s1;
	}  
}
