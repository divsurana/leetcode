/**
 * 
 */
package org.leetcode.dynamicprogramming.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int currMax = 0;

		for (int num : nums) {
			currMax += num;
			max = Math.max(max, currMax);
			currMax = currMax < 0 ? 0 : currMax;
		}

		return max;
	}
}
