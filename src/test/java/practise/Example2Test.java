package practise;


import org.testng.annotations.Test;

public class Example2Test {


	@Test(groups = "smoke")
	public void data1() {
		System.out.println("smoke 2 executed");
	}
	@Test(groups = "regression")
	public void data2() {
		System.out.println("regression 2 executed");
	}
	
}
