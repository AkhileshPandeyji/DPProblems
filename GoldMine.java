package dynamicProgCodes;

import java.util.Scanner;

public class GoldMine {
	public static int dp[][];

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int mine[][] = new int[n][m];
		int tabdp[][] = new int[n][m + 1];

		dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mine[i][j] = scn.nextInt();
			}
		}

		int maxGold = Integer.MIN_VALUE;

		for (int i = 0; i < mine.length; i++) {
			int temp = findMaxGold(mine, i, 0);
			if (temp > maxGold) {
				maxGold = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(dp[i][j] + ":");
			}
			System.out.println();
		}
		System.out.println(maxGold);

		// ############################################ Tabulation
		// ##########################

		for (int j = mine[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < mine.length; i++) {
				int x = 0, y = 0, z = 0;
				if (i - 1 >= 0 && j + 1 < mine[0].length) {
					x = tabdp[i - 1][j + 1];
				}
				if (j + 1 < mine[0].length) {
					y = tabdp[i][j + 1];
				}
				if (i + 1 < mine.length && j + 1 < mine[0].length) {
					z = tabdp[i + 1][j + 1];
				}
				tabdp[i][j] = mine[i][j] + Math.max(Math.max(x, y), z);
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < tabdp.length; i++) {
			for (int j = 0; j < tabdp.length; j++) {
				if (j == 0) {
					if (dp[i][j] > max) {
						max = dp[i][j];
					}
				}
				System.out.print(tabdp[i][j] + ":");
			}
			System.out.println();
		}
		System.out.println(max);

	}

	public static int findMaxGold(int mine[][], int r, int c) {

		if (r >= mine.length || c >= mine[0].length || r < 0) {
			return Integer.MIN_VALUE;
		}

		int x = 0, y = 0, z = 0;

		if (dp[r][c] != 0) {
			return dp[r][c];
		}

		if (c + 1 < mine[0].length) {
			x = findMaxGold(mine, r, c + 1);
		}
		if (c + 1 < mine[0].length && r + 1 < mine.length) {
			y = findMaxGold(mine, r + 1, c + 1);
		}
		if (r - 1 >= 0 && c + 1 < mine[0].length) {
			z = findMaxGold(mine, r - 1, c + 1);
		}

		dp[r][c] = mine[r][c] + Math.max(Math.max(x, y), z);

		return dp[r][c];
	}
}
