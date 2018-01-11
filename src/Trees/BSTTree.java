package Trees;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public boolean isBalanced() {
		Set<Integer> heights = new HashSet<>();
		root.returnHeights(heights, 0);
		if (heights.isEmpty()) {
			return true;
		}
		return (heights.size() <= 2 && 
				(heights.stream().max(Integer::compare).get() - 
						heights.stream().min(Integer::compare).get() < 2));
	}
}
