/**
 * 
 */
package org.leetcode.array.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class NextPermutation {
	public void nextPermutation_v1(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int i = nums.length - 2; // initialize at the second last index
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--; // Find 1st id i that breaks descending order
		}
		if (i >= 0) { // If not entirely descending
			int j = nums.length - 1; // Start from the end
			while (nums[j] <= nums[i]) {
				j--; // Find rightmost first larger id j
			}
			swap(nums, i, j); // Switch i and j
		}
		reverse(nums, i + 1, nums.length - 1); // Reverse the descending
												// sequence
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i++, j--);
		}
	}

	public void nextPermutation_v2(int[] nums) {
		int pivot = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				pivot = i - 1;
				break;
			}
		}
		if (pivot != -1) {
			for (int j = nums.length - 1; j > pivot; j--) {
				if (nums[j] > nums[pivot]) {
					swap(nums, pivot, j);
					break;
				}
			}
		}
		reverse(nums, pivot + 1);
	}

	private void reverse(int[] matrix, int start) {
		int end = matrix.length - 1;
		while (start < end) {
			swap(matrix, start, end);
			start++;
			end--;
		}
	}
}
