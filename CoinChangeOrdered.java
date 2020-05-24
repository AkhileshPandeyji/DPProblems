package dynamicProgCodes;

import java.util.Scanner;

public class CoinChangeOrdered {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		int coins[] = new int[m];
		int dp[] = new int[n+1];
		
		dp[0] = 1;
		
		for(int i=0;i<m;i++)
		{
			coins[i] = scn.nextInt();
		}
		
		int rem = 0;
		
		for(int i=1;i<=n;i++) {
			rem = 0;
			for(int j=0;j<coins.length;j++) {
				rem = i - coins[j];
				//System.out.println(rem);
				if(rem>=0) {
					dp[i] += dp[rem];
					
				}				
			}
		}
		
		for(int i=0;i<dp.length;i++) {
			System.out.print(dp[i]+":");
		}
		
		System.out.println();
		System.out.println(dp[n]);
		scn.close();
	}
}
