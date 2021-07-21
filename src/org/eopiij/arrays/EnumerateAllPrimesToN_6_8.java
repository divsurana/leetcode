/**
 * 
 */
package org.eopiij.arrays;

import java.util.Arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 204. Count Primes -
// https://leetcode.com/problems/count-primes/
public class EnumerateAllPrimesToN_6_8 {
	public int countPrimes_v1(int n) {
		if (n < 2) {
			return 0;
		}
		int count = 0;
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				// Here just add it to an array if you need to return
				// the primes instead of the count
				count++;
				for (int multiple = i + i; multiple <= n; multiple += i) {
					isPrime[multiple] = false;
				}
			}
		}

		return count;
	}

	// Finding composite numbers only after n ^ 2 since all the multiples of n
	// of form kn with k < n have already been found.
	public int countPrimes_v2(int n) {
		if (n < 2) {
			return 0;
		}
		int count = 0;
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				// Here just add it to an array if you need to return
				// the primes instead of the count
				count++;
				for (long multiple = (long) i * i; multiple <= n; multiple += i) {
					isPrime[(int) multiple] = false;
				}
			}
		}

		return count;
	}
}
