/**
 * 
 */
package org.eoplij.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 13. Roman to Integer -
// https://leetcode.com/problems/roman-to-integer/
public class ConvertFromRomanToDecimal_7_9 {
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

	public int romanToInt(String s) {
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

	Map<Integer, Character> romans = new HashMap<Integer, Character>() {
		{
			put(1, 'I');
			put(5, 'V');
			put(10, 'X');
			put(50, 'L');
			put(100, 'C');
			put(500, 'D');
			put(1000, 'M');

		}
	};

	int[] factors = new int[] { 1000, 100, 10, 1 };

	// Variant
	public String intToRoman_v1(int num) {
		StringBuilder builder = new StringBuilder();

		for (int factor : factors) {
			if (num >= factor) {
				int quotient = num / factor;
				if (quotient == 4 || quotient == 9) {
					builder.append(romans.get(factor)).append(romans.get(factor * (quotient + 1)));
				} else {
					if (quotient / 5 > 0) {
						builder.append(romans.get(factor * 5));
						quotient -= 5;
					}
					while (quotient-- > 0) {
						builder.append(romans.get(factor));
					}
				}
				num = num % factor;
			}
		}

		return builder.toString();
	}

	public String intToRoman_v2(int num) {
		StringBuilder result = new StringBuilder();

		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		int i = 0;
		// iterate until the number becomes zero, NO NEED to go until the last
		// element in roman array
		while (num > 0) {
			while (num >= values[i]) {
				num -= values[i];
				result.append(roman[i]);
			}
			i++;
		}
		return result.toString();
	}

}
