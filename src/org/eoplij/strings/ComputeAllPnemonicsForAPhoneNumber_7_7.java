/**
 * 
 */
package org.eoplij.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 17. Letter Combinations of a Phone Number -
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class ComputeAllPnemonicsForAPhoneNumber_7_7 {
	char[][] mapping = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations_v1(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		List<String> result = new ArrayList<>();
		helper(result, 0, digits, new StringBuffer());
		return result;
	}

	public void helper(List<String> result, int index, String digits, StringBuffer buffer) {
		for (char c : mapping[Character.getNumericValue(digits.charAt(index))]) {
			buffer.append(c);
			if (index == digits.length() - 1) {
				result.add(buffer.toString());
			} else {
				helper(result, index + 1, digits, buffer);
			}
			buffer.setLength(buffer.length() - 1);
		}
	}

	public List<String> letterCombinations_v2(String digits) {
		List<String> result = new ArrayList<>();
		if (!digits.isEmpty()) {
			helper(result, 0, digits, new char[digits.length()]);
		}
		return result;
	}

	public void helper(List<String> result, int index, String digits, char[] buffer) {
		for (char c : mapping[Character.getNumericValue(digits.charAt(index))]) {
			buffer[index] = c;
			if (index == digits.length() - 1) {
				result.add(String.valueOf(buffer));
			} else {
				helper(result, index + 1, digits, buffer);
			}
		}
	}

	public List<String> letterCombinations_v3(String digits) {
		List<String> result = new ArrayList<>();
		if (!digits.isEmpty()) {
			Queue<char[]> queue = new LinkedList<>();
			queue.offer(new char[digits.length()]);
			for (int index = 0; index < digits.length(); index++) {
				int n = queue.size();
				while (n-- > 0) {
					char[] buffer = queue.poll();
					for (char c : mapping[Character.getNumericValue(digits.charAt(index))]) {
						buffer[index] = c;
						if (index == digits.length() - 1) {
							result.add(String.valueOf(buffer));
						} else {
							queue.offer(Arrays.copyOf(buffer, buffer.length));
						}
					}
				}
			}
		}
		return result;
	}
}
