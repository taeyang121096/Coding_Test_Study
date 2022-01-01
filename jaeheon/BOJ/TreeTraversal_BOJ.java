import java.io.*;

public class TreeTraversal_BOJ {

	// 노드 만들기
	static class node {

		String x;
		node left;
		node right;

		public node() {
		};

		public node(String x) {
			this.x = x;
		}

	}

	// 트리 만들기
	static void searchnode(node root, String parant, String left, String right) {

		if (root == null)
			return;

		if (root.x.equals(parant)) {
			if (!left.equals(".")) {
				root.left = new node(left);
			}
			if (!right.equals(".")) {
				root.right = new node(right);
			}
		} else {
			searchnode(root.left, parant, left, right);
			searchnode(root.right, parant, left, right);
		}
	}

	static node Root = new node();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 트리 만들기
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");

			if (i == 0) {
				Root = new node(input[0]);
				if (!input[1].equals(".")) {
					Root.left = new node(input[1]);
				}
				if (!input[2].equals(".")) {
					Root.right = new node(input[2]);
				}
			} else {
				searchnode(Root, input[0], input[1], input[2]);
			}
		}

		// 전위 탐색
		preorder(Root);
		System.out.println();
		inorder(Root);
		System.out.println();
		postorder(Root);
	}

	// 전위 탐색 (루트) (왼쪽 자식) (오른쪽 자식)
	public static void preorder(node root) {
		System.out.print(root.x);
		if (root.left != null) preorder(root.left);
		if (root.right != null) preorder(root.right);
	}

	// 중위 (왼쪽 자식) (루트) (오른쪽 자식)
	public static void inorder(node root) {
		if (root.left != null) inorder(root.left);
		System.out.print(root.x);
		if (root.right != null) inorder(root.right);
	}

	// 후위 (왼쪽 자식) (오른쪽 자식) (루트)
	public static void postorder(node root) {
		if (root.left != null) postorder(root.left);
		if (root.right != null) postorder(root.right);
		System.out.print(root.x);
	}

}