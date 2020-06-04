package dynamicProgCodes;

import java.util.Scanner;

public class BuyAndSellStocksOne {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int prices[] = new int[n];
		
		for(int i=0;i<n;i++) {
			prices[i] = scn.nextInt();
		}
		
		System.out.println(maxProfit(prices));		
	}
	
	public static int maxProfit(int[] prices) {
		int min = prices[0];
		int maxProfit = 0;
		
		for(int i=0;i<prices.length;i++) {
			if(prices[i]<min) {
				min = prices[i];
			}
			if(prices[i]-min>maxProfit) {
				maxProfit = prices[i] - min;
			}
		}
		return maxProfit;
	}
}
