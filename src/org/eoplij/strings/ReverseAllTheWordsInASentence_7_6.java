/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 151. Reverse Words in a String -
// https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseAllTheWordsInASentence_7_6 {
	public static void reverseWords(char[] input) {
		// Reverses the whole string first.
		reverse(input, 0, input.length);
		int start = 0, end;
		while ((end = find(input, ' ', start)) != -1) {
			// Reverses each word in the string.
			reverse(input, start, end);
			start = end + 1;
		} // Reverses the last word.
		reverse(input, start, input.length);
	}

	public static void reverse(char[] array, int start, int stoplndex) {
		if (start >= stoplndex) {
			return;
		}
		int last = stoplndex - 1;
		while (start < last) {
			char tmp = array[start];
			array[start++] = array[last];
			array[last--] = tmp;
		}
	}

	public static int find(char[] array, char c, int start) {
		for (int i = start; i < array.length; i++) {
			if (array[i] == c) {
				return i;
			}
		}
		return -1;
	}

	public String reverseWords_v1(String s) {
		StringBuffer buffer = new StringBuffer();
		String[] words = s.trim().split(" ");

		for (int i = words.length - 1; i >= 0; i--) {
			if (!words[i].isEmpty()) {
				buffer.append(words[i]).append(" ");
			}
		}

		return buffer.toString().trim();
	}

	public String reverseWords_v2(String s) {
		final char SEPARATOR = ' ';
		StringBuffer buffer = new StringBuffer();
		StringBuffer word = new StringBuffer();

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == SEPARATOR) {
				if (word.length() > 0) {
					buffer.append(word.reverse()).append(SEPARATOR);
					word.setLength(0);
				}
				continue;
			}
			word.append(s.charAt(i));
		}
		buffer.append(word.reverse());
		return buffer.toString().trim();
	}
}
