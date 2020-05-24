package dynamicProgCodes;

import java.util.Scanner;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int n = str.length();
        boolean dp[][] = new boolean[n][n];
        int max = 0;
        
        for(int diag=0;diag<n;diag++) {
        	for(int i=0,j=diag;j<n;i++,j++) {
        		if(diag==0) {
        			dp[i][j] =true;
        		}
        		else if(diag==1) {
        			if(str.charAt(i) == str.charAt(j)) {
        				dp[i][j] =  true;
        			}
        			else {
        				dp[i][j] = false;
        			}
        		}        		
        		else {
        			if(str.charAt(i) == str.charAt(j)) {
        				dp[i][j] = dp[i+1][j-1] && true;
        			}
        			else {
        				dp[i][j] = false;
        			}
        		}
        		if(dp[i][j]) {
        			max = diag+1;
        		}
        	}
        }
        
//        for(int i=0;i<n;i++) {
//        	for(int j=0;j<n;j++) {
//        		System.out.print(dp[i][j]+" ");
//        	}
//        	System.out.println();
//        }
        
        System.out.println(max);

	}

}
