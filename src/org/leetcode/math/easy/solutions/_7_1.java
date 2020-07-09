/**
 * 
 */
package org.leetcode.math.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class _7_1 {
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
}
