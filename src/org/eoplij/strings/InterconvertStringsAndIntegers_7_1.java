/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 8. String to Integer (atoi) -
// https://leetcode.com/problems/string-to-integer-atoi/
public class InterconvertStringsAndIntegers_7_1 {
	public int myAtoi(String str) {
		int result = 0;
		str = str.trim();
		int i = 0, multiplier = 1;

		if (str.length() > 0) {
			if (str.charAt(0) == '+') {
				i++;
			} else if (str.charAt(0) == '-') {
				multiplier = -1;
				i++;
			}
		}

		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				break;
			}
			int newResult = result * 10 + c - '0';
			// Check overflow
			if (newResult / 10 != result) {
				return multiplier == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = newResult;
		}

		return multiplier * result;
	}

	public static String intToString(int x) {
		boolean isNegative = x < 0;

		StringBuilder s = new StringBuilder();
		do {
			s.append((char) ('0' + Math.abs(x % 10)));
			x /= 10;
		} while (x != 0);
		if (isNegative) {
			s.append('-'); // Adds the negative sign back
		}
		return s.reverse().toString();
	}

	public static int stringToInt(String s) {
		int result = 0;
		for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
			final int digit = s.charAt(i) - '0';
			result = result * 10 + digit;
		}
		return s.charAt(0) == '-' ? -result : result;
	}
}
