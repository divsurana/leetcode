/**
 * 
 */
package org.leetcode.twopointers.hard.solutions;

/**
 * @author divyeshsurana
 *
 */
public class Template {
	public String minWindow(String s, String t) {
		int[] map = new int[128];
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
		while (end < s.length()) {
			if (map[s.charAt(end)] > 0) {
				counter--;
			}
			map[s.charAt(end)]--;
			end++;
			for (; counter == 0; map[s.charAt(begin)]++, begin++) {
				if (end - begin < d) {
					d = end - begin;
					head = begin;
				}
				if (map[s.charAt(begin)] == 0) {
					counter++;
				}
			}
		}

		return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
	}

	int findSubstring(String s) {
		int[] map = new int[128];
		int counter; // check whether the substring is valid
		int begin = 0, end = 0; // two pointers, one point to tail and one head
		int d = 0; // the length of substring

		for (;;) {
			/* initialize the hash map here */
			break;
		}

		while (end < s.length()) {

			// if(map[s.charAt(end)] ?){ /* modify counter here */ }
			map[s.charAt(end)]--;
			end++;

			for (boolean counter_condition = false; counter_condition; map[s.charAt(begin)]++, begin++) {

				/* update d here if finding minimum */

				// increase begin to make it invalid/valid again

				// if(map[s.charAt(begin)]++ ?){ /*modify counter here*/ }
			}

			/* update d here if finding maximum */
		}
		return d;
	}

	/*
	 * Length of Longest Substring with two distinct characters
	 */
	int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] map = new int[128];
		int counter = 0, begin = 0, end = 0, d = 0;
		for (; end < s.length();) {
			if (map[s.charAt(end)] == 0) {
				counter++;
			}
			map[s.charAt(end)]++;
			end++;
			for (; counter > 2; map[s.charAt(begin)]++, begin++) {
				if (map[s.charAt(begin)] == 1) {
					counter--;
				}
			}
			d = Math.max(d, end - begin);
		}
		return d;
	}

	/*
	 * Length of Longest Substring with no repeating characters
	 */
	int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];
		int counter = 0, begin = 0, end = 0, d = 0;
		for (; end < s.length();) {
			if (map[s.charAt(end)] > 0) {
				counter++;
			}
			map[s.charAt(end)]++;
			end++;
			for (; counter > 0; map[s.charAt(begin)]--, begin++) {
				if (map[s.charAt(begin)] > 1) {
					counter--;
				}
			}
			d = Math.max(d, end - begin); // while valid, update d
		}
		return d;
	}
}
