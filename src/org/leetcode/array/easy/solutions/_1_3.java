/**
 * 
 */
package org.leetcode.array.easy.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class _1_3 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> complements = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (complements.containsKey(num)) {
				return new int[] { complements.get(num), i };
			}
			complements.put(target - num, i);

		}

		return new int[] {};
	}
}
