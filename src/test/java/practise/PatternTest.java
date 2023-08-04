package practise;

import org.testng.annotations.Test;

public class PatternTest {

	@Test
	public void test() {
		int n=4;
		for(int i = 0; i < n; i++) {
			for(int j = i ; j < n; j++) {
				System.out.print("* ");
							}
			System.out.println();
		}
	}
	
	@Test
	public void test1() {
		int n = 4;
		for(int i=n-1;i>=0;i--) {
			for(int j=i;j<n;j++) {
				System.out.print("  ");
			}
			for(int j=i;j>=0;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	@Test
	public void test2() {
		int n = 4;
		int i=4 ,j=4;
		
		while(n!=0) {
			
			 if(i!=0) {
				while(i==4) {
				System.out.print("  ");
				n++;
			}
			 }
				i--;
			 j = n;
			 while(j!=0) {
				System.out.print("* ");
				j--;
			}
			System.out.println();
			n--;
			j--;
			
		}
	}
}
