package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryNode {
	BinaryNode left;
	BinaryNode right;
	int value;
	
	public BinaryNode(int value) {
		this.value = value;
	}
	public String toString() {
		return Integer.toString(this.value);
	}
	
	public static List<BinaryNode> inorder(BinaryNode root) {
		List<BinaryNode> inorderList = new ArrayList<>();
		Stack<BinaryNode> nodesToVisit = new Stack<>();
		BinaryNode current = root;
		BinaryNode visiting = null;
		while (current != null || !nodesToVisit.isEmpty()) {
			while (current != null) {
				nodesToVisit.push(current);
				current = current.left;
			}

			visiting = nodesToVisit.pop();
			inorderList.add(visiting);
			if (visiting.right != null) {
				current = visiting.right;
			}
		}
		return inorderList;
	}
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(9);
		BinaryNode left = new BinaryNode(5);
		BinaryNode right = new BinaryNode(10);
		BinaryNode leftLeft = new BinaryNode(3);
		left.left = leftLeft;
		root.left = left;
		root.right = right;
		System.out.println(inorder(root));
	}
}
