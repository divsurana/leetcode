/**
 * 
 */
package org.leetcode.array.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int prev = nums[0];
		int index = 1;

		for (int i = 1; i < nums.length && index < nums.length; i++) {
			if (prev != nums[i]) {
				nums[index] = nums[i];
				prev = nums[i];
				index++;
			}
		}

		return index;
	}
}
