/**
 * 
 */
package org.fb.problems.search;

//Add any extra import statements you may need here
/**
 * @author divyeshsurana
 *
 */
public class RevenueMilestones {

	// Add any helper functions you may need here
	int binarySearch(int[] revenues, int milestone) {
		int l = 0, r = revenues.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (revenues[mid] == milestone) {
				l = mid;
				break;
			}
			if (revenues[mid] > milestone) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return l == revenues.length ? -1 : l + 1;
	}

	int[] getMilestoneDays(int[] revenues, int[] milestones) {
		// Write your code here
		int[] reached = new int[milestones.length];

		for (int i = 1; i < revenues.length; i++) {
			revenues[i] += revenues[i - 1];
		}

		for (int i = 0; i < reached.length; i++) {
			reached[i] = binarySearch(revenues, milestones[i]);
		}

		return reached;
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom.
	int test_case_number = 1;

	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= output[i] == expected[i];
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	public void run() {
		int revenues_1[] = { 100, 200, 300, 400, 500 };
		int milestones_1[] = { 300, 800, 1000, 1400 };
		int expected_1[] = { 2, 4, 4, 5 };
		int[] output_1 = getMilestoneDays(revenues_1, milestones_1);
		check(expected_1, output_1);

		int revenues_2[] = { 700, 800, 600, 400, 600, 700 };
		int milestones_2[] = { 100, 2200, 800, 2100, 10000 };
		int expected_2[] = { 1, 4, 2, 3, -1 };
		int[] output_2 = getMilestoneDays(revenues_2, milestones_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new RevenueMilestones().run();
	}
}