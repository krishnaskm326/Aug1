package practise;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class JPProgram05 {

	@Test
	public void test() {
		int n=5;
		for(int i=1;i<=n;i++) {
			if(i%2==0)
				i++;
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				if(j%2==0) {
					System.out.print("0 ");
				}
				else {
					System.out.print("1 ");
				}
			}
			System.out.println();	
		}
	}
	@Test
	public void test1() {
		
		String s="oneoneone";
		char[] st = s.toCharArray();
		int count =st.length;
		
		LinkedHashSet<Character> ch=new LinkedHashSet<Character>();
		for(int i=0;i<count;i++) {
			ch.add(st[i]);
		}
		
		int num=0;
		for(Character set:ch) {
			
			for(int j=0;j<st.length;j++) {
				if(set==st[j]) {
					num++;
				}
			}
			System.out.println(set+" occured "+num+" times");
		     num=0;
		
		}
		}
	
	@Test
	public void test2() {
		int sum=0;
		int x,b,y;
		int a=371;
		y=a;
		do {
		  
		b=a%10;
		sum=sum+b*b*b;
		a=a/10;
		}while(a!=0);
		System.out.println(sum==y);
		
		
	}
	
	@Test
	public void test3() {
		String s="india";
		char ch[]=s.toCharArray();
		
	LinkedHashSet<Character> list=new LinkedHashSet<Character>();
	 for(int i=0;i<ch.length;i++)
	 {
		 list.add(ch[i]);
	 }
	 		for(int i=0;i<list.size();i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(s.charAt(j));
								}
				System.out.println();
				
				}
	 		
	
	}
	}
	
