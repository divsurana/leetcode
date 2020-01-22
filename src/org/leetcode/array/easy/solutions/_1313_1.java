/**
 * 
 */
package org.leetcode.array.easy.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1313_1 {
	public int[] decompressRLElist(int[] nums) {
		int size = 0;
		for (int i = 0; i < nums.length; i += 2) {
			size += nums[i];
		}
		int[] decList = new int[size];

		int j = 0;
		for (int i = 0; i < nums.length; i += 2) {
			for (int k = 0; k < nums[i]; k++, j++) {
				decList[j] = nums[i + 1];
			}
		}

		return decList;
	}
}
