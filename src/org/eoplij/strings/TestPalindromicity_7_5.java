/**
 * 
 */
package org.eoplij.strings;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 125. Valid Palindrome -
// https://leetcode.com/problems/valid-palindrome/
public class TestPalindromicity_7_5 {
	public boolean isPalindrome_v1(String s) {
		int left = 0, right = s.length() - 1;
		boolean isPalindrome = true;

		while (left < right && isPalindrome) {
			char leftChar = Character.toLowerCase(s.charAt(left));
			char rightChar = Character.toLowerCase(s.charAt(right));
			while (!(leftChar >= 'a' && leftChar <= 'z') && !(leftChar >= '0' && leftChar <= '9') && left < right) {
				leftChar = Character.toLowerCase(s.charAt(++left));
			}
			while (!(rightChar >= 'a' && rightChar <= 'z') && !(rightChar >= '0' && rightChar <= '9') && left < right) {
				rightChar = Character.toLowerCase(s.charAt(--right));
			}
			isPalindrome = isPalindrome && leftChar == rightChar;
			left++;
			right--;
		}

		return isPalindrome;
	}

	public boolean isPalindrome_v2(String s) {
		int left = 0, right = s.length() - 1;
		boolean isPalindrome = true;

		while (left < right && isPalindrome) {
			while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
				left++;
			}
			while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
				right--;
			}
			isPalindrome = isPalindrome
					&& Character.toLowerCase(s.charAt(left++)) == Character.toLowerCase(s.charAt(right--));
		}

		return isPalindrome;
	}
}
