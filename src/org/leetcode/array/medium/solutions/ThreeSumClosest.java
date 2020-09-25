/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;

/**
 * @author divyesh_surana
 *
 */
public class ThreeSumClosest {
	public int threeSumClosest_v1(int[] nums, int target) {
		int closest = 0;
		int difference = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			int one = nums[i];

			for (int j = i + 1; j < nums.length - 1; j++) {
				int two = nums[j];

				for (int k = j + 1; k < nums.length; k++) {
					int three = nums[k];

					int sum = one + two + three;
					difference = Math.min(Math.abs(target - sum), difference);
					if (difference == Math.abs(target - sum)) {
						closest = sum;
						if (difference == 0) {
							return closest;
						}
					}
				}
			}

		}

		return closest;
	}

	public int threeSumClosest_v2(int[] nums, int target) {
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

	public int threeSumClosest_v3(int[] nums, int target) {
		int result = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (Math.abs(target - sum) < Math.abs(target - result)) {
					result = sum;
				}

				if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}

		return result;
	}
}
