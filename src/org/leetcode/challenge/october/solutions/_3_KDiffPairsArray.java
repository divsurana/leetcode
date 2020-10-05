/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author divyesh_surana
 *
 */
public class _3_KDiffPairsArray {
	public int findPairs(int[] nums, int k) {
		int result = 0;
		Arrays.sort(nums);
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i] - k)) {
				result++;
				while (i < nums.length - 1 && nums[i] == nums[i + 1])
					i++;
			}
			set.add(nums[i]);
		}

		return result;
	}
}
