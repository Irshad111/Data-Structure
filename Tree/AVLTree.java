package Tree;

public class AVLTree {
	private class Node {
		int data;
		int height;
		Node left;
		Node right;

		Node(int item) {
			this.data = item;
			this.height = 1;
		}

	}

	private Node root;

	public void insert(int item) {
		this.root = insert(this.root, item);
	}

	private Node insert(Node node, int item) {
		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}
		if (node.data >= item) {
			node.left = insert(node.left, item);
		} else {
			node.right = insert(node.right, item);
		}
		
		node.height=Math.max(ht(node.left),ht(node.right))+1;
		
		int bf=bf(node);
		
		//LL case
		if(bf>1 && item<node.left.data) {
			return rightRotate(node);
		}
		
		//RR
		if(bf<-1 && item>node.right.data) {
			return leftRotate(node);
		}
		
		//LR
		if(bf>1 && item>node.left.data) {
			node.left=leftRotate(node.left);
			return rightRotate(node);
		}
		
		//RL case
		if(bf<-1 && item<node.right.data) {
			node.right=rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	
	private int bf(Node node) {
		if(node==null) {
			return 0;
		}
		return (ht(node.left)-ht(node.right));
	}

	private int ht(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	private Node rightRotate(Node c) {
		// value capture
		Node b = c.left;
		Node t3 = b.right;

		// after rotate value update
		b.right = c;
		c.left = t3;

		// height update
		c.height = Math.max(ht(c.left), ht(c.right)) + 1;
		b.height = Math.max(ht(b.left), ht(b.right)) + 1;

		return b;
	}
	private Node leftRotate(Node c) {
		// value capture
		Node b = c.right;
		Node t2 = b.left;

		// after rotate value update
		b.left = c;
		c.right = t2;

		// height update
		c.height = Math.max(ht(c.left), ht(c.right)) + 1;
		b.height = Math.max(ht(b.left), ht(b.right)) + 1;

		return b;
	}
	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;

		}
		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}
		str += ">=" + node.data + ">=";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

}
