/**
 * 
 */
package org.eopiij.arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 123. Best Time to Buy and Sell Stock III -
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BuyAndSellAStockTwice_6_7 {
	public int maxProfit_v1(int[] prices) {
		int minPrice = Integer.MAX_VALUE, maxPrice = Integer.MIN_VALUE, maxProfit = 0;
		int[] maxProfits = new int[prices.length];

		// Forward phase. For each day, we record maximum profit if we
		// sell on or before that day.
		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			maxProfits[i] = maxProfit;
		}

		// Backward phase. For each day, find the maximum profit if we make
		// the second buy on that day.
		for (int i = prices.length - 1; i > 0; i--) {
			maxPrice = Math.max(maxPrice, prices[i]);
			maxProfit = Math.max(maxProfit, maxPrice - prices[i] + maxProfits[i - 1]);
		}

		return maxProfit;
	}
}
