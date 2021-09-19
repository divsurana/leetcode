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
public class ImplementAStackWithMaxAPI_9_1 {
	/**
	 * Your MinStack object will be instantiated and called as such: MinStack
	 * obj = new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
	class MinStack_v1 {
		Deque<Integer> stack;
		Deque<Integer> minCache;

		/** initialize your data structure here. */
		public MinStack_v1() {
			stack = new LinkedList<>();
			minCache = new LinkedList<>();
		}

		public void push(int val) {
			stack.push(val);
			minCache.push(Math.min(minCache.isEmpty() ? val : minCache.peek(), val));
		}

		public void pop() {
			stack.pop();
			minCache.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return minCache.peek();
		}
	}

	class MinMaxStack {
		private Node head;

		public void push(int x) {
			if (head == null) {
				head = new Node(x, x, x);
			} else {
				head = new Node(x, Math.min(x, head.min), Math.max(x, head.max), head);
			}
		}

		public void pop() {
			head = head.next;
		}

		public int top() {
			return head.val;
		}

		public int getMin() {
			return head.min;
		}

		public int getMax() {
			return head.max;
		}

		private class Node {
			int val;
			int min;
			int max;
			Node next;

			private Node(int val, int min, int max) {
				this(val, min, max, null);
			}

			private Node(int val, int min, int max, Node next) {
				this.val = val;
				this.min = min;
				this.max = max;
				this.next = next;
			}
		}
	}

}
