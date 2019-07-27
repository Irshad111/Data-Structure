package linkedlist;

public class LLClient {
	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(50);
		list.addLast(20);
		list.addLast(10);
		list.addLast(40);
		list.addLast(60);
		list.addLast(30);

		list.addLast(70);
		list.addLast(90);
		list.addLast(80);

		list.display();
//		System.out.println(list.removeAt(2));
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.getAt(2));
//		list.display();
//		list.addAt(30, 2);
//		list.display();
		//list.reverseDI();
		//list.display();
		//list.reversePI();
		//list.display();
		//list.DRHeapmover();
		//list.display();
		//list.reversePR();
		//list.display();
		//list.foldH();
		//list.display();
		System.out.println(list.mid());
		System.out.println(list.kthfromlast(2));
		list.mergesort();
		list.kreverse(3);
		list.display();

	}


}
