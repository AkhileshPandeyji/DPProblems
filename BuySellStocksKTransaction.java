package dynamicProgCodes;

import java.util.Scanner;

public class BuySellStocksKTransaction {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int prices[] = new int[n];
        
        for(int i=0;i<n;i++){
            prices[i]=scn.nextInt();
        }
        
        int k = scn.nextInt();
        
        int dp[][] = new int[k+1][n];
        
        for(int i=1;i<k+1;i++){
            for(int j=1;j<n;j++){
                int maxP = Integer.MIN_VALUE;
                for(int x=0;x<j;x++){
                    maxP = Math.max(maxP,prices[j]-prices[x]+dp[i-1][x]);
                }
                maxP = Math.max(maxP,dp[i][j-1]);
                dp[i][j] = maxP;
            }
        }
        
        System.out.println(dp[k][n-1]);
	}
}

