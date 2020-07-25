/**
 * 
 */
package org.leetcode.math.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		int reverse = 0;

		try {
			do {
				reverse = Math.addExact(Math.multiplyExact(reverse, 10), x % 10);
				x /= 10;
			} while (x != 0);
		} catch (ArithmeticException e) {
			return 0;
		}

		return reverse;
	}

	public int reverse_2(int x) {
		long div = x / 10;
		long out = x % 10;

		while (div != 0) {
			out *= 10;
			out += div % 10;
			div = div / 10;
		}

		return Integer.MIN_VALUE < out && out < Integer.MAX_VALUE ? (int) out : 0;
	}
}
