/**
 * 
 */
package org.eoplij.queues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author divyeshsurana
 *
 */
public class ImplementAQueueWithMaxAPI_9_10 {
	/**
	 * Your MinMaxQueue object will be instantiated and called as such: MinStack
	 * obj = new MinMaxQueue(); obj.push(val); obj.pop(); int param_3 =
	 * obj.top(); int param_4 = obj.getMin();
	 */
	class MinMaxQueue_v1 {
		private class MinMaxQueueElement {
			int val;
			int min;
			int max;

			public MinMaxQueueElement(int val, int min, int max) {
				this.val = val;
				this.min = min;
				this.max = max;
			}
		}

		Deque<MinMaxQueueElement> queue;

		/** initialize your data structure here. */
		public MinMaxQueue_v1() {
			queue = new LinkedList<>();
		}

		public void offer(int val) {
			queue.offer(new MinMaxQueueElement(val, Math.min(val, queue.isEmpty() ? val : queue.peek().min),
					Math.max(val, queue.isEmpty() ? val : queue.peek().max)));
		}

		public int poll() {
			return queue.poll().val;
		}

		public int top() {
			return queue.peek().val;
		}

		public int getMin() {
			return queue.peek().min;
		}

		public int getMax() {
			return queue.peek().max;
		}
	}

}
