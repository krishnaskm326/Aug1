package practise;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.annotations.Test;

public class JPPractice07 {

	@Test
	public void test() {
		int a[]= {1,0,8,0,6,0,2,2};
		int b[]=new int[a.length];
			int m=0;
			int n=a.length-1;
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				b[m]=a[i];
				m++;
			}
			else {
				b[n]=a[i];
				n--;
			}
		}
			for(int i=0;i<b.length;i++) {
				System.out.print(b[i]+" ");
			}
		}
	@Test
	public void test2() {
		int a[]= {1,3,2,6,5};
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			list.add(a[i]);
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		int num=list.get(1);
		System.out.println(num);
	}
	
	@Test
	public void test3() {
		String a="a3%d4b&6";
		char ch[]=a.toCharArray();
		int sum=0;
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>='0' && ch[i]<='9') {
				
				 sum=sum+(ch[i]-48);
				
			}
		}
		System.out.println(sum);
	}
	
	@Test
	public void test4() {
		String s="hi this is krishna";
		char ch[]=s.toCharArray();
		String st[]=s.split(" ");
		int x=ch.length-1;
		for(int k=0;k<=st.length;k++) {
		int count=0;
			for(int j=0;j<st[k].length();j++) {
				
				if(ch[x]!=' ') {
					System.out.print(ch[x]);
					count++;
					x--;
				}
				
			else {
				
				x--;
			}
				if(count==st[k].length()) {
					System.out.print(" ");
				}
		}
			
		}
	}
	}

