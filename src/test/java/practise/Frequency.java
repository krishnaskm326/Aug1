package practise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.apache.commons.collections4.Put;
import org.testng.annotations.Test;

public class Frequency {

	@Test
	public void test() {
		int a=122334;
		LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
		while(a!=0) {

			int b=a%10;

			if(map.containsKey(b))
			{
				map.put(b,map.get(b)+1);
			}
			else
				map.put(b,1);
			    a=a/10;
		}
		for(int i:map.keySet())
		{
			if(map.get(i)==2)
			{
				System.out.println(i+" "+map.get(i));
			}
		}




	}
	
	@Test
	public void test1() {
		String s1="peek";
		char[] ch1 = s1.toCharArray();
		String s2="keep";
		char[] ch2 = s2.toCharArray();
		int sum=0;
		int sum1=0;
		
		if(ch1.length==ch2.length) {
		for(int i=0;i<ch1.length;i++) {
			for(int j=0;j<ch2.length;j++) {
				
					sum=sum+s1.charAt(i);
					sum1=sum1+s2.charAt(i);
			}
		}
		System.out.println(sum+" "+sum1);
		if(sum==sum1)
			System.out.println("is anagram");
		
	}
		else {
			System.out.println("is not anagram");
		}
		}
}
