package dynamicProgCodes;

import java.util.Scanner;

public class PaintFence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();		
		System.out.println(paintFence(n,k));
		scn.close();
	}
	public static int paintFence(int n,int k) {
		int dp[][] = new int[2][n];
		dp[0][0] = 0;
		dp[1][0] = k;
		for(int i=1;i<n;i++) {
			dp[0][i] = dp[1][i-1];
			dp[1][i] = (dp[0][i-1]+dp[1][i-1])*(k-1);
		}
		return dp[0][n-1]+dp[1][n-1];
	}
}
