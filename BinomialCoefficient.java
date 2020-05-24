package dynamicProgCodes;
import java.util.Scanner;

public class BinomialCoefficient {
	private static int dp[][];
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r = scn.nextInt();
		
		dp = new int[n+1][r+1];
		
//  ########################################### Tabulation #########################################
		int C[][] = new int[n+1][r+1];
		
		C[n][0] = C[n][r] =1;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=r;j++) {
				if(j>i) {
					break;
				}
				if(j==0 || j==i) {
					C[i][j] = 1;
					continue;
				}
				C[i][j] = C[i-1][j-1]+C[i-1][j];
			}
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=r;j++) {
				System.out.print(C[i][j]+":");
			}
			System.out.println();
		}
		
		System.out.println(C[n][r]);
		
//	################################### Memoization ##########################################
		
		int value = binomialCoeff(n,r);
		System.out.println(value);
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=r;j++) {
				System.out.print(dp[i][j]+":");
			}
			System.out.println();
		}
		
		
		scn.close();
	}
	
	public static int binomialCoeff(int n,int r) {
		if(r==0 && r==n) {
			return 1;
		}
		if(n<=0 || r<0) {
			return 0;
		}		
		if(dp[n][r]!=0) {
			return dp[n][r];
		}
		dp[n][r]= binomialCoeff(n-1,r-1)+binomialCoeff(n-1,r);		
		return dp[n][r];
	}

}
