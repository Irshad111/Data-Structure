package stack;

public class StackClient {
	public static void main(String[] args) throws Exception {

//		Stack s = new Stack(10);
//		s.push(10);
//		s.push(20);
//		s.push(30);
//		s.push(40);
//		s.push(50);
//		s.push(60);
//		s.display();
//		System.out.println(s.peek());
//		System.out.println(s.pop());
//		s.display();
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		displayReverse(s);
//		actualReverse(s,new Stack(10));
//		s.display();
		int arr[]= {
				100, 80, 60, 70, 60, 75, 85
		};
		nextGreaterElement((arr));
		int [] temp=stockSpanProblem(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(temp[i]+" ");
			System.out.println();
		

	}
	public static void displayReverse(Stack s) throws Exception {
		if(s.isEmpty()) {
			return ;
		}
		int temp=s.pop();
		displayReverse(s);
		System.out.println(temp);
		s.push(temp);
	}
	public static void actualReverse(Stack s,Stack h) throws Exception {
		if(s.isEmpty()) {
			helper(s,h);
			 return;
		}
		int temp=s.pop();
		h.push(temp);
		actualReverse(s,h);
		
		
	}
	public static void helper(Stack s,Stack h) throws Exception {
		if(h.isEmpty()) {
			return ;
		}
		int temp=h.pop();
		
		helper(s,h);
		s.push(temp);
	}
	public static void nextGreaterElement(int []arr) throws Exception {
		Stack s=new DynamicStack();
		for(int i=0;i<arr.length;i++) {
			while(!s.isEmpty() && arr[i]>s.peek()) {
				int temp=s.pop();
				System.out.println(temp + ":>" +arr[i]);
			}
			s.push(arr[i]);
		}
		while(!s.isEmpty()) {
			System.out.println(s.pop()+":>"+-1);
		}
	}
   public static int[] stockSpanProblem(int arr[]) throws Exception {
	    Stack s=new DynamicStack();
	    int [] span=new int[arr.length];
	    span[0]=1;
	    s.push(0);
	    for(int i=1;i<arr.length;i++) {
	    	while(!s.isEmpty() && arr[i]>arr[s.peek()]) {
	    		s.pop();
	    	}
	    	if(s.isEmpty()) {
	    		span[i]=i+1;
	    	}
	    	else {
	    		span[i]=i-s.peek();
	    	}
	    	s.push(i);
	    }
	    return span;
   }

}
