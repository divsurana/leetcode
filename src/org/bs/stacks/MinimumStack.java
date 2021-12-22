/**
 * 
 */
package org.bs.stacks;

import java.util.Stack;

/**
 * @author divyeshsurana
 *
 */
public class MinimumStack {
	class Element {
		int val;
		int min;

		Element(int val, int min) {
			this.val = val;
			this.min = min;
		}
	}

	Stack<Element> stack;

	public MinimumStack() {
		stack = new Stack<>();
	}

	public void append(int val) {
		stack.push(new Element(val, stack.isEmpty() ? val : Math.min(val, stack.peek().min)));
	}

	public int peek() {
		return stack.peek().val;
	}

	public int min() {
		return stack.peek().min;
	}

	public int pop() {
		return stack.pop().val;
	}

}
