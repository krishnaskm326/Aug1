package practise;

import org.testng.annotations.Test;

public class ClairVoyantJPP {

	@Test
	public void addNumberInTheString() {
		
		String s="a53b12c25";    //o/p=====a8b3c7
		char []ch=s.toCharArray();
		int  j;

		for(int i=0;i<ch.length;i++) {

			System.out.println(i);
			if(ch[i]>='a'  &&   ch[i]<='z') {
												
				//System.out.print(ch[i]);			// print alphabets
			}
			
			
			else {
				int count=0;
				for( j=i;j<ch.length;j++) {

					if(ch[j]>='0'  &&   ch[j]<='9') {
						int a=Character.getNumericValue(ch[j]);
						count=count+a;                       //sum of frequent numbers
						
						if(j==ch.length-1) {
							i=j;
							break;
						}
					}
					
					else if(ch[j]>='a'  &&   ch[j]<='z') {
						i=j-1;
					//	System.out.println(i);
						break;
					}
				}

				System.out.print(count);
			}
		}
	}

	@Test
	public void addNumberInTheString1() {
		String s="abcd123hfgdj56483";
		char ch[]=s.toCharArray();
		int count=0;
		for(int i=0;i<ch.length;i++) {
			if(ch[i]>='0'  && ch[i]<='9') {
           count=count+Character.getNumericValue(ch[i]);
			}
		}
		System.out.println(count);
	}
	
	@Test
	public void fibonacciSeries() {
		int n1=0;
		int n2=1;
		int n3;
		System.out.print(n1+","+n2+",");
		for(int i=2;i<=20;i++) {
			
			n3=n1+n2;
			System.out.print(n3);
			n1=n2;
			n2=n3;
			if(i<20) {
				System.out.print(",");
			}
		}
	}
	
	@Test
	public void countDupllicates() {
		String s="abccddeeffgghh";
		int count=0;
		for(int i=0;i<s.length();i++) {
			
			for(int j=i+1;j<s.length();j++) {
				
				if(s.charAt(i)==s.charAt(j)) {
					count++;
				}
			}
		}
		System.out.println("duplicate count "+count);
	}
	@Test
	public void factorial() {
		int fact=1;
		for(int i=1;i<=5;i++) {
			fact=fact*i;
		}
		System.out.println(fact);
	}
}
