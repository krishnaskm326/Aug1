package practise;



import org.testng.annotations.Test;



public class example11 {

	@Test
	public void test1() {
		String s="india";
		char ch[]=s.toCharArray();

		for(int k=0;k<s.length();k++)
		{
			for(int i=k;i<s.length();i++) {
				for(int j=k;j<=i;j++) {

					System.out.print(ch[j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}

