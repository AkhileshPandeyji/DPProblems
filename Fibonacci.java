package dynamicProgCodes;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String args[]) {
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		for(int i=0;i<=n;i++) {
			System.out.print(dp[i]+":");
		}
		
		System.out.println();
		
		int dps[] = new int[n+1];
		int last = memFibonacci(n,dps);
		
		for(int i=0;i<=n;i++) {
			System.out.print(dps[i]+":");
		}
		
	}
	
	public static int memFibonacci(int n,int[] dps) {
				
		if(n==0||n==1) {
			dps[0]=0;
			dps[1]=1;
			return n;
		}
		
		if(dps[n]!=0) {
			return dps[n];
		}
		
		dps[n]=memFibonacci(n-1,dps)+memFibonacci(n-2,dps);
		
		return dps[n];		
		
	}
	
}
