/**
 * 
 */
package org.leetcode.twopointers.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class ReverseString {
	public void reverseString(char[] s) {
		for (int i = 0, j = s.length - 1; i < j; i++, j--) {
			char swap = s[i];
			s[i] = s[j];
			s[j] = swap;
		}
	}
}
