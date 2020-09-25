/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

import java.util.Arrays;

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

	public int coinChange_v3(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		for (int i = 1; i < amount + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (coin <= i && dp[i - coin] != -1) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
			dp[i] = dp[i] == Integer.MAX_VALUE ? -1 : dp[i];
		}

		return dp[amount];
	}

	public int coinChange_v4(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.sort(coins);

		for (int i = 1; i < amount + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i - coin < 0) {
					break;
				} else if (dp[i - coin] != -1) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
			dp[i] = dp[i] == Integer.MAX_VALUE ? -1 : dp[i];
		}

		return dp[amount];
	}
}
