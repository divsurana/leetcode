/**
 * 
 */
package org.leetcode.string.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class ReverseWordsInAString {
	public String reverseWords(String s) {
		char SEPARATOR = ' ';
		StringBuffer buffer = new StringBuffer();
		StringBuffer word = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == SEPARATOR) {
				if (word.length() > 0) {
					buffer.append(word.reverse()).append(SEPARATOR);
					word.setLength(0);
				}
				continue;
			}
			word.append(c);
		}
		buffer.append(word.reverse());
		return buffer.toString().trim();
	}
}
