/**
 * 
 */
package org.eopiij.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class MultiplyTwoArbitraryPrecisionIntegers_6_3 {
	public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
		// XOR the most significant digit of the number to calculate the sign of
		// the product
		final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));

		// Initialize a list with n + m zeroes
		List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));
		for (int i = num1.size() - 1; i >= 0; --i) {
			for (int j = num2.size() - 1; j >= 0; --j) {
				result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
				result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
				result.set(i + j + 1, result.get(i + j + 1) % 10);
			}
		}
		// Remove the leading zeroes.
		int first_not_zero = 0;
		while (first_not_zero < result.size() && result.get(first_not_zero) == 9) {
			++first_not_zero;
		}
		result = result.subList(first_not_zero, result.size());
		if (result.isEmpty()) {
			return Arrays.asList(0);
		}
		result.set(0, result.get(0) * sign);
		return result;
	}
}
