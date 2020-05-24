package dynamicProgCodes;
import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		
		String x = scn.nextLine();
		String y = scn.nextLine();
		
		int m = x.length();
		int n = y.length();
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
				else if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];		
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println(dp[m][n]);
		
		
	}
}
