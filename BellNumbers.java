package dynamicProgCodes;
import java.util.Scanner;

public class BellNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = n;
		
		int dp[][] = new int[n+1][k+1];
		int bell[] = new int[n+1];
		
		dp[1][1] = 1;
		
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=n;j++) {
				dp[i][j] = j*dp[i-1][j]+dp[i-1][j-1];
			}
		}
		
		int sum =0;
		
		for(int i=0;i<=n;i++) {
			sum=0;
			for(int j=0;j<=n;j++) {
//				System.out.print(dp[i][j]+":");
				sum+=dp[i][j];
			}
			bell[i] = sum;
//			System.out.println();
		}
		
		for(int i=0;i<=n;i++) {
			System.out.print(bell[i]+":");
		}
		
		scn.close();

	}

}
