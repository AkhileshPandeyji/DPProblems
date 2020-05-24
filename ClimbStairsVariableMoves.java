package dynamicProgCodes;

import java.util.Scanner;

public class ClimbStairsVariableMoves {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int jumps[] = new int[n];

		for (int i = 0; i < n; i++) {
			jumps[i] = scn.nextInt();
		}

		int dp[] = new int[n];

		dp[n - 1] = 1;

		for (int i = n - 2; i >= 0; i--) {
			int jump = jumps[i];
			for (int j = 1; j <= jump; j++) {
				if (i + j < n) {
					dp[i] += dp[i + j];
				}

			}
		}

		// for(int i=0;i<n;i++){
		// System.out.print(dp[i]+":");
		// }

		// System.out.println();

		System.out.println(dp[0]);

	}

}
