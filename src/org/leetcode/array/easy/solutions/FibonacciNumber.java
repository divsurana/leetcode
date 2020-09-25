/**
 * 
 */
package org.leetcode.array.easy.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class FibonacciNumber {
	private static Map<Integer, Integer> memo = new HashMap<>();
	static {
		memo.put(0, 0); // fibonacci(0)
		memo.put(1, 1); // fibonacci(1)
	}

	// Using map T = O(n) S = O(n)
	public int fib_v1(int N) {
		return memo.computeIfAbsent(N, n -> fib_v1(n - 2) + fib_v1(n - 1));
	}

	// Using array and recursion T = O(n) S = O(n)
	public int fib_v2(int N) {
		if (N == 0 || N == 1) {
			return N;
		}
		int[] arr = new int[N + 1];
		arr[1] = 1;
		helper(arr, N);
		return arr[N];
	}

	private void helper(int[] arr, int N) {
		if (N == 0 || N == 1 || arr[N] != 0) {
			return;
		}
		helper(arr, N - 1);
		helper(arr, N - 2);
		arr[N] = arr[N - 1] + arr[N - 2];
	}

	// Using array and iterative T = O(n) S = O(n)
	public int fib_v3(int N) {
		if (N == 0 || N == 1) {
			return N;
		}
		int[] arr = new int[N + 1];
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[N];
	}

	// Using variables to store past 2 results T = O(n) S = O(1)
	public int fib_v4(int N) {
		if (N <= 1) {
			return N;
		}
		int a = 0, b = 1;
		while (N-- > 1) {
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
}
