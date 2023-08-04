
public class B {
	
	static int[] a= {1,2,3};
	public static void main(String[] args) {
		a[0]=21;
		System.out.println(a[0]);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
}