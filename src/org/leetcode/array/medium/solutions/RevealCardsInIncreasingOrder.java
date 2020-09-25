/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author divyesh_surana
 *
 */
public class RevealCardsInIncreasingOrder {
	// Better space complexity
	public int[] deckRevealedIncreasing_v1(int[] deck) {
		int[] result = new int[deck.length];
		boolean add = true;
		Arrays.sort(deck);
		int index = 0;

		for (int i = 0; i < deck.length; i++) {
			boolean notAdded = true;

			while (notAdded) {
				if (result[index] == 0) {
					if (add) {
						result[index] = deck[i];
						add = false;
						notAdded = false;
					} else {
						add = true;
					}
				}
				index = (index + 1) % deck.length;
			}

		}

		return result;
	}

	// Better use of data structure
	public int[] deckRevealedIncreasing_v2(int[] deck) {
		int n = deck.length;
		int[] result = new int[n];
		Arrays.sort(deck);

		Queue<Integer> indices = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			indices.add(i);
		}

		for (int i = 0; i < n; i++) {
			result[indices.poll()] = deck[i];
			indices.offer(indices.poll());
		}

		return result;
	}

	// Slower because of 2 queues. Better to use another primitive array than 2
	// queues.
	public int[] deckRevealedIncreasing_v3(int[] deck) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		Queue<Integer> indices = new LinkedList<>();

		for (int i = 0; i < deck.length; i++) {
			queue.offer(deck[i]);
			indices.offer(i);
		}

		while (!queue.isEmpty()) {
			deck[indices.poll()] = queue.poll();
			indices.offer(indices.poll());
		}

		return deck;
	}
}
