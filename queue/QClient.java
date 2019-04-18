package queue;

public class QClient {

	public static void main(String[] args) throws Exception {
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.display();
//		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
//		q.enqueue(60);
//		q.enqueue(70);
//		q.display();
		displayReverse(q,0);
		q.display();
		actualReverse(q);
		q.display();
		

	}
	public static void displayReverse(Queue q,int count) throws Exception {
		if(count==q.size()) {
			return ;
		}
		int temp=q.dequeue();
		q.enqueue(temp);
		displayReverse(q,count+1);
		System.out.println(temp);
	}
	public static void actualReverse(Queue q) throws Exception {
		if(q.isEmpty()) {
			return ;
		}
		int temp=q.dequeue();
		actualReverse(q);
		q.enqueue(temp);
		
	}

}
