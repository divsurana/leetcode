/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

import java.util.Arrays;

/**
 * @author divyeshsurana
 *
 */
public class MaxTaxiEarnings {
	// Came up with solution by using the end point. More intuitive and faster
	// than by using starting point.
	public long maxTaxiEarnings_v1(int n, int[][] rides) {
		Arrays.sort(rides, (a, b) -> Integer.compare(a[1], b[1]));
		long[] dp = new long[n + 1];
		int k = 0;

		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i - 1];
			while (k < rides.length && i == rides[k][1]) {
				int[] ride = rides[k++];
				dp[i] = Math.max(dp[i], dp[ride[0]] + ride[1] - ride[0] + ride[2]);
			}
		}

		return dp[n];
	}

	// Solution by using the start point.
	public long maxTaxiEarnings_v2(int n, int[][] rides) {
		Arrays.sort(rides, (a, b) -> a[0] - b[0]);
		long[] dp = new long[n + 1];
		int j = 0;
		for (int i = 1; i <= n; ++i) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			while (j < rides.length && rides[j][0] == i) {
				dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[i] + rides[j][1] - rides[j][0] + rides[j][2]);
				++j;
			}
		}
		return dp[n];
	}
}
