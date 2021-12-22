/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class PerfectSquares {
	// Changing this to static makes the solution run faster but that only works
	// when we have multiple test cases as the same copy will be reused for all
	// the cases, eliminating a lot of repeated calls.
	int[] dp = new int[10001];

	// dp starting with 4 and going up towards the largest square
	public int numSquares(int n) {
		int i = 2, s = 4;
		dp[n] = n;
		while (n >= s) {
			dp[n - s] = dp[n - s] == 0 ? numSquares(n - s) : dp[n - s];
			dp[n] = Math.min(dp[n], dp[n - s] + 1);
			i++;
			s = i * i;
		}
		return dp[n];
	}

	// dp starting with subtracting the largest square first
	public int numSquares_v2(int n) {
		if (n < 4) {
			dp[n] = n;
		} else {
			int i = (int) Math.sqrt(n), s = i * i;
			dp[n] = n;
			while (i > 1) {
				dp[n - s] = dp[n - s] == 0 ? numSquares(n - s) : dp[n - s];
				dp[n] = Math.min(dp[n], dp[n - s] + 1);
				i--;
				s = i * i;
			}
		}
		return dp[n];
	}

	// Based on Lagrange's Four Square theorem, there
	// are only 4 possible results: 1, 2, 3, 4.
	public int numSquares_v3(int n) {
		// If n is a perfect square, return 1.
		if (isSquare(n)) {
			return 1;
		}

		// The result is 4 if and only if n can be written in the
		// form of 4^k*(8*m + 7). Please refer to
		// Legendre's three-square theorem.
		while (n % 4 == 0) // n & 3 == 0
		{
			n /= 4;
		}
		if (n % 8 == 7) // n & 7 == 7
		{
			return 4;
		}

		// Check whether 2 is the result.
		int sqrtN = (int) Math.sqrt(n);
		for (int i = 1; i <= sqrtN; i++) {
			if (isSquare(n - i * i)) {
				return 2;
			}
		}

		return 3;
	}

	private boolean isSquare(int n) {
		int sqrtN = (int) Math.sqrt(n);
		return sqrtN * sqrtN == n;
	}
}
