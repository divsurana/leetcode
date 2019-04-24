/**
 * 
 */
package org.leetcode.array.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _16_1 {
	public int threeSumClosest(int[] nums, int target) {
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
}
