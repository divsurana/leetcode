/**
 * 
 */
package org.leetcode.bitmanipulation.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class XORQueriesOfASubArray {
	// Can be done in a better way by using understanding xor rules
	public int[] xorQueries_v1(int[] arr, int[][] queries) {
		int[] result = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			for (int j = query[0]; j <= query[1]; j++) {
				result[i] ^= arr[j];
			}
		}

		return result;
	}

	public int[] xorQueries_v2(int[] arr, int[][] queries) {
		int[] result = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				result[i] ^= arr[j];
			}
		}

		return result;
	}

	// dp approach and using the property of xor that A ^ B ^ A = B or B ^ 0 = B
	public int[] xorQueries_v3(int[] arr, int[][] queries) {
		int[] result = new int[queries.length];
		int[] dp = new int[arr.length + 1];
		dp[0] = 0;
		for (int i = 1; i <= arr.length; i++) {
			dp[i] = arr[i - 1] ^ dp[i - 1];
		}

		for (int i = 0; i < queries.length; i++) {
			result[i] = dp[queries[i][1] + 1] ^ dp[queries[i][0]];
		}

		return result;
	}
}
