/**
 * 
 */
package org.leetcode.math.easy.solutions;

/**
 * @author divyeshsurana
 *
 */
public class _9_1 {
	public boolean isPalindrome(int x) {
		StringBuilder builder = new StringBuilder(String.valueOf(x));
		return builder.toString().equals(builder.reverse().toString());
	}
}
