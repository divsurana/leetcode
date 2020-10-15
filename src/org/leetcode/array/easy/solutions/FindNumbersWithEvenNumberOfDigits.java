/**
 * 
 */
package org.leetcode.array.easy.solutions;

/**
 * @author divyesh_surana
 *
 */
public class FindNumbersWithEvenNumberOfDigits {
	public int findNumbers_v1(int[] nums) {
		int count = 0;

		for (int num : nums) {
			count = Integer.toString(num).length() % 2 == 0 ? count + 1 : count;
		}

		return count;
	}

	public int findNumbers_v2(int[] nums) {
		int count = 0;

		for (int num : nums) {
			int no = 0;
			while (num != 0) {
				num /= 10;
				no++;
			}
			count = no % 2 == 0 ? count + 1 : count;
		}

		return count;
	}
}
