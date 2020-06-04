package dynamicProgCodes;

import java.util.Scanner;

public class BuyAndSellStocksTwo {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		
		for(int i=0;i<n;i++) {
			prices[i] = scn.nextInt();
		}
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		
		int[] dp = new int[prices.length];
		dp[0] = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<prices.length;i++) {
			if(prices[i]<min) {
				min = prices[i];
			}
			int maxP = prices[i] - min;
			if(dp[i-1]>maxP) {
				dp[i] = dp[i-1];
			}
			else {
				dp[i] = maxP;
			}
		}
		int max = prices[prices.length-1];
		
		for(int i=prices.length-2;i>=0;i--) {
			if(prices[i]>max) {
				max = prices[i];
			}
			int maxP = max - prices[i];
			int sum = maxP + dp[i];
			if(sum>dp[i+1]) {
				dp[i] = sum;
			}
			else {
				dp[i] = dp[i+1];
			}
		}
		
		max = Integer.MIN_VALUE;
		for(int i=0;i<dp.length;i++) {
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		return max;		
	}

}
