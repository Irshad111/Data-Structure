package Tree;

public class SegmentTree {

	private class Node {
		int data;
		int startinterval;
		int endinterval;
		Node left;
		Node right;
	}

	private Node root;

	public SegmentTree(int arr[]) {
		this.root = construct(arr, 0, arr.length - 1);

	}

	private Node construct(int[] arr, int si, int ei) {
		if (si == ei) {
			Node leafnode = new Node();
			leafnode.data = arr[si];
			leafnode.startinterval = si;
			leafnode.endinterval = ei;
			return leafnode;
		}

		Node nn = new Node();
		nn.startinterval = si;
		nn.endinterval = ei;

		int mid = (si + ei) / 2;
		nn.left = construct(arr, si, mid);
		nn.right = construct(arr, mid + 1, ei);
		nn.data = nn.left.data + nn.right.data;
		return nn;
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
			str += "[" + node.left.startinterval + "," + node.left.endinterval + "] " + node.left.data;
		}
		str += " <=" + "[" + node.startinterval + "," + node.endinterval + "] " + node.data + "=> ";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data + " [" + node.right.startinterval + "," + node.right.endinterval + "]";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int query(int si, int ei) {
		return this.query(this.root, si, ei);
	}

	private int query(Node node, int si, int ei) {
		// node interval completly outside -ve case
		if (si > node.endinterval || ei < node.startinterval) {
			return 0;
		} // node interval inside in query interval
		else if (si <=node.startinterval && ei >=node.endinterval) {
			return node.data;
		} else {// overlapping
			int lc = query(node.left, si, ei);
			int rc = query(node.right, si, ei);
			return lc + rc;
		}

	}
	public void update(int idx,int value) {
		this.root.data=update(this.root,idx,value);
	}

	private int update(Node node, int idx, int value) {
		if(idx>=node.startinterval && idx<=node.endinterval) {
			if(idx==node.startinterval && idx==node.endinterval) {
				node.data=value;
			}else {
				int lc=update(node.left,idx,value);
				int rc=update(node.right,idx,value);
				node.data=lc+rc;
				
			}
		}
		return node.data;
	}

}
