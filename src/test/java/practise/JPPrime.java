package practise;

import org.testng.annotations.Test;

public class JPPrime {

		@Test
		public boolean prime(int a) {
			for(int i=2;i<a/2;i++)
			{
				if(a%i==0)
					return false;
			}
			return true;
			}
		@Test(dependsOnMethods = "prime")
		public void getPrime() {
			int a=25;
		
			for(int i=1;i<=a;i++) {
				boolean rs=prime(i);
				for(int j=2;j<i/2;j++) {
					if(i%j==0) {
						rs=false;
						break;
					}
					if(rs==true)
						System.out.print(i+" ");
				}
				
			}
		}
	}
	