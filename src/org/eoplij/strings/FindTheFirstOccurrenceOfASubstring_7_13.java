/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 28. Implement strStr() -
// https://leetcode.com/problems/string-compression/
public class FindTheFirstOccurrenceOfASubstring_7_13 {
	public int strStr_v1(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}
		int i = 0, idx = 0;

		while (i < haystack.length() && idx < needle.length()) {
			if (haystack.charAt(i++) == needle.charAt(idx)) {
				idx++;
			} else {
				i -= idx;
				idx = 0;
			}
		}

		return idx < needle.length() ? -1 : i - needle.length();
	}

	public int strStr_v2(String haystack, String needle) {
		if (needle.isEmpty()) {
			return 0;
		}

		for (int start = 0, end = needle.length(); end <= haystack.length(); start++, end++) {
			if (haystack.substring(start, end).equals(needle)) {
				return start;
			}
		}

		return -1;
	}

	public int strStr_v3(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length()) {
					return i;
				}
				if (i + j == haystack.length()) {
					return -1;
				}
				if (needle.charAt(j) != haystack.charAt(i + j)) {
					break;
				}
			}
		}
	}
}
