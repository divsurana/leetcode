/**
 * 
 */
package org.leetcode.array.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class SumOfBeautyInTheArray {
	public int sumOfBeauties(int[] nums) {
		int n = nums.length, sum = 0;
		int[] max = new int[n], min = new int[n];
		max[0] = nums[0];
		min[n - 1] = nums[n - 1];

		for (int i = 1; i < n - 1; i++) {
			max[i] = Math.max(max[i - 1], nums[i]);
		}

		for (int i = n - 2; i > 0; i--) {
			min[i] = Math.min(min[i + 1], nums[i]);
			if (max[i - 1] < nums[i] && nums[i] < min[i + 1]) {
				sum += 2;
			} else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
				sum += 1;
			}
		}

		return sum;
	}
}
