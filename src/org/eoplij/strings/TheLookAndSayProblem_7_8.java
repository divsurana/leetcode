/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 38. Count and Say -
// https://leetcode.com/problems/count-and-say/
public class TheLookAndSayProblem_7_8 {
	// recursive
	public String countAndSay_v1(int n) {
		if (n == 1) {
			return "1";
		}
		String prev = countAndSay_v1(n - 1);
		StringBuilder curr = new StringBuilder();
		int count = 1;
		char prevC = prev.charAt(0);
		for (int i = 1; i < prev.length(); i++) {
			char c = prev.charAt(i);
			if (c == prevC) {
				count++;
			} else {
				curr.append(count).append(prevC);
				count = 1;
				prevC = c;
			}
		}
		curr.append(count).append(prevC);

		return curr.toString();
	}

	// iterative
	public String countAndSay_v2(int n) {
		String prev = "1";
		while (--n > 0) {
			StringBuilder curr = new StringBuilder();
			int count = 1;
			char prevC = prev.charAt(0);
			for (int i = 1; i < prev.length(); i++) {
				char c = prev.charAt(i);
				if (c == prevC) {
					count++;
				} else {
					curr.append(count).append(prevC);
					count = 1;
					prevC = c;
				}
			}
			curr.append(count).append(prevC);
			prev = curr.toString();
		}

		return prev;
	}

	public static String lookAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; ++i) {
			s = nextNumber(s);
		}
		return s;
	}

	private static String nextNumber(String s) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); ++i) {
			int count = 1;
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				++i;
				++count;
			}
			result.append(count);
			result.append(s.charAt(i));
		}
		return result.toString();
	}
}
