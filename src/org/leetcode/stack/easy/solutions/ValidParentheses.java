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
	public boolean isValid_v1(String s) {
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

	public boolean isValid_v2(String s) {
		if (s.length() % 2 == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;
			default:
				if (stack.isEmpty() || c != stack.pop()) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
