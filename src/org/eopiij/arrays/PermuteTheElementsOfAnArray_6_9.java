/**
 * 
 */
package org.eopiij.arrays;

import org.leetcode.common.Utils;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 1920. Build Array from Permutation -
// https://leetcode.com/problems/build-array-from-permutation/
public class PermuteTheElementsOfAnArray_6_9 {
	// Based on the assumption that you can make changes to perm array
	public int[] returnPermutation_v1(int[] arr, int[] perm) {
		for (int i = 0; i < arr.length; i++) {
			int replace = arr[i];
			// Check if the element at index i has not been moved by checking if
			// perm[i] is nonnegative.
			while (perm[i] >= 0) {
				// Swap values between i and perm[i]
				int temp = arr[perm[i]];
				arr[perm[i]] = replace;
				replace = temp;

				// Change i to now be perm[i] and perm[i] to be -1
				temp = perm[i];
				perm[i] = -1;
				i = temp;
			}
		}

		return arr;
	}

	// Based on the assumption that you can make changes to perm array
	public int[] returnPermutation_v2(int[] arr, int[] perm) {
		for (int i = 0; i < arr.length; i++) {
			// Check if the element at index i has not been moved by checking if
			// perm[i] is nonnegative.
			int next = i;
			while (perm[next] >= 0) {
				Utils.swap(arr, i, perm[next]);
				int temp = perm[next];
				// Subtracts perm.length from an entry in perm to make it
				// negative, which indicates the corresponding move has been
				// performed.
				perm[next] -= perm.length;
				next = temp;
			}
		}

		return arr;
	}

	// Based on the assumption that you cannot make changes to perm array. Based
	// on the solution of the leetcode problem below.
	public int[] returnPermutation_v3(int[] arr, int[] perm) {
		int n = arr.length;

		// This is done to keep both old and new value together.
		// going by the example of [5,0,1,2,3,4]
		// after this nums[0] will be 5 + 6*(4%6) = 5 + 24 = 29;
		// now for next index calculation we might need the original value of
		// nums[0] which can be obtained by nums[0]%6 = 29%6 = 5;
		// if we want to get just the new value of nums[0], we can get it by
		// nums[0]/6 = 29/6 = 4
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] + n * (arr[perm[i]] % n);
		}

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / n;
		}

		return arr;
	}

	// Similar problem from leetcode with T = O(n) and S = O(n)
	public int[] buildArray_v1(int[] nums) {
		int[] arr = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			arr[i] = nums[nums[i]];
		}

		return arr;
	}

	// Similar problem from leetcode with T = O(n) and S = O(1)
	public int[] buildArray_v2(int[] nums) {
		int n = nums.length;

		// This is done to keep both old and new value together.
		// going by the example of [5,0,1,2,3,4]
		// after this nums[0] will be 5 + 6*(4%6) = 5 + 24 = 29;
		// now for next index calculation we might need the original value of
		// nums[0] which can be obtained by nums[0]%6 = 29%6 = 5;
		// if we want to get just the new value of nums[0], we can get it by
		// nums[0]/6 = 29/6 = 4
		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] + n * (nums[nums[i]] % n);
		}

		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] / n;
		}

		return nums;
	}

	// Variant
	// Used the previous solution to get inverse permutation of an array.
	// Example: [5,0,1,2,3,4] -> [1,2,3,4,5,0] where the index becomes the value
	// of the value of that index as the index of the subsequent array
	// 0 becomes the value of index 5 and conversely, 0 becomes the value of
	// index 1 making both arrays inverse permutations of each other.
	public int[] inversePermutation(int[] nums) {
		int n = nums.length;

		// This is done to keep both old and new value together. going by the
		// example of [5,0,1,2,3,4] after this for index 0 nums[nums[0]] i.e.
		// nums[5] will be 4 + 6*0 = 4; now for next index calculation we might
		// need the original value of nums[5] which can be obtained by nums[5]%6
		// = 4%6 = 4; if we want to get just the new value of nums[5], we can
		// get it by nums[5]/6 = 4/6 = 0
		for (int i = 0; i < n; i++) {
			nums[nums[i] % n] = nums[nums[i] % n] % n + n * i;
		}

		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] / n;
		}

		return nums;
	}

}