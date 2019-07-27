package linkedlist;


public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// o(1)
	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index");
		}
		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	// O(n)
	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index");
		}
		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void display() {
		System.out.println("-------------");
		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("--------------");
	}

	// O(1)
	public void addLast(int item) {
		Node temp = new Node();
		temp.data = item;
		temp.next = null;
		if (this.size == 0) {
			this.head = temp;
			this.tail = temp;
			this.size++;
		} else {
			this.tail.next = temp;
			this.tail = temp;
			this.size++;
		}

	}

	// O(1)
	public void addFirst(int item) {

		Node temp = new Node();
		temp.data = item;
		temp.next = null;
		if (this.size == 0) {
			this.head = temp;
			this.tail = temp;
			this.size++;
		} else {
			temp.next = this.head;
			this.head = temp;
			this.size++;
		}

	}

	// O(n)
	public void addAt(int item, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid index");
		}

		if (idx == 0) {
			this.addFirst(item);
		} else if (idx == this.size) {
			this.addLast(item);
		} else {
			Node nn = new Node();
			nn.data = item;
			nn.next = null;
			Node nm1 = this.getNodeAt(idx - 1);
			nn.next = nm1.next;
			nm1.next = nn;
			this.size++;
		}

	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty ");
		}
		int temp = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node n = this.getNodeAt(this.size - 2);
			n.next = null;
			this.tail = n;

		}

		this.size--;

		return temp;
	}

	// O(1)
	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty ");
		}
		int temp = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;

		}
		this.size--;

		return temp;

	}

	// O(n)
	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}
		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {
			Node prev = getNodeAt(idx - 1);
			Node self = prev.next;
			prev.next = self.next;
			return self.data;
		}

	}

	public void reverseDI() throws Exception {
		int left = 0;
		int right = this.size - 1;
		while (left < right) {
			Node l = getNodeAt(left);
			Node r = getNodeAt(right);
			int temp = l.data;
			l.data = r.data;
			r.data = temp;
			left++;
			right--;
		}
	}

	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		// change head & tail
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;
		this.tail.next = null;
	}

	public void reversePR() {
		reversePRH(this.head, this.head.next);
		// change head & tail
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;
		this.tail.next = null;
	}

	private void reversePRH(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		reversePRH(curr, curr.next);
		curr.next = prev;

	}

	public void reverseDR() {
		reverseDRH(this.head, this.head, 0);
	}

	private Node reverseDRH(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}

		left = reverseDRH(left, right.next, count + 1);
		// swap
		if (count >= this.size / 2) {
			int t = right.data;
			right.data = left.data;
			left.data = t;

		}
		return left.next;

	}

	private class Heapmover {
		Node left = head;
	}

	public void DRHeapmover() {
		Heapmover mover = new Heapmover();
		DRHHeapmover(mover, this.head, 0);
	}

	private void DRHHeapmover(Heapmover mover, Node right, int count) {

		if (right == null) {
			return;
		}
		DRHHeapmover(mover, right.next, count + 1);
		if (count >= this.size / 2) {
			int t = mover.left.data;
			mover.left.data = right.data;
			right.data = t;
		}
		mover.left = mover.left.next;

	}

	public void foldH() {
		Heapmover mover = new Heapmover();
		foldH(mover, this.head, 0);
	}

	private void foldH(Heapmover mover, Node right, int count) {
		if (right == null) {
			return;
		}
		foldH(mover, right.next, count + 1);
		if (count > this.size / 2) {
			Node ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;
			mover.left = ahead;
		}
		if (count == size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}
	public int mid() {
		Node slow=this.head;
		Node fast=this.head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	public int kthfromlast(int k) {
		Node slow=this.head;
		Node fast=this.head;
		for(int i=1;i<=k;i++) {
			fast=fast.next;
		}
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow.data;
	}
	public void kreverse(int k) throws Exception {
		LinkedList prev=null;
		while(this.size!=0) {
			LinkedList curr=new LinkedList();
			for(int i=1;i<=k;i++) {
				curr.addFirst(this.removeFirst());
			}
			if(prev==null) {
				prev=curr;
			}else {
				prev.tail.next=curr.head;
				prev.tail=curr.tail;
				prev.size+=curr.size;
			}
			
		}
		this.size=prev.size;
		this.head=prev.head;
		this.tail=prev.tail;
	}
	private Node midNode() {
		Node slow=this.head;
		Node fast=this.head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public LinkedList mergetosorted(LinkedList second) {
		LinkedList merge=new LinkedList();
		Node fone=this.head;
		Node sone=second.head;
		while(fone!=null && sone!=null) {
			if(fone.data<sone.data) {
				merge.addLast(fone.data);
				fone=fone.next;
			}else {
				merge.addLast(sone.data);
				sone=sone.next;
			}
		}
		if(fone==null) {
			while(sone!=null) {
				merge.addLast(sone.data);
				sone=sone.next;
			}
		}
		if(sone==null) {
			while(fone!=null) {
				merge.addLast(fone.data);
				fone=fone.next;
			}
		}
		return merge;
	}
	public void mergesort() {
		if(size==1) {
			return;
		}
		LinkedList fh=new LinkedList();
		LinkedList sh=new LinkedList();
		Node mid=midNode();
		Node midtonext=mid.next;
		fh.head=this.head;
		fh.tail=mid;
		fh.tail.next=null;
		fh.size=(this.size+1)/2;
		sh.head=midtonext;
		sh.tail=this.tail;
		sh.tail.next=null;
		sh.size=this.size/2;
		fh.mergesort();
		sh.mergesort();
		LinkedList merge=fh.mergetosorted(sh);
		this.head=merge.head;
		this.tail=merge.tail;
		this.size=merge.size;
	}

}
