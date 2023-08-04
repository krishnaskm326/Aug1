package practise;

public class JPProgram08 {

	public static void main(String[] args) {

		int a[]= {23,14,43,34,15,1};
		maxNum(a,4);
	}

	private static void maxNum(int[] a, int n) {
		
		for(int i=0;i<a.length;i++) {
			int count=0;
			for(int j=0;j<a.length;j++) {
				if(a[j]<a[i])
				{
					count++;
				}
				}
			if(count==n-1) {
				System.out.println(a[i]+" is "+n+" minimum");
				
			}
		}
		

		
	}

}
