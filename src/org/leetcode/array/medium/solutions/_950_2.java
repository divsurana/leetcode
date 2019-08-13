/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author divyesh_surana
 *
 */
public class _950_2 {
	public int[] deckRevealedIncreasing(int[] deck) {
		int n = deck.length;
		int[] result = new int[n];
		Arrays.sort(deck);

		Queue<Integer> indices = new LinkedList<>();
		for (int i = 0; i < n; i++)
			indices.add(i);

		for (int i = 0; i < n; i++) {
			result[indices.poll()] = deck[i];
			indices.offer(indices.poll());
		}

		return result;
	}
}
