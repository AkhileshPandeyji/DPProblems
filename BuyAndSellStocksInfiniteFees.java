package dynamicProgCodes;

import java.util.Scanner;

public class BuyAndSellStocksInfiniteFees {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for(int i=0;i<n;i++) {
			prices[i] = scn.nextInt();
		}
		int fees = scn.nextInt();
		System.out.println(maxProfit(prices,fees));
	}
	
	public static int maxProfit(int[] prices,int fees) {
		int dp[][]= new int[2][prices.length];
		dp[0][0] = 0 - prices[0];
		dp[1][0] = 0;
		for(int i=1;i<prices.length;i++) {
			int buyP = dp[1][i-1] - prices[i];
			if(buyP>dp[0][i-1]) {
				dp[0][i] = buyP;
			}
			else {
				dp[0][i] = dp[0][i-1];
			}
			int sellP = dp[0][i] + prices[i] - fees;
			if(sellP>dp[1][i-1]) {
				dp[1][i] = sellP;
			}
			else {
				dp[1][i] = dp[1][i-1];
			}
		}
		return dp[1][prices.length-1];
	}
}
