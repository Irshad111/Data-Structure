package Tree;

public class SegmentTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {
				3,8,7,6,-2,-8,4,9
		};
		SegmentTree st=new SegmentTree(arr);
		st.display();
		System.out.println(st.query(2,6));
		st.update(3, 14);
		st.display();
		

	}

}
