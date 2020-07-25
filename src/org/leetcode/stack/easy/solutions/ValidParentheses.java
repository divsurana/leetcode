/**
 * 
 */
package org.leetcode.stack.easy.solutions;

import java.util.Stack;

/**
 * @author divyeshsurana
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s.length() % 2 == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (stack.isEmpty()) {
				return false;
			} else {
				switch (c) {
				case ')':
					if (stack.pop() == '(') {
						break;
					} else {
						return false;
					}
				case '}':
					if (stack.pop() == '{') {
						break;
					} else {
						return false;
					}
				case ']':
					if (stack.pop() == '[') {
						break;
					} else {
						return false;
					}
				default:
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
