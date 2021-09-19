/**
 * 
 */
package org.fb.problems.arrays;

/**
 * @author divyeshsurana
 *
 */
public class ReverseToMakeEqual {

	// Add any helper functions you may need here

	boolean areTheyEqual(int[] a, int[] b) {
		// Write your code here
		int start_a = 0, start_b = 0;
		while (start_a < a.length && start_b < b.length && a[start_a] == b[start_b]) {
			start_a++;
			start_b++;
		}
		if (start_a == a.length) {
			return true;
		}

		int end_a = a.length - 1, end_b = b.length - 1;
		while (end_a >= 0 && end_b >= 0 && a[end_a] == b[end_b]) {
			end_a--;
			end_b--;
		}

		while (start_a < end_a && start_b < end_b && a[start_a] == b[end_b] && a[end_a] == b[start_b]) {
			start_a++;
			start_b++;
			end_a--;
			end_b--;
		}

		return a[start_a] == b[end_b] && a[end_a] == b[start_b];
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

	public void run() {
		int[] array_a_1 = { 1, 2, 3, 4 };
		int[] array_b_1 = { 1, 4, 3, 2 };
		boolean expected_1 = true;
		boolean output_1 = areTheyEqual(array_a_1, array_b_1);
		check(expected_1, output_1);

		int[] array_a_2 = { 1, 2, 3, 4 };
		int[] array_b_2 = { 1, 4, 3, 3 };
		boolean expected_2 = false;
		boolean output_2 = areTheyEqual(array_a_2, array_b_2);
		check(expected_2, output_2);
		// Add your own test cases here

	}

	public static void main(String[] args) {
		new ReverseToMakeEqual().run();
	}
}
