/**
 * 
 */
package org.eoplij.queues;

import java.util.Stack;

/**
 * @author divyeshsurana
 *
 */
public class ImplementAQueueUsingStacks_9_9 {

	/**
	 * Your MyQueue object will be instantiated and called as such: MyQueue obj
	 * = new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
	 * obj.peek(); boolean param_4 = obj.empty();
	 */
	class MyQueue {
		Stack<Integer> queue;
		Stack<Integer> reverseQueue;

		/** Initialize your data structure here. */
		public MyQueue() {
			queue = new Stack<Integer>();
			reverseQueue = new Stack<Integer>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			reverseQueue.push(x);
		}

		/**
		 * Removes the element from in front of queue and returns that element.
		 */
		public int pop() {
			repopulateQueue();
			return queue.pop();
		}

		/** Get the front element. */
		public int peek() {
			repopulateQueue();
			return queue.peek();
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return queue.isEmpty() && reverseQueue.isEmpty();
		}

		private void repopulateQueue() {
			if (queue.isEmpty()) {
				while (!reverseQueue.isEmpty()) {
					queue.push(reverseQueue.pop());
				}
			}
		}
	}

}
