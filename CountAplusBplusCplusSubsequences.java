package dynamicProgCodes;

import java.util.Scanner;

public class CountAplusBplusCplusSubsequences {
public static void main(String args[]) {
	Scanner scn = new Scanner(System.in);
	String str = scn.nextLine();
	int dp[][] = new int[3][str.length()];
	
	if(str.charAt(0) == 'a') {
		dp[0][0] = 1;
	}
	
	for(int j=1;j<str.length();j++) {
		if(str.charAt(j) == 'a') {
			dp[0][j] = 1 + (2*dp[0][j-1]);
		}
		else {
			dp[0][j] = dp[0][j-1];
		}
		
		if(str.charAt(j) == 'b') {
			dp[1][j] = dp[0][j-1] +(2*dp[1][j-1]);
		}
		else {
			dp[1][j] = dp[1][j-1];
		}
		
		
		if(str.charAt(j) == 'c') {
			dp[2][j] = dp[1][j-1]+(2*dp[2][j-1]);
		}
		else {
			dp[2][j] = dp[2][j-1];
		}
	}
	
	System.out.println(dp[2][str.length()-1]);
	scn.close();	
}
}
