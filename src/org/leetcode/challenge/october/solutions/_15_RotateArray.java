/**
 * 
 */
package org.leetcode.challenge.october.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _15_RotateArray {
	public void rotate_v1(int[] nums, int k) {
		for (k = k % nums.length; k > 0; k--) {
			int swap = nums[nums.length - 1];
			for (int i = 0; i < nums.length; i++) {
				int tmp = nums[i];
				nums[i] = swap;
				swap = tmp;
			}
		}
	}

	public void rotate_v2(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		if (k == 0)
			return;

		for (int i = 0, start = 0, swap = nums[0], idx = k; i < n; i++, idx = (idx + k) % n) {
			int tmp = nums[idx];
			nums[idx] = swap;
			swap = tmp;
			if (idx == start) {
				swap = nums[++start];
				idx = start;
			}
		}
	}
}
