/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class NumberOfIslands {
	public int numIslands_1(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int n = grid.length;
		int m = grid[0].length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					floodFill(grid, i, j, n, m);
					++count;
				}
			}
		}
		return count;
	}

	void floodFill(char[][] grid, int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '0';
		floodFill(grid, i + 1, j, n, m); // then i can either go south
		floodFill(grid, i - 1, j, n, m); // or north
		floodFill(grid, i, j + 1, n, m); // or east
		floodFill(grid, i, j - 1, n, m); // or west
	}
	
	public int numIslands_2(char[][] grid) {
        int num = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    floodFill(grid, i, j);
                    num++;
                }
            }
        }
        
        return num;
    }
    
    private void floodFill(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        floodFill(grid, i + 1, j);
        floodFill(grid, i, j + 1);
        floodFill(grid, i - 1, j);
        floodFill(grid, i, j - 1);
    }
}
