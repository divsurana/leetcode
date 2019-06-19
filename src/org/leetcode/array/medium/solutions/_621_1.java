/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author divyesh_surana
 *
 */
public class _621_1 {
	char[] tasks;
	String task;
	List<Character> taskList = tasks.toString().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
}
