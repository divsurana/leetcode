/**
 * 
 */
package org.leetcode.dynamicprogramming.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}

		return maxProfit;
	}
}
