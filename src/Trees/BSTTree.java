package Trees;

import java.util.List;

public class BSTTree {
	BSTNode root;
	public void insert(int data) {
		if (root != null) {
			root.insert(data);
			return;
		}
		root = new BSTNode(data);
	}
	public void delete(int data) {
		if (root.data == data && root.left == null && root.right == null) {
			root = null;
			return;
		}
		root.delete(data);
	}
	public void buildPreorderList(List<BSTNode> nodes) {
		if (root != null) {
			root.buildPreorderList(nodes);
		}
	}
}
