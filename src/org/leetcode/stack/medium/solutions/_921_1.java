/**
 * 
 */
package org.leetcode.stack.medium.solutions;

import java.util.Stack;

/**
 * @author divyesh_surana
 *
 */
public class _921_1 {
	public int minAddToMakeValid(String S) {
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
}
