/**
 * 
 */
package org.leetcode.backtracking.medium.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author divyesh_surana
 *
 */
public class _46_1 {
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> numsList = IntStream.of(nums) // returns IntStream
				.boxed().collect(Collectors.toList());

		return helper(numsList);
	}

	private List<List<Integer>> helper(List<Integer> nums) {
		List<List<Integer>> result = new LinkedList<>();

		if (nums.isEmpty())
			return result;

		for (int i = 0; i < nums.size(); i++) {
			int number = nums.get(i);
			System.out.println(number);

			List<List<Integer>> perms = helper(
					Stream.concat(nums.subList(0, i).stream(), nums.subList(i + 1, nums.size()).stream())
							.collect(Collectors.toList()));

			for (List<Integer> list : perms) {
				result.add(Stream.concat(Arrays.asList(Integer.valueOf(number)).stream(), list.stream())
						.collect(Collectors.toList()));
			}

			if (result.isEmpty()) {
				result.add(Arrays.asList(Integer.valueOf(number)));
			}
		}

		return result;

	}
}
