package Trees;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BSTNodeTest {

	@Test
	public void insert() {
		BSTTree tree = new BSTTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(1);
		tree.insert(8);
		tree.insert(10);
		tree.insert(6);
		List<BSTNode> nodes = new LinkedList<>();
		tree.buildPreorderList(nodes);
		System.out.println(nodes);
		tree.delete(8);
		nodes = new LinkedList<>();
		tree.buildPreorderList(nodes);
		System.out.println(nodes);
	}
}
