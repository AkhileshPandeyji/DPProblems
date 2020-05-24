package dynamicProgCodes;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		
		int dp[][] = new int[str.length()][str.length()];
		
		for(int diag=0;diag<str.length();diag++) {
			for(int i=0,j=diag;j<str.length();i++,j++) {
				if(diag == 0) {
					dp[i][j] = 1;
				}
				else {
					if(str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2+dp[i+1][j-1];
					}
					else {
						dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
					}
				}
			}
		}
		
		System.out.println(dp[0][str.length()-1]);
		scn.close();
	}

}
