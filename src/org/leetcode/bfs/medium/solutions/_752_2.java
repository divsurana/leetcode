/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author divyesh_surana
 *
 */
public class _752_2 {
	public int openLock(String[] deadends, String target) {
		if (Arrays.asList(deadends).contains(target) || Arrays.asList(deadends).contains("0000"))
			return -1;
		if (target.equals("0000"))
			return 0;

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
				for (int i = 0; i < 4; i++) {
					int num = Character.getNumericValue(start.toCharArray()[i]);
					StringBuilder sb = new StringBuilder();

					String newStart = sb.append(start.substring(0, i)).append(Math.floorMod(num + 1, 10))
							.append(start.substring(i + 1, 4)).toString();
					if (end.contains(newStart))
						return moves + 1;
					if (!visited.contains(newStart))
						transition.add(newStart);

					sb = new StringBuilder();

					newStart = sb.append(start.substring(0, i)).append(Math.floorMod(num - 1, 10))
							.append(start.substring(i + 1, 4)).toString();
					if (end.contains(newStart))
						return moves + 1;
					if (!visited.contains(newStart))
						transition.add(newStart);
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
}
