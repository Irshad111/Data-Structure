package queue;


public class DQClient {
	public static void main(String[] args) throws Exception{
		Queue q=new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(70);
		q.display();
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(60);
		q.display();

}
}
