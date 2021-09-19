/**
 * 
 */
package org.eoplij.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author divyeshsurana
 *
 */
public class ComputeTheMedianOfOnlineData_11_5 {
	class MedianFinder {
		PriorityQueue<Integer> minHeap; // right side
		PriorityQueue<Integer> maxHeap; // left side
		double median;

		/** initialize your data structure here. */
		public MedianFinder() {
			minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
			maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			median = 0;
		}

		public void addNum_v1(int num) {
			if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
				maxHeap.offer(num);
			} else if (minHeap.isEmpty() || num >= minHeap.peek()) {
				minHeap.offer(num);
			} else {
				if (maxHeap.size() < minHeap.size()) {
					maxHeap.offer(num);
				} else {
					minHeap.offer(num);
				}
			}
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.offer(maxHeap.poll());
			} else if (minHeap.size() - maxHeap.size() > 1) {
				maxHeap.offer(minHeap.poll());
			}
			median = maxHeap.size() == minHeap.size() ? (double) (maxHeap.peek() + minHeap.peek()) / 2
					: maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
		}

		public void addNum_v2(int num) {
			if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
				maxHeap.offer(num);
			} else {
				minHeap.offer(num);
			}

			// Ensure that maxHeap and minHeap have the same size or maxHeap
			// must have the extra element. This eliminates the amount of
			// computing done in the previous solution.
			if (maxHeap.size() - minHeap.size() > 1) {
				minHeap.offer(maxHeap.poll());
			} else if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
			median = maxHeap.size() == minHeap.size() ? (double) (maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
		}

		public double findMedian() {
			return median;
		}
	}

	class MedianFinderClean {
		private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		private PriorityQueue<Integer> right = new PriorityQueue<>();
		private boolean even = true;

		public double findMedian() {
			return even ? (left.peek() + right.peek()) / 2.0 : left.peek();
		}

		public void addNum(int num) {
			if (even) {
				// Left gets the extra element
				right.offer(num);
				left.offer(right.poll());
			} else {
				// Right gets the element to balance out the heaps
				left.offer(num);
				right.offer(left.poll());
			}
			even = !even;
		}
	}
}
