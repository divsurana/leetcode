/**
 * 
 */
package org.leetcode.math.medium.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class StringToInteger {
	public int myAtoi(String str) {
		Set<Character> set = initializeSet();
		int result = 0;
		str = str.trim();
		int i = 0, multiplier = 1;

		if (str.length() > 0) {
			if (str.charAt(0) == '+') {
				i++;
			} else if (str.charAt(0) == '-') {
				multiplier = -1;
				i++;
			}
		}

		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!set.contains(c)) {
				break;
			}
			int newResult = result * 10 + Character.getNumericValue(c);
			if (newResult / 10 != result) {
				return multiplier == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = newResult;
		}

		return multiplier * result;
	}

	private Set<Character> initializeSet() {
		Set<Character> set = new HashSet<>();
		set.add('0');
		set.add('1');
		set.add('2');
		set.add('3');
		set.add('4');
		set.add('5');
		set.add('6');
		set.add('7');
		set.add('8');
		set.add('9');
		return set;
	}
}
