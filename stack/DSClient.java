package stack;


public class DSClient {
	public static void main(String[] args) throws Exception {
		Stack stack=new DynamicStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.display();

	}

}
