/**
 * 
 */
package org.eoplij.queues;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author divyeshsurana
 *
 */
public class ImplementACircularQueue_9_8 {
	/**
	 * Your MyCircularQueue object will be instantiated and called as such:
	 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
	 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
	 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
	 * boolean param_6 = obj.isFull();
	 */

	class MyCircularQueue_v1 {
		int[] queue;
		int front;
		int rear;
		int size;
		boolean isEmpty;
		boolean isFull;

		public MyCircularQueue_v1(int k) {
			queue = new int[k];
			front = 0;
			rear = 0;
			size = k;
			isEmpty = true;
			isFull = false;
		}

		public boolean enQueue(int value) {
			if (isFull()) {
				return false;
			}
			queue[rear] = value;
			rear = (rear + 1) % size;
			isEmpty = false;
			isFull = front == rear;
			return true;
		}

		public boolean deQueue() {
			if (isEmpty()) {
				return false;
			}
			front = (front + 1) % size;
			isEmpty = front == rear;
			isFull = false;
			return true;
		}

		public int Front() {
			return isEmpty() ? -1 : queue[front];
		}

		public int Rear() {
			return isEmpty() ? -1 : queue[(rear + size - 1) % size];
		}

		public boolean isEmpty() {
			return isEmpty;
		}

		public boolean isFull() {
			return isFull;
		}
	}

	class MyCircularQueue_v2 {
		private static final int SCALE_FACTOR = 2;
		int[] queue;
		int front;
		int rear;
		int size;
		int numElements;

		public MyCircularQueue_v2(int k) {
			queue = new int[k];
			front = 0;
			rear = -1;
			size = k;
			numElements = 0;
		}

		public boolean enQueue(int value) {
			if (isFull()) {
				return false;
			}
			rear = (rear + 1) % size;
			queue[rear] = value;
			numElements++;
			return true;
		}

		// Dynamic resizing code
		public void enqueue(Integer x) {
			if (numElements == queue.length) { // Need to resize.
				// Makes the queue elements appear consecutively.
				// And moves the front element to 0th index
				Collections.rotate(Arrays.asList(queue), -front);
				// Resets head and tail.
				front = 0;
				rear = numElements;
				queue = Arrays.copyOf(queue, numElements * SCALE_FACTOR);
				size = queue.length;
			}
			queue[rear] = x;
			rear = (rear + 1) % size;
			++numElements;
		}

		public boolean deQueue() {
			if (isEmpty()) {
				return false;
			}
			front = (front + 1) % size;
			numElements--;
			return true;
		}

		public int Front() {
			return isEmpty() ? -1 : queue[front];
		}

		public int Rear() {
			return isEmpty() ? -1 : queue[rear];
		}

		public boolean isEmpty() {
			return numElements == 0;
		}

		public boolean isFull() {
			return numElements == size;
		}
	}

}
