/**
 * 
 */
package org.leetcode.stack.medium.solutions;

import java.util.Stack;

/**
 * @author divyesh_surana
 *
 */
public class MinimumAddToMakeParenthesesValid {
	public int minAddToMakeValid_v1(String S) {
		Stack<Character> stack = new Stack<>();

		for (char c : S.toCharArray()) {
			if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
				continue;
			}
			stack.push(c);
		}

		return stack.size();
	}

	public int minAddToMakeValid_v2(String s) {
		int l = 0, r = 0;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				l++;
			} else if (l == 0) {
				r++;
			} else {
				l--;
			}
		}

		return l + r;
	}
}
