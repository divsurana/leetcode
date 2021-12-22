/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit_v1(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int[] s0 = new int[prices.length];
		int[] s1 = new int[prices.length];
		int[] s2 = new int[prices.length];

		s0[0] = 0;
		s1[0] = -prices[0];
		s2[0] = Integer.MIN_VALUE;

		for (int i = 1; i < prices.length; i++) {
			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
			s2[i] = s1[i - 1] + prices[i];
		}

		return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
	}

	public int maxProfit_v2(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		int b0 = -prices[0], b1 = b0;
		int s0 = 0, s1 = 0, s2 = 0;

		for (int i = 1; i < prices.length; i++) {
			b0 = Math.max(b1, s2 - prices[i]);
			s0 = Math.max(s1, b1 + prices[i]);
			b1 = b0;
			s2 = s1;
			s1 = s0;
		}
		return s0;
	}
}
