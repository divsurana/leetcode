/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author divyeshsurana
 *
 */
public class FindClosestElements {
	// Heap approach
	public List<Integer> findClosestElements_v1(int[] arr, int k, int x) {
		List<Integer> closest = new ArrayList<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int num : arr) {
			if (heap.size() == k) {
				if (Math.abs(x - heap.peek()) == Math.abs(num - x)) {
					continue;
				}
				if (Math.abs(x - heap.peek()) > Math.abs(num - x)) {
					heap.poll();
					heap.offer(num);
				} else {
					break;
				}
			} else {
				heap.offer(num);
			}
		}

		while (!heap.isEmpty()) {
			closest.add(heap.poll());
		}

		return closest;
	}

	// Two Pointer approach
	public List<Integer> findClosestElements_v2(int[] arr, int k, int x) {
		List<Integer> closest = new ArrayList<>();
		int l = 0, r = l + k;

		while (r < arr.length) {
			if (arr[l] == arr[r] || Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
				l++;
				r++;
			} else {
				break;
			}
		}

		for (int i = l; i < r; i++) {
			closest.add(arr[i]);
		}

		return closest;
	}

	// Binary Search to find the first element in the range
	public List<Integer> findClosestElements_v3(int[] arr, int k, int x) {
		int l = 0, r = arr.length - k;

		while (l < r) {
			int m = (l + r) / 2;
			if (x - arr[m] > arr[m + k] - x) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		return Arrays.stream(arr, l, l + k).boxed().collect(Collectors.toList());
	}
}
