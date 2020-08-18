/**
 * 
 */
package org.leetcode.twopointers.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i == 0 || nums[i] != nums[i - 1]) {
				int remainder = -nums[i];
				for (int j = i + 1, k = nums.length - 1; j < k;) {
					int sum = nums[j] + nums[k];
					if (sum < remainder) {
						j++;
					} else if (sum > remainder) {
						k--;
					} else {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while (j < k && nums[j] == nums[j + 1]) {
							j++;
						}
						while (j < k && nums[k] == nums[k - 1]) {
							k--;
						}
						j++;
						k--;
					}
				}
			}
		}

		return result;
	}
}
