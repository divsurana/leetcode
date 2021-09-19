/**
 * 
 */
package org.eoplij.arrays;

import org.leetcode.common.Utils;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 31. Next Permutation -
// https://leetcode.com/problems/next-permutation/
public class ComputeTheNextPermutation_6_10 {
	public void nextPermutation_v1(int[] nums) {
		int pivot;
		// Finding the number that breaks the increasing order
		for (pivot = nums.length - 2; pivot >= 0; pivot--) {
			if (nums[pivot] < nums[pivot + 1]) {
				break;
			}
		}

		// Swap the number with the first number higher than it from the back
		for (int i = nums.length - 1; i > pivot && pivot > -1; i--) {
			if (nums[i] > nums[pivot]) {
				Utils.swap(nums, i, pivot);
				break;
			}
		}

		// Reverse the sequence by swapping all the numbers
		for (int i = pivot + 1; i < (nums.length + pivot + 1) / 2; i++) {
			Utils.swap(nums, i, nums.length + pivot - i);
		}
	}

	public void nextPermutation_v2(int[] nums) {
		int pivot = nums.length - 2;
		// Finding the number that breaks the increasing order
		while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
			pivot--;
		}

		// Swap the number with the first number higher than it from the back
		for (int i = nums.length - 1; i > pivot && pivot > -1; i--) {
			if (nums[i] > nums[pivot]) {
				Utils.swap(nums, i, pivot);
				break;
			}
		}

		// Reverse the sequence by swapping all the numbers
		for (int i = pivot + 1; i < (nums.length + pivot + 1) / 2; i++) {
			Utils.swap(nums, i, nums.length + pivot - i);
		}
	}

	public void nextPermutation_v3(int[] nums) {
		int pivot = nums.length - 2;
		// Finding the number that breaks the increasing order
		while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
			pivot--;
		}

		// Swap the number with the first number higher than it from the back
		for (int i = nums.length - 1; i > pivot && pivot > -1; i--) {
			if (nums[i] > nums[pivot]) {
				swap(nums, i, pivot);
				break;
			}
		}

		// Reverse the sequence by swapping all the numbers
		reverse(nums, pivot + 1, nums.length - 1);
	}

	public void swap(int[] nums, int to, int from) {
		int temp = nums[to];
		nums[to] = nums[from];
		nums[from] = temp;
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start++, end--);
		}
	}
}
