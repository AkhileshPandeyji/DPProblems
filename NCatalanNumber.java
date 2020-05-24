package dynamicProgCodes;
import java.util.Scanner;

//1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862,

public class NCatalanNumber {
	public static void main(String args[]) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int dp[] = new int[n+1];
		
		dp[0] = 1;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<i;j++) {
				dp[i]+=dp[j]*dp[(i-1)-j];
			}			
		}
		
//		for(int i=0;i<=n;i++) {
//			System.out.print(dp[i]+":");
//		}
		
		System.out.println(dp[n]);
		
		scn.close();
		
	}
}
