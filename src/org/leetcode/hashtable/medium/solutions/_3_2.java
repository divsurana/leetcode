/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class _3_2 {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0;
		int longestLength = 0;

		while (right < s.length()) {
			if (map.containsKey(s.charAt(right))) {
				// This line does the trick of not having to delete all the
				// previous characters
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}
			map.put(s.charAt(right), right);
			longestLength = Math.max(longestLength, right - left + 1);
			right++;
		}
		return longestLength;
	}
}
