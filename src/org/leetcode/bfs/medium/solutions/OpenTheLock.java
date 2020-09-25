/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author divyesh_surana
 *
 */
public class OpenTheLock {
	public int openLock_v1(String[] deadends, String target) {
		if (Arrays.asList(deadends).contains(target) || Arrays.asList(deadends).contains("0000")) {
			return -1;
		}
		if (target.equals("0000")) {
			return 0;
		}

		List<String> deadEndList = Arrays.asList(deadends);
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer("0000");
		int moves = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();
			while (size-- > 0) {
				String start = queue.poll();

				for (int i = 0; i < 4; i++) {
					char[] charArray = start.toCharArray();
					int num = Character.getNumericValue(charArray[i]);
					charArray[i] = Character.forDigit(Math.floorMod(num + 1, 10), 10);
					String newStart = new String(charArray);
					if (newStart.equals(target)) {
						return moves + 1;
					}

					if (!(deadEndList.contains(newStart) || visited.contains(newStart))) {
						queue.offer(newStart);
					}
					visited.add(newStart);

					charArray[i] = Character.forDigit(Math.floorMod(num - 1, 10), 10);
					newStart = new String(charArray);
					if (newStart.equals(target)) {
						return moves + 1;
					}

					if (!(deadEndList.contains(newStart) || visited.contains(newStart))) {
						queue.offer(newStart);
					}
					visited.add(newStart);
				}
			}

			moves++;
		}

		return -1;
	}

	public int openLock_v3(String[] deadends, String target) {
		if (target.equals("0000")) {
			return 0;
		}
		Set<String> deadendSet = new HashSet<>();
		for (String deadend : deadends) {
			deadendSet.add(deadend);
		}
		if (deadendSet.contains("0000")) {
			return -1;
		}
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer("0000");
		int moves = 0;

		while (!queue.isEmpty()) {

			int size = queue.size();
			while (size-- > 0) {
				String start = queue.poll();

				for (int i = 0; i < 4; i++) {
					char[] charArray = start.toCharArray();
					int num = Character.getNumericValue(charArray[i]);
					charArray[i] = Character.forDigit(Math.floorMod(num + 1, 10), 10);
					String newStart = new String(charArray);
					if (newStart.equals(target)) {
						return moves + 1;
					}

					if (!(deadendSet.contains(newStart) || visited.contains(newStart))) {
						queue.offer(newStart);
					}
					visited.add(newStart);

					charArray[i] = Character.forDigit(Math.floorMod(num - 1, 10), 10);
					newStart = new String(charArray);
					if (newStart.equals(target)) {
						return moves + 1;
					}

					if (!(deadendSet.contains(newStart) || visited.contains(newStart))) {
						queue.offer(newStart);
					}
					visited.add(newStart);
				}
			}

			moves++;
		}

		return -1;
	}

	public int openLock_v2(String[] deadends, String target) {
		if (Arrays.asList(deadends).contains(target) || Arrays.asList(deadends).contains("0000")) {
			return -1;
		}
		if (target.equals("0000")) {
			return 0;
		}

		Set<String> visited = new HashSet<>(Arrays.asList(deadends));
		Set<String> begin = new HashSet<>();
		Set<String> end = new HashSet<>();
		begin.add("0000");
		end.add(target);
		int moves = 0;

		while (!begin.isEmpty() && !end.isEmpty()) {
			Set<String> transition = new HashSet<>();
			visited.addAll(begin);

			for (String start : begin) {
				System.out.println("start " + start);
				for (int i = 0; i < 4; i++) {

					String s1 = nextTransition(visited, transition, start, i, 1);
					String s2 = nextTransition(visited, transition, start, i, -1);

					if (s1 != null && end.contains(s1) || s2 != null && end.contains(s2)) {
						return moves + 1;
					}
				}
			}

			moves++;
			if (transition.size() > end.size()) {
				begin = end;
				end = transition;
			} else {
				begin = transition;
			}
		}

		return -1;
	}

	/**
	 * @param visited
	 * @param transition
	 * @param start
	 * @param i
	 * @param change
	 */
	private String nextTransition(Set<String> visited, Set<String> transition, String start, int i, int change) {
		int num = Character.getNumericValue(start.toCharArray()[i]);
		StringBuilder sb = new StringBuilder();

		String newStart = sb.append(start.substring(0, i)).append(Math.floorMod(num + change, 10))
				.append(start.substring(i + 1, 4)).toString();

		if (!visited.contains(newStart)) {
			transition.add(newStart);
			return newStart;
		}
		return null;
	}
}
