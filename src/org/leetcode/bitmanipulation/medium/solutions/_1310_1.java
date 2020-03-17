/**
 * 
 */
package org.leetcode.bitmanipulation.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1310_1 {
	// Can be done in a better way by using understanding xor rules
	public int[] xorQueries(int[] arr, int[][] queries) {
		int[] result = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			for (int j = query[0]; j <= query[1]; j++) {
				result[i] ^= arr[j];
			}
		}

		return result;
	}
}
