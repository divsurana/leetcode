/**
 * 
 */
package org.leetcode.array.easy.solutions;

/**
 * @author divyesh_surana
 *
 */
public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int curr = 0;

		for (int num : nums) {
			if (num == 0) {
				max = Math.max(max, curr);
				curr = 0;
			} else {
				curr += num;
			}
		}

		return Math.max(max, curr);
	}
}
