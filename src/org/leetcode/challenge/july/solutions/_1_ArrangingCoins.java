/**
 * 
 */
package org.leetcode.challenge.july.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1_ArrangingCoins {
	public int arrangeCoins(int n) {
		int i = 1;
		for (; n >= 0; i++) {
			n -= i;
		}
		return i - 2;
	}
}
