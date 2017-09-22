package Trees;

import java.util.List;

public class BSTNode {
	BSTNode left;
	BSTNode right;
	BSTNode parent;
	int data;
	public BSTNode(int data) {
		this.data = data;
	}
	public BSTNode insert(int data) {
		if (data <= this.data) {
			if (this.left == null) {
				this.left = new BSTNode(data);
				this.left.parent = this;
				return this.left;
			}
			else {
				return this.left.insert(data);
			}
		}
		if (data > this.data) {
			if (this.right == null) {
				this.right = new BSTNode(data);
				this.right.parent = this;
				return this.right;
			}
			else {
				return this.right.insert(data);
			}
		}
		return null;
	}
	public BSTNode search(int data) {
		if (data == this.data) {
			return this;
		}
		if (data < this.data) {
			if (this.left != null) {
				return left.search(data);
			}
		}
		if (data > this.data) {
			if (this.right != null) {
				return right.search(data);
			}
		}
		return null;
	}
	public BSTNode findMin() {
		if (this.left != null) {
			return left.findMin();
		}
		return this;
	}
	public void buildPreorderList(List<BSTNode> nodes) {
		nodes.add(this);
		if (this.left != null) {
			this.left.buildPreorderList(nodes);
		}
		if (this.right != null) {
			this.right.buildPreorderList(nodes);
		}
	}
	public void delete(int data) {
		if (data == this.data) {
			if (this.parent == null && this.left == null && this.right == null) {
				return;
			}
			if (this.left == null) {
				if (this.parent != null && this.parent.left == this) {
					this.parent.left = this.right;
				}
				if (this.parent != null && this.parent.right == this) {
					this.parent.right = this.right;
				}
				if (this.right != null) {
					this.right.parent = this.parent;
				}
				return;
			}
			if (this.right == null) {
				if (this.parent != null && this.parent.right == this) {
					this.parent.right = this.left;
					
				}
				if (this.parent != null && this.parent.left == this) {
					this.parent.left = this.left;
				}
				if (this.left != null) {
					this.left.parent = this.parent;
				}
				return;
			}
			BSTNode min = this.right.findMin();
			this.data = min.data;
			right.delete(this.data);
			return;
		}
		if (data < this.data) {
			left.delete(data);
		}
		if (data > this.data) {
			right.delete(data);
		}
	}	
}
