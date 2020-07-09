/**
 * 
 */
package org.leetcode.twopointers.medium.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author divyeshsurana
 *
 */
public class _3_1 {
	public int lengthOfLongestSubstring(String s) {
		Queue<Character> longestSubstring = new LinkedList<>();
		int longestLength = 0;

		for (char c : s.toCharArray()) {
			if (longestSubstring.contains(c)) {
				while (longestSubstring.poll() != c) {
					continue;
				}
			}
			longestSubstring.offer(c);
			longestLength = Math.max(longestSubstring.size(), longestLength);
		}

		return longestLength;
	}
}
