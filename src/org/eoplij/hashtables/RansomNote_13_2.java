/**
 * 
 */
package org.eoplij.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class RansomNote_13_2 {

	// Using Array in lieu of a Hash Table to make things faster

	public boolean canConstruct_v5(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		int[] freq = new int[256]; // To cover all ascii characters

		for (char c : magazine.toCharArray()) {
			freq[c]++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (--freq[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean canConstruct_v3(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		int[] freq = new int[26];

		for (char c : magazine.toCharArray()) {
			freq[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (--freq[c - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean canConstruct_v2(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		int[] freq = new int[26];

		for (int i = 0, j = 0; j < magazine.length(); i++, j++) {
			if (i < ransomNote.length()) {
				freq[ransomNote.charAt(i) - 'a']++;
			}
			freq[magazine.charAt(j) - 'a']--;
		}

		for (int f : freq) {
			if (f > 0) {
				return false;
			}
		}
		return true;
	}

	public boolean canConstruct_v1(String ransomNote, String magazine) {
		char[] ransomNoteArray = ransomNote.toCharArray();
		Arrays.sort(ransomNoteArray);
		char[] magazineArray = magazine.toCharArray();
		Arrays.sort(magazineArray);

		for (int i = 0, j = 0; i < ransomNote.length(); j++) {
			if (j >= magazine.length()) {
				return false;
			}
			if (ransomNoteArray[i] == magazineArray[j]) {
				i++;
			} else if (ransomNoteArray[i] < magazineArray[j]) {
				if (j == 0 || magazineArray[j - 1] != magazineArray[j]) {
					return false;
				}
			}
		}

		return true;
	}

	// Using HashMap (slow but whole point of the exercise)
	public boolean canConstruct_v4(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		Map<Character, Integer> freq = new HashMap<>();

		for (char c : ransomNote.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		for (char c : magazine.toCharArray()) {
			if (freq.containsKey(c)) {
				freq.put(c, freq.get(c) - 1);
				if (freq.get(c) == 0) {
					freq.remove(c);
				}
				if (freq.isEmpty()) {
					break;
				}
			}
		}

		return freq.isEmpty();
	}

}
