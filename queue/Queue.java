package queue;

public class Queue {
	protected int[] data;
	protected int size;
	protected int front;

	public Queue() {
		this.data = new int[5];
		this.size = 0;
		this.front = 0;
	}

	public Queue(int cap) {
		this.data = new int[cap];
		this.size = 0;
		this.front = 0;
	}

	public void enqueue(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is full");
		}
		int idx = (this.front + this.size) % this.data.length;
		this.data[idx] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rm = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rm;
	}

	public int getFront() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int rm = this.data[this.front];
		return rm;
	}

	public boolean isFull() {
		return this.size == this.data.length;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void display() {
		System.out.println("*****************");
		for (int i = 0; i < this.size; i++) {
			int idx = (i + this.front) % this.data.length;
			System.out.println(this.data[idx] + " ");

		}
		System.out.println("*****************");
	}

}
