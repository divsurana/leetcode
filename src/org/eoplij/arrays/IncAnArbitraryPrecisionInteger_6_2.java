/**
 * 
 */
package org.eoplij.arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 66. Plus One -
// https://leetcode.com/problems/plus-one/
public class IncAnArbitraryPrecisionInteger_6_2 {
	public int[] plusOne_v1(int[] digits) {
		digits[digits.length - 1]++;

		for (int i = digits.length - 1; i > 0 && digits[i] > 9; i--) {
			digits[i] = 0;
			digits[i - 1]++;
		}

		if (digits[0] > 9) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}

		return digits;
	}

	public int[] plusOne_v2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				return digits;
			}
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
