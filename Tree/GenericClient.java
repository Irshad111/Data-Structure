package Tree;


public class GenericClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
		GenericTree gt = new GenericTree();
		gt.display();
		 System.out.println(gt.size());
		 System.out.println(gt.max());
		 System.out.println(gt.height());
		 System.out.println(gt.find(60));
		// gt.mirror();
		// gt.display();
		   gt.preorder();
		   gt.postorder();
		 gt.levelorder();
		 gt.levelorderlinewise();
		 gt.levelorderZZ();
		 gt.printAtLevel(2);
		 gt.multisolver(50);
		 //gt.display1();
		 GenericTree gt2=new GenericTree();
		 System.out.println(gt.isMirror(gt2));

	}

}
