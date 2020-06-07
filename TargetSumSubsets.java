package dynamicProgCodes;

import java.util.Scanner;

public class TargetSumSubsets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = scn.nextInt();
		}
		int tar = scn.nextInt();
		System.out.println(targetSum(arr,tar));
		scn.close();
	}
	public static boolean targetSum(int[] arr,int tar) {
		boolean[][] dp = new boolean[arr.length+1][tar+1];
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j-arr[i-1]>=0) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[arr.length][tar];
	}

}
