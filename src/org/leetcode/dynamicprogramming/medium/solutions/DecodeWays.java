/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.equals("") || s.charAt(0) == '0') {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < s.length() + 1; i++) {
			if (s.charAt(i - 1) != '0') {
				dp[i] = dp[i - 1];
			}

			String encoded = "" + s.charAt(i - 2) + s.charAt(i - 1);
			int num = Integer.valueOf(encoded);

			if (num >= 10 && num <= 26) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[s.length()];
	}
}
