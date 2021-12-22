/**
 * 
 */
package org.eoplij.searching;

/**
 * @author divyeshsurana
 *
 */
public class SeachACyclicallySortedArray_12_3 {
	public int findMin_v1(int[] nums) {
		int l = 0, h = nums.length - 1;

		while (l < h) {
			if (nums[l] < nums[h]) {
				break;
			}
			int m = l + (h - l) / 2;
			if (nums[m] >= nums[l]) {
				l = m + 1;
			} else {
				h = m;
			}
		}

		return nums[l];
	}

	public int findMin_v2(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (nums[m] > nums[r]) {
				l = m + 1;
			} else if (nums[m] < nums[l]) {
				r = m;
			} else {
				break;
			}
		}
		return nums[l];
	}
}
