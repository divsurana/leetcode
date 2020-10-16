/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class _12_BuddyStrings {
	public boolean buddyStrings_v1(String A, String B) {
		if (A.length() != B.length()) {
			return false;
		}
		boolean result = false;

		if (A.equals(B)) {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < A.length(); i++) {
				set.add(A.charAt(i));
			}
			result = set.size() < A.length();
		} else {
			int count = 0, pos = -1;
			for (int i = 0; i < A.length(); i++) {
				int c1 = A.charAt(i);
				int c2 = B.charAt(i);

				if (c1 != c2) {
					if (pos == -1) {
						pos = i;
					} else {
						if (c1 == B.charAt(pos) && c2 == A.charAt(pos)) {
							count++;
						} else {
							count += 2;
						}
					}
				}
			}
			result = count == 1;
		}

		return result;
	}

	public boolean buddyStrings_v2(String A, String B) {
		if (A.length() != B.length()) {
			return false;
		}
		boolean result = false;

		if (A.equals(B)) {
			boolean[] occurences = new boolean[26];
			int count = 0;
			for (int i = 0; i < A.length(); i++) {
				occurences[A.charAt(i) - 'a'] = true;
			}
			for (boolean occur : occurences) {
				if (occur) {
					count++;
				}
			}
			result = count < A.length();
		} else {
			int count = 0, pos = -1;
			for (int i = 0; i < A.length(); i++) {
				int c1 = A.charAt(i);
				int c2 = B.charAt(i);

				if (c1 != c2) {
					if (pos == -1) {
						pos = i;
					} else {
						if (c1 == B.charAt(pos) && c2 == A.charAt(pos)) {
							count++;
						} else {
							count += 2;
						}
					}
				}
			}
			result = count == 1;
		}

		return result;
	}
}
