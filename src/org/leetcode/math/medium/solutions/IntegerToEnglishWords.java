/**
 * 
 */
package org.leetcode.math.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class IntegerToEnglishWords {
	String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	String[] thousands = { "", "Thousand", "Million", "Billion" };
	int[] factors = { 1, 1000, 1000000, 1000000000 };
	String SEPARATOR = " ";

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}

		StringBuffer buffer = new StringBuffer();

		for (int i = factors.length - 1; i >= 0; i--) {
			int factor = factors[i];
			if (num / factor > 0) {
				helper(num / factor, buffer);
				buffer.append(thousands[i]).append(SEPARATOR);
				num %= factor;
			}
		}

		return buffer.toString().trim();
	}

	// recursive approach
	private void helper(int num, StringBuffer buffer) {
		if (num == 0) {
			return;
		}
		if (num < 20) {
			buffer.append(ones[num]).append(SEPARATOR);
		} else if (num < 100) {
			buffer.append(tens[num / 10]).append(SEPARATOR);
			helper(num % 10, buffer);
		} else {
			helper(num / 100, buffer);
			buffer.append("Hundred").append(SEPARATOR);
			helper(num % 100, buffer);
		}
	}

	// straightforward approach
	private void helper_v2(int num, StringBuffer buffer) {
		if (num / 100 > 0) {
			buffer.append(ones[num / 100]).append(SEPARATOR).append("Hundred").append(SEPARATOR);
		}
		if (num % 100 >= 20) {
			buffer.append(tens[num % 100 / 10]).append(SEPARATOR);
			if (num % 10 > 0) {
				buffer.append(ones[num % 10]).append(SEPARATOR);
			}
		}
		if (0 < num % 100 && num % 100 < 20) {
			buffer.append(ones[num % 100]).append(SEPARATOR);
		}
	}
}
