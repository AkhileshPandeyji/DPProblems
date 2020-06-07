package dynamicProgCodes;

import java.util.Scanner;

public class MinMazeCostPath {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int cost[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				cost[i][j] = scn.nextInt();
			}
		}
		System.out.println(minCostPath(cost));
		scn.close();
	}
	
	public static int minCostPath(int[][] cost) {
		int dp[][] = new int[cost.length][cost[0].length];
		String path[][] = new String[cost.length][cost[0].length];
		
		dp[cost.length-1][cost[0].length-1] = cost[cost.length-1][cost[0].length-1];
		path[cost.length-1][cost[0].length-1] = ".";
		
		for(int i=cost.length-1;i>=0;i--) {
			for(int j=cost[0].length-1;j>=0;j--) {
				if(i+1<cost.length && j+1<cost[0].length) {
					String move = dp[i+1][j]<dp[i][j+1]?"V":"H";
					dp[i][j] = cost[i][j]+Math.min(dp[i+1][j], dp[i][j+1]);
					if(move.equals("V")) {
						path[i][j] = move+path[i+1][j];
					}
					else {
						path[i][j] = move+path[i][j+1];
					} 
				}
				else {
					if(i+1<cost.length) {
						dp[i][j] = cost[i][j]+dp[i+1][j];
						path[i][j] = "V"+path[i+1][j];
					}
					else if(j+1<cost[0].length) {
						dp[i][j] = cost[i][j]+dp[i][j+1];
						path[i][j] = "H"+path[i][j+1];
					}
				}
			}
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(path[0][0]);
		return dp[0][0];
	}

}
