/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class CoinChange {
	public int coinChange_v1(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (coin <= i && dp[i - coin] > -1) {
					min = Math.min(min, dp[i - coin]);
				}
			}
			dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
		}

		return dp[amount];
	}

	public int coinChange_v2(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {
			dp[i] = -1;
			for (int coin : coins) {
				if (coin <= i && dp[i - coin] != -1) {
					if (dp[i] == -1 || dp[i] > dp[i - coin] + 1) {
						dp[i] = dp[i - coin] + 1;
					}
				}
			}
		}

		return dp[amount];
	}
}
