package practise;

public abstract class Parent2 {

	static String st="one";
	static String st1="two";    // static members
	int a;

	public abstract void test2();   // abstract Method
	public void TestS() {}
	
	public Parent2(int a) {  // constructor
		this.a=a;
	}
	public void test() {
		System.out.println("Abstract class allowed non static method with implementation ");
	}
}
