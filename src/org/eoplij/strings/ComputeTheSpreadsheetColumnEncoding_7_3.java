/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 171. Excel Sheet Column Number -
// https://leetcode.com/problems/excel-sheet-column-number/
public class ComputeTheSpreadsheetColumnEncoding_7_3 {
	public int titleToNumber(String columnTitle) {
		int number = 0;
		for (char c : columnTitle.toCharArray()) {
			number *= 26;
			number += c - 'A' + 1;
		}
		return number;
	}

	// Variant - If 'A' starts as 0 instead of 1
	public int titleToNumberWithZero(String columnTitle) {
		int number = 0;
		for (char c : columnTitle.toCharArray()) {
			number *= 26;
			number += c - 'A' + 1;
		}
		return number - 1;
	}

	// Variant to inverse
	// 168. Excel Sheet Column Title
	// https://leetcode.com/problems/excel-sheet-column-title/
	public String convertToTitle(int columnNumber) {
		StringBuffer buffer = new StringBuffer();

		while (columnNumber > 0) {
			columnNumber--;
			buffer.append((char) ('A' + columnNumber % 26));
			columnNumber /= 26;
		}

		return buffer.reverse().toString();
	}
}
