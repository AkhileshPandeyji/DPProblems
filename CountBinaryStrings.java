package dynamicProgCodes;

import java.util.Scanner;

public class CountBinaryStrings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(countBinary(n));
		scn.close();
	}

	public static int countBinary(int n) {
		int dp[][] = new int[2][n + 1];

		dp[0][1] = 1;
		dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[0][i] = dp[1][i - 1];
			dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
		}

		return dp[0][n] + dp[1][n];
	}
}
