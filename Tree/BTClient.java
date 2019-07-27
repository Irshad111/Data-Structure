package Tree;


public class BTClient {

	public static void main(String[] args) {

		int[] pre= {10,20,40,60,30,50,70};
		int [] in= {40,20,60,10,70,50,30};
		BTree bt=new BTree(pre,in);
		//10 true 20 true 40 false false true 50 false false true 30 false false
		//10 true 20 true 40 true 50 true 60 true 70 false false false false false true 80 false true 90 
		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(20));
//		System.out.println(bt.ht());
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameter2());
//		System.out.println(bt.isBalanced());
//		bt.preorder();
//		bt.preorderI();

	

	}

}
