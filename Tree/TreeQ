package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TreeQ {
	// 1. count leaves in binary tree
	private class Node {
		Node left;
		Node right;
		int data;
		int hd;
	}

	int countLeaves(Node node) {
		// Your code
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int count = 0;
		count += countLeaves(node.left);
		count += countLeaves(node.right);
		return count;

	}

	// 2.k distance from root
	void printKdistance(Node root, int k) {
		// Your code here
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		} else {
			printKdistance(root.left, k - 1);
			printKdistance(root.right, k - 1);
		}

	}

	// 3. mirror tree
	void mirror(Node node) {
		// Your code here
		if (node == null) {
			return;
		}
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		mirror(node.left);
		mirror(node.right);

	}

	// 4. lCA in bst
	Node LCA(Node node, int n1, int n2) {
		// Your code here
		while (node != null) {
			if (node.data > n1 && node.data > n2) {
				node = node.left;
			} else if (node.data < n1 && node.data < n2) {
				node = node.right;
			} else {
				break;
			}
		}
		return node;
	}

	// 5. level order trversal
	static void levelOrder(Node node) {
		// Your code here
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			Node rm = q.remove();
			if (rm != null) {
				System.out.print(rm.data + " ");
			}
			if (rm.left != null) {
				q.add(rm.left);
			}
			if (rm.right != null) {
				q.add(rm.right);
			}

		}
	}

	// 6. find minimum dist b/w two node
	int findDist(Node root, int a, int b) {
		// Your code here
		Node lca_node = lca(root, a, b);
		int d1 = levelofNode(lca_node, a, 0);
		int d2 = levelofNode(lca_node, b, 0);
		return d1 + d2;
	}

	Node lca(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		if (node.data == n1 || node.data == n2) {
			return node;
		}
		Node lc = lca(node.left, n1, n2);
		Node rc = lca(node.right, n1, n2);
		if (lc != null && rc != null) {
			return node;
		}
		return lc != null ? lc : rc;
	}

	int levelofNode(Node root, int n1, int level) {
		if (root == null) {
			return -1;
		}
		if (root.data == n1) {
			return level;
		}
		int lc = levelofNode(root.left, n1, level + 1);
		if (lc != -1) {
			return lc;
		}
		return levelofNode(root.right, n1, level + 1);
	}

	// 7. kth largest in bst
	private class Mover {
		int count = 0;
	}

	public void kthLargest(Node root, int k) {
		// Your code here

		helper(root, k, new Mover());

	}

	private void helper(Node root, int k, Mover m) {
		if (root == null || m.count >= k) {
			return;
		}
		helper(root.right, k, m);
		m.count++;
		if (m.count == k) {
			System.out.println(root.data);
			return;
		}
		helper(root.left, k, m);
	}

	// 8. left view
	void leftView(Node node) {
		// Your code here
		if (node == null) {
			return;
		}
		LinkedList<Node> q = new LinkedList<>();
		q.addLast(node);
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				Node temp = q.removeFirst();
				if (i == 1) {
					System.out.print(temp.data + " ");
				}
				if (temp.left != null) {
					q.addLast(temp.left);
				}
				if (temp.right != null) {
					q.addLast(temp.right);
				}
			}

		}
	}

	// 9. print k distance node from target node
	public static int printkdistanceNode(Node root, Node target, int k) {
		if (root == null || k < 0) {
			return -1;
		}
		if (root == target) {
			printkdistanceDown(root, k);
			return 0;
		}
		int dleft = printkdistanceNode(root.left, target, k);
		if (dleft != -1) {
			if (dleft + 1 == k) {
				System.out.print(root.data + " ");
			} else {
				printkdistanceDown(root.right, k - dleft - 2);
			}
			return dleft + 1;
		}

		int dright = printkdistanceNode(root.right, target, k);
		if (dright != -1) {
			if (dright + 1 == k) {
				System.out.print(root.data + " ");
			} else {
				printkdistanceDown(root.left, k - dright - 2);
			}
			return dright + 1;
		}
		return -1;

	}

	public static void printkdistanceDown(Node root, int k) {
		if (root == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data + " ");
			return;
		}
		printkdistanceDown(root.left, k - 1);
		printkdistanceDown(root.right, k - 1);
	}

	// 10.Given a Binary Tree and a sum s, your task is to check whether there is a
	// root to leaf path in that tree with the following sum
	boolean hasPathSum(Node node, int sum) {
		// Your code here
		if (node == null) {
			return false;
		}
		int subsum = sum - node.data;
		if (subsum == 0 && node.left == null && node.right == null) {
			return true;
		}
		boolean lc = hasPathSum(node.left, subsum);
		boolean rc = hasPathSum(node.right, subsum);
		return lc || rc;
	}

	// 11.delete node from bst
	Node deleteNode(Node root, int key) {
		// Your code here
		if (root == null) {
			return null;
		}
		if (root.data > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.data < key) {
			root.right = deleteNode(root.right, key);
		} else {
			// if node have one one node or no node
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {// if node have both node
				root.data = max(root.left);
				root.left = deleteNode(root.left, root.data);

			}
		}
		return root;
	}

	private int max(Node node) {
		if (node.right == null)
			return node.data;
		return max(node.right);
	}

	// 12. sum from k level
	public static void sumKLevel(String str, int k) {
		int sum = 0;
		int idx = 0;
		int level = -1;
		while (idx < str.length()) {
			char ch = str.charAt(idx);
			if (ch == '(') {
				level++;
				idx++;
			} else if (ch == ')') {
				level--;
				idx++;
			} else if (ch >= '0' && ch <= '9') {
				if (level == k) {
					int temp = 0;
					while (ch >= '0' && ch <= '9') {
						temp = temp * 10 + ch - '0';
						idx++;
						ch = str.charAt(idx);
					}
					sum += temp;
				} else {
					idx++;
				}
			}
		}
		System.out.println(sum);

	}

	// 13. top view
	public void printTopView(Node root) {
		// add code here.
		if (root == null) {
			return;
		}
		LinkedList<Node> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int hd = 0;
		root.hd = 0;
		q.addLast(root);
		while (!q.isEmpty()) {
			Node temp = q.removeFirst();
			hd = temp.hd;
			if (!map.containsKey(hd)) {
				System.out.print(temp.data + " ");
				map.put(hd, temp.data);
			}
			if (temp.left != null) {
				temp.left.hd = hd - 1;
				q.addLast(temp.left);
			}
			if (temp.right != null) {
				temp.right.hd = hd + 1;
				q.addLast(temp.right);
			}
		}
		// for(int key:map.keySet()){
		// System.out.print(map.get(key)+" ");
		// }
	}

	// 14. largest bst in bt
	private class Pair {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isbst = true;
	}

	public int largestBst(Node node) {
		// add code here.
		Pair np = largest(node);
		return np.size;
	}

	private Pair largest(Node node) {
		if (node == null) {
			Pair nn = new Pair();
			return nn;
		}
		Pair lp = largest(node.left);
		Pair rp = largest(node.right);
		Pair np = new Pair();
		if (!lp.isbst || !rp.isbst || lp.max > node.data || rp.min <= node.data) {
			np.isbst = false;
			np.size = Math.max(lp.size, rp.size);
			return np;
		}
		// if above condition not true then
		np.isbst = true;
		np.size = lp.size + rp.size + 1;
		np.min = node.left != null ? lp.min : node.data;
		np.max = node.right != null ? rp.max : node.data;
		return np;
	}

	// 15.binary tree to dll
	Node head;

	Node bToDLL(Node root) {
		// Your code here
		// logic reverse inorder traversal
		if (root == null) {
			return null;
		}
		bToDLL(root.right);
		root.right = head;
		if (head != null) {
			head.left = root;
		}
		head = root;
		bToDLL(root.left);
		return head;
	}
	// 16. bt is bst or not
	int isBST(Node root)  
    {
        // Your code here
        if(isbst(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            return 1;
        }else{
            return 0;
        }
    }
    private boolean isbst(Node node,int min,int max){
        if(node==null){
            return true;
        }
        if(node.data<=min || node.data>max){
            return false;
        }
        return isbst(node.left,min,node.data) && isbst(node.right,node.data,max);
    }
    // 17. boundary  traversal
    void printBoundary(Node node)
	{
		// Your code here
		if(node==null){
		    return;
		}
		System.out.print(node.data+" ");
		//left boundary top to buttom
		printleft(node.left);
		
		// left & right leaf node
		printLeaves(node.left);
		printLeaves(node.right);
		
		// right boundary buttom to top
		printRight(node.right);
		
		
	}
	void printleft(Node node){
	    if(node==null){
	        return;
	    }
	    if(node.left!=null){
	        System.out.print(node.data+" ");
	        printleft(node.left);
	    }else if(node.right!=null){
	        System.out.print(node.data+" ");
	        printleft(node.right);
	    }
	}
	void printLeaves(Node node){
	    if(node==null){
	        return ;
	    }
	    printLeaves(node.left);
	    if(node.left==null && node.right==null){
	        System.out.print(node.data+" ");
	    }
	    printLeaves(node.right);
	}
	void printRight(Node node){
	    if(node==null){
	        return;
	    }
	    if(node.right!=null){
	        printRight(node.right);
	        System.out.print(node.data+" ");
	    }else if(node.left!=null){
	        printRight(node.left);
	        System.out.print(node.data+" ");
	    }
	    
	}
// 18.count no of turns
 static int count=0;
    int NumberOfTurn(Node root, int first, int second)
    {
        Node LCA=lca(root,first,second);
        if(LCA==null){
            return -1;
        }
        count=0;
        if(LCA.data!=first && LCA.data!=second){
            
            if(countTurn(LCA.left,first,true) || countTurn(LCA.right,first,false));    
            
            if(countTurn(LCA.left,second,true) || countTurn(LCA.right,second,false));
            return count+1;
        }
        if(LCA.data==first){
            countTurn(LCA.left,second,true);
            countTurn(LCA.right,second,false);
            return count;
            }else{
                countTurn(LCA.left,first,true);
            countTurn(LCA.right,first,false);
            return count;
                
            }
            
        }
    public static boolean countTurn(Node node,int key,boolean turn){
        if(node==null){
            return false;
        }
        if(node.data==key){
            return true;
        }
        if(turn==true){//case1
            if(countTurn(node.left,key,turn))
            return true;
            if(countTurn(node.right,key,!turn)){
                count++;
                return true;
            }
        }else{ //case2
            if(countTurn(node.right,key,turn))
            return true;
            if(countTurn(node.left,key,!turn)){
                count++;
                return true;
            }
            
        }
        return false;
    }
}
