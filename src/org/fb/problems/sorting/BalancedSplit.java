/**
 * 
 */
package org.fb.problems.sorting;

// Add any extra import statements you may need here
import java.util.Arrays;

/**
 * @author divyeshsurana
 *
 */
class BalancedSplit {

	// Add any helper functions you may need here

	boolean balancedSplitExists(int[] arr) {
		// Write your code here
		Arrays.sort(arr);
		int l = 0, r = arr.length - 1, lsum = 0, rsum = 0;

		while (l <= r) {
			if (lsum <= rsum) {
				while (arr[l] == arr[l + 1]) {
					lsum += arr[l++];
				}
				lsum += arr[l++];
			} else {
				while (arr[r] == arr[r - 1]) {
					rsum += arr[r--];
				}
				rsum += arr[r--];
			}
		}

		return lsum == rsum;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom.
	int test_case_number = 1;

	void check(boolean expected, boolean output) {
		boolean result = expected == output;
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			System.out.print(expected);
			System.out.print(" Your output: ");
			System.out.print(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printString(String str) {
		System.out.print("[" + str + "]");
	}

	public void run() {
		int arr_1[] = { 2, 1, 2, 5 };
		boolean expected_1 = true;
		boolean output_1 = balancedSplitExists(arr_1);
		check(expected_1, output_1);

		int arr_2[] = { 3, 6, 3, 4, 4 };
		boolean expected_2 = false;
		boolean output_2 = balancedSplitExists(arr_2);
		check(expected_2, output_2);

		int arr_3[] = { 1, 5, 7, 1 };
		boolean expected_3 = true;
		boolean output_3 = balancedSplitExists(arr_3);
		check(expected_3, output_3);

		int arr_4[] = { 12, 7, 6, 6, 6 };
		boolean expected_4 = false;
		boolean output_4 = balancedSplitExists(arr_4);
		check(expected_4, output_4);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new BalancedSplit().run();
	}
}