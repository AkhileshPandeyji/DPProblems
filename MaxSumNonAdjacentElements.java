package dynamicProgCodes;

import java.util.Scanner;

public class MaxSumNonAdjacentElements {
public static void main(String args[]) {
	Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
	int[] inputs = new int[n];
	for(int i=0;i<n;i++) {
		inputs[i] = scn.nextInt();
	}
	System.out.println(maxSum(inputs));
	scn.close();
	}
public static int maxSum(int[] inputs) {
	int dp[][] = new int[2][inputs.length];
	dp[0][0] = inputs[0];
	dp[1][0] = 0;
	
	for(int i=1;i<inputs.length;i++) {
		dp[0][i] = inputs[i]+dp[1][i-1];
		dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
	}
	
	return Math.max(dp[0][inputs.length-1], dp[1][inputs.length-1]);	
}
}
