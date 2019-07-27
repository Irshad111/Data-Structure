package Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class BTree {
	Scanner sc = new Scanner(System.in);

	private class Node {
		Node left;
		Node right;
		int data;
	}

	private Node root;

	public BTree() {
		this.root = takeInput(null, false);
	}

	// ilc=is left chiled?
	private Node takeInput(Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("Enter data for root node");
		} else {
			if (ilc) {
				System.out.println("Enter data for left node of " + parent.data);

			} else {
				System.out.println("Enter data for right node of " + parent.data);
			}
		}
		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println(nn.data + "has left child ?");
		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = takeInput(nn, true);
		}
		System.out.println(nn.data + "has right child ?");
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		return nn;
	}

	public void display() {
		System.out.println("----------");
		display(this.root);
		System.out.println("----------");
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data + " <- ";
		} else {
			str += ".";
		}
		str += node.data;
		if (node.right != null) {
			str += " -> " + node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int tm = node.data;// total max
		int lm = max(node.left);
		if (lm > tm)
			tm = lm;
		int rm = max(node.right);
		if (rm > tm)
			tm = rm;
		return tm;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		boolean lc = find(node.left, item);
		if (lc) {
			return true;
		}
		boolean rc = find(node.right, item);
		if (rc) {
			return true;
		}
		return false;

	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {
		if (node == null) {
			return -1;
		}
		int lh = ht(node.left);
		int rh = ht(node.right);
		return Math.max(lh, rh) + 1;

	}

	public int diameter() {
		return diameter(this.root);
	}

	// o(n2)
	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sd = ht(node.left) + ht(node.right) + 2;

		return Math.max(sd, Math.max(ld, rd));
	}
	// for o(n)

	private class Diapair {
		int ht = -1;
		int diameter = 0;
	}

	public int diameter2() {
		return diameter2(this.root).diameter;
	}

	private Diapair diameter2(Node node) {
		if (node == null) {
			Diapair dp = new Diapair();
			return dp;
		}
		Diapair ldp = diameter2(node.left);
		Diapair rdp = diameter2(node.right);
		Diapair np = new Diapair();
		np.ht = Math.max(ldp.ht, rdp.ht) + 1;
		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sp = ldp.ht + rdp.ht + 2;
		np.diameter = Math.max(sp, Math.max(ld, rd));

		return np;
	}

	private class Balpair {
		int ht = -1;
		boolean isBal = true;
	}

	public boolean isBalanced() {
		return isBalanced(this.root).isBal;
	}

	private Balpair isBalanced(Node node) {
		if (node == null) {
			Balpair bp = new Balpair();
			return bp;
		}
		Balpair lbp = isBalanced(node.left);
		Balpair rbp = isBalanced(node.right);
		int bf = Math.abs(lbp.ht - rbp.ht);

		Balpair nn = new Balpair();
		nn.ht = Math.max(lbp.ht, rbp.ht) + 1;
		if (lbp.isBal && rbp.isBal && bf <= 1) {
			nn.isBal = true;
		} else {
			nn.isBal = false;
		}
		return nn;
	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		// node
		System.out.print(node.data + " ");

		// left
		preorder(node.left);

		// right
		preorder(node.right);

	}

	public void postorder() {
		postorder(this.root);
		System.out.println();
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		// left
		postorder(node.left);

		// right
		postorder(node.right);
		// node
		System.out.print(node.data + " ");

	}

	public void inorder() {
		inorder(this.root);
		System.out.println();
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		// left
		inorder(node.left);
		// node
		System.out.print(node.data + " ");

		// right
		inorder(node.right);

	}

	private class Pair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void preorderI() {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		sp.node = this.root;
		stack.addFirst(sp);

		while (!stack.isEmpty()) {
			Pair tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			} else if (tp.leftdone == false) {
				Pair nn = new Pair();
				nn.node = tp.node.left;
				stack.addFirst(nn);
				tp.leftdone = true;
			} else if (tp.rightdone == false) {
				Pair nn = new Pair();
				nn.node = tp.node.right;
				stack.addFirst(nn);
				tp.rightdone = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	public BTree(int[] pre, int[] in) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);

	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		for (int i = ilo; i <=ihi; i++) {
			if (pre[plo] == in[i]) {
				si = i;
				break;
			}
		}
		int noele = si - ilo;
		nn.left = construct(pre, plo + 1, plo + noele, in, ilo, si - 1);
		nn.right = construct(pre, plo + noele + 1, phi, in, si + 1, ihi);
		return nn;

	}

}
