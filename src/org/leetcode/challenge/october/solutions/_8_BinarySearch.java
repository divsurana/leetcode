/**
 * 
 */
package org.leetcode.challenge.october.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _8_BinarySearch {
	public int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		int result = -1;

		while (low <= high) {
			int idx = (low + high) / 2;
			if (nums[idx] < target) {
				low = idx + 1;
			} else if (nums[idx] > target) {
				high = idx - 1;
			} else {
				result = idx;
				break;
			}
		}

		return result;
	}
}
