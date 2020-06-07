package dynamicProgCodes;

import java.util.Scanner;

public class ArrangeBuildings {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int dp[][] = new int[2][n + 1];

		dp[0][1] = 1;
		dp[1][1] = 1;

		for (int i = 2; i < n + 1; i++) {
			dp[0][i] = dp[1][i - 1];
			dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
		}

		int A = dp[0][n] + dp[1][n];
		System.out.println(A * A);
		for(int i=0;i<2;i++) {
			for(int j=0;j<n+1;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		scn.close();
	}
}
