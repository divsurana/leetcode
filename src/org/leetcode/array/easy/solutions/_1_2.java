/**
 * 
 */
package org.leetcode.array.easy.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class _1_2 {
	public int[] twoSum(int[] nums, int target) {

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
}
