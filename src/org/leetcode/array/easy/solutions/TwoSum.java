/**
 * 
 */
package org.leetcode.array.easy.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class TwoSum {
	public int[] twoSum_v1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (diff == nums[j]) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public int[] twoSum_v2(int[] nums, int target) {

		List<Integer> complements = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int complement = target - num;
			if (complements.contains(num)) {
				return new int[] { complements.indexOf(num), i };
			} else {
				complements.add(complement);
			}
		}

		return new int[] {};
	}

	public int[] twoSum_v3(int[] nums, int target) {
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

	public int[] twoSum_v4(int[] nums, int target) {
		Map<Integer, Integer> complements = new HashMap<>();
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (complements.containsKey(nums[i])) {
				result[0] = complements.get(nums[i]);
				result[1] = i;
				break;
			} else {
				complements.put(target - nums[i], i);
			}
		}

		return result;
	}
}
