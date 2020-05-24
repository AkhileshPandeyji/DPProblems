package dynamicProgCodes;
import java.util.Scanner;

public class StairCase123 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int dp[]= new int[n+1];
		
		dp[0] = 1;
		
		for(int i=1;i<=n;i++)
		{
			if(i-1 >= 0) {
				dp[i]+=dp[i-1];
			}
			if(i-2 >= 0) {
				dp[i]+=dp[i-2];
			}			
			if(i-3 >= 0) {
				dp[i]+=dp[i-3];
			}
		}
		
		for(int i=0;i<=n;i++) {
			System.out.print(dp[i]+":");
		}

	}

}
