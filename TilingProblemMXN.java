package dynamicProgCodes;

import java.util.Scanner;

public class TilingProblemMXN {
public static void main(String args[]) {
	Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
	int m = scn.nextInt();
	System.out.println(solve(n,m));
	scn.close();
}
public static int solve(int n,int m)
{
int dp[] = new int[n+1];
dp[1] = 1;

for(int i=2;i<n+1;i++) {
	if(i<m) {
		dp[i] = dp[i-1];
	}
	else if(i==m) {
		dp[i] = 2;
	}
	else {
		dp[i] = dp[i-1]+dp[i-m];
	}
}

return dp[n];
}
}
