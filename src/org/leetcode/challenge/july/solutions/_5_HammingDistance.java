/**
 * 
 */
package org.leetcode.challenge.july.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _5_HammingDistance {
	public int hammingDistance_v1(int x, int y) {
		int count = 0;

		// loop through 32 times since since 2^31 (max) has 32 bits
		for (int i = 0; i < 32; i++) {
			// rightshift the ith bit to last and then & with 1 to isolate it before
			// comparing the 2 bits
			if ((x >> i & 1) != (y >> i & 1))
				count++;
		}

		return count;
	}

	public int hammingDistance_v2(int x, int y) {
		// using bitcount to count set bits after xoring x and y
		return Integer.bitCount(x ^ y);
	}
}
