/**
 * 
 */
package org.leetcode.sort.medium.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author divyesh_surana
 *
 */
public class _1329_2 {
	public int[][] diagonalSort(int[][] mat) {

		// Approach using PriorityQueue to sort the values in the diagonals and then
		// poll them out to have the diagonal sorted.
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		int m = mat.length;
		int n = mat[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map.putIfAbsent(i - j, new PriorityQueue<Integer>());
				map.get(i - j).add(mat[i][j]);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = map.get(i - j).poll();
			}
		}

		return mat;
	}
}
