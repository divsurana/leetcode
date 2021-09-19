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
public class EvaluateRPNExpressions_9_2 {
	public int evalRPN_v1(String[] tokens) {
		Deque<Integer> stack = new LinkedList<>();

		for (String token : tokens) {
			switch (token) {
			case "+":
				int second = stack.pop();
				int first = stack.pop();
				stack.push(first + second);
				break;
			case "-":
				second = stack.pop();
				first = stack.pop();
				stack.push(first - second);
				break;
			case "*":
				second = stack.pop();
				first = stack.pop();
				stack.push(first * second);
				break;
			case "/":
				second = stack.pop();
				first = stack.pop();
				stack.push(first / second);
				break;
			default:
				int num = Integer.parseInt(token);
				stack.push(num);
			}
		}

		return stack.pop();
	}

	public int evalRPN_v2(String[] tokens) {
		Deque<Integer> stack = new LinkedList<>();

		for (String token : tokens) {
			switch (token) {
			case "+":
			case "-":
			case "*":
			case "/":
				stack.push(calculate(stack.pop(), stack.pop(), token));
				break;
			default:
				int num = Integer.parseInt(token);
				stack.push(num);
			}
		}

		return stack.pop();
	}

	public int calculate(int second, int first, String operator) {
		int result = 0;
		switch (operator) {
		case "+":
			result = first + second;
			break;
		case "-":
			result = first - second;
			break;
		case "*":
			result = first * second;
			break;
		case "/":
			result = first / second;
			break;
		}
		return result;
	}
}
