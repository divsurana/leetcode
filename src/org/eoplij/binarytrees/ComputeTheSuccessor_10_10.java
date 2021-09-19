/**
 * 
 */
package org.eoplij.binarytrees;

/**
 * @author divyeshsurana
 *
 */
public class ComputeTheSuccessor_10_10 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode computeSuccessor(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode successor = null;
		if (node.right == null) {
			// successor one of the ancestors
			successor = node;
			while (successor.parent != null && successor.parent.right == successor) {
				successor = successor.parent;
			}
			successor = successor.parent;
		} else {
			// successor is in the right subtree
			successor = node.right;
			while (successor.left != null) {
				successor = successor.left;
			}
		}
		return successor;
	}
}
