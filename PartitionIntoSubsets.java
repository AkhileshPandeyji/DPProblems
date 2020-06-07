package dynamicProgCodes;

import java.util.Scanner;

public class PartitionIntoSubsets {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int dp[][] = new int[n + 1][k + 1];

		for (int i = 1; i < n + 1; i++) {
			dp[i][1] = 1;
		}

		for (int i = 2; i < n + 1; i++) {
			for (int j = 2; j < k + 1; j++) {
				if (i >= j) {
					dp[i][j] = dp[i - 1][j - 1] + (j * dp[i - 1][j]);
				}
			}
		}
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<k+1;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(dp[n][k]);
		scn.close();
	}
}
