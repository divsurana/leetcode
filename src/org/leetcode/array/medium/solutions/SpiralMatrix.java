/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder_v1(int[][] matrix) {
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

	public List<Integer> spiralOrder_v2(int[][] matrix) {
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

	public List<Integer> spiralOrder_v3(int[][] matrix) {
		if (matrix.length == 0) {
			return new ArrayList<>();
		}
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int r = matrix.length;
		int c = matrix[0].length;
		int counter = r * c;

		List<Integer> result = new ArrayList<>(counter);

		int i = 0, j = 0, d = 0, i_ll = 0, i_ul = r, j_ll = 0, j_ul = c;
		while (counter > 0) {
			for (; i >= i_ll && i < i_ul && j >= j_ll && j < j_ul
					&& counter > 0; i += direction[d][0], j += direction[d][1]) {
				result.add(matrix[i][j]);
				counter--;
			}
			if (i == i_ll) {
				i_ll += 1;
			} else if (i == i_ul - 1) {
				i_ul = i;
			}
			if (j == j_ll) {
				j_ll += 1;
			} else if (j == j_ul - 1) {
				j_ul = j;
			}
			i -= direction[d][0];
			j -= direction[d][1];
			d = (d + 1) % 4;
			i += direction[d][0];
			j += direction[d][1];
		}

		return result;
	}

	public List<Integer> spiralOrder_v4(int[][] matrix) {
		List<Integer> result = new LinkedList<>();
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int d = 0, i = 0, j = 0, m = matrix.length, n = matrix[0].length;
		int count = m * n;

		while (count > 0) {
			result.add(matrix[i][j]);
			matrix[i][j] = 0;
			i += directions[d][0];
			j += directions[d][1];
			if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == 0) {
				i -= directions[d][0];
				j -= directions[d][1];
				d = (d + 1) % 4;
				i += directions[d][0];
				j += directions[d][1];
			}
			count--;
		}

		return result;
	}
}
