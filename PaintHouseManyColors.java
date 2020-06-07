package dynamicProgCodes;

import java.util.Scanner;

public class PaintHouseManyColors {
public static void main(String args[]) {
	Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
	int k = scn.nextInt();
	int[][] prices = new int[n][k];
	
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
	
	int min = Integer.MAX_VALUE;
	int smin = 0;
	
	for(int j=0;j<k;j++) {
		dp[0][j] = prices[0][j];
		if(dp[0][j]<min) {
			smin = min;
			min = dp[0][j];
		}
		else {
			if(dp[0][j]<smin) {
				smin = dp[0][j];
			}
		}
	}
	
	for(int i=1;i<n;i++) {
		int nmin = Integer.MAX_VALUE;
		int nsmin = nmin;
		for(int j=0;j<k;j++) {
			if(dp[i-1][j] == min) {
				dp[i][j] = prices[i][j]+smin;
			}
			else {
				dp[i][j] = prices[i][j]+min;
			}
			if(dp[i][j]<nmin) {
				nsmin = nmin;
				nmin = dp[i][j];
			}
			else {
				if(dp[i][j] < nsmin) {
					nsmin = dp[i][j];
				}
			}
		}
		min = nmin;
		smin = nsmin;
	}
	
	int minVal = Integer.MAX_VALUE;
	for(int j=0;j<k;j++) {
		if(dp[n-1][j]<minVal) {
			minVal = dp[n-1][j];
		}
	}
	
	for(int i=0;i<n;i++) {
		for(int j=0;j<k;j++) {
			System.out.print(dp[i][j]+" ");
		}
		System.out.println();
	}
	return minVal;
}
}
