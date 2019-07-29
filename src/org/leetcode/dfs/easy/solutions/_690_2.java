/**
 * 
 */
package org.leetcode.dfs.easy.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.leetcode.common.Employee;

/**
 * @author divyesh_surana
 *
 */
public class _690_2 {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}
		return getImportanceHelper(map, id);
	}

	private int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
		Employee root = map.get(rootId);
		int total = root.importance;
		for (int subordinate : root.subordinates) {
			total += getImportanceHelper(map, subordinate);
		}
		return total;
	}
}
