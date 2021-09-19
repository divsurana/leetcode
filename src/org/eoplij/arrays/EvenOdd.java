/**
 * 
 */
package org.eoplij.arrays;

import org.leetcode.common.Utils;

/**
 * @author divyeshsurana
 */
// Leetcode Problem 905. Sort Array By Parity -
// https://leetcode.com/problems/sort-array-by-parity
public class EvenOdd {

	public int[] sortArrayByParity_v1(int[] nums) {
		for (int evenIndex = 0, oddIndex = nums.length - 1; evenIndex < nums.length
				&& evenIndex < oddIndex; evenIndex++) {
			while (nums[evenIndex] % 2 != 0) {
				Utils.swap(nums, evenIndex, oddIndex);
				oddIndex--;
			}
		}
		return nums;
	}

	public int[] sortArrayByParity_v2(int[] nums) {
		int nextEven = 0, nextOdd = nums.length - 1;
		while (nextEven < nextOdd) {
			if (nums[nextEven] % 2 == 0) {
				nextEven++;
			} else {
				Utils.swap(nums, nextEven, nextOdd);
				nextOdd--;
			}
		}

		return nums;
	}

}
