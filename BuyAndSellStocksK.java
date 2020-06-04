package dynamicProgCodes;

import java.util.Scanner;

public class BuyAndSellStocksK {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.println(maxProfit(prices, k));
		scn.close();
	}

	public static int maxProfit(int[] prices, int k) {
		int dp[][] = new int[k + 1][prices.length];
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 1; i < k + 1; i++) {
			for (int j = 1; j < prices.length; j++) {
				maxProfit = Integer.MIN_VALUE;
				for (int x = j - 1; x >= 0; x--) {
					int profit = prices[j] - prices[x] + dp[i - 1][x];
					maxProfit = Math.max(maxProfit, profit);
				}
				maxProfit = Math.max(maxProfit, dp[i][j - 1]);
				dp[i][j] = maxProfit;
			}
		}

		return dp[k][prices.length - 1];
	}
}
