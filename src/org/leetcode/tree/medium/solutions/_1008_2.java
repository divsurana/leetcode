/**
 * 
 */
package org.leetcode.tree.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1008_2 {
	List<Integer> values = Arrays.asList(preorder);
    Collections.sort(values);
    int[] inorder = values.stream()
						.mapToInt(Integer::intValue)
						.toArray();
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) return root;
        int i = 1;
        while(i < preorder.length && preorder[i] < preorder[0]) {
            i++;
        }
        root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, i));
        root.right = bstFromPreorder(Arrays.copyOfRange(preorder, i, preorder.length));
        return root;
    }
}
