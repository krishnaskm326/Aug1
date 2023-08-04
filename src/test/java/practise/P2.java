package practise;

import java.util.HashMap;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class P2 {

	@Test
	public void Num() {
		int a[]= {7,2,12,15};
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++) {
			map.put(i,a[i]);
		}
		
			
			for(int i=0;i<map.size();i++) {
				for(int j=i+1;j<map.size();j++) {
					
					int ans=map.get(i)+map.get(j);
					if(ans==9) {
					System.out.println(map.get(i)+"+"+map.get(j)+"="+ans);
			}
				}
		}
	
}
	
	@Test
	public void CountUniqCharacter() {
		
		String s="aaabccdeee";
		for(int i=0;i<s.length();i++) {
			int count =0;
			for(int j=0;j<s.length();j++) {
				
				if(s.charAt(i)==s.charAt(j)) {
					count++;
				}
			}
				if(count<2) {
					System.out.print(s.charAt(i));
				}
			}
		}
@Test
public void number() {
	String s="abcd123klm345";
	char s1[]=s.toCharArray();
	String num="";
	for(int i=0;i<s1.length;i++) {
		
		if(s1[i]>='a'  && s1[i]<='z') {
			//System.out.print(s.charAt(i)+" ");
		}
		else {
			num=num+s1[i];
			System.out.print(num+" ");
		}
	}
}
	
	@Test
	public void test() {
		int a[]= {1,3,5,7,9};
		int k=2;
		
		a[1]=k;
		int b[]=new int[a.length];
		int temp=a[a.length-1];
		a[a.length-1]=a[0];
		a[0]=temp;
		int temp1;
		
		System.out.println("");
		for(int i=1;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
			if(a[j]< a[i]) {
				
			temp1=a[a.length-1];
			a[a.length-1]=a[i];
			a[i]=temp1;
			}
		}
	}
		for(int i=0;i<a.length;i++) {
		  System.out.print(a[i]);
		  
		}
		System.out.println();
		}
}
		
		
		
	
	
	
	
