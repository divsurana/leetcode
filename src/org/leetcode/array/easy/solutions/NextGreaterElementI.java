/**
 * 
 */
package org.leetcode.array.easy.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author divyeshsurana
 *
 */
public class NextGreaterElementI {
	// Using HashTable and Heap
	public int[] nextGreaterElement_v1(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Arrays.fill(res, -1);
		Map<Integer, Integer> mapping = new HashMap<>();

		for (int i = 0; i < nums1.length; i++) {
			mapping.put(nums1[i], i);
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int num : nums2) {
			if (mapping.containsKey(num)) {
				minHeap.offer(num);
			}
			while (!minHeap.isEmpty() && num > minHeap.peek()) {
				res[mapping.get(minHeap.poll())] = num;
			}
		}

		return res;
	}

	// Using HashTable and Monostack (Linear time)
	public int[] nextGreaterElement_v2(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Map<Integer, Integer> nextGreatest = new HashMap<>();
		Stack<Integer> monostack = new Stack<>();

		for (int num : nums2) {
			while (!monostack.isEmpty() && num > monostack.peek()) {
				nextGreatest.put(monostack.pop(), num);
			}
			monostack.push(num);
		}

		for (int i = 0; i < nums1.length; i++) {
			res[i] = nextGreatest.getOrDefault(nums1[i], -1);
		}

		return res;
	}
}
