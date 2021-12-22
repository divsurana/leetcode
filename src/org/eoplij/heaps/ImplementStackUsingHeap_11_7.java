/**
 * 
 */
package org.eoplij.heaps;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author divyeshsurana
 *
 */
public class ImplementStackUsingHeap_11_7 {
	class Element {
		int val;
		int index;

		Element(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

	PriorityQueue<Element> stack;
	int k;

	/** Initialize your data structure here. */
	public ImplementStackUsingHeap_11_7() {
		stack = new PriorityQueue<>((a, b) -> b.index - a.index);
		k = 0;
	}

	/** Push element x onto stack. */
	public void push(int x) {
		stack.offer(new Element(x, k++));
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return stack.poll().val;
	}

	/** Get the top element. */
	public int top() {
		return stack.peek().val;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return stack.isEmpty();
	}

	// A very elegant O(1) operation implementation using queue. The entire
	// queue reference is added making push O(1) as well.
	class MyStack {

		private Queue queue;

		public void push(int x) {
			Queue q = new LinkedList(); // could be any queue type, see note
										// above
			q.add(x);
			q.add(queue);
			queue = q;
		}

		public void pop() {
			queue.remove();
			queue = (Queue) queue.peek();
		}

		public int top() {
			return (int) queue.peek();
		}

		public boolean empty() {
			return queue.isEmpty();
		}
	}
}
