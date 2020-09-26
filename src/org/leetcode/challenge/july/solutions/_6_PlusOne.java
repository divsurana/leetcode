/**
 * 
 */
package org.leetcode.challenge.july.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _6_PlusOne {
	public int[] plusOne_v1(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9)
				digits[i] = 0;
			else {
				digits[i]++;
				break;
			}
		}
		if (digits[0] == 0) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			System.arraycopy(digits, 0, res, 1, digits.length);
			digits = res;
		}
		return digits;
	}

	public int[] plusOne_v2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9)
				digits[i] = 0;
			else {
				// Instead of breaking just returning it to simplify the logic after the loop
				digits[i]++;
				return digits;
			}
		}
		// Didn't need to copy the entire array since overflow would happen only if all
		// the digits are 9 and therefore the new number is 100...
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
