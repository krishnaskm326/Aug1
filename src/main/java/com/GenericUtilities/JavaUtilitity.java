package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaUtilitity {
	public int random() {
		Random ran = new Random();
		int random=ran.nextInt(1000);
		return random;
	}
	public String getSysDate() {
		Date dt = new Date();
		WebDriver sd;
		String date=dt.toString();
		return date;
	}
	public String formatSystemDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dt=new Date();
		String getDateandTime = dateFormat.format(dt);
		getDateandTime.replace(":","-");
		return getDateandTime;
	}


	public String customDateFormat(int date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("M yyyy");
		Date dt=new Date();
		String getDateandTime = dateFormat.format(dt);
		String s[]=getDateandTime.split(" ");

		String month=s[0];
		int currMonth=Integer.parseInt(month);
		String year=s[1];
		int currYear=Integer.parseInt(year)-1900;
		
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("EEEEE dd MMMM, yyyy");
		Date dt2=new Date(currYear,currMonth-1,date);//yyy,mm,date
		String getDateandTime2 = dateFormat2.format(dt2);
		

		return getDateandTime2;
	}

	@Test
	
       public String[] customDateFormat1(String date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE dd MMMM, yyyy");
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
