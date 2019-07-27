package Tree;

import java.util.*;

public class GenericTree {
	Scanner sc=new Scanner(System.in);
	private class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}
	private Node root;
	public GenericTree() {
		this.root=takeinput(null,-1);
	}
	private Node takeinput(Node parent, int ith) {
		
		// TODO Auto-generated method stub
		if(parent==null) {
			System.out.println("Enter data for root node");
		}else {
			System.out.println("Enter data for "+ith+"child of "+parent.data);
		}
		int item=sc.nextInt();
		Node nn=new Node();
		nn.data=item;
		System.out.println("Enter No of children ? for "+nn.data);
		int noc=sc.nextInt();
		for(int i=0;i<noc;i++) {
			Node child=takeinput(nn,i);
			nn.children.add(child);
		}
		
		return nn;
	}
	public void display() {
		System.out.println("-------------");
		display(this.root);
		System.out.println("-------------");
		
	}
	private void display(Node node) {
		// TODO Auto-generated method stub
		String str=node.data+"->";
		for(Node child:node.children) {
			str+=child.data+", ";
		}
		System.out.println(str+".");
		for(Node child:node.children) {
	       display(child);
		}
		
	}
	public int size() {
		return size(this.root);
	}
	private int size(Node node) {
		int ts=0;
		for(Node child:node.children) {
			int cs=size(child);
			ts+=cs;
		}
		return ts+1;
	}
	public int max() {
		return max(this.root);
	}
	private int max(Node node) {
		int mn=node.data;
		for(Node child:node.children) {
			int cn=max(child);
			if(cn>mn) {
				mn=cn;
			}
		}
		
		return mn;
	}
	public int height() {
		return height(this.root);
	}
	private int height(Node node) {
		int ht=-1;
		for(Node child:node.children) {
			int ch=height(child);
			if(ch>ht) {
				ht=ch;
			}
		}
		return ht+1;
	}
	public boolean find(int item) {
		return find(this.root,item);
	}
	private boolean find(Node node, int item) {
		if(node.data==item) {
			return true;
		}
		for(Node child:node.children) {
			boolean rec=find(child,item);
			if(rec) {
				return true;
			}
		}
		return false;
	}
	public void mirror() {
		mirror(this.root);
	}
	private void mirror(Node node) {
		int left=0;
		int right=node.children.size()-1;
		while(left<right) {
			Node ln=node.children.get(left);
			Node rn=node.children.get(right);
			node.children.set(left, rn);
			node.children.set(right, ln);
			left++;
			right--;
		}
		
	}
	public void display1() {
		display1(this.root);
	}

	private void display1(Node node) {

		System.out.println("hii " + node.data);

		for (Node child : node.children) {
			System.out.println("going towards " + child.data);
			display1(child);
			System.out.println("coming back from " + child.data);
		}

		System.out.println("bye " + node.data);

	}
	public void preorder() {
		preorder(this.root);
		System.out.println();
	}
	private void preorder(Node node) {
		System.out.print(node.data+" ");
		for(Node child:node.children) {
			preorder(child);
		}
		
	}
	public void postorder() {
		postorder(this.root);
		System.out.println();
	}
	private void postorder(Node node) {
		
		for(Node child:node.children) {
			postorder(child);
		}
		System.out.print(node.data+" ");
		
	}
	public void levelorder() {
		LinkedList<Node> q=new LinkedList<>();
		q.addLast(this.root);
		while(!q.isEmpty()) {
			Node rm=q.removeFirst();
			System.out.print(rm.data+" ");
			for(Node child:rm.children) {
				q.addLast(child);
			}
		}
		System.out.println();
	}
	public void levelorderlinewise() {
		LinkedList<Node> q=new LinkedList<>();
		LinkedList<Node> helper=new LinkedList<>();
		
		q.addLast(this.root);
		while(!q.isEmpty()) {
			Node rm=q.removeFirst();
			
			System.out.print(rm.data+" ");
			
			for(Node child:rm.children) {
				helper.addLast(child);
			}
			
			if(q.isEmpty()) {
				q=helper;
				System.out.println();
				helper=new LinkedList<>();
				
			}
			
		}
		
	}
	public void levelorderZZ() {
		LinkedList<Node> q=new LinkedList<>();
		LinkedList<Node> stack=new LinkedList<>();
		int count=0;
		q.addLast(this.root);
		while(!q.isEmpty()) {
			Node rm=q.removeFirst();
			
			System.out.print(rm.data+" ");
			
			if(count%2==0) {
			for(int i=0;i<rm.children.size();i++) {
				stack.addFirst(rm.children.get(i));
			}
			}else {
				for(int i=rm.children.size()-1;i>=0;i--) {
					stack.addFirst(rm.children.get(i));
				}
				
			}
			
			if(q.isEmpty()) {
				q=stack;
				System.out.println();
				stack=new LinkedList<>();
				count++;
				
			}
			
		}
		
	}
	public void printAtLevel(int level) {
		printAtLevel(this.root,0,level);
		System.out.println();
	}
	private void printAtLevel(Node node, int count, int level) {
		if(level==count) {
			System.out.print(node.data+" ");
			return;
		}
		for(Node child:node.children) {
			printAtLevel(child,count+1,level);
		}
		
	}
	private class Heapmover{
		int size;
		int max=Integer.MIN_VALUE;
		int ht;
		boolean find;
		Node succ;
		Node pre;
		Node jl;//just large;
	}
	public void multisolver(int item) {
		Heapmover mover=new Heapmover();
		multisolver(mover,this.root,item,0);
		
		System.out.println("Max : " + mover.max);
		System.out.println("Size : " + mover.size);
		System.out.println("Find : " + mover.find);
		System.out.println("Ht : " + mover.ht);

		System.out.println("Pred : " + (mover.pre == null ? null : mover.pre.data));
		System.out.println("Succ : " + (mover.succ == null ? null : mover.succ.data));
		System.out.println("Just Large : " + (mover.jl == null ? null : mover.jl.data));
		
	}
	private void multisolver(Heapmover mover,Node node, int item, int count) {
		mover.size++;
		if(mover.find==true && mover.succ==null) {
			mover.succ=node;
		}
		if(node.data==item) {
			mover.find=true;
		}
		if(mover.find==false) {
			mover.pre=node;
		}
		if(count>mover.ht) {
			mover.ht=count;
		}
		if(node.data>mover.max) {
			mover.max=node.data;
		}
		if(node.data>item) {
			if(mover.jl==null || node.data<mover.jl.data) {
				mover.jl=node;
			}
		}
		for(Node child :node.children) {
			multisolver(mover,child,item,count+1);
		}
		
	}
	public boolean isMirror(GenericTree other) {
		return isMirror(this.root,other.root);
	}
	private boolean isMirror(Node one, Node second) {
		if(one.children.size()!=second.children.size()) {
			return false;
		}
		for(int i=0;i<one.children.size();i++) {
		Node on=one.children.get(i);
		Node se=second.children.get(one.children.size()-1-i);
		if(!isMirror(on,se)) {
			return false;
		}
		}
		
		
		return true;
	}




}
