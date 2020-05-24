package dynamicProgCodes;

import java.util.Scanner;

public class CountPalindromicSubsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		
		int n = str.length();
		int dp[][] = new int[n][n];
		
		for(int diag=0;diag<n;diag++) {
			for(int i=0,j=diag;j<n;i++,j++) {
				if(diag==0){
					dp[i][j] = 1;
				}
				else {
					if(str.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i][j-1]+dp[i+1][j]+1;
					}
					else {
						dp[i][j] = dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println(dp[0][n-1]);

	}

}
