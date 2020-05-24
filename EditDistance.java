package dynamicProgCodes;
import java.util.Scanner;

public class EditDistance {
	
	static int minEditsDP[][];

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		
		int m = str1.length();
		int n = str2.length();
		
		minEditsDP = new int[m][n];
		
		int minEdits = minEditsFunc(str1,str2,m-1,n-1);
		
		System.out.println(minEdits);

	}
	
	public static int minEditsFunc(String str1,String str2,int m,int n) {
				
		if(m==0) {
			return n;
		}
		
		if(n==0) {
			return m;
		}
		
		if(minEditsDP[m][n] != 0) {
			return minEditsDP[m][n];
		}
		
		if(str1.charAt(m) == str2.charAt(n)) {
			minEditsDP[m][n] = minEditsFunc(str1,str2,m-1,n-1);
			return minEditsDP[m][n];
		}
		
		else {
			
			int a = minEditsFunc(str1,str2,m,n-1);
			int b = minEditsFunc(str1,str2,m-1,n);
			int c = minEditsFunc(str1,str2,m-1,n-1);
			
			minEditsDP[m][n] = Math.min(Math.min(a, b), c)+1;
			
			return minEditsDP[m][n];
		}
	}

}
