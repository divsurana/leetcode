/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
public class BaseConversion_7_2 {
	// Handling incorrect inputs as well
	public String convert(String number, int base1, int base2) {
		int num = 0;
		boolean isNegative = number.startsWith("-");
		StringBuilder result = new StringBuilder();

		for (int i = isNegative ? 1 : 0; i < number.length(); i++) {
			num *= base1;
			char c = number.charAt(i);
			if (c >= '0' && c <= '9') {
				num += (c - '0') * base1;
			} else if (c >= 'A' && c <= 'G') {
				num += (c - 'A' + 10) * base1;
			} else {
				return null;
			}
		}

		while (num > 0) {
			int digit = num % base2;
			if (digit >= 0 && digit < 10) {
				digit += '0';
			} else if (digit > 9 && digit < 16) {
				digit += 'A' - 10;
			} else {
				return null;
			}
			result.append((char) digit);
			num /= base2;
		}
		if (isNegative) {
			result.append('-');
		}

		return result.reverse().toString();
	}

	public static String convertBase(String numAsString, int b1, int b2) {
		boolean isNegative = numAsString.startsWith("-");
		int numAsInt = 0;
		for (int i = isNegative ? 1 : 0; i < numAsString.length(); ++i) {
			numAsInt *= b1;
			numAsInt += Character.isDigit(numAsString.charAt(i)) ? numAsString.charAt(i) - '0'
					: numAsString.charAt(i) - 'A' + 10;
		}
		return (isNegative ? "-" : "") + (numAsInt == 0 ? "0" : constructFromBaseIterative(numAsInt, b2));
	}

	private static String constructFromBaseRecursive(int numAsInt, int base) {
		return numAsInt == 0 ? ""
				: constructFromBaseRecursive(numAsInt / base, base)
						+ (char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);
	}

	private static String constructFromBaseIterative(int numAsInt, int base) {
		StringBuilder result = new StringBuilder();
		while (numAsInt > 0) {
			result.append((char) (numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base));
			numAsInt /= base;
		}

		return result.reverse().toString();
	}
}
