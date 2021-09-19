/**
 * 
 */
package org.leetcode.binarysearch.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (nums[m] > nums[r]) {
				l = m + 1;
			} else if (nums[m] < nums[l]) {
				r = m; // since m can be the index of the min element as well
			} else {
				break;
			}
		}
		return nums[l];
	}
}
