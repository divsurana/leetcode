/**
 * 
 */
package org.leetcode.common;

import java.util.List;

/**
 * Definition for a Node.
 * 
 * @author divyesh_surana
 *
 */
public class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}

}