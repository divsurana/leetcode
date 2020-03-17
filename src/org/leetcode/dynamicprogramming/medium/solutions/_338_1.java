/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _338_1 {
	public int[] countBits(int num) {
		int[] bits = new int[num + 1];

		for (int limit = 1, counter = 1; counter < num + 1; limit *= 2) {
			for (int i = 0; i < limit && counter < num + 1; i++, counter++) {
				bits[counter] = bits[i] + 1;
			}
		}

		return bits;
	}
}
