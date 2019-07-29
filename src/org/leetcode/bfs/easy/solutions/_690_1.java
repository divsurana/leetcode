/**
 * 
 */
package org.leetcode.bfs.easy.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.leetcode.common.Employee;

/**
 * @author divyesh_surana
 *
 */
public class _690_1 {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> mapping = new HashMap<>();
		Queue<Employee> queue = new LinkedList<>();
		int importance = 0;

		for (Employee emp : employees) {
			mapping.put(emp.id, emp);
		}
		queue.offer(mapping.get(id));

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Employee curr = queue.poll();
				importance += curr.importance;
				for (int subordinate : curr.subordinates) {
					queue.offer(mapping.get(subordinate));
				}
			}
		}

		return importance;
	}
}
