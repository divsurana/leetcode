/**
 * 
 */
package org.leetcode.array.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class RemoveElement {
	public int removeElement_v1(int[] nums, int val) {
		int last = nums.length - 1;
		// move last index to a point where the val is not equal to the val to
		// be rejected
		while (last >= 0 && nums[last] == val) {
			last--;
		}

		for (int first = 0; first < last; first++) {
			if (nums[first] == val) {
				// swap if found reject val
				swap(nums, first, last);
				// decrement last index until found val not to be rejected
				while (nums[last] == val) {
					last--;
				}
			}
		}

		return last + 1;
	}

	public void swap(int[] nums, int i1, int i2) {
		int swap = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = swap;
	}

	public int removeElement_v2(int[] A, int elem) {
		int m = 0;
		for (int i = 0; i < A.length; i++) {

			if (A[i] != elem) {
				A[m] = A[i];
				m++;
			}
		}

		return m;
	}
}
