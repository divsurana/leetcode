/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyesh_surana
 *
 */
public class _54_2 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> numbers = new ArrayList<>();

		if (matrix.length > 0) {
			int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
			boolean[][] visited = new boolean[matrix.length][matrix[0].length];

			int directionIndex = 0;
			int i = 0;
			int j = 0;
			int[] direction = directions[directionIndex];
			int counter = matrix.length * matrix[0].length;

			while (counter > 0) {
				counter--;
				numbers.add(matrix[i][j]);
				visited[i][j] = true;
				i = i + direction[0];
				j = j + direction[1];
				if (i < 0 || i >= visited.length || j < 0 || j >= visited[i].length || visited[i][j]) {
					i = i - direction[0];
					j = j - direction[1];
					directionIndex = ++directionIndex % directions.length;
					direction = directions[directionIndex];
					i = i + direction[0];
					j = j + direction[1];
				}

			}

		}

		return numbers;
	}
}