/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;

/**
 * @author divyesh_surana
 *
 */
public class _16_2 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = 0;
		int difference = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			int num = nums[i];

			while (start < end) {
				int one = nums[start];
				int two = nums[end];
				int sum = num + one + two;
				difference = Math.min(Math.abs(target - sum), difference);

				if (difference == Math.abs(target - sum)) {
					closest = sum;
					if (difference == 0) {
						return closest;
					}
				}
				if (sum > target) {
					end--;
				} else if (sum < target) {
					start++;
				}
			}
		}

		return closest;
	}
}
