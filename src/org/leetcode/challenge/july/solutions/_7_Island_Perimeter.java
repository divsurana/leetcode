/**
 * 
 */
package org.leetcode.challenge.july.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _7_Island_Perimeter {
	int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					for (int[] dir : directions) {
						int r = i + dir[0];
						int c = j + dir[1];
						if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 1)
							perimeter--;
					}
					perimeter += 4;
				}
			}
		}
		return perimeter;
	}

	// floodFill is slower
	public int islandPerimeter_v2(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					return floodFill(grid, i, j, 0);
				}
			}
		}
		return 0;
	}

	private int floodFill(int[][] grid, int r, int c, int perimeter) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0)
			return perimeter + 1;
		if (grid[r][c] == 2)
			return perimeter;
		grid[r][c] = 2;
		for (int[] dir : directions) {
			perimeter = floodFill(grid, r + dir[0], c + dir[1], perimeter);
		}
		return perimeter;
	}

	// fastest
	public int islandPerimeter_v3(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					perimeter += 4;
					// check for only the previous neighbors and decrease the perimeter on their and
					// the current cell behalf, hence -2
					if (i > 0 && grid[i - 1][j] == 1)
						perimeter -= 2;
					if (j > 0 && grid[i][j - 1] == 1)
						perimeter -= 2;
				}
			}
		}
		return perimeter;
	}
}
