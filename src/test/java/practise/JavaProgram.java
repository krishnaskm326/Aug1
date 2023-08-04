package practise;

import org.testng.annotations.Test;

public class JavaProgram {

	@Test
	public void test() {
		String s="india";
		for(int i=0;i<s.length();i++) {
			try {
				
			System.out.println(s.substring(i,i+1)+""+s.charAt(i+1));
		}
			catch (Exception e) {
				break;
			}
	}
		}
	

	@Test
	public void test1() {
		String s="india";
		for(int i=0;i<s.length();i++) {
			try {
			System.out.println(s.charAt(i)+""+s.charAt(i+1));
			}
			catch (Exception e) {
				e.getMessage();
			}
	}
	}
	
	
	@Test
	public void test2() {
		String s="india";
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<s.length();j++) {
			try {
			System.out.print(s.charAt(j));
			}
			catch (Exception e) {
				e.getMessage();
			}
	}
			
		System.out.println();
		}
	}
	
	@Test
	public void test3() {
		String s="india";
		for(int i=0;i<s.length();i++) {
			try {
			System.out.println(s.charAt(i)+""+s.charAt(i+1)+""+s.charAt(i+2));
			}
			catch (Exception e) {
				e.getMessage();
			}
	}
	}
	
	@Test
	public void test4() {
		String s="india is my country";
		for(int i=0;i<s.length();i++) {
			
		}
}
}
