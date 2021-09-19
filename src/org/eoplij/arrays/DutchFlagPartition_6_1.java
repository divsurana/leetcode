/**
 * 
 */
package org.eoplij.arrays;

import org.leetcode.common.Utils;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 75. Sort Colors -
// https://leetcode.com/problems/sort-colors
public class DutchFlagPartition_6_1 {
	public void sortColors_v1(int[] nums) {
		int pivot = 1;
		int left = 0, mid = 0, right = nums.length - 1;

		while (mid <= right) {
			if (nums[mid] < pivot) {
				Utils.swap(nums, left, mid);
				left++;
				mid++;
			} else if (nums[mid] == pivot) {
				mid++;
			} else {
				Utils.swap(nums, right, mid);
				right--;
			}
		}
	}

	public void sortColors_v2(int[] nums) {
		int pivot = 1;
		int left = 0, mid = 0, right = nums.length;

		while (mid < right) {
			if (nums[mid] < pivot) {
				Utils.swap(nums, left++, mid++);
			} else if (nums[mid] == pivot) {
				mid++;
			} else {
				Utils.swap(nums, --right, mid);
			}
		}
	}

	// Less optimal version of the one above that uses 2 iterations
	public void partition_v1(int[] arr, int pivot) {
		int left = 0, right = arr.length - 1;
		int pivotVal = arr[pivot];
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] < pivotVal) {
				Utils.swap(arr, left++, i);
			}
		}

		for (int i = arr.length - 1; i >= left && arr[i] >= pivotVal; i--) {
			if (arr[i] > pivotVal) {
				Utils.swap(arr, right--, i);
			}
		}
	}

	// Variant
	public void falseFirst(boolean[] arr) {
		int nextFalse = 0, nextTrue = arr.length - 1;

		while (nextFalse < nextTrue) {
			if (arr[nextFalse]) {
				Utils.swap(arr, nextFalse, nextTrue--);
			} else {
				nextFalse++;
			}
		}
	}

	// Variant
	public void falseFirstPreserveOrder(boolean[] arr) {
		int lastFalse = arr.length - 1, lastTrue = arr.length - 1;

		while (lastFalse >= 0 && lastTrue >= 0) {
			if (arr[lastFalse]) {
				lastFalse--;
			} else if (!arr[lastTrue] || lastTrue > lastFalse) {
				lastTrue--;
			} else {
				Utils.swap(arr, lastFalse, lastTrue);
			}
		}
	}

}
