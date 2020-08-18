/**
 * 
 */
package org.leetcode.backtracking.medium.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations_v1(String digits) {
		List<String> combinations = new ArrayList<>();
		if (digits.length() > 0) {
			backtrack(combinations, digits, 0, "");
		}
		return combinations;
	}

	private void backtrack(List<String> combinations, String digits, int index, String combination) {
		if (index >= digits.length()) {
			combinations.add(combination);
			return;
		}
		char digit = digits.charAt(index);

		switch (digit) {
		case '2':
			backtrack(combinations, digits, index + 1, combination + "a");
			backtrack(combinations, digits, index + 1, combination + "b");
			backtrack(combinations, digits, index + 1, combination + "c");
			break;
		case '3':
			backtrack(combinations, digits, index + 1, combination + "d");
			backtrack(combinations, digits, index + 1, combination + "e");
			backtrack(combinations, digits, index + 1, combination + "f");
			break;
		case '4':
			backtrack(combinations, digits, index + 1, combination + "g");
			backtrack(combinations, digits, index + 1, combination + "h");
			backtrack(combinations, digits, index + 1, combination + "i");
			break;
		case '5':
			backtrack(combinations, digits, index + 1, combination + "j");
			backtrack(combinations, digits, index + 1, combination + "k");
			backtrack(combinations, digits, index + 1, combination + "l");
			break;
		case '6':
			backtrack(combinations, digits, index + 1, combination + "m");
			backtrack(combinations, digits, index + 1, combination + "n");
			backtrack(combinations, digits, index + 1, combination + "o");
			break;
		case '7':
			backtrack(combinations, digits, index + 1, combination + "p");
			backtrack(combinations, digits, index + 1, combination + "q");
			backtrack(combinations, digits, index + 1, combination + "r");
			backtrack(combinations, digits, index + 1, combination + "s");
			break;
		case '8':
			backtrack(combinations, digits, index + 1, combination + "t");
			backtrack(combinations, digits, index + 1, combination + "u");
			backtrack(combinations, digits, index + 1, combination + "v");
			break;
		case '9':
			backtrack(combinations, digits, index + 1, combination + "w");
			backtrack(combinations, digits, index + 1, combination + "x");
			backtrack(combinations, digits, index + 1, combination + "y");
			backtrack(combinations, digits, index + 1, combination + "z");
			break;
		default:
			backtrack(combinations, digits, index + 1, combination);
			break;
		}
	}

	char[][] mapping = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

	public List<String> letterCombinations_v2(String digits) {
		List<String> combinations = new ArrayList<>();
		if (digits.length() > 0) {
			helper(combinations, digits, new StringBuffer());
		}
		return combinations;
	}

	private void helper(List<String> combinations, String digits, StringBuffer combination) {
		if (combination.length() == digits.length()) {
			combinations.add(combination.toString());
			return;
		}
		int index = combination.length();
		int num = Character.getNumericValue(digits.charAt(index));
		for (char c : mapping[num]) {
			helper(combinations, digits, combination.append(c));
			combination.deleteCharAt(combination.length() - 1);
		}
	}
}
