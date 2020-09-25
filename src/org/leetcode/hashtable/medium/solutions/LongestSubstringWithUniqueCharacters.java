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
public class LongestSubstringWithUniqueCharacters {
	public int lengthOfLongestSubstring_v1(String s) {
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

	public int lengthOfLongestSubstring_v2(String s) {
		int longestLength = 0;
		int currLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				currLength = Math.min(i - map.get(c), currLength + 1);
			} else {
				currLength++;
			}
			map.put(c, i);
			longestLength = Math.max(currLength, longestLength);
		}
		return longestLength;
	}

	public int lengthOfLongestSubstring_v3(String s) {
		int longestLength = 0;
		int currLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// The trick is to add 1 in case the character isn't present (hence
			// the default value of -1) in the hashmap else just subtract the
			// index from the current index. This helps eliminating the contains
			// check.
			currLength = Math.min(i - map.getOrDefault(c, -1), currLength + 1);
			map.put(c, i);
			longestLength = Math.max(currLength, longestLength);
		}
		return longestLength;
	}

	// Fastest due to the use of a static int array
	public int lengthOfLongestSubstring_v4(String s) {
		int longestLength = 0;
		int currLength = 0;
		int[] arr = new int[95];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			currLength = Math.min(i - arr[c - ' '] + 1, currLength + 1);
			arr[c - ' '] = i + 1; // Adding the position by adding 1 as by
									// default every element will be 0 which
									// should correspond to -1 instead
			longestLength = Math.max(currLength, longestLength);
		}
		return longestLength;
	}
}
