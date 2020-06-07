package dynamicProgCodes;

import java.util.Scanner;

public class PaintHouse3Colors {
public static void main(String args[]) {
	Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
	int k = 3;
	int prices[][] = new int[n][k];
	for(int i=0;i<n;i++) {
		for(int j=0;j<k;j++) {
			prices[i][j] = scn.nextInt();
		}		
	}
	System.out.println(minCost(prices));
	scn.close();
}
public static int minCost(int[][] prices) {
	int n = prices.length;
	int k = prices[0].length;
	int dp[][] = new int[n][k];
	
	dp[0][0] = prices[0][0];
	dp[0][1] = prices[0][1];
	dp[0][2] = prices[0][2];
	
	for(int i=1;i<n;i++) {
		dp[i][0] = prices[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
		dp[i][1] = prices[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
		dp[i][2] = prices[i][2]+Math.min(dp[i-1][0], dp[i-1][1]);
	}
	
	return Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
}
}
