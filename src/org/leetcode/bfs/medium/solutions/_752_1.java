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
public class _752_1 {
	public int openLock(String[] deadends, String target) {
		if (Arrays.asList(deadends).contains(target) || Arrays.asList(deadends).contains("0000"))
			return -1;
		if (target.equals("0000"))
			return 0;

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
					if (newStart.equals(target))
						return moves + 1;

					if (!(deadEndList.contains(newStart) || visited.contains(newStart)))
						queue.offer(newStart);
					visited.add(newStart);

					charArray[i] = Character.forDigit(Math.floorMod(num - 1, 10), 10);
					newStart = new String(charArray);
					if (newStart.equals(target))
						return moves + 1;

					if (!(deadEndList.contains(newStart) || visited.contains(newStart)))
						queue.offer(newStart);
					visited.add(newStart);
				}
			}

			moves++;
		}

		return -1;
	}
}
