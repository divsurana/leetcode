import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author divyeshsurana
 *
 */
public class Math {
	private static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}

		TreeNode(int val, TreeNode odd, TreeNode even) {
			this.val = val;
			this.left = odd;
			this.right = even;
		}

		public void printPreOrder() {
			StringBuilder sb = new StringBuilder();
			Queue<TreeNode> queue = new LinkedList<>();
			Queue<String> pointers = new LinkedList<>();
			StringBuilder paddingBuilder = new StringBuilder("");
			queue.offer(this);
			pointers.offer("");
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				sb.append(paddingBuilder.toString());
				sb.append(pointers.poll());
				sb.append(node.val);
				sb.append("\n");

				paddingBuilder.append("│  ");

				String pointerForRight = "└──";
				String pointerForLeft = node.right != null ? "├──" : "└──";

				if (node.left != null) {
					queue.offer(node.left);
				}
				pointers.offer(pointerForLeft);
				if (node.right != null) {
					queue.offer(node.right);
				}
				pointers.offer(pointerForRight);
			}
			System.out.print(sb.toString());
		}

		public String traversePreOrder() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.val);

			String pointerRight = "└──";
			String pointerLeft = this.right != null ? "├──" : "└──";

			traverseNodes(sb, "", pointerLeft, this.left, this.right != null);
			traverseNodes(sb, "", pointerRight, this.right, false);

			return sb.toString();
		}

		public void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,
				boolean hasRightSibling) {
			if (node != null) {
				sb.append("\n");
				sb.append(padding);
				sb.append(pointer);
				sb.append(node.val);

				StringBuilder paddingBuilder = new StringBuilder(padding);
				if (hasRightSibling) {
					paddingBuilder.append("│  ");
				} else {
					paddingBuilder.append("   ");
				}

				String paddingForBoth = paddingBuilder.toString();
				String pointerRight = "└──";
				String pointerLeft = node.right != null ? "├──" : "└──";

				traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
				traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
			}
		}

		public void print(PrintStream os) {
			os.println(traversePreOrder());
		}
	}

	public static TreeNode generateTree(int limit) {
		Queue<TreeNode> level = new LinkedList<>();
		boolean[] reached = new boolean[limit + 1];
		TreeNode root = new TreeNode(1);
		reached[1] = true;
		root.right = new TreeNode(2);
		level.add(root.right);
		reached[2] = true;

		while (!level.isEmpty()) {
			TreeNode node = level.poll();
			if ((node.val - 1) % 3 == 0) {
				int left = (node.val - 1) / 3;
				if (reached[left]) {
					System.out.println("Cycle detected when " + node.val + " -> " + left);
				} else {
					reached[left] = true;
					node.left = new TreeNode(left);
					level.offer(node.left);
				}
			}
			if (node.val < limit / 2) {
				reached[node.val * 2] = true;
				node.right = new TreeNode(node.val * 2);
				level.offer(node.right);
			}
		}

		return root;
	}

	private static interface Math3x1 {

		public int convert(int num);

	}

	public static void generate_sequence(int start, Math3x1 eqn) {
		StringBuilder output = new StringBuilder(String.valueOf(start));
		int noOfIterations = 0;
		for (; start != 1; noOfIterations++) {
			start = eqn.convert(start);
			output.append(",").append(start);
		}
		System.out.println("No of Iterations: " + noOfIterations);
		System.out.println(output);
	}

	public static void main(String[] args) {
		generateTree(1000).print(System.out);

		Math3x1 eqn = (num) -> {
			return num % 2 == 0 ? num / 2 : num * 3 + 1;
		};
		generate_sequence(628, eqn);

		eqn = (num) -> {
			return num % 2 == 0 ? num / 2 : num * 5 - 3;
		};
		generate_sequence(628, eqn);
	}
}
