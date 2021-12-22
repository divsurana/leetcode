/**
 * 
 */
package org.eoplij.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author divyeshsurana
 *
 */
public class PaintAMatrix_19_2 {
	final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	// Leetcode solution using an integer 2D array
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		helper(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	public void helper(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor
				|| image[sr][sc] == newColor) {
			return;
		}
		image[sr][sc] = newColor;
		for (int[] d : DIRS) {
			helper(image, sr + d[0], sc + d[1], newColor, oldColor);
		}
	}

	// Book solution using a boolean matrix and adjacency list
	private static class Coordinate {
		public Integer x;
		public Integer y;

		public Coordinate(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}
	}

	public void flipColor_itr(List<List<Boolean>> A, int x, int y) {
		boolean color = A.get(x).get(y);
		Queue<Coordinate> q = new LinkedList<>();
		A.get(x).set(y, !A.get(x).get(y)); // Flips.
		q.add(new Coordinate(x, y));
		while (!q.isEmpty()) {
			Coordinate curr = q.element();
			for (int[] dir : DIRS) {
				Coordinate next = new Coordinate(curr.x + dir[0], curr.y + dir[1]);
				if (next.x >= 0 && next.x < A.size() && next.y >= 0 && next.y < A.get(next.x).size()
						&& A.get(next.x).get(next.y) == color) {
					// Flips the color.
					A.get(next.x).set(next.y, !color);
					q.add(next);
				}
			}
			q.remove();
		}
	}

	// Recursive solution similar to the solution above
	public void flipColor(List<List<Boolean>> A, int x, int y) {
		boolean color = A.get(x).get(y);
		A.get(x).set(y, !color); // Flips.
		for (int[] dir : DIRS) {
			int nextX = x + dir[0], nextY = y + dir[1];
			if (nextX >= 0 && nextX < A.size() && nextY >= 0 && nextY < A.get(nextX).size()
					&& A.get(nextX).get(nextY) == color) {
				flipColor(A, nextX, nextY);
			}
		}
	}
}
