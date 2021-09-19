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
	Map<Character, Integer> values = new HashMap<Character, Integer>() {

		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};

	public int romanToInt_v1(String s) {
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

	public int romanToInt_v2(String s) {
		int total = 0;
		for (int i = 0; i + 1 < s.length(); i++) {
			char c = s.charAt(i);
			if (values.get(c) >= values.get(s.charAt(i + 1))) {
				total += values.get(c);
			} else {
				total -= values.get(c);
			}
		}
		total += values.get(s.charAt(s.length() - 1));
		return total;
	}
}
