/**
 * 
 */
package org.eoplij.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author divyeshsurana
 *
 */
public class ComputeKLargestInAMaxHeap_11_6 {
	// Solution from leetcode
	public static List<Integer> peekTopK(int[] arr, int k) {
		final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> arr[b] - arr[a]);
		final List<Integer> ans = new ArrayList<>();
		pq.offer(0);
		while (!pq.isEmpty() && k > 0) {
			int largest = pq.poll();
			ans.add(arr[largest]);
			int l = 2 * largest + 1, r = l + 1;
			if (l < arr.length) {
				pq.offer(l);
			}
			if (r < arr.length) {
				pq.offer(r);
			}
			k--;
		}
		return ans;
	}

	// Solution from EOPLI
	private static class HeapEntry {
		public Integer index;
		public Integer value;

		public HeapEntry(Integer index, Integer value) {
			this.index = index;
			this.value = value;
		}
	}

	private static class Compare implements Comparator<HeapEntry> {
		@Override
		public int compare(HeapEntry ol, HeapEntry o2) {
			return Integer.compare(o2.value, ol.value);
		}

		public static final Compare COMPARE_HEAP_ENTRIES = new Compare();
	}

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public static List<Integer> kLargestlnBinaryHeap(List<Integer> A, int k) {
		if (k <= 0) {
			return Collections.emptyList();
		}
		// Stores the (index, value)-pair in candidateMaxHeap. This heap is
		// ordered by the value field.
		PriorityQueue<HeapEntry> candidateMaxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY,
				Compare.COMPARE_HEAP_ENTRIES);
		candidateMaxHeap.add(new HeapEntry(0, A.get(0)));
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; ++i) {
			Integer candidateldx = candidateMaxHeap.peek().index;
			result.add(candidateMaxHeap.remove().value);
			Integer leftChildldx = 2 * candidateldx + 1;
			if (leftChildldx < A.size()) {
				candidateMaxHeap.add(new HeapEntry(leftChildldx, A.get(leftChildldx)));
			}
			Integer rightChildldx = 2 * candidateldx + 2;
			if (rightChildldx < A.size()) {
				candidateMaxHeap.add(new HeapEntry(rightChildldx, A.get(rightChildldx)));
			}
		}
		return result;
	}
}
