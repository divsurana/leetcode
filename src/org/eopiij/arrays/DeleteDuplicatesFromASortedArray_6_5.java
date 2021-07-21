/**
 * 
 */
package org.eopiij.arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 26. Remove Duplicates from Sorted Array -
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class DeleteDuplicatesFromASortedArray_6_5 {
	public int removeDuplicates_v1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int slowIndex = 0, fastIndex = 1;

		while (fastIndex < nums.length) {
			if (nums[slowIndex] == nums[fastIndex]) {
				fastIndex++;
			} else {
				nums[++slowIndex] = nums[fastIndex++];
			}
		}

		return slowIndex + 1;
	}

	// Older version on leetcode
	public int removeDuplicates_v2(int[] nums) {
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

	// Variant - Remove all occurrences of input key and maintain order
	public int removeElement(int[] nums, int val) {
		int slowIndex = 0, fastIndex = 0;

		// Can be done using for loop too
		while (fastIndex < nums.length) {
			if (nums[fastIndex] == val) {
				fastIndex++;
			} else {
				nums[slowIndex++] = nums[fastIndex++];
			}
		}

		return slowIndex;
	}
}
