/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int area = floodFill(grid, i, j);
					maxArea = Math.max(area, maxArea);
				}
			}
		}
		return maxArea;
	}

	private int floodFill(int[][] grid, int i, int j) {
		int area = 0;
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0) {
			return area;
		}
		area++;
		grid[i][j] = 0;
		area += floodFill(grid, i - 1, j);
		area += floodFill(grid, i, j - 1);
		area += floodFill(grid, i + 1, j);
		area += floodFill(grid, i, j + 1);

		return area;
	}
}
