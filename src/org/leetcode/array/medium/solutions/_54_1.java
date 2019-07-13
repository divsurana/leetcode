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
public class _54_1 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> numbers = new ArrayList<>();

		if (matrix.length > 0) {
			String[] directions = { "right", "down", "left", "up" };
			boolean[][] visited = new boolean[matrix.length][matrix[0].length];

			int directionIndex = 0;
			int i = 0;
			int j = 0;
			String direction = directions[directionIndex];

			while (direction != null) {
				switch (direction) {
				case "right":
					while (j < matrix[i].length && !visited[i][j]) {
						numbers.add(matrix[i][j]);
						visited[i][j] = true;
						j++;
					}
					j--;
					i++;
					if (directionIndex + 1 < directions.length) {
						direction = directions[++directionIndex];
					} else {
						directionIndex = 0;
						direction = directions[directionIndex];
					}
					break;
				case "down":
					while (i < matrix.length && !visited[i][j]) {
						numbers.add(matrix[i][j]);
						visited[i][j] = true;
						i++;
					}
					i--;
					j--;
					if (directionIndex + 1 < directions.length) {
						direction = directions[++directionIndex];
					} else {
						directionIndex = 0;
						direction = directions[directionIndex];
					}
					break;
				case "left":
					while (j >= 0 && !visited[i][j]) {
						numbers.add(matrix[i][j]);
						visited[i][j] = true;
						j--;
					}
					j++;
					i--;
					if (directionIndex + 1 < directions.length) {
						direction = directions[++directionIndex];
					} else {
						directionIndex = 0;
						direction = directions[directionIndex];
					}
					break;
				case "up":
					while (i >= 0 && !visited[i][j]) {
						numbers.add(matrix[i][j]);
						visited[i][j] = true;
						i--;
					}
					i++;
					j++;
					if (directionIndex + 1 < directions.length) {
						direction = directions[++directionIndex];
					} else {
						directionIndex = 0;
						direction = directions[directionIndex];
					}
					break;

				}
				if (i < 0 || i >= visited.length || j < 0 || j >= visited[i].length || visited[i][j]) {
					direction = null;
				}

			}
		}

		return numbers;
	}
}