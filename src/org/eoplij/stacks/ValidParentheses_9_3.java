/**
 * 
 */
package org.eoplij.stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author divyeshsurana
 *
 */
public class ValidParentheses_9_3 {
	public boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();

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
				if (stack.isEmpty() || stack.pop() != c) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
