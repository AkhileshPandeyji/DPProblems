package dynamicProgCodes;

import java.util.Scanner;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];

		for (int i = 0; i < n; i++) {
			val[i] = scn.nextInt();
		}
		for (int i = 0; i < n; i++) {
			wt[i] = scn.nextInt();
		}
		int cap = scn.nextInt();
		System.out.println(maxProfit(val, wt, cap));
		scn.close();
	}

	public static int maxProfit(int[] val, int[] wt, int cap) {
		int dp[] = new int[cap + 1];
		for (int j = 1; j < cap + 1; j++) {
			for (int i = 0; i < val.length; i++) {
				if (j - wt[i] >= 0) {
					dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i] + " ");
		}
		System.out.println();
		return dp[cap];
	}

}
