/**
 * 
 */
package org.eoplij.arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 121. Best Time to Buy and Sell Stock -
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class BuyAndSellAStockOnce_6_6 {
	public int maxProfit(int[] prices) {
		int max = 0, prev = Integer.MAX_VALUE;

		for (int price : prices) {
			prev = Math.min(price, prev);
			max = Math.max(price - prev, max);
		}

		return max;
	}

	// Variant - Find the length of the longest contiguous subarray with the
	// same values
	public int longestContiguousSubarray(int[] arr) {
		if (arr.length <= 1) {
			return arr.length;
		}
		int max = 1, count = 1, prev = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == prev) {
				count++;
			} else {
				prev = arr[i];
				count = 1;
			}
			max = Math.max(max, count);
		}

		return max;
	}
}
