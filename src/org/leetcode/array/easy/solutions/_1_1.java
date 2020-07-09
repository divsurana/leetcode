/**
 * 
 */
package org.leetcode.array.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class _1_1 {
	public int[] twoSum(int[] nums, int target) {
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
}
