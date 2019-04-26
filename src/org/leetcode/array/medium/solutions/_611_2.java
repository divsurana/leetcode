/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;

/**
 * @author divyesh_surana
 *
 */
public class _611_2 {
	public int triangleNumber(int[] nums) {
		int noOfTriangles = 0;

		Arrays.sort(nums);

		for (int i = nums.length - 1; i > 1; i--) {
			int start = 0;
			int end = i - 1;

			while (start < end) {
				if (nums[start] + nums[end] > nums[i]) {
					noOfTriangles += end - start;
					end--;
				} else {
					start++;
				}
			}
		}

		return noOfTriangles;
	}
}
