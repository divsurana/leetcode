/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class CountingBits {
	public int[] countBits_v1(int num) {
		int[] bits = new int[num + 1];

		for (int limit = 1, counter = 1; counter < num + 1; limit *= 2) {
			for (int i = 0; i < limit && counter < num + 1; i++, counter++) {
				bits[counter] = bits[i] + 1;
			}
		}

		return bits;
	}

	public int[] countBits_v2(int num) {
		int[] count = new int[num + 1];

		for (int i = 1; i < num + 1; i *= 2) {
			for (int j = 0; j < i && j + i < num + 1; j++) {
				count[j + i] = count[j] + 1;
			}
		}

		return count;
	}

	// Another possible way is f[i] = f[i / 2] + i % 2
}
