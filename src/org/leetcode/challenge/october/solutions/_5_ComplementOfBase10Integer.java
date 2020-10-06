/**
 * 
 */
package org.leetcode.challenge.october.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _5_ComplementOfBase10Integer {
	public int bitwiseComplement(int N) {
		int base = 0;
		int complement = 0;
		do {
			int rem = N % 2;
			complement += ((rem + 1) % 2) << base;
			base++;
			N >>= 1;
		} while (N > 0);
		return complement;
	}
}
