/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 443. String Compression -
// https://leetcode.com/problems/string-compression/
public class ImplementRunLengthEncoding_7_12 {
	public int compress_v1(char[] chars) {
		int freq = 1;
		int index = 1;

		for (int i = 1; i < chars.length; i++) {
			while (i < chars.length && chars[i] == chars[i - 1]) {
				i++;
				freq++;
			}
			if (freq > 1) {
				for (char c : String.valueOf(freq).toCharArray()) {
					chars[index++] = c;
				}
				freq = 1;
			}
			if (i < chars.length) {
				chars[index++] = chars[i];
			}
		}

		return index;
	}

	public int compress_v2(char[] chars) {
		int freq = 1;
		int index = 1;

		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				freq++;
			} else {
				if (freq > 1) {
					for (char c : String.valueOf(freq).toCharArray()) {
						chars[index++] = c;
					}
					freq = 1;
				}
				chars[index++] = chars[i];
			}

		}

		if (freq > 1) {
			for (char c : String.valueOf(freq).toCharArray()) {
				chars[index++] = c;
			}
		}

		return index;
	}

	public static String encoding(String s) {
		int count = 1;
		StringBuilder ss = new StringBuilder();
		for (int i = 1; i <= s.length(); ++i) {
			if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
				// Found new character so write the count of previous character.
				ss.append(count);
				ss.append(s.charAt(i - 1));
				count = 1;
			} else { // s.charAt(i) == s.charAt(i - 1).
				++count;
			}
		}
		return ss.toString();
	}

	public static String decoding(String s) {
		int count = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				count = count * 10 + c - '0';
			} else { // c is a letter of alphabet.

				while (count > 0) { // Appends count copies of c to result.
					result.append(c);
					count--;
				}
			}
		}
		return result.toString();
	}

}
