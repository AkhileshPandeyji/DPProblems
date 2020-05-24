package dynamicProgCodes;

public class LongestIncreasingSubsequence {
	public static void main(String args[]) {

		int[] input = { 50, 3, 10, 7, 40, 80 };

		int[] dp = new int[input.length];

		dp[0] = 1;

		int maxVal = Integer.MIN_VALUE;

		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] > maxVal) {
					maxVal = dp[j];
				}
				if (input[i] > input[j]) {
					dp[i] = 1 + maxVal;
				} else {
					dp[i] = 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
