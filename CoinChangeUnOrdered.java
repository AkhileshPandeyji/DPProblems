package dynamicProgCodes;

import java.util.Scanner;

public class CoinChangeUnOrdered {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int coins[] = new int[m];
		
		for(int i=0;i<coins.length;i++) {
			coins[i] = scn.nextInt();
		}
		
		int dp[] = new int[n+1];
		dp[0] = 1;
		
		for(int i=0;i<coins.length;i++) {
			int coin = coins[i];
			for(int j=coin;j<dp.length;j++) {
				if(dp[j-coin]!=0) {
					dp[j]+=dp[j-coin];
				}
			}
		}
		
		
		for(int i=0;i<dp.length;i++)
		{
			System.out.print(dp[i]+":");
		}
		
		System.out.println();
		System.out.println(dp[n]);
	}
}
