/**
 * 
 */
package org.ctci.arraysandstrings.solutions;

import java.util.HashSet;

/**
 * @author divyeshsurana
 *
 */
public class IsUnique {
	public boolean isUnique(String string) {
		HashSet<Character> set = new HashSet<>();
		for (char c : string.toCharArray()) {
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

	public boolean isUniqueWithArray(String string) {
		boolean[] arr = new boolean[128];

		for (char c : string.toCharArray()) {
			if (arr[c]) {
				return false;
			}
			arr[c] = true;
		}
		return true;
	}

	// TODO: read on this
	boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & 1 << val) > 0) {
				return false;
			}
			checker |= 1 << val;
		}
		return true;
	}
}
