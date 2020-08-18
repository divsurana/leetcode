/**
 * 
 */
package org.leetcode.math.easy.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> values = initializeValues();
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char nextC = i < s.length() - 1 ? s.charAt(i + 1) : 0;
			switch (c) {
			case 'I':
				if (nextC == 'V' || nextC == 'X') {
					result += values.get(nextC) - values.get(c);
					i++;
				} else {
					result += values.get(c);
				}
				break;
			case 'X':
				if (nextC == 'L' || nextC == 'C') {
					result += values.get(nextC) - values.get(c);
					i++;
				} else {
					result += values.get(c);
				}
				break;
			case 'C':
				if (nextC == 'D' || nextC == 'M') {
					result += values.get(nextC) - values.get(c);
					i++;
				} else {
					result += values.get(c);
				}
				break;
			case 'V':
			case 'L':
			case 'D':
			case 'M':
				result += values.get(c);
				break;
			}
		}

		return result;
	}

	private Map<Character, Integer> initializeValues() {
		Map<Character, Integer> values = new HashMap<>();

		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);

		return values;
	}
}
