package dynamicProgCodes;

import java.util.Scanner;

public class BuyAndSellStocksInfinite {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] prices = new int[n];
		for(int i=0;i<n;i++) {
			prices[i] = scn.nextInt();
		}
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
		int totProfit = 0;
		
		for(int i=0;i<prices.length-1;i++) {
			if(prices[i+1]-prices[i]>0) {
				totProfit+=(prices[i+1]-prices[i]);
			}
		}
		
		return totProfit;
	}
}
