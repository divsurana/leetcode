/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author divyesh_surana
 *
 */
public class ShortestBridge {
	public int shortestBridge(int[][] A) {
		boolean[][] visited = new boolean[A.length][A[0].length];
		Queue<int[]> queue = new LinkedList<>();
		Queue<int[]> expand = new LinkedList<>();

		findIsland(A, visited, queue);

		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];

				for (int i = 0; i < 4; i++) {
					int newR = r + directions[i][0];
					int newC = c + directions[i][1];

					if (newR >= 0 && newR < A.length && newC >= 0 && newC < A[0].length) {
						if (A[newR][newC] == 1 && !visited[newR][newC]) {
							A[newR][newC] = 2;
							visited[newR][newC] = true;
							queue.offer(new int[] { newR, newC });
						} else if (A[newR][newC] == 0 && !visited[newR][newC]) {
							A[newR][newC] = 3;
							visited[newR][newC] = true;
							expand.offer(new int[] { newR, newC });
						}
					}
				}
			}
		}

		int bridgeLength;
		for (bridgeLength = 4; !expand.isEmpty(); bridgeLength++) {
			int size = expand.size();

			while (size-- > 0) {
				int[] curr = expand.poll();
				int r = curr[0];
				int c = curr[1];

				for (int i = 0; i < 4; i++) {
					int newR = r + directions[i][0];
					int newC = c + directions[i][1];

					if (newR >= 0 && newR < A.length && newC >= 0 && newC < A[0].length) {
						if (A[newR][newC] == 0 && !visited[newR][newC]) {
							A[newR][newC] = bridgeLength;
							visited[newR][newC] = true;
							expand.offer(new int[] { newR, newC });
						} else if (A[newR][newC] == 1 && !visited[newR][newC]) {
							return bridgeLength - 3;
						}
					}
				}
			}
		}

		return 1;
	}

	/**
	 * @param A
	 * @param visited
	 * @param queue
	 */
	private void findIsland(int[][] A, boolean[][] visited, Queue<int[]> queue) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 1) {
					A[i][j] = 2;
					visited[i][j] = true;
					queue.offer(new int[] { i, j });
					return;
				}
			}
		}
	}
}
