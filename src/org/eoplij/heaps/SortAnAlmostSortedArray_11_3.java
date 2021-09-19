/**
 * 
 */
package org.eoplij.heaps;

import java.util.PriorityQueue;

/**
 * @author divyeshsurana
 *
 */
public class SortAnAlmostSortedArray_11_3 {
	public void sort(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1, (a, b) -> Integer.compare(a, b));
		int i = 0;
		for (int num : arr) {
			minHeap.offer(num);
			if (minHeap.size() == k + 1) {
				arr[i++] = minHeap.poll();
			}
		}
		while (i < arr.length) {
			arr[i++] = minHeap.poll();
		}
	}
}
