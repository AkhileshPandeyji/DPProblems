package dynamicProgCodes;

import java.util.Scanner;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] val = new int[n];
		int[] wt = new int[n];
		
		for(int i=0;i<n;i++) {
			val[i] = scn.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			wt[i] = scn.nextInt();
		}
		int cap = scn.nextInt();
		System.out.println(maxVal(val,wt,cap));
		scn.close();
	}
	
	public static int maxVal(int[] val,int[] wt,int cap) {
		int n = val.length;
		int dp[][] = new int[n+1][cap+1];
		for(int i=0;i<n+1;i++) {
			dp[i][0] = 0;
		}
		for(int j=0;j<cap+1;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<cap+1;j++) {
				int zero = dp[i-1][j];
				if(j>=wt[i-1]) {					
					int one = val[i-1]+dp[i-1][j-wt[i-1]];
					dp[i][j] = Math.max(zero, one);
				}
				else {
					dp[i][j] = zero;
				}				
			}
		}
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<cap+1;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[n][cap];
	}
}
