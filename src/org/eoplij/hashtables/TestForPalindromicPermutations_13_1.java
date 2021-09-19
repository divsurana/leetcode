/**
 * 
 */
package org.eoplij.hashtables;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class TestForPalindromicPermutations_13_1 {
	// Using array in lieu of a hashtable
	public boolean canPermutePalindrome_v1(String string) {
		int[] freq = new int[26];
		boolean isPalindrome = true;

		for (char c : string.toLowerCase().toCharArray()) {
			freq[c - 'a']++;
		}

		int oddCount = 0;
		for (int f : freq) {
			if (f % 2 != 0 && ++oddCount > 1) {
				isPalindrome = false;
				break;
			}
		}

		return isPalindrome;
	}

	// Using HashTable (the whole point of this exercise)
	public boolean canPermutePalindrome_v2(String string) {
		Set<Character> chars = new HashSet<>();

		for (char c : string.toLowerCase().toCharArray()) {
			if (chars.contains(c)) {
				chars.remove(c);
			} else {
				chars.add(c);
			}
		}

		return chars.size() <= 1;
	}
}
